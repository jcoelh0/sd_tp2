package shared.Lounge;

import communication.ChannelServer;
import static communication.ChannelPorts.NAME_LOUNGE;
import static communication.ChannelPorts.PORT_LOUNGE;
import static settings.Constants.N_CUSTOMERS;
import static settings.Constants.N_TYPE_PIECES;

/**
 * 
 * @author André Oliveira
 * @author João Coelho
 */
public class LoungeServer {
    
    /**
     * Server running the lounge.
     * @param args -
     */    
    public static void main(String[] args) {
        
        Lounge lounge = new Lounge(N_CUSTOMERS, N_TYPE_PIECES);
        LoungeInterface loungeInterface = new LoungeInterface(lounge);
        ChannelServer listeningSocket = new ChannelServer(PORT_LOUNGE);
        ChannelServer communicationSocket;
        LoungeProxyClient proxyClient;
        
        listeningSocket.start();
        
        System.out.println("Lounge server up!");
        
        while(true) {
            try {
                communicationSocket = listeningSocket.accept();
                proxyClient = new LoungeProxyClient(communicationSocket, loungeInterface);
                
                Thread.UncaughtExceptionHandler h = (Thread t, Throwable ex) -> {
                    System.out.println("Lounge server down!");
                    System.exit(0);
                };
                        
                proxyClient.setUncaughtExceptionHandler(h);
                proxyClient.start();
            }
            catch(Exception ex) {
                break;
            }
        }
        
        System.out.println("Lounge server down!");
    }
    
}