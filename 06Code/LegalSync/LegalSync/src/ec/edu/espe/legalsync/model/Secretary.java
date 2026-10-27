package ec.edu.espe.legalsync.model;

/**
 *
 * @author Mateo Unda, CodeLex, @ESPE
 */
public class Secretary {
    private int secretaryId;
    private String name;
    private String email;
    private String officeArea;

    public Secretary() {
    }

    public Secretary(int secretaryId, String name, String email, String officeArea) {
        this.secretaryId = secretaryId;
        this.name = name;
        this.email = email;
        this.officeArea = officeArea;
    }

    public String getDetails() {
        return String.format("Secretary ID: %d | Name: %-20s | Email: %-25s | Office Area: %s",
                secretaryId, name, email, officeArea);
    }

    public int getSecretaryId() {
        return secretaryId;
    }

    public void setSecretaryId(int secretaryId) {
        this.secretaryId = secretaryId;
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

    public String getOfficeArea() {
        return officeArea;
    }

    public void setOfficeArea(String officeArea) {
        this.officeArea = officeArea;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
