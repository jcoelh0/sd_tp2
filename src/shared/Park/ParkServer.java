package shared.Park;

import communication.ChannelServer;
import static communication.ChannelPorts.NAME_PARK;
import static communication.ChannelPorts.PORT_PARK;
import static settings.Constants.N_REPLACEMENT_CARS;

public class ParkServer {
    
    public static void main(String[] args) {
        
        Park park = new Park(N_REPLACEMENT_CARS);
        ParkInterface parkInterface = new ParkInterface(park);
        ChannelServer listeningSocket = new ChannelServer(PORT_PARK);
        ChannelServer communicationSocket;
        ParkProxyClient proxyClient;
        
        listeningSocket.start();
        
        System.out.println("Park server up!");
        
        while(true) {
            try {
                communicationSocket = listeningSocket.accept();
                proxyClient = new ParkProxyClient(communicationSocket, parkInterface);
                
                Thread.UncaughtExceptionHandler h = (Thread t, Throwable ex) -> {
                    System.out.println("Park server down!");
                    System.exit(0);
                };
                        
                proxyClient.setUncaughtExceptionHandler(h);
                proxyClient.start();
            }
            catch(Exception ex) {
                break;
            }
        }
        
        System.out.println("Park server down!");
    }
    
}