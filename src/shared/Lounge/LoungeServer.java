package shared.Lounge;

import communication.ChannelServer;
import static communication.ChannelPorts.NAME_LOUNGE;
import static communication.ChannelPorts.PORT_LOUNGE;

public class LoungeServer {
    
    public static void main(String[] args) {
        
        Lounge lounge = new Lounge();
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