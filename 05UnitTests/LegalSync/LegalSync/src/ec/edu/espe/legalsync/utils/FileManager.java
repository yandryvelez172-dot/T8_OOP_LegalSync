package ec.edu.espe.legalsync.utils;

import ec.edu.espe.legalsync.model.AuditEntry;
import ec.edu.espe.legalsync.model.CaseFile;
import ec.edu.espe.legalsync.model.Client;
import ec.edu.espe.legalsync.model.Deadline;
import ec.edu.espe.legalsync.model.Defendant;
import ec.edu.espe.legalsync.model.Document;
import ec.edu.espe.legalsync.model.Expense;
import ec.edu.espe.legalsync.model.Lawyer;
import ec.edu.espe.legalsync.model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christopher Torres, CodeLex, @ESPE
 */


public class FileManager {

    public static final String DATA_DIR = "data";
    public static final String REPORTS_DIR = "reports";
    public static final String USERS_JSON = DATA_DIR + "/users.json";
    public static final String CLIENTS_JSON = DATA_DIR + "/clients.json";
    public static final String CASES_JSON = DATA_DIR + "/cases.json";
    public static final String AUDIT_JSON = DATA_DIR + "/audit_log.json";
    public static final String CASES_CSV = REPORTS_DIR + "/cases_report.csv";
    public static final String BILLING_CSV = REPORTS_DIR + "/billing_report.csv";

    public static void ensureDirectories() {
        File dataFolder = new File(DATA_DIR);
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        File reportsFolder = new File(REPORTS_DIR);
        if (!reportsFolder.exists()) {
            reportsFolder.mkdirs();
        }
    }

    private static String escapeJson(String text) {
        if (text == null) {
            return "";
        }
        return text.replace("\\", "\\\\").replace("\"", "'").replace("\n", " ").replace("\r", " ");
    }

    private static String escapeCsv(String text) {
        if (text == null) {
            return "";
        }
        if (text.contains(",") || text.contains("\"")) {
            return "\"" + text.replace("\"", "\"\"") + "\"";
        }
        return text;
    }

    private static Map<String, String> parseFlatJsonObject(String line) {
        Map<String, String> map = new HashMap<>();
        String clean = line.trim();
        if (clean.startsWith("{")) {
            clean = clean.substring(1);
        }
        if (clean.endsWith("},")) {
            clean = clean.substring(0, clean.length() - 2);
        } else if (clean.endsWith("}")) {
            clean = clean.substring(0, clean.length() - 1);
        }

        List<String> pairs = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < clean.length(); i++) {
            char c = clean.charAt(i);
            if (c == '\"') {
                inQuotes = !inQuotes;
            }
            if (c == ',' && !inQuotes) {
                pairs.add(current.toString().trim());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }
        if (current.length() > 0) {
            pairs.add(current.toString().trim());
        }

        for (int i = 0; i < pairs.size(); i++) {
            String pair = pairs.get(i);
            int colonIdx = pair.indexOf(':');
            if (colonIdx > 0) {
                String key = pair.substring(0, colonIdx).trim().replace("\"", "");
                String val = pair.substring(colonIdx + 1).trim();
                if (val.startsWith("\"") && val.endsWith("\"") && val.length() >= 2) {
                    val = val.substring(1, val.length() - 1);
                }
                val = val.replace("\\\\", "\\");
                map.put(key, val);
            }
        }
        return map;
    }

    public static void saveUsersToJson(List<User> users) {
        ensureDirectories();
        try (PrintWriter out = new PrintWriter(new FileWriter(USERS_JSON))) {
            out.println("[");
            for (int i = 0; i < users.size(); i++) {
                User u = users.get(i);
                String comma = (i < users.size() - 1) ? "," : "";
                out.printf("  {\"userId\": %d, \"name\": \"%s\", \"email\": \"%s\", \"password\": \"%s\", \"role\": \"%s\", \"active\": %b}%s%n",
                        u.getUserId(), escapeJson(u.getName()), escapeJson(u.getEmail()),
                        escapeJson(u.getPassword()), escapeJson(u.getRole()), u.isActive(), comma);
            }
            out.println("]");
        } catch (IOException e) {
            System.out.println("Error saving users.json: " + e.getMessage());
        }
    }

    public static List<User> loadUsersFromJson() {
        List<User> users = new ArrayList<>();
        File file = new File(USERS_JSON);
        if (!file.exists()) {
            return users;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("{")) {
                    Map<String, String> m = parseFlatJsonObject(line);
                    int id = Integer.parseInt(m.getOrDefault("userId", "0"));
                    String name = m.getOrDefault("name", "");
                    String email = m.getOrDefault("email", "");
                    String pass = m.getOrDefault("password", "");
                    String role = m.getOrDefault("role", "JUNIOR_LAWYER");
                    boolean active = Boolean.parseBoolean(m.getOrDefault("active", "true"));
                    users.add(new User(id, name, email, pass, role, active));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading users.json: " + e.getMessage());
        }
        return users;
    }

