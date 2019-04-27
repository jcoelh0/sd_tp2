package messages.SupplierSiteMessage;

public class SupplierSiteMessageException extends RuntimeException {

    private SupplierSiteMessage msg;

    public SupplierSiteMessageException(String error, SupplierSiteMessage msg) {
        super(error);
        this.msg = msg;
    }

    public SupplierSiteMessage getMsg() {
        return msg;
    }

}