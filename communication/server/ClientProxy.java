package communication.server;


import communication.message.Message;
import communication.message.MessageWrapper;
import settings.SettingsProxy;
/**
 *
 * @author andre and joao
 */
public class ClientProxy {

	private final String SERVER_HOST;
	private final int SERVER_PORT;
	private final String proxyName;

	/**
	 * Client Proxy constructor.
	 *
	 * @param proxyName
	 */
	public ClientProxy(String proxyName) {
		SettingsProxy proxy = new SettingsProxy();
		SERVER_HOST = proxy.SERVER_HOSTS().get(proxyName);
		SERVER_PORT = proxy.SERVER_PORTS().get(proxyName);
		this.proxyName = proxyName;
	}

	/**
	 * Method to communicate with a given server:port.
	 *
	 * @param m
	 * @return
	 */
	public MessageWrapper communicate(Message m) {
		return Proxy.connect(SERVER_HOST, SERVER_PORT, m);
	}
}
