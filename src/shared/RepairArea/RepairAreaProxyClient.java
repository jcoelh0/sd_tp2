package shared.RepairArea;

import communication.ChannelServer;
import messages.RepairAreaMessage.RepairAreaMessage;
import messages.RepairAreaMessage.RepairAreaMessageException;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class RepairAreaProxyClient extends Thread {
    
    private ChannelServer cs;
    
    private RepairAreaInterface repairAreaInterface;
    
    /**
     * RepairArea proxy client constructor.
     * 
     * @param cs communication channel
     * @param repairAreaInterface repair area interface
     */
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
