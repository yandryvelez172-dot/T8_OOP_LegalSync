package ec.edu.espe.legalsync.model;

/**
 *
 * @author Yandry Velez, Codelex, @ESPE
 */
public class Lawyer {

    private int lawyerId;
    private String name;
    private String email;
    private String position;
    private String licenseNumber;

    public Lawyer() {
    }

    public Lawyer(int lawyerId, String name, String email, String position, String licenseNumber) {
        this.lawyerId = lawyerId;
        this.name = name;
        this.email = email;
        this.position = position;
        this.licenseNumber = licenseNumber;
    }

    public boolean isDirector() {
        return this.position != null && this.position.equalsIgnoreCase("DIRECTOR");
    }

    public boolean assignUserRole(User targetUser, String newRole) {
        if (this.isDirector() && targetUser != null && User.isValidRole(newRole)) {
            targetUser.setRole(newRole.toUpperCase());
            return true;
        }
        return false;
    }

    public void restrictUserAccess(User targetUser) {
        if (this.isDirector() && targetUser != null) {
            targetUser.setActive(false);
        }
    }

    public String getDetails() {
        return String.format("Lawyer ID: %d | Name: %s | Position: %s | License: %s | Email: %s",
                lawyerId, name, position, licenseNumber, email);
    }

    public int getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(int lawyerId) {
        this.lawyerId = lawyerId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
