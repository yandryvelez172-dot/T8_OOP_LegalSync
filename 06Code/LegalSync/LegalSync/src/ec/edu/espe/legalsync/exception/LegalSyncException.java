package ec.edu.espe.legalsync.exception;

/**
 *
 * @author Yandry Velez, Codelex, @ESPE
 */
public class LegalSyncException extends Exception {

    private String errorCode;

    public LegalSyncException(String message) {
        super(message);
        this.errorCode = "ERR-GENERAL";
    }

    public LegalSyncException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}