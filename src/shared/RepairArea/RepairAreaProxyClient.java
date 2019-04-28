/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.RepairArea;

import communication.ChannelServer;
import messages.RepairAreaMessage.RepairAreaMessage;
import messages.RepairAreaMessage.RepairAreaMessageException;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author Andre
 */
public class RepairAreaProxyClient extends Thread {
    
    private ChannelServer cs;
    
    private RepairAreaInterface repairAreaInterface;
    
    public RepairAreaProxyClient(ChannelServer cs, RepairAreaInterface repairAreaInterface) {
        this.cs = cs;
        this.repairAreaInterface = repairAreaInterface;
    }
    
    @Override
    public void run() {
        RepairAreaMessage in;
        RepairAreaMessage out = null;
        
        in = (RepairAreaMessage) cs.readObject();
        
        try {
            out = repairAreaInterface.process(in);
        }
        catch(RepairAreaMessageException e) {
            System.out.println("Thread " + getName() + ": " + e.getMessage() + "!");
            System.out.println(e.getMsg().toString());
            System.out.println("Failed to process request : " + in);
            System.exit(1);
        }
        if(!this.repairAreaInterface.getStatus()) {
            cs.writeObject(out);
            cs.close();
            throw new RepairAreaMessageException("End message received", out);
        }
        else {
            cs.writeObject(out);
            cs.close();
        }
    }
    
}
