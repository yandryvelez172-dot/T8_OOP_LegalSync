package ec.edu.espe.legalsync.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author Josselyn Ulcuango, CodeLex, @ESPE
 */
public class Deadline {
    
    private int deadlineId;
    private int caseId;
    private String description;
    private String disposition;
    private String type;
    private String targetDate;
    private String assignedUser;
    private boolean completed;

    public Deadline() {
        this.completed = false;
    }

    public Deadline(int deadlineId, int caseId, String description, String disposition,
            String type, String targetDate, String assignedUser, boolean completed) {
        this.deadlineId = deadlineId;
        this.caseId = caseId;
        this.description = description;
        this.disposition = disposition;
        this.type = type;
        this.targetDate = targetDate;
        this.assignedUser = assignedUser;
        this.completed = completed;
    }

    public int calculateRemainingDays() {
        try {
            LocalDate target = LocalDate.parse(this.targetDate);
            LocalDate today = LocalDate.now();
            return (int) ChronoUnit.DAYS.between(today, target);
        } catch (Exception e) {
            return 0;
        }
    }

    public void markCompleted() {
        this.completed = true;
    }

    public String getDetails() {
        int remaining = calculateRemainingDays();
        String state = completed ? "COMPLETED" : ("PENDING (" + remaining + " days)");
        return String.format("Task ID: %d | Case: %d | Date: %-10s | Type: %-10s | Assigned: %-18s | State: %-20s | Disposition: %s (%s)",
                deadlineId, caseId, targetDate, type, assignedUser, state, disposition, description);
    }

    public int getDeadlineId() {
        return deadlineId;
    }

    public void setDeadlineId(int deadlineId) {
        this.deadlineId = deadlineId;
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

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
