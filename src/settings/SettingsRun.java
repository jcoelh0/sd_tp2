/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import communication.ServerChannel;
import communication.server.ServerProxy;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcoel
 */
public class SettingsRun {

	public static void main(String[] args) throws SocketException, IOException {
		String json_path = "hosts.json";

		if (Settings.DEBUG) {
			json_path = "debug_hosts.json";
		}

		if (args.length == 1) {
			json_path = args[0];
		}

		// canais de comunicação
		ServerChannel serverChannel; //server	
		ServerChannel clientChannel; //cliente

		// thread agente prestador do serviço
		ServerProxy cliProxy;

		/* estabelecimento do servico */
		SettingsServer settingsServer = new SettingsServer(json_path);

		// criação do canal de escuta e sua associação
		serverChannel = new ServerChannel(settingsServer.SERVER_PORTS.get("Settings"));
		serverChannel.start();

		System.out.println("Node Setts service has started!\nServer is listening.");

		/* processamento de pedidos */
		while (true) {

			try {
				// entrada em processo de escuta
				clientChannel = serverChannel.accept();
				// lançamento do agente prestador do serviço
				cliProxy = new ServerProxy(serverChannel, clientChannel, settingsServer, "Settings");
				cliProxy.start();
			} catch (SocketTimeoutException ex) {
				Logger.getLogger(SettingsRun.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
