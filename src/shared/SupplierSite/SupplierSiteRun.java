package shared.SupplierSite;

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
public class SupplierSiteRun {

	private static int SERVER_PORT;
	private static int nTypePieces;

	public static void main(String[] args) throws SocketException {
		SettingsProxy proxy = new SettingsProxy();
		SERVER_PORT = proxy.SERVER_PORTS().get("SupplierSite");
		nTypePieces = proxy.N_TYPE_PIECES();

		// canais de comunicação
		ServerChannel serverChannel, clientChannel;

		// thread agente prestador do serviço
		ServerProxy cliProxy;

		/* estabelecimento do servico */
		// criação do canal de escuta e sua associação
		serverChannel = new ServerChannel(SERVER_PORT);
		serverChannel.start();

		RepairShopProxy repairShop = new RepairShopProxy();

		SupplierSiteServer supplierSiteServer = new SupplierSiteServer(nTypePieces, repairShop);
		System.out.println("SupplierSite service has started!\nServer is listening.");

		// processamento de pedidos 
		while (true) {
			try {
				// entrada em processo de escuta
				clientChannel = serverChannel.accept();
				// lançamento do agente prestador do serviço

				cliProxy = new ServerProxy(serverChannel, clientChannel, supplierSiteServer, "Lounge");
				cliProxy.start();

			} catch (SocketTimeoutException ex) {
				Logger.getLogger(LoungeRun.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
