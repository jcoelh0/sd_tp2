package shared.Lounge;

import communication.ChannelServer;
import messages.LoungeMessage.LoungeMessage;
import messages.LoungeMessage.LoungeMessageException;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class LoungeProxyClient extends Thread {
    
    private ChannelServer cs;
    
    private LoungeInterface loungeInterface;
    
    /**
     * Lounge proxy client constructor.
     * 
     * @param cs communication channel
     * @param loungeInterface lounge interface
     */
    public LoungeProxyClient(ChannelServer cs, LoungeInterface loungeInterface) {
        this.cs = cs;
        this.loungeInterface = loungeInterface;
    }
    
    @Override
    public void run() {
        LoungeMessage in;
        LoungeMessage out = null;
        
        in = (LoungeMessage) cs.readObject();
        
        try {
            out = loungeInterface.process(in);
        }
        catch(LoungeMessageException e) {
            System.out.println("Thread " + getName() + ": " + e.getMessage() + "!");
            System.out.println(e.getMsg().toString());
            System.out.println("Failed to process request : " + in);
            System.exit(1);
        }
        if(!this.loungeInterface.getStatus()) {
            cs.writeObject(out);
            cs.close();
            throw new LoungeMessageException("End message received", out);
        }
        else {
            cs.writeObject(out);
            cs.close();
        }
    }
    
}
