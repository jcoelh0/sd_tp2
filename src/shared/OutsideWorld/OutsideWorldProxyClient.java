package shared.OutsideWorld;

import communication.ChannelServer;
import messages.OutsideWorldMessage.OutsideWorldMessage;
import messages.OutsideWorldMessage.OutsideWorldMessageException;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class OutsideWorldProxyClient extends Thread {
    
    private ChannelServer cs;
    
    private OutsideWorldInterface outsideWorldInterface;
    
    /**
     * OutsideWorld proxy client constructor.
     * 
     * @param cs communication channel
     * @param outsideWorldInterface outside world interface
     */
    public OutsideWorldProxyClient(ChannelServer cs, OutsideWorldInterface outsideWorldInterface) {
        this.cs = cs;
        this.outsideWorldInterface = outsideWorldInterface;
    }
    
    @Override
    public void run() {
        OutsideWorldMessage in;
        OutsideWorldMessage out = null;
        
        in = (OutsideWorldMessage) cs.readObject();
        
        try {
            out = outsideWorldInterface.process(in);
        }
        catch(OutsideWorldMessageException e) {
            System.out.println("Thread " + getName() + ": " + e.getMessage() + "!");
            System.out.println(e.getMsg().toString());
            System.out.println("Failed to process request : " + in);
            System.exit(1);
        }
        if(!this.outsideWorldInterface.getStatus()) {
            cs.writeObject(out);
            cs.close();
            throw new OutsideWorldMessageException("End message received", out);
        }
        else {
            cs.writeObject(out);
            cs.close();
        }
    }
    
}
