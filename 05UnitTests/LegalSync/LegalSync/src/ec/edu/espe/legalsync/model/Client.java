package ec.edu.espe.legalsync.model;

/**
 *
 * @author Mateo Unda, CodeLex, @ESPE
 */
public class Client {
   private int clientId;
    private String idNumber;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Client() {
    }

    public Client(int clientId, String idNumber, String name, String phone, String email, String address) {
        this.clientId = clientId;
        this.idNumber = idNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public boolean register() {
        return this.clientId > 0 && this.name != null && !this.name.trim().isEmpty()
                && this.idNumber != null && !this.idNumber.trim().isEmpty();
    }

    public boolean update(String phone, String email, String address) {
        if (phone != null && !phone.trim().isEmpty()) {
            this.phone = phone.trim();
        }
        if (email != null && !email.trim().isEmpty()) {
            this.email = email.trim();
        }
        if (address != null && !address.trim().isEmpty()) {
            this.address = address.trim();
        }
        return true;
    }

    public String getDetails() {
        return String.format("Client ID: %d | ID/RUC: %-13s | Name: %-22s | Phone: %-12s | Email: %-22s | Address: %s",
                clientId, idNumber, name, phone, email, address);
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return getDetails();
    } 
}
