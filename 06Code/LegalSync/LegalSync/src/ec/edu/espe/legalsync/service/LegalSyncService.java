package ec.edu.espe.legalsync.service;

import ec.edu.espe.legalsync.exception.LegalSyncException;
import ec.edu.espe.legalsync.model.AuditEntry;
import ec.edu.espe.legalsync.model.CaseFile;
import ec.edu.espe.legalsync.model.Client;
import ec.edu.espe.legalsync.model.Deadline;
import ec.edu.espe.legalsync.model.Defendant;
import ec.edu.espe.legalsync.model.Document;
import ec.edu.espe.legalsync.model.Expense;
import ec.edu.espe.legalsync.model.Lawyer;
import ec.edu.espe.legalsync.model.User;
import ec.edu.espe.legalsync.utils.FileManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christopher Torres, CodeLex, @ESPE
 */

public class LegalSyncService {

    private List<User> users;
    private List<Client> clients;
    private List<CaseFile> caseFiles;
    private List<AuditEntry> auditLog;
    private User currentUser;

    public LegalSyncService() {
        this.users = FileManager.loadUsersFromJson();
        this.clients = FileManager.loadClientsFromJson();
        this.caseFiles = FileManager.loadCasesFromJson(this.clients);
        this.auditLog = FileManager.loadAuditFromJson();
        initializeDefaultDataIfEmpty();
    }

    private void initializeDefaultDataIfEmpty() {
        if (this.users.isEmpty()) {
            this.users.add(new User(1, "Managing Director", "director@legalsync.com", "admin123", "DIRECTOR", true));
            this.users.add(new User(2, "Senior Partner", "partner@legalsync.com", "partner123", "PARTNER", true));
            this.users.add(new User(3, "Associate Lawyer", "associate@legalsync.com", "assoc123", "ASSOCIATE_LAWYER", true));
            this.users.add(new User(4, "Junior Lawyer", "junior@legalsync.com", "junior123", "JUNIOR_LAWYER", true));
            this.users.add(new User(5, "Legal Assistant", "assistant@legalsync.com", "assist123", "LEGAL_ASSISTANT", true));
            this.users.add(new User(6, "Firm Secretary", "secretary@legalsync.com", "sec123", "SECRETARY", true));
            FileManager.saveUsersToJson(this.users);
        }
        if (this.clients.isEmpty()) {
            Client c1 = new Client(1, "1712345678", "Maria Fernanda Gomez", "0991112233", "mgomez@mail.com", "Av. Amazonas, Quito");
            Client c2 = new Client(2, "1798765432", "Carlos Andres Vaca", "0984445566", "cvaca@mail.com", "San Martin, Quito");
            this.clients.add(c1);
            this.clients.add(c2);
            FileManager.saveClientsToJson(this.clients);

            if (this.caseFiles.isEmpty()) {
                Defendant d1 = new Defendant(1, "1700112233", "Jorge Luis Perez", "0998887766", "Carcelen, Quito");
                Lawyer l1 = new Lawyer(1, "Managing Director", "director@legalsync.com", "DIRECTOR", "MAT-17-2020-01");
                CaseFile cf1 = new CaseFile(101, "17203-2026-00451", "Alimony Claim Gomez vs Perez",
                        "Summary Proceeding", "FAMILY", "HIGH", "Family Judicial Unit North Quito",
                        "ACTIVE", "2026-10-10", c1, d1, l1);
                cf1.addExpense(new Expense(1, 101, "Notarized copies for alimony filing", 5.00, "2026-10-12", false));
                cf1.addExpense(new Expense(2, 101, "Judicial courier notification fee", 15.00, "2026-10-15", false));
                cf1.addExpense(new Expense(3, 101, "Initial legal consultation fee", 50.00, "2026-10-10", true));
                cf1.addDeadline(new Deadline(1, 101, "Single Alimony Hearing", "Prepare income certificates and witnesses",
                        "HEARING", "2026-11-15", "junior@legalsync.com", false));
                cf1.addDocument(new Document(1, "Alimony_Lawsuit.pdf", "PDF", "C:\\cases\\101\\Alimony_Lawsuit.pdf", "2026-10-10"));
                this.caseFiles.add(cf1);
                FileManager.saveCasesToJson(this.caseFiles);
            }
        }
    }

