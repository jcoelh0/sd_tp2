/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.Park;

import shared.Lounge.LoungeRun;
import communication.ServerChannel;
import communication.server.ServerProxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.RepairShopProxy;
import settings.SettingsProxy;

/**
 *
 * @author andre and joao
 */
public class ParkRun {
	private static int SERVER_PORT;
	private static int nReplacementCars;
    
    public static void main(String[] args) throws SocketException {
		SettingsProxy proxy = new SettingsProxy(); 
        SERVER_PORT = proxy.SERVER_PORTS().get("Park");
        nReplacementCars = proxy.N_REPLACEMENT_CARS();
		
        // canais de comunicação
        ServerChannel serverChannel, clientChannel;
        
        // thread agente prestador do serviço
        ServerProxy cliProxy;                               

        /* estabelecimento do servico */
        
        // criação do canal de escuta e sua associação
        serverChannel = new ServerChannel(SERVER_PORT);    
        serverChannel.start();
        
		RepairShopProxy repairShop = new RepairShopProxy();
		
        ParkServer parkServer = new ParkServer(nReplacementCars, repairShop);
        System.out.println("Park service has started!\nServer is listening.");

        // processamento de pedidos 
        
        while (true) {
            try {
                // entrada em processo de escuta
                clientChannel = serverChannel.accept();
                // lançamento do agente prestador do serviço
                
				cliProxy = new ServerProxy(serverChannel, clientChannel, parkServer, "Park");
                cliProxy.start();
				
            } catch (SocketTimeoutException ex) {
                Logger.getLogger(LoungeRun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
