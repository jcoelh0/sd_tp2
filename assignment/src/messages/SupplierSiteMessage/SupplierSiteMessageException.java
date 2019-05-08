package messages.SupplierSiteMessage;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class SupplierSiteMessageException extends RuntimeException {

    private SupplierSiteMessage msg;

    /**
     * Instantiation of SupplierSite message exception.
     * @param error text with error
     * @param msg message with exception
     */    
    public SupplierSiteMessageException(String error, SupplierSiteMessage msg) {
        super(error);
        this.msg = msg;
    }

    /**
     * Obtaining the SupplierSite message with error.
     * @return message
     */
    public SupplierSiteMessage getMsg() {
        return msg;
    }

}