    public void recordAudit(String action, String docketNumber) {
        String email = (currentUser != null) ? currentUser.getEmail() : "SYSTEM";
        String role = (currentUser != null) ? currentUser.getRole() : "SYSTEM";
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.auditLog.add(new AuditEntry(now, email, role, action, docketNumber));
        FileManager.saveAuditToJson(this.auditLog);
    }

    public void verifyWritePermission() throws LegalSyncException {
        if (currentUser == null) {
            throw new LegalSyncException("ERR-AUTH", "You must be logged in to perform this action.");
        }
        if (!currentUser.hasPermission("WRITE")) {
            throw new LegalSyncException("ERR-ROLE-READONLY",
                    "Access Denied: Role '" + currentUser.getRole() + "' is restricted to read-only visualization.");
        }
    }

    public void verifyDirectorPermission() throws LegalSyncException {
        if (currentUser == null || !currentUser.hasPermission("MANAGE_USERS")) {
            throw new LegalSyncException("ERR-DIRECTOR-ONLY",
                    "Access Denied: Only the Managing Director (DIRECTOR) can manage user roles and accounts.");
        }
    }

    // Operation 1 & 2: Authentication and Role Management
    public User authenticate(String email, String password) throws LegalSyncException {
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.getEmail().equalsIgnoreCase(email.trim())) {
                if (!u.isActive()) {
                    throw new LegalSyncException("ERR-DISABLED", "Account disabled by the Managing Director.");
                }
                if (u.login(email, password)) {
                    this.currentUser = u;
                    recordAudit("USER_LOGIN", "N/A");
                    return u;
                } else {
                    throw new LegalSyncException("ERR-CREDENTIALS", "Invalid password.");
                }
            }
        }
        throw new LegalSyncException("ERR-NOT-FOUND", "No registered user found with email: " + email);
    }

    public void registerOrUpdateUserRole(String name, String email, String password, String role, boolean active)
            throws LegalSyncException {
        verifyDirectorPermission();
        if (!User.isValidRole(role)) {
            throw new LegalSyncException("ERR-INVALID-ROLE", "Invalid role specified.");
        }
        for (int i = 0; i < users.size(); i++) {
            User existing = users.get(i);
            if (existing.getEmail().equalsIgnoreCase(email.trim())) {
                existing.setRole(role);
                existing.setActive(active);
                if (name != null && !name.trim().isEmpty()) {
                    existing.setName(name.trim());
                }
                FileManager.saveUsersToJson(users);
                recordAudit("UPDATE_USER_ROLE -> " + email + " (" + role + ", active=" + active + ")", "N/A");
                return;
            }
        }
        int nextId = users.size() + 1;
        User newUser = new User(nextId, name, email.trim(), password, role.toUpperCase(), active);
        users.add(newUser);
        FileManager.saveUsersToJson(users);
        recordAudit("CREATE_USER -> " + email + " [" + role + "]", "N/A");
    }

    // Operation 3: Client Management
    public Client registerClient(String idNumber, String name, String phone, String email, String address)
            throws LegalSyncException {
        verifyWritePermission();
        if (idNumber == null || idNumber.trim().isEmpty() || name == null || name.trim().isEmpty()) {
            throw new LegalSyncException("ERR-MANDATORY", "Client ID number and name are mandatory.");
        }
        int nextId = clients.size() + 1;
        Client c = new Client(nextId, idNumber.trim(), name.trim(), phone, email, address);
        clients.add(c);
        FileManager.saveClientsToJson(clients);
        recordAudit("REGISTER_CLIENT -> " + c.getName(), "CLIENT-" + nextId);
        return c;
    }

    public Client findClientById(int clientId) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getClientId() == clientId) {
                return clients.get(i);
            }
        }
        return null;
    }

    // Operation 4: Case Registration & Status Update
    public CaseFile registerCaseFile(int caseId, String docketNumber, String title, String processClass,
            String category, String priority, String judicialUnit, String status, String openingDate,
            Client client, Defendant defendant, Lawyer lawyer) throws LegalSyncException {
        verifyWritePermission();
        if (findCaseById(caseId) != null) {
            throw new LegalSyncException("ERR-DUPLICATE-ID", "A case with ID " + caseId + " already exists.");
        }
        CaseFile cf = new CaseFile(caseId, docketNumber, title, processClass, category, priority,
                judicialUnit, status, openingDate, client, defendant, lawyer);
        if (!cf.validateMandatoryFields()) {
            throw new LegalSyncException("ERR-CASE-FIELDS", "Case ID, Docket Number, Title, and Client are mandatory.");
        }
        caseFiles.add(cf);
        FileManager.saveCasesToJson(caseFiles);
        recordAudit("REGISTER_CASE [" + category + " | " + status + "]", docketNumber);
        return cf;
    }

    public void updateCaseStatus(int caseId, String newStatus, String newPriority) throws LegalSyncException {
        verifyWritePermission();
        CaseFile cf = findCaseById(caseId);
        if (cf == null) {
            throw new LegalSyncException("ERR-CASE-NOT-FOUND", "Case ID " + caseId + " not found.");
        }
        if (newStatus != null && !newStatus.trim().isEmpty()) {
            cf.setStatus(newStatus);
        }
        if (newPriority != null && !newPriority.trim().isEmpty()) {
            cf.setPriority(newPriority);
        }
        FileManager.saveCasesToJson(caseFiles);
        recordAudit("UPDATE_CASE_STATUS -> Status: " + cf.getStatus() + ", Priority: " + cf.getPriority(), cf.getDocketNumber());
    }

    // Operation 5: Multi-Criteria Search Engine
    public CaseFile findCaseById(int caseId) {
        for (int i = 0; i < caseFiles.size(); i++) {
            if (caseFiles.get(i).getCaseId() == caseId) {
                return caseFiles.get(i);
            }
        }
        return null;
    }

    public List<CaseFile> searchByClientName(String query) {
        List<CaseFile> results = new ArrayList<>();
        if (query == null) return results;
        String q = query.trim().toLowerCase();
        for (int i = 0; i < caseFiles.size(); i++) {
            CaseFile cf = caseFiles.get(i);
            if (cf.getClient() != null && cf.getClient().getName().toLowerCase().contains(q)) {
                results.add(cf);
            }
        }
        return results;
    }

    public List<CaseFile> filterByCategory(String category) {
        List<CaseFile> results = new ArrayList<>();
        if (category == null) return results;
        for (int i = 0; i < caseFiles.size(); i++) {
            if (caseFiles.get(i).getCategory().equalsIgnoreCase(category.trim())) {
                results.add(caseFiles.get(i));
            }
        }
        return results;
    }

    public List<CaseFile> filterByStatus(String status) {
        List<CaseFile> results = new ArrayList<>();
        if (status == null) return results;
        for (int i = 0; i < caseFiles.size(); i++) {
            if (caseFiles.get(i).getStatus().equalsIgnoreCase(status.trim())) {
                results.add(caseFiles.get(i));
            }
        }
        return results;
    }

    // Operation 6: Case Expense & Client Debt Ledger
    public void addExpenseToCase(int caseId, String description, double amount, String date, boolean paid)
            throws LegalSyncException {
        verifyWritePermission();
        if (amount <= 0) {
            throw new LegalSyncException("ERR-AMOUNT", "Expense amount must be greater than $0.00.");
        }
        CaseFile cf = findCaseById(caseId);
        if (cf == null) {
            throw new LegalSyncException("ERR-CASE-NOT-FOUND", "Case ID " + caseId + " not found.");
        }
        int nextExpId = cf.getExpenses().size() + 1;
        Expense exp = new Expense(nextExpId, caseId, description, amount, date, paid);
        cf.addExpense(exp);
        FileManager.saveCasesToJson(caseFiles);
        recordAudit("ADD_EXPENSE ($" + String.format("%.2f", amount) + " - " + description + ")", cf.getDocketNumber());
    }

    public void markExpenseAsPaid(int caseId, int expenseId) throws LegalSyncException {
        verifyWritePermission();
        CaseFile cf = findCaseById(caseId);
        if (cf == null) {
            throw new LegalSyncException("ERR-CASE-NOT-FOUND", "Case ID " + caseId + " not found.");
        }
        for (int i = 0; i < cf.getExpenses().size(); i++) {
            Expense ex = cf.getExpenses().get(i);
            if (ex.getExpenseId() == expenseId) {
                ex.markAsPaid();
                FileManager.saveCasesToJson(caseFiles);
                recordAudit("PAY_EXPENSE (Expense ID " + expenseId + " marked PAID)", cf.getDocketNumber());
                return;
            }
        }
        throw new LegalSyncException("ERR-EXPENSE-NOT-FOUND", "Expense ID " + expenseId + " not found in Case " + caseId);
    }

    // Operation 7: Dispositions, Tasks & Schedule Calendar
    public void addDeadlineToCase(int caseId, String description, String disposition, String type,
            String targetDate, String assignedUser) throws LegalSyncException {
        verifyWritePermission();
        CaseFile cf = findCaseById(caseId);
        if (cf == null) {
            throw new LegalSyncException("ERR-CASE-NOT-FOUND", "Case ID " + caseId + " not found.");
        }
        int nextDlId = cf.getDeadlines().size() + 1;
        Deadline dl = new Deadline(nextDlId, caseId, description, disposition, type, targetDate, assignedUser, false);
        cf.addDeadline(dl);
        FileManager.saveCasesToJson(caseFiles);
        recordAudit("ADD_DISPOSITION_TASK (" + type + " on " + targetDate + ")", cf.getDocketNumber());
    }

    public void completeDeadlineTask(int caseId, int deadlineId) throws LegalSyncException {
        verifyWritePermission();
        CaseFile cf = findCaseById(caseId);
        if (cf == null) {
            throw new LegalSyncException("ERR-CASE-NOT-FOUND", "Case ID " + caseId + " not found.");
        }
        for (int i = 0; i < cf.getDeadlines().size(); i++) {
            Deadline dl = cf.getDeadlines().get(i);
            if (dl.getDeadlineId() == deadlineId) {
                dl.markCompleted();
                FileManager.saveCasesToJson(caseFiles);
                recordAudit("COMPLETE_TASK (Task ID " + deadlineId + ")", cf.getDocketNumber());
                return;
            }
        }
        throw new LegalSyncException("ERR-TASK-NOT-FOUND", "Task ID " + deadlineId + " not found in Case " + caseId);
    }

    public List<Deadline> getAllScheduleDeadlines() {
        List<Deadline> all = new ArrayList<>();
        for (int i = 0; i < caseFiles.size(); i++) {
            all.addAll(caseFiles.get(i).getDeadlines());
        }
        return all;
    }

    // Operation 8: Document & Evidence Path Registration
    public void attachDocumentToCase(int caseId, String name, String type, String filePath, String uploadDate)
            throws LegalSyncException {
        verifyWritePermission();
        CaseFile cf = findCaseById(caseId);
        if (cf == null) {
            throw new LegalSyncException("ERR-CASE-NOT-FOUND", "Case ID " + caseId + " not found.");
        }
        int nextDocId = cf.getDocuments().size() + 1;
        Document doc = new Document(nextDocId, name, type, filePath, uploadDate);
        cf.addDocument(doc);
        FileManager.saveCasesToJson(caseFiles);
        recordAudit("ATTACH_DOCUMENT (" + name + ")", cf.getDocketNumber());
    }

    // Operation 9: CSV Report Generation
    public boolean exportAllReportsToCsv() {
        boolean ok = FileManager.generateCsvReports(caseFiles);
        if (ok) {
            recordAudit("EXPORT_CSV_REPORTS (cases_report.csv & billing_report.csv)", "ALL");
        }
        return ok;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<CaseFile> getCaseFiles() {
        return caseFiles;
    }

    public List<AuditEntry> getAuditLog() {
        return auditLog;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}