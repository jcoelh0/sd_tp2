package communication.server;

import communication.ServerChannel;
import communication.message.Message;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre and joao
 */
public class ServerProxy extends Thread {

	//serverProxy serve de intermediário entre o cliente (que procura recursos do server) e o server
	private static int nProxy;
	private final ServerChannel sconi;
	private final ServerInterface serverInterface;
	private final ServerChannel scon;

	/**
	 * Constructor to create the server proxy.
	 *
	 * @param scon
	 * @param sconi
	 * @param serverInterface
	 * @param name
	 */
	public ServerProxy(ServerChannel scon, ServerChannel sconi, ServerInterface serverInterface, String name) {
		super(name);
		this.sconi = sconi;
		this.serverInterface = serverInterface;
		this.scon = scon;
	}

	/**
	 * Method to run the server proxy.
	 */
	@Override
	public void run() {
		Message request = null;  // mensagem de entrada
		Message response = null; // mensagem de saída

		request = (Message) sconi.readObject();

		
		try {
			response = serverInterface.processAndReply(request, scon);
		} catch (SocketException ex) {
			Logger.getLogger(ServerProxy.class.getName()).log(Level.SEVERE, null, ex);
		}
		

		sconi.writeObject(response);                                // enviar resposta ao cliente
		sconi.close();                                              // fechar canal de comunicação

		if (serverInterface.serviceEnded()) {
			System.out.println(this.serverInterface.serviceName() + " - Closing service ... Done!");
			System.exit(0);
		}
	}

	/**
	 * Method to retrieve the server proxy ID.
	 *
	 * @return
	 */
	public static int getProxyId() {
		return nProxy;
	}
}
