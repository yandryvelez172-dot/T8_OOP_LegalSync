package ec.edu.espe.legalsync.view;

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
import ec.edu.espe.legalsync.service.LegalSyncService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Yandry Velez, Codelex, @ESPE
 */
public class LegalSyncSystem {

    private static final String[] MENU_OPTIONS = {
        "1. [PB-001] Manage Users & Email Role Hierarchy (DIRECTOR Only)",
        "2. [PB-002] Account Security & Change Password",
        "3. [PB-003] Register & View Clients",
        "4. [PB-004] Register & Classify Case File ( or Update Case Status )",
        "5. [PB-005] Multi-Criteria Case Search & Client Debt Inspection",
        "6. [PB-006] Case Expense & Client Debt Ledger (Add Expense / Mark Paid)",
        "7. [PB-007] Lawyer Dispositions, Tasks & Schedule Calendar",
        "8. [PB-008] Attach Document / Evidence Local File Path",
        "9. [PB-009] Generate CSV Reports & View Audit Log",
        "0. Log Out / Exit System"
    };

    private static Scanner scanner = new Scanner(System.in);
    private static LegalSyncService service = new LegalSyncService();

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("          LEGALSYNC - LEGAL CASE MANAGEMENT SYSTEM (v2.0)             ");
        System.out.println("                   Team CodeLex | ESPE - OOP                          ");
        System.out.println("======================================================================");

