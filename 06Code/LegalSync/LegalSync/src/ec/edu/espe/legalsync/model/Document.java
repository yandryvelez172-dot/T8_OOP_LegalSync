package ec.edu.espe.legalsync.model;

/**
 *
 * @author Josselyn Ulcuango, CodeLex, @ESPE
 */
public class Document {
    
    private int documentId;
    private String name;
    private String type;
    private String filePath;
    private String uploadDate;

    public Document() {
    }

    public Document(int documentId, String name, String type, String filePath, String uploadDate) {
        this.documentId = documentId;
        this.name = name;
        this.type = type;
        this.filePath = filePath;
        this.uploadDate = uploadDate;
    }

    public boolean register() {
        return this.filePath != null && !this.filePath.trim().isEmpty();
    }

    public String getDetails() {
        return String.format("Doc ID: %d | Type: %-10s | Name: %-20s | Date: %-10s | Path: %s",
                documentId, type, name, uploadDate, filePath);
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
