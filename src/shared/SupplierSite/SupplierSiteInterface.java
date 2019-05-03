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

    public SupplierSiteInterface(SupplierSite supplierSite) {
        this.supplierSite = supplierSite;
    }

    public boolean getStatus() {
        return this.status;
    }

    public SupplierSiteMessage process(SupplierSiteMessage inMsg) throws SupplierSiteMessageException {

        SupplierSiteMessage outMsg = null;
        Object response;

        switch(inMsg.getMessageType()) {

            case SupplierSiteMessage.GO_TO_SUPPLIER:
                response = supplierSite.goToSupplier(inMsg.getPiece());
                outMsg = new SupplierSiteMessage(SupplierSiteMessage.SUCCESS, (int) response);
                break;
                
        }

        return outMsg;
    }

}