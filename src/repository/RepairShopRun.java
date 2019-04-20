package repository;

import communication.ServerChannel;
import communication.server.ServerProxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import settings.SettingsProxy;
import shared.LoungeRun;

/**
 *
 * @author andre and joao
 */
public class RepairShopRun {
	private static int SERVER_PORT;
	private static int nCustomers, nMechanics, nTypePieces;
    
    public static void main(String[] args) throws SocketException {
		SettingsProxy proxy = new SettingsProxy(); 
        SERVER_PORT = proxy.SERVER_PORTS().get("RepairShop");
        nCustomers = proxy.N_CUSTOMERS();
		nTypePieces = proxy.N_TYPE_PIECES();
		nMechanics = proxy.N_MECHANICS();
		
        // canais de comunicação
        ServerChannel serverChannel, clientChannel;
        
        // thread agente prestador do serviço
        ServerProxy cliProxy;                               

        /* estabelecimento do servico */
        
        // criação do canal de escuta e sua associação
        serverChannel = new ServerChannel(SERVER_PORT);    
        serverChannel.start();
       
        RepairShopServer repairShopProxy = new RepairShopServer(nTypePieces, nMechanics, nCustomers, "repairShop.log");
        System.out.println("RepairShop service has started!\nServer is listening.");

        // processamento de pedidos 
        
        while (true) {
            try {
                // entrada em processo de escuta
                clientChannel = serverChannel.accept();
                // lançamento do agente prestador do serviço
                
				cliProxy = new ServerProxy(serverChannel, clientChannel, repairShopProxy, "RepairShop");
                cliProxy.start();
				
            } catch (SocketTimeoutException ex) {
                Logger.getLogger(LoungeRun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
