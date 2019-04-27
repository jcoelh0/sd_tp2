package shared.SupplierSite;

import messages.SupplierSiteMessage.*;

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

        switch(inMsg.getMessageType()) {

            case SupplierSiteMessage.GO_TO_SUPPLIER:
                break;
                
        }

        return outMsg;
    }

}