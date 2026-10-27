package ec.edu.espe.legalsync.model;

/**
 *
 * @author Mateo Unda, CodeLex, @ESPE
 */
public class Defendant {
     private int defendantId;
    private String idNumber;
    private String name;
    private String contactInfo;
    private String address;

    public Defendant() {
    }

    public Defendant(int defendantId, String idNumber, String name, String contactInfo, String address) {
        this.defendantId = defendantId;
        this.idNumber = idNumber;
        this.name = name;
        this.contactInfo = contactInfo;
        this.address = address;
    }

    public boolean register() {
        return this.defendantId > 0 && this.name != null && !this.name.trim().isEmpty();
    }

    public boolean update(String contactInfo, String address) {
        if (contactInfo != null && !contactInfo.trim().isEmpty()) {
            this.contactInfo = contactInfo.trim();
        }
        if (address != null && !address.trim().isEmpty()) {
            this.address = address.trim();
        }
        return true;
    }

    public String getDetails() {
        return String.format("Defendant ID: %d | ID: %-13s | Name: %-22s | Contact: %-18s | Address: %s",
                defendantId, idNumber, name, contactInfo, address);
    }

    public int getDefendantId() {
        return defendantId;
    }

    public void setDefendantId(int defendantId) {
        this.defendantId = defendantId;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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
