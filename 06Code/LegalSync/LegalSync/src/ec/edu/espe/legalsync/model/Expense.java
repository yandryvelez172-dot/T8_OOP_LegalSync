package ec.edu.espe.legalsync.model;

/**
 *
 * @author Josselyn Ulcuango, CodeLex, @ESPE
 */
public class Expense {
    
    private int expenseId;
    private int caseId;
    private String description;
    private double amount;
    private String expenseDate;
    private boolean paid;

    public Expense() {
        this.paid = false;
    }

    public Expense(int expenseId, int caseId, String description, double amount, String expenseDate, boolean paid) {
        this.expenseId = expenseId;
        this.caseId = caseId;
        this.description = description;
        this.amount = amount >= 0 ? amount : 0.0;
        this.expenseDate = expenseDate;
        this.paid = paid;
    }

    public void markAsPaid() {
        this.paid = true;
    }

    public String getDetails() {
        return String.format("Expense ID: %d | Case ID: %d | Date: %-10s | Amount: $%-8.2f | Status: %-7s | Desc: %s",
                expenseId, caseId, expenseDate, amount, (paid ? "PAID" : "PENDING"), description);
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        }
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return getDetails();
    }
    
}
