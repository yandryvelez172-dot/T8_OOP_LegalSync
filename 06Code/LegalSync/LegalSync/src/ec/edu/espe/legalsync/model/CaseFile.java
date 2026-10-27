package ec.edu.espe.legalsync.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josselyn Ulcuango, CodeLex, @ESPE
 */
public class CaseFile {
    
    public static final String[] VALID_CATEGORIES = {"CRIMINAL", "FAMILY", "CIVIL", "LABOR", "TRANSIT"};
    public static final String[] VALID_PRIORITIES = {"HIGH", "MEDIUM", "LOW"};
    public static final String[] VALID_STATUSES = {"ACTIVE", "PASSIVE", "IN_PROGRESS", "SUSPENDED", "CLOSED"};

    private int caseId;
    private String docketNumber;
    private String title;
    private String processClass;
    private String category;
    private String priority;
    private String judicialUnit;
    private String status;
    private String openingDate;
    private Client client;
    private Defendant defendant;
    private Lawyer assignedLawyer;
    private List<Document> documents;
    private List<Deadline> deadlines;
    private List<Expense> expenses;

    public CaseFile() {
        this.documents = new ArrayList<>();
        this.deadlines = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.status = "ACTIVE";
        this.priority = "MEDIUM";
        this.category = "CIVIL";
    }

    public CaseFile(int caseId, String docketNumber, String title, String processClass,
            String category, String priority, String judicialUnit, String status,
            String openingDate, Client client, Defendant defendant, Lawyer assignedLawyer) {
        this();
        this.caseId = caseId;
        this.docketNumber = docketNumber;
        this.title = title;
        this.processClass = processClass;
        this.category = isValidValue(category, VALID_CATEGORIES) ? category.toUpperCase() : "CIVIL";
        this.priority = isValidValue(priority, VALID_PRIORITIES) ? priority.toUpperCase() : "MEDIUM";
        this.judicialUnit = judicialUnit;
        this.status = isValidValue(status, VALID_STATUSES) ? status.toUpperCase() : "ACTIVE";
        this.openingDate = openingDate;
        this.client = client;
        this.defendant = defendant;
        this.assignedLawyer = assignedLawyer;
    }

    public static boolean isValidValue(String value, String[] allowedValues) {
        if (value == null || allowedValues == null) {
            return false;
        }
        for (int i = 0; i < allowedValues.length; i++) {
            if (allowedValues[i].equalsIgnoreCase(value.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean validateMandatoryFields() {
        return caseId > 0 && docketNumber != null && !docketNumber.trim().isEmpty()
                && title != null && !title.trim().isEmpty() && client != null;
    }

    public void addDocument(Document document) {
        if (document != null) {
            this.documents.add(document);
        }
    }

    public void addDeadline(Deadline deadline) {
        if (deadline != null) {
            this.deadlines.add(deadline);
        }
    }

    public void addExpense(Expense expense) {
        if (expense != null) {
            this.expenses.add(expense);
        }
    }

    public double calculateTotalBilled() {
        double total = 0.0;
        for (int i = 0; i < expenses.size(); i++) {
            total += expenses.get(i).getAmount();
        }
        return total;
    }

    public double calculateTotalDebt() {
        double debt = 0.0;
        for (int i = 0; i < expenses.size(); i++) {
            Expense exp = expenses.get(i);
            if (!exp.isPaid()) {
                debt += exp.getAmount();
            }
        }
        return debt;
    }

    public boolean isPaidInFull() {
        return calculateTotalDebt() == 0.0;
    }

    public String getSummary() {
        String clientName = (client != null) ? client.getName() : "N/A";
        String lawyerName = (assignedLawyer != null) ? assignedLawyer.getName() : "N/A";
        String paymentState = isPaidInFull() ? "PAID IN FULL ($0.00)" : String.format("PENDING ($%.2f)", calculateTotalDebt());
        return String.format("Case ID: %d | Docket: %-12s | Cat: %-8s | Priority: %-6s | Status: %-8s | Client: %-18s | Lawyer: %-16s | Debt: %s",
                caseId, docketNumber, category, priority, status, clientName, lawyerName, paymentState);
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getDocketNumber() {
        return docketNumber;
    }

    public void setDocketNumber(String docketNumber) {
        this.docketNumber = docketNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProcessClass() {
        return processClass;
    }

    public void setProcessClass(String processClass) {
        this.processClass = processClass;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (isValidValue(category, VALID_CATEGORIES)) {
            this.category = category.toUpperCase();
        }
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        if (isValidValue(priority, VALID_PRIORITIES)) {
            this.priority = priority.toUpperCase();
        }
    }

    public String getJudicialUnit() {
        return judicialUnit;
    }

    public void setJudicialUnit(String judicialUnit) {
        this.judicialUnit = judicialUnit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (isValidValue(status, VALID_STATUSES)) {
            this.status = status.toUpperCase();
        }
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Defendant getDefendant() {
        return defendant;
    }

    public void setDefendant(Defendant defendant) {
        this.defendant = defendant;
    }

    public Lawyer getAssignedLawyer() {
        return assignedLawyer;
    }

    public void setAssignedLawyer(Lawyer assignedLawyer) {
        this.assignedLawyer = assignedLawyer;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Deadline> getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(List<Deadline> deadlines) {
        this.deadlines = deadlines;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return getSummary();
    }
}
