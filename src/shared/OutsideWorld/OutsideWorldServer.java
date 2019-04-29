package shared.OutsideWorld;

import communication.ChannelServer;
import static communication.ChannelPorts.NAME_OUTSIDE_WORLD;
import static communication.ChannelPorts.PORT_OUTSIDE_WORLD;
import static settings.Constants.N_CUSTOMERS;

public class OutsideWorldServer {
    
    public static void main(String[] args) {
        
        OutsideWorld outsideWorld = new OutsideWorld(N_CUSTOMERS);
        OutsideWorldInterface outsideWorldInterface = new OutsideWorldInterface(outsideWorld);
        ChannelServer listeningSocket = new ChannelServer(PORT_OUTSIDE_WORLD);
        ChannelServer communicationSocket;
        OutsideWorldProxyClient proxyClient;
        
        listeningSocket.start();
        
        System.out.println("OutsideWorld server up!");
        
        while(true) {
            try {
                communicationSocket = listeningSocket.accept();
                proxyClient = new OutsideWorldProxyClient(communicationSocket, outsideWorldInterface);
                
                Thread.UncaughtExceptionHandler h = (Thread t, Throwable ex) -> {
                    System.out.println("OutsideWorld server down!");
                    System.exit(0);
                };
                        
                proxyClient.setUncaughtExceptionHandler(h);
                proxyClient.start();
            }
            catch(Exception ex) {
                break;
            }
        }
        
        System.out.println("OutsideWorld server down!");
    }
    
}