        boolean runningSystem = true;
        while (runningSystem) {
            if (service.getCurrentUser() == null) {
                runningSystem = showLoginScreen();
            } else {
                showMainConsoleMenu();
            }
        }
        System.out.println("Thank you for using LegalSync. All JSON data files are saved.");
    }

    private static boolean showLoginScreen() {
        System.out.println("\n--- AUTHENTICATION SCREEN (Data loaded from data/users.json) ---");
        System.out.println("Default Accounts for Testing:");
        System.out.println("  * Director (Full Access) : director@legalsync.com  | Pass: admin123");
        System.out.println("  * Partner  (Write Access): partner@legalsync.com   | Pass: partner123");
        System.out.println("  * Secretary (Read-Only)  : secretary@legalsync.com | Pass: sec123");
        System.out.println("Type 'EXIT' as email to close the application.");
        System.out.print("Enter registered email: ");
        String email = scanner.nextLine().trim();

        if ("EXIT".equalsIgnoreCase(email)) {
            return false;
        }

        System.out.print("Enter password (masked [****]): ");
        String password = scanner.nextLine().trim();

        try {
            User logged = service.authenticate(email, password);
            System.out.println("\n[SUCCESS] Welcome, " + logged.getName() + " | Role: " + logged.getRole());
        } catch (LegalSyncException e) {
            System.out.println("\n[AUTH ERROR - " + e.getErrorCode() + "] " + e.getMessage());
        }
        return true;
    }

    private static void showMainConsoleMenu() {
        User current = service.getCurrentUser();
        System.out.println("\n======================================================================");
        System.out.println(" MAIN NAVIGABLE MENU | User: " + current.getEmail() + " [" + current.getRole() + "]");
        System.out.println("======================================================================");
        for (int i = 0; i < MENU_OPTIONS.length; i++) {
            System.out.println("  " + MENU_OPTIONS[i]);
        }
        System.out.println("======================================================================");

        int option = readInt("Select an operation (0-9): ");
        try {
            switch (option) {
                case 1:
                    handleOperation1ManageUsers();
                    break;
                case 2:
                    handleOperation2Security();
                    break;
                case 3:
                    handleOperation3Clients();
                    break;
                case 4:
                    handleOperation4Cases();
                    break;
                case 5:
                    handleOperation5SearchAndDebt();
                    break;
                case 6:
                    handleOperation6Expenses();
                    break;
                case 7:
                    handleOperation7DispositionsAndCalendar();
                    break;
                case 8:
                    handleOperation8Documents();
                    break;
                case 9:
                    handleOperation9ReportsAndAudit();
                    break;
                case 0:
                    current.logout();
                    service.setCurrentUser(null);
                    break;
                default:
                    System.out.println("[WARNING] Invalid option. Please enter a number between 0 and 9.");
            }
        } catch (LegalSyncException e) {
            System.out.println("\n[OPERATION DENIED - " + e.getErrorCode() + "] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[UNEXPECTED ERROR] " + e.getMessage());
        }
    }

    // OPERATION 1: Manage Users & Roles (Director Only)
    private static void handleOperation1ManageUsers() throws LegalSyncException {
        System.out.println("\n--- OP 1: HIERARCHICAL ROLE & EMAIL ACCESS MANAGEMENT ---");
        List<User> allUsers = service.getUsers();
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.println("  " + allUsers.get(i).toString());
        }
        System.out.println("\n1. Create User or Update Role/Access by Email (DIRECTOR Only)");
        System.out.println("2. Return to Main Menu");
        int sub = readInt("Select option: ");
        if (sub == 1) {
            service.verifyDirectorPermission();
            System.out.print("Enter staff email address: ");
            String email = scanner.nextLine().trim();
            System.out.print("Enter staff full name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter password (for new account): ");
            String pass = scanner.nextLine().trim();
            System.out.println("Available Roles: DIRECTOR, PARTNER, ASSOCIATE_LAWYER, JUNIOR_LAWYER, LEGAL_ASSISTANT, SECRETARY");
            System.out.print("Enter assigned role: ");
            String role = scanner.nextLine().trim().toUpperCase();
            System.out.print("Enable account access? (true/false): ");
            boolean active = Boolean.parseBoolean(scanner.nextLine().trim());

            service.registerOrUpdateUserRole(name, email, pass, role, active);
            System.out.println("[SUCCESS] User account/role saved to data/users.json.");
        }
    }

    // OPERATION 2: Change Password & Account Info
    private static void handleOperation2Security() {
        User u = service.getCurrentUser();
        System.out.println("\n--- OP 2: ACCOUNT SECURITY & CREDENTIAL VALIDATION ---");
        System.out.println("Logged in as: " + u.toString());
        System.out.print("Do you want to change your password? (yes/no): ");
        String ans = scanner.nextLine().trim();
        if ("yes".equalsIgnoreCase(ans)) {
            System.out.print("Enter current password: ");
            String oldP = scanner.nextLine().trim();
            System.out.print("Enter new password: ");
            String newP = scanner.nextLine().trim();
            if (u.changePassword(oldP, newP)) {
                ec.edu.espe.legalsync.utils.FileManager.saveUsersToJson(service.getUsers());
                service.recordAudit("PASSWORD_CHANGED", "N/A");
                System.out.println("[SUCCESS] Password updated in data/users.json.");
            } else {
                System.out.println("[ERROR] Current password is incorrect or new password is empty.");
            }
        }
    }

    // OPERATION 3: Register & View Clients
    private static void handleOperation3Clients() throws LegalSyncException {
        System.out.println("\n--- OP 3: CLIENT MANAGEMENT (data/clients.json) ---");
        System.out.println("1. List All Registered Clients");
        System.out.println("2. Register New Client");
        int sub = readInt("Select option: ");
        if (sub == 1) {
            List<Client> list = service.getClients();
            for (int i = 0; i < list.size(); i++) {
                System.out.println("  " + list.get(i).getDetails());
            }
        } else if (sub == 2) {
            service.verifyWritePermission();
            System.out.print("Enter Client ID/RUC (10-13 digits): ");
            String idNum = scanner.nextLine().trim();
            System.out.print("Enter Client Full Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine().trim();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine().trim();
            System.out.print("Enter Address: ");
            String addr = scanner.nextLine().trim();

            Client c = service.registerClient(idNum, name, phone, email, addr);
            System.out.println("[SUCCESS] Client registered with ID: " + c.getClientId());
        }
    }

    // OPERATION 4: Register & Classify Case File / Update Status
    private static void handleOperation4Cases() throws LegalSyncException {
        System.out.println("\n--- OP 4: CASE REGISTRATION, CODING & CLASSIFICATION (data/cases.json) ---");
        System.out.println("1. Register New Classified Case File");
        System.out.println("2. Update Existing Case Status (ACTIVE / PASSIVE / CLOSED) or Priority");
        int sub = readInt("Select option: ");
        if (sub == 1) {
            service.verifyWritePermission();
            int caseId = readInt("Enter Unique Case ID (e.g., 102): ");
            System.out.print("Enter Official Judicial Docket Code (e.g., 17203-2026-00890): ");
            String docket = scanner.nextLine().trim();
            System.out.print("Enter Case Title: ");
            String title = scanner.nextLine().trim();
            System.out.print("Enter Process Class (e.g., Ordinary, Summary, Executive): ");
            String pClass = scanner.nextLine().trim();
            System.out.print("Enter Legal Category (CRIMINAL, FAMILY, CIVIL, LABOR, TRANSIT): ");
            String cat = scanner.nextLine().trim().toUpperCase();
            System.out.print("Enter Priority (HIGH, MEDIUM, LOW): ");
            String prio = scanner.nextLine().trim().toUpperCase();
            System.out.print("Enter Judicial Unit (Unidad Judicial): ");
            String jUnit = scanner.nextLine().trim();
            System.out.print("Enter Initial Case Status (ACTIVE / PASSIVE): ");
            String status = scanner.nextLine().trim().toUpperCase();
            System.out.print("Enter Opening Date (YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();

            System.out.println("Available Clients:");
            for (int i = 0; i < service.getClients().size(); i++) {
                System.out.println("  " + service.getClients().get(i).getDetails());
            }
            int clientId = readInt("Enter Client ID for this case: ");
            Client cl = service.findClientById(clientId);
            if (cl == null) {
                throw new LegalSyncException("ERR-CLIENT", "Client ID not found. Register the client first in Op 3.");
            }

            System.out.print("Enter Defendant Full Name: ");
            String defName = scanner.nextLine().trim();
            System.out.print("Enter Defendant ID/Cedula: ");
            String defId = scanner.nextLine().trim();
            Defendant def = new Defendant(caseId, defId, defName, "N/A", "Quito");

            System.out.print("Enter Assigned Lawyer Name: ");
            String lawName = scanner.nextLine().trim();
            System.out.print("Enter Assigned Lawyer Email: ");
            String lawEmail = scanner.nextLine().trim();
            Lawyer law = new Lawyer(1, lawName, lawEmail, "LAWYER", "MAT-17");

            service.registerCaseFile(caseId, docket, title, pClass, cat, prio, jUnit, status, date, cl, def, law);
            System.out.println("[SUCCESS] Case file registered and saved to data/cases.json.");
        } else if (sub == 2) {
            service.verifyWritePermission();
            int caseId = readInt("Enter Case ID to update: ");
            System.out.print("Enter new Status (ACTIVE, PASSIVE, IN_PROGRESS, SUSPENDED, CLOSED): ");
            String st = scanner.nextLine().trim().toUpperCase();
            System.out.print("Enter new Priority (HIGH, MEDIUM, LOW): ");
            String pr = scanner.nextLine().trim().toUpperCase();
            service.updateCaseStatus(caseId, st, pr);
            System.out.println("[SUCCESS] Case status updated in data/cases.json.");
        }
    }

    // OPERATION 5: Multi-Criteria Search & Client Debt Inspection
    private static void handleOperation5SearchAndDebt() {
        System.out.println("\n--- OP 5: MULTI-CRITERIA CASE SEARCH & CLIENT DEBT INSPECTION ---");
        System.out.println("1. Search by Case ID (Displays full case, client profile, and debt ledger)");
        System.out.println("2. Search by Client Name");
        System.out.println("3. Filter by Legal Category (CRIMINAL, FAMILY, CIVIL, LABOR, TRANSIT)");
        System.out.println("4. Filter by Case Status (ACTIVE / PASSIVE / CLOSED)");
        System.out.println("5. View All Cases");
        int sub = readInt("Select search criterion: ");

        if (sub == 1) {
            int id = readInt("Enter Case ID: ");
            CaseFile cf = service.findCaseById(id);
            if (cf == null) {
                System.out.println("[INFO] No case found with ID " + id);
            } else {
                displayFullCaseAndClientDebt(cf);
            }
        } else if (sub == 2) {
            System.out.print("Enter Client Name (or part of name): ");
            String name = scanner.nextLine();
            printCaseList(service.searchByClientName(name));
        } else if (sub == 3) {
            System.out.print("Enter Category (CRIMINAL, FAMILY, CIVIL, LABOR, TRANSIT): ");
            String cat = scanner.nextLine();
            printCaseList(service.filterByCategory(cat));
        } else if (sub == 4) {
            System.out.print("Enter Status (ACTIVE, PASSIVE, IN_PROGRESS, SUSPENDED, CLOSED): ");
            String st = scanner.nextLine();
            printCaseList(service.filterByStatus(st));
        } else if (sub == 5) {
            printCaseList(service.getCaseFiles());
        }
    }

    private static void printCaseList(List<CaseFile> list) {
        if (list.isEmpty()) {
            System.out.println("[INFO] No matching case files found.");
            return;
        }
        System.out.println("\n--- MATCHING CASE FILES (" + list.size() + ") ---");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  " + list.get(i).getSummary());
        }
    }

    private static void displayFullCaseAndClientDebt(CaseFile cf) {
        System.out.println("\n**********************************************************************");
        System.out.println(" CASE DOCKET DETAILS: " + cf.getDocketNumber() + " (Case ID: " + cf.getCaseId() + ")");
        System.out.println("**********************************************************************");
        System.out.println(" Title         : " + cf.getTitle());
        System.out.println(" Process Class : " + cf.getProcessClass() + " | Category: " + cf.getCategory() + " | Priority: " + cf.getPriority());
        System.out.println(" Judicial Unit : " + cf.getJudicialUnit() + " | Status: " + cf.getStatus() + " | Opened: " + cf.getOpeningDate());
        if (cf.getClient() != null) {
            System.out.println(" CLIENT PROFILE: " + cf.getClient().getDetails());
        }
        if (cf.getDefendant() != null) {
            System.out.println(" DEFENDANT     : " + cf.getDefendant().getDetails());
        }
        System.out.println("\n --- ITEMIZED EXPENSE & CLIENT DEBT LEDGER ---");
        if (cf.getExpenses().isEmpty()) {
            System.out.println("  No procedural expenses recorded for this case.");
        } else {
            for (int i = 0; i < cf.getExpenses().size(); i++) {
                System.out.println("  " + cf.getExpenses().get(i).getDetails());
            }
        }
        System.out.printf(" TOTAL BILLED: $%.2f | TOTAL PENDING CLIENT DEBT: $%.2f | ACCOUNT STATUS: %s%n",
                cf.calculateTotalBilled(), cf.calculateTotalDebt(),
                (cf.isPaidInFull() ? "PAID IN FULL (Completo)" : "PENDING BALANCE (Debe)"));
        System.out.println("**********************************************************************");
    }

    // OPERATION 6: Case Expense & Client Debt Ledger
    private static void handleOperation6Expenses() throws LegalSyncException {
        System.out.println("\n--- OP 6: CASE EXPENSE & CLIENT DEBT LEDGER ---");
        System.out.println("1. View Expense & Debt Statement for a Case");
        System.out.println("2. Add New Procedural Expense / Legal Cost to a Case");
        System.out.println("3. Mark an Expense Item as PAID");
        int sub = readInt("Select option: ");
        int caseId = readInt("Enter Case ID: ");

        if (sub == 1) {
            CaseFile cf = service.findCaseById(caseId);
            if (cf != null) {
                displayFullCaseAndClientDebt(cf);
            } else {
                System.out.println("[ERROR] Case not found.");
            }
        } else if (sub == 2) {
            service.verifyWritePermission();
            System.out.print("Enter Expense Description (e.g., Notarized copies for alimony): ");
            String desc = scanner.nextLine().trim();
            double amount = readDouble("Enter Expense Amount in USD (e.g., 5.00): ");
            System.out.print("Enter Expense Date (YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();
            System.out.print("Is this expense already paid? (true/false): ");
            boolean paid = Boolean.parseBoolean(scanner.nextLine().trim());

            service.addExpenseToCase(caseId, desc, amount, date, paid);
            System.out.println("[SUCCESS] Expense added and client debt recalculated in data/cases.json.");
        } else if (sub == 3) {
            service.verifyWritePermission();
            int expId = readInt("Enter Expense ID to mark as PAID: ");
            service.markExpenseAsPaid(caseId, expId);
            System.out.println("[SUCCESS] Expense marked as PAID. Client debt updated.");
        }
    }

    // OPERATION 7: Dispositions, Tasks & Schedule Calendar
    private static void handleOperation7DispositionsAndCalendar() throws LegalSyncException {
        System.out.println("\n--- OP 7: LAWYER DISPOSITIONS, PENDING TASKS & SCHEDULE CALENDAR ---");
        System.out.println("1. Consult Chronological Court Schedule Calendar (All Roles / Secretary)");
        System.out.println("2. Add Lawyer Disposition / Task / Hearing Date to a Case");
        System.out.println("3. Mark a Pending Task / Disposition as COMPLETED");
        int sub = readInt("Select option: ");

        if (sub == 1) {
            List<Deadline> schedule = service.getAllScheduleDeadlines();
            System.out.println("\n--- COURT SCHEDULE & PENDING TASKS CALENDAR ---");
            if (schedule.isEmpty()) {
                System.out.println("  No scheduled hearings or tasks registered.");
            } else {
                for (int i = 0; i < schedule.size(); i++) {
                    System.out.println("  " + schedule.get(i).getDetails());
                }
            }
        } else if (sub == 2) {
            service.verifyWritePermission();
            int caseId = readInt("Enter Case ID: ");
            System.out.print("Enter Task/Hearing Title: ");
            String desc = scanner.nextLine().trim();
            System.out.print("Enter Lawyer Disposition / Instructions: ");
            String disp = scanner.nextLine().trim();
            System.out.print("Enter Type (HEARING, FILING, JUDICIAL_TASK): ");
            String type = scanner.nextLine().trim().toUpperCase();
            System.out.print("Enter Target Date (YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();
            System.out.print("Enter Assigned Staff Email (Junior Lawyer or Legal Assistant): ");
            String assigned = scanner.nextLine().trim();

            service.addDeadlineToCase(caseId, desc, disp, type, date, assigned);
            System.out.println("[SUCCESS] Disposition and date added to schedule calendar in data/cases.json.");
        } else if (sub == 3) {
            service.verifyWritePermission();
            int caseId = readInt("Enter Case ID: ");
            int dlId = readInt("Enter Task/Deadline ID to mark COMPLETED: ");
            service.completeDeadlineTask(caseId, dlId);
            System.out.println("[SUCCESS] Pending task marked as COMPLETED.");
        }
    }

    // OPERATION 8: Attach Document / Evidence Reference
    private static void handleOperation8Documents() throws LegalSyncException {
        System.out.println("\n--- OP 8: DOCUMENT & EVIDENCE FILE PATH REGISTRATION ---");
        System.out.println("1. View Linked Documents for a Case");
        System.out.println("2. Attach Local File Path to a Case");
        int sub = readInt("Select option: ");
        int caseId = readInt("Enter Case ID: ");
        CaseFile cf = service.findCaseById(caseId);
        if (cf == null) {
            System.out.println("[ERROR] Case ID not found.");
            return;
        }
        if (sub == 1) {
            if (cf.getDocuments().isEmpty()) {
                System.out.println("  No documents linked to this case.");
            } else {
                for (int i = 0; i < cf.getDocuments().size(); i++) {
                    System.out.println("  " + cf.getDocuments().get(i).getDetails());
                }
            }
        } else if (sub == 2) {
            service.verifyWritePermission();
            System.out.print("Enter Document/Evidence Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter Format/Type (PDF, DOCX, EVIDENCE): ");
            String type = scanner.nextLine().trim().toUpperCase();
            System.out.print("Enter Local File Path (e.g., C:\\cases\\evidence1.pdf): ");
            String path = scanner.nextLine().trim();
            System.out.print("Enter Upload Date (YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();

            service.attachDocumentToCase(caseId, name, type, path, date);
            System.out.println("[SUCCESS] Document path linked in data/cases.json.");
        }
    }

    // OPERATION 9: Generate CSV Reports & View Audit Log
    private static void handleOperation9ReportsAndAudit() {
        System.out.println("\n--- OP 9: CSV DATA REPORTS & SYSTEM AUDIT LOG ---");
        System.out.println("1. Generate CSV Data Reports (reports/cases_report.csv & reports/billing_report.csv)");
        System.out.println("2. View Modification Audit Log (data/audit_log.json)");
        int sub = readInt("Select option: ");

        if (sub == 1) {
            if (service.exportAllReportsToCsv()) {
                System.out.println("[SUCCESS] CSV Reports generated successfully:");
                System.out.println("  -> reports/cases_report.csv   (Classified Active/Passive Cases)");
                System.out.println("  -> reports/billing_report.csv (Itemized Expenses, Invoices & Client Debts)");
            }
        } else if (sub == 2) {
            List<AuditEntry> logs = service.getAuditLog();
            System.out.println("\n--- CHRONOLOGICAL AUDIT LOG (" + logs.size() + " entries) ---");
            for (int i = 0; i < logs.size(); i++) {
                System.out.println("  " + logs.get(i).toLogLine());
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[INPUT ERROR] Please enter a valid integer number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("[INPUT ERROR] Please enter a valid decimal amount (e.g., 5.00).");
            }
        }
    }
}