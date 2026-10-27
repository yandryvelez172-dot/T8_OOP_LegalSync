package ec.edu.espe.legalsync.model;

/**
 *
 * @author Yandry Velez, Codelex, @ESPE
 */
public class User {

    public static final String[] VALID_ROLES = {
        "DIRECTOR", "PARTNER", "ASSOCIATE_LAWYER",
        "JUNIOR_LAWYER", "LEGAL_ASSISTANT", "SECRETARY"
    };

    private int userId;
    private String name;
    private String email;
    private String password;
    private String role;
    private boolean active;

    public User() {
        this.active = true;
        this.role = "JUNIOR_LAWYER";
    }

    public User(int userId, String name, String email, String password, String role, boolean active) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = isValidRole(role) ? role.toUpperCase() : "JUNIOR_LAWYER";
        this.active = active;
    }

    public static boolean isValidRole(String roleToCheck) {
        if (roleToCheck == null) {
            return false;
        }
        for (int i = 0; i < VALID_ROLES.length; i++) {
            if (VALID_ROLES[i].equalsIgnoreCase(roleToCheck.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean login(String inputEmail, String inputPassword) {
        if (!this.active || inputEmail == null || inputPassword == null) {
            return false;
        }
        return this.email.equalsIgnoreCase(inputEmail.trim()) && this.password.equals(inputPassword);
    }

    public void logout() {
        System.out.println("Session closed for user: " + this.email);
    }

    public boolean changePassword(String oldPass, String newPass) {
        if (this.password != null && this.password.equals(oldPass) && newPass != null && !newPass.trim().isEmpty()) {
            this.password = newPass.trim();
            return true;
        }
        return false;
    }

    public boolean hasPermission(String operationType) {
        if (!this.active) {
            return false;
        }
        if ("MANAGE_USERS".equalsIgnoreCase(operationType)) {
            return "DIRECTOR".equalsIgnoreCase(this.role);
        }
        if ("WRITE".equalsIgnoreCase(operationType)) {
            return !"SECRETARY".equalsIgnoreCase(this.role);
        }
        return true; // READ operations allowed for all active roles
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (isValidRole(role)) {
            this.role = role.toUpperCase();
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-20s | Email: %-25s | Role: %-16s | Active: %s",
                userId, name, email, role, (active ? "YES" : "NO"));
    }
}