    public static void saveClientsToJson(List<Client> clients) {
        ensureDirectories();
        try (PrintWriter out = new PrintWriter(new FileWriter(CLIENTS_JSON))) {
            out.println("[");
            for (int i = 0; i < clients.size(); i++) {
                Client c = clients.get(i);
                String comma = (i < clients.size() - 1) ? "," : "";
                out.printf("  {\"clientId\": %d, \"idNumber\": \"%s\", \"name\": \"%s\", \"phone\": \"%s\", \"email\": \"%s\", \"address\": \"%s\"}%s%n",
                        c.getClientId(), escapeJson(c.getIdNumber()), escapeJson(c.getName()),
                        escapeJson(c.getPhone()), escapeJson(c.getEmail()), escapeJson(c.getAddress()), comma);
            }
            out.println("]");
        } catch (IOException e) {
            System.out.println("Error saving clients.json: " + e.getMessage());
        }
    }

    public static List<Client> loadClientsFromJson() {
        List<Client> clients = new ArrayList<>();
        File file = new File(CLIENTS_JSON);
        if (!file.exists()) {
            return clients;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("{")) {
                    Map<String, String> m = parseFlatJsonObject(line);
                    int id = Integer.parseInt(m.getOrDefault("clientId", "0"));
                    clients.add(new Client(id, m.getOrDefault("idNumber", ""), m.getOrDefault("name", ""),
                            m.getOrDefault("phone", ""), m.getOrDefault("email", ""), m.getOrDefault("address", "")));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading clients.json: " + e.getMessage());
        }
        return clients;
    }

    public static void saveAuditToJson(List<AuditEntry> entries) {
        ensureDirectories();
        try (PrintWriter out = new PrintWriter(new FileWriter(AUDIT_JSON))) {
            out.println("[");
            for (int i = 0; i < entries.size(); i++) {
                AuditEntry a = entries.get(i);
                String comma = (i < entries.size() - 1) ? "," : "";
                out.printf("  {\"dateTime\": \"%s\", \"userEmail\": \"%s\", \"role\": \"%s\", \"action\": \"%s\", \"docketNumber\": \"%s\"}%s%n",
                        escapeJson(a.getDateTime()), escapeJson(a.getUserEmail()), escapeJson(a.getRole()),
                        escapeJson(a.getAction()), escapeJson(a.getDocketNumber()), comma);
            }
            out.println("]");
        } catch (IOException e) {
            System.out.println("Error saving audit_log.json: " + e.getMessage());
        }
    }

    public static List<AuditEntry> loadAuditFromJson() {
        List<AuditEntry> entries = new ArrayList<>();
        File file = new File(AUDIT_JSON);
        if (!file.exists()) {
            return entries;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("{")) {
                    Map<String, String> m = parseFlatJsonObject(line);
                    entries.add(new AuditEntry(m.getOrDefault("dateTime", ""), m.getOrDefault("userEmail", ""),
                            m.getOrDefault("role", ""), m.getOrDefault("action", ""), m.getOrDefault("docketNumber", "")));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading audit_log.json: " + e.getMessage());
        }
        return entries;
    }

