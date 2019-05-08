package shared.Repository;

import static communication.ChannelPorts.PORT_GENERAL_REPOSITORY;
import communication.ChannelServer;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class RepositoryServer2 {
    
    /**
     * Server running the repository.
     * @param args -
     */ 
    public static void main(String[] args) {
        
        Repository repository = new Repository();
        RepositoryInterface repositoryInterface = new RepositoryInterface(repository);
        ChannelServer listeningSocket = new ChannelServer(PORT_GENERAL_REPOSITORY);
        ChannelServer communicationSocket;
        RepositoryProxyClient proxyClient;
        
        listeningSocket.start();
        
        System.out.println("Repository server up!");
        
        while(true) {
            try {
                communicationSocket = listeningSocket.accept();
                proxyClient = new RepositoryProxyClient(communicationSocket, repositoryInterface);
                
                Thread.UncaughtExceptionHandler h = (Thread t, Throwable ex) -> {
                    System.out.println("Repository server down!");
                    System.exit(0);
                };
                        
                proxyClient.setUncaughtExceptionHandler(h);
                proxyClient.start();
            }
            catch(Exception e) {
                break;
            }
        }
        
        System.out.println("Repository server down!");
    }
    
}