package shared.SupplierSite;

import messages.SupplierSiteMessage.*;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class SupplierSiteInterface {

    private SupplierSite supplierSite;
    private boolean status = true;

    /**
     * SupplierSiteInterface constructor
     * @param supplierSite SupplierSite reference
     */
    public SupplierSiteInterface(SupplierSite supplierSite) {
        this.supplierSite = supplierSite;
    }

    /**
     * Checks if the server is running.
     * @return boolean to determine server status.
     */
    public boolean getStatus() {
        return this.status;
    }

    /**
     * Method that processes the message received and executes the operation
     * associated to that message.
     * 
     * @param inMsg message that contains a given request
     * @return SupplierSiteMessage reply
     * @throws SupplierSiteMessageException if the message contains an invalid request
     */

    public SupplierSiteMessage process(SupplierSiteMessage inMsg) throws SupplierSiteMessageException {

        SupplierSiteMessage outMsg = null;
        Object response;

        switch(inMsg.getMessageType()) {

            case SupplierSiteMessage.GO_TO_SUPPLIER:
                response = supplierSite.goToSupplier(inMsg.getPiece());
                outMsg = new SupplierSiteMessage(SupplierSiteMessage.SUCCESS, (int) response);
                break;
                
            case SupplierSiteMessage.END:
                System.out.println("End!");
                this.status = false;
                outMsg = new SupplierSiteMessage(SupplierSiteMessage.SUCCESS);
                break;
                
            default:
                throw new SupplierSiteMessageException("Invalid message type.", inMsg);
        }

        return outMsg;
    }

}