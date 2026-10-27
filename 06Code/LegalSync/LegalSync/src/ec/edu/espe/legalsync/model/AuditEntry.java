package ec.edu.espe.legalsync.model;

/**
 *
 * @author Josselyn Ulcuango, CodeLex, @ESPE
 */
public class AuditEntry {
    
    private String dateTime;
    private String userEmail;
    private String role;
    private String action;
    private String docketNumber;

    public AuditEntry() {
    }

    public AuditEntry(String dateTime, String userEmail, String role, String action, String docketNumber) {
        this.dateTime = dateTime;
        this.userEmail = userEmail;
        this.role = role;
        this.action = action;
        this.docketNumber = docketNumber;
    }

    public String toLogLine() {
        return String.format("[%s] User: %-24s | Role: %-16s | Case/Docket: %-12s | Action: %s",
                dateTime, userEmail, role, docketNumber, action);
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDocketNumber() {
        return docketNumber;
    }

    public void setDocketNumber(String docketNumber) {
        this.docketNumber = docketNumber;
    }

    @Override
    public String toString() {
        return toLogLine();
    }
}
