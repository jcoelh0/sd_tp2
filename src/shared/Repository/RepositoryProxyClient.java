package shared.Repository;

import communication.ChannelServer;
import messages.RepositoryMessage.RepositoryMessage;
import messages.RepositoryMessage.RepositoryMessageException;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class RepositoryProxyClient extends Thread {
    
    private ChannelServer cs;
    
    private RepositoryInterface repositoryInterface;
    
    /**
     * Repository proxy client constructor.
     * 
     * @param cs communication channel
     * @param repositoryInterface repository interface
     */
    public RepositoryProxyClient(ChannelServer cs, RepositoryInterface repositoryInterface) {
        this.cs = cs;
        this.repositoryInterface = repositoryInterface;
    }
    
    @Override
    public void run() {
        RepositoryMessage in = null;
        RepositoryMessage out = null;
        
        in = (RepositoryMessage) cs.readObject();
        
        try {
            out = repositoryInterface.process(in);
        }
        catch(RepositoryMessageException e) {
            System.out.println("Thread " + getName() + ": " + e.getMessage() + "!");
            System.out.println(e.getMsg().toString());
            System.out.println("Failed to process request : " + in);
            System.exit(1);
        }
        if(!this.repositoryInterface.getStatus()) {
            cs.writeObject(out);
            cs.close();
            throw new RepositoryMessageException("End message received", out);
        }
        else {
            cs.writeObject(out);
            cs.close();
        }
    }
    
}
