package shared.RepairArea;

import communication.ChannelServer;
import static communication.ChannelPorts.NAME_REPAIR_AREA;
import static communication.ChannelPorts.PORT_REPAIR_AREA;
import static settings.Constants.N_TYPE_PIECES;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class RepairAreaServer {
    
    /**
     * Server running the repair area.
     * @param args -
     */ 
    public static void main(String[] args) {
        
        RepairArea repairArea = new RepairArea(N_TYPE_PIECES);
        RepairAreaInterface repairAreaInterface = new RepairAreaInterface(repairArea);
        ChannelServer listeningSocket = new ChannelServer(PORT_REPAIR_AREA);
        ChannelServer communicationSocket;
        RepairAreaProxyClient proxyClient;
        
        listeningSocket.start();
        
        System.out.println("RepairArea server up!");
        
        while(true) {
            try {
                communicationSocket = listeningSocket.accept();
                proxyClient = new RepairAreaProxyClient(communicationSocket, repairAreaInterface);
                
                Thread.UncaughtExceptionHandler h = (Thread t, Throwable ex) -> {
                    System.out.println("RepairArea server down!");
                    System.exit(0);
                };
                        
                proxyClient.setUncaughtExceptionHandler(h);
                proxyClient.start();
            }
            catch(Exception ex) {
                break;
            }
        }
        
        System.out.println("RepairArea server down!");
    }
    
}