    public static void saveCasesToJson(List<CaseFile> cases) {
        ensureDirectories();
        try (PrintWriter out = new PrintWriter(new FileWriter(CASES_JSON))) {
            out.println("[");
            for (int i = 0; i < cases.size(); i++) {
                CaseFile cf = cases.get(i);
                Client cl = cf.getClient() != null ? cf.getClient() : new Client(0, "N/A", "N/A", "", "", "");
                Defendant df = cf.getDefendant() != null ? cf.getDefendant() : new Defendant(0, "N/A", "N/A", "", "");
                Lawyer lw = cf.getAssignedLawyer() != null ? cf.getAssignedLawyer() : new Lawyer(0, "N/A", "", "LAWYER", "");

                StringBuilder expSerialized = new StringBuilder();
                for (int j = 0; j < cf.getExpenses().size(); j++) {
                    Expense ex = cf.getExpenses().get(j);
                    if (j > 0) expSerialized.append(";;");
                    expSerialized.append(ex.getExpenseId()).append("|")
                            .append(escapeJson(ex.getDescription()).replace("|", "/")).append("|")
                            .append(ex.getAmount()).append("|")
                            .append(escapeJson(ex.getExpenseDate())).append("|")
                            .append(ex.isPaid());
                }

                StringBuilder dlSerialized = new StringBuilder();
                for (int j = 0; j < cf.getDeadlines().size(); j++) {
                    Deadline dl = cf.getDeadlines().get(j);
                    if (j > 0) dlSerialized.append(";;");
                    dlSerialized.append(dl.getDeadlineId()).append("|")
                            .append(escapeJson(dl.getDescription()).replace("|", "/")).append("|")
                            .append(escapeJson(dl.getDisposition()).replace("|", "/")).append("|")
                            .append(escapeJson(dl.getType())).append("|")
                            .append(escapeJson(dl.getTargetDate())).append("|")
                            .append(escapeJson(dl.getAssignedUser())).append("|")
                            .append(dl.isCompleted());
                }

                StringBuilder docSerialized = new StringBuilder();
                for (int j = 0; j < cf.getDocuments().size(); j++) {
                    Document dc = cf.getDocuments().get(j);
                    if (j > 0) docSerialized.append(";;");
                    docSerialized.append(dc.getDocumentId()).append("|")
                            .append(escapeJson(dc.getName()).replace("|", "/")).append("|")
                            .append(escapeJson(dc.getType())).append("|")
                            .append(escapeJson(dc.getFilePath())).append("|")
                            .append(escapeJson(dc.getUploadDate()));
                }

                String comma = (i < cases.size() - 1) ? "," : "";
                out.printf("  {\"caseId\": %d, \"docketNumber\": \"%s\", \"title\": \"%s\", \"processClass\": \"%s\", \"category\": \"%s\", \"priority\": \"%s\", \"judicialUnit\": \"%s\", \"status\": \"%s\", \"openingDate\": \"%s\", \"clientId\": %d, \"clientName\": \"%s\", \"clientIdNum\": \"%s\", \"defendantName\": \"%s\", \"defendantIdNum\": \"%s\", \"lawyerName\": \"%s\", \"lawyerEmail\": \"%s\", \"expensesData\": \"%s\", \"deadlinesData\": \"%s\", \"documentsData\": \"%s\"}%s%n",
                        cf.getCaseId(), escapeJson(cf.getDocketNumber()), escapeJson(cf.getTitle()),
                        escapeJson(cf.getProcessClass()), escapeJson(cf.getCategory()), escapeJson(cf.getPriority()),
                        escapeJson(cf.getJudicialUnit()), escapeJson(cf.getStatus()), escapeJson(cf.getOpeningDate()),
                        cl.getClientId(), escapeJson(cl.getName()), escapeJson(cl.getIdNumber()),
                        escapeJson(df.getName()), escapeJson(df.getIdNumber()),
                        escapeJson(lw.getName()), escapeJson(lw.getEmail()),
                        expSerialized.toString(), dlSerialized.toString(), docSerialized.toString(), comma);
            }
            out.println("]");
        } catch (IOException e) {
            System.out.println("Error saving cases.json: " + e.getMessage());
        }
    }

