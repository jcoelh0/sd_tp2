package shared.SupplierSite;

import communication.ChannelServer;
import messages.SupplierSiteMessage.SupplierSiteMessage;
import messages.SupplierSiteMessage.SupplierSiteMessageException;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class SupplierSiteProxyClient extends Thread {
    
    private ChannelServer cs;
    
    private SupplierSiteInterface supplierSiteInterface;
    
    public SupplierSiteProxyClient(ChannelServer cs, SupplierSiteInterface supplierSiteInterface) {
        this.cs = cs;
        this.supplierSiteInterface = supplierSiteInterface;
    }
    
    @Override
    public void run() {
        SupplierSiteMessage in;
        SupplierSiteMessage out = null;
        
        in = (SupplierSiteMessage) cs.readObject();
        
        try {
            out = supplierSiteInterface.process(in);
        }
        catch(SupplierSiteMessageException e) {
            System.out.println("Thread " + getName() + ": " + e.getMessage() + "!");
            System.out.println(e.getMsg().toString());
            System.out.println("Failed to process request : " + in);
            System.exit(1);
        }
        if(!this.supplierSiteInterface.getStatus()) {
            cs.writeObject(out);
            cs.close();
            throw new SupplierSiteMessageException("End message received", out);
        }
        else {
            cs.writeObject(out);
            cs.close();
        }
    }
    
}
