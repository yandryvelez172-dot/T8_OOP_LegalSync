package ec.edu.espe.legalsync.model;

/**
 *
 * @author Mateo Unda, CodeLex, @ESPE
 */
public class LegalAssistant {
    private int assistantId;
    private String name;
    private String email;
    private String judicialUnit;

    public LegalAssistant() {
    }

    public LegalAssistant(int assistantId, String name, String email, String judicialUnit) {
        this.assistantId = assistantId;
        this.name = name;
        this.email = email;
        this.judicialUnit = judicialUnit;
    }

    public String getDetails() {
        return String.format("Assistant ID: %d | Name: %-20s | Email: %-25s | Judicial Unit: %s",
                assistantId, name, email, judicialUnit);
    }

    public int getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(int assistantId) {
        this.assistantId = assistantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJudicialUnit() {
        return judicialUnit;
    }

    public void setJudicialUnit(String judicialUnit) {
        this.judicialUnit = judicialUnit;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