    public static List<CaseFile> loadCasesFromJson(List<Client> knownClients) {
        List<CaseFile> cases = new ArrayList<>();
        File file = new File(CASES_JSON);
        if (!file.exists()) {
            return cases;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("{")) {
                    Map<String, String> m = parseFlatJsonObject(line);
                    int caseId = Integer.parseInt(m.getOrDefault("caseId", "0"));
                    int clientId = Integer.parseInt(m.getOrDefault("clientId", "1"));
                    Client foundClient = null;
                    for (int i = 0; i < knownClients.size(); i++) {
                        if (knownClients.get(i).getClientId() == clientId) {
                            foundClient = knownClients.get(i);
                            break;
                        }
                    }
                    if (foundClient == null) {
                        foundClient = new Client(clientId, m.getOrDefault("clientIdNum", "N/A"),
                                m.getOrDefault("clientName", "Unknown"), "0990000000", "client@mail.com", "Quito");
                    }
                    Defendant def = new Defendant(caseId, m.getOrDefault("defendantIdNum", "N/A"),
                            m.getOrDefault("defendantName", "Unknown"), "N/A", "Quito");
                    Lawyer law = new Lawyer(1, m.getOrDefault("lawyerName", "Assigned Lawyer"),
                            m.getOrDefault("lawyerEmail", "lawyer@legalsync.com"), "PARTNER", "MAT-17-001");

                    CaseFile cf = new CaseFile(caseId, m.getOrDefault("docketNumber", ""),
                            m.getOrDefault("title", ""), m.getOrDefault("processClass", "Ordinary"),
                            m.getOrDefault("category", "CIVIL"), m.getOrDefault("priority", "MEDIUM"),
                            m.getOrDefault("judicialUnit", "Quito Judicial Unit"), m.getOrDefault("status", "ACTIVE"),
                            m.getOrDefault("openingDate", "2026-10-26"), foundClient, def, law);

                    String expData = m.getOrDefault("expensesData", "");
                    if (!expData.isEmpty()) {
                        String[] items = expData.split(";;");
                        for (int i = 0; i < items.length; i++) {
                            String[] p = items[i].split("\\|");
                            if (p.length >= 5) {
                                cf.addExpense(new Expense(Integer.parseInt(p[0]), caseId, p[1],
                                        Double.parseDouble(p[2]), p[3], Boolean.parseBoolean(p[4])));
                            }
                        }
                    }

                    String dlData = m.getOrDefault("deadlinesData", "");
                    if (!dlData.isEmpty()) {
                        String[] items = dlData.split(";;");
                        for (int i = 0; i < items.length; i++) {
                            String[] p = items[i].split("\\|");
                            if (p.length >= 7) {
                                cf.addDeadline(new Deadline(Integer.parseInt(p[0]), caseId, p[1],
                                        p[2], p[3], p[4], p[5], Boolean.parseBoolean(p[6])));
                            }
                        }
                    }

                    String docData = m.getOrDefault("documentsData", "");
                    if (!docData.isEmpty()) {
                        String[] items = docData.split(";;");
                        for (int i = 0; i < items.length; i++) {
                            String[] p = items[i].split("\\|");
                            if (p.length >= 5) {
                                cf.addDocument(new Document(Integer.parseInt(p[0]), p[1], p[2], p[3], p[4]));
                            }
                        }
                    }
                    cases.add(cf);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading cases.json: " + e.getMessage());
        }
        return cases;
    }

    public static boolean generateCsvReports(List<CaseFile> cases) {
        ensureDirectories();
        try (PrintWriter caseOut = new PrintWriter(new FileWriter(CASES_CSV));
             PrintWriter billOut = new PrintWriter(new FileWriter(BILLING_CSV))) {

            caseOut.println("CaseID,DocketNumber,Title,ProcessClass,LegalCategory,Priority,JudicialUnit,Status,ClientName,AssignedLawyer,OpeningDate");
            billOut.println("CaseID,DocketNumber,ClientName,ClientIDNumber,ExpenseID,ExpenseDate,ExpenseDescription,AmountUSD,PaymentStatus,TotalCaseDebtUSD,AccountBalanceStatus");

            for (int i = 0; i < cases.size(); i++) {
                CaseFile cf = cases.get(i);
                String clientName = cf.getClient() != null ? cf.getClient().getName() : "N/A";
                String clientIdNum = cf.getClient() != null ? cf.getClient().getIdNumber() : "N/A";
                String lawyerName = cf.getAssignedLawyer() != null ? cf.getAssignedLawyer().getName() : "N/A";

                caseOut.printf("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n",
                        cf.getCaseId(), escapeCsv(cf.getDocketNumber()), escapeCsv(cf.getTitle()),
                        escapeCsv(cf.getProcessClass()), cf.getCategory(), cf.getPriority(),
                        escapeCsv(cf.getJudicialUnit()), cf.getStatus(), escapeCsv(clientName),
                        escapeCsv(lawyerName), cf.getOpeningDate());

                double totalDebt = cf.calculateTotalDebt();
                String accStatus = cf.isPaidInFull() ? "PAID IN FULL" : "PENDING DEBT";

                if (cf.getExpenses().isEmpty()) {
                    billOut.printf("%d,%s,%s,%s,0,N/A,No expenses recorded,0.00,N/A,%.2f,%s%n",
                            cf.getCaseId(), escapeCsv(cf.getDocketNumber()), escapeCsv(clientName),
                            escapeCsv(clientIdNum), totalDebt, accStatus);
                } else {
                    for (int j = 0; j < cf.getExpenses().size(); j++) {
                        Expense ex = cf.getExpenses().get(j);
                        billOut.printf("%d,%s,%s,%s,%d,%s,%s,%.2f,%s,%.2f,%s%n",
                                cf.getCaseId(), escapeCsv(cf.getDocketNumber()), escapeCsv(clientName),
                                escapeCsv(clientIdNum), ex.getExpenseId(), ex.getExpenseDate(),
                                escapeCsv(ex.getDescription()), ex.getAmount(),
                                (ex.isPaid() ? "PAID" : "PENDING"), totalDebt, accStatus);
                    }
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error generating CSV reports: " + e.getMessage());
            return false;
        }
    }
}