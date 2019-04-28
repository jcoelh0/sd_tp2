package shared.SupplierSite;

import communication.ChannelServer;
import static communication.ChannelPorts.NAME_SUPPLIER_SITE;
import static communication.ChannelPorts.PORT_SUPPLIER_SITE;

public class SupplierSiteServer {
    
    public static void main(String[] args) {
        
        SupplierSite supplierSite = new SupplierSite();
        SupplierSiteInterface supplierSiteInterface = new SupplierSiteInterface(supplierSite);
        ChannelServer listeningSocket = new ChannelServer(PORT_SUPPLIER_SITE);
        ChannelServer communicationSocket;
        SupplierSiteProxyClient proxyClient;
        
        listeningSocket.start();
        
        System.out.println("SupplierSite server up!");
        
        while(true) {
            try {
                communicationSocket = listeningSocket.accept();
                proxyClient = new SupplierSiteProxyClient(communicationSocket, supplierSiteInterface);
                
                Thread.UncaughtExceptionHandler h = (Thread t, Throwable ex) -> {
                    System.out.println("SupplierSite server down!");
                    System.exit(0);
                };
                        
                proxyClient.setUncaughtExceptionHandler(h);
                proxyClient.start();
            }
            catch(Exception ex) {
                break;
            }
        }
        
        System.out.println("SupplierSite server down!");
    }
    
}