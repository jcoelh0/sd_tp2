/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication.server;

import communication.ClientChannel;
import communication.message.Message;
import communication.message.MessageType;
import communication.message.MessageWrapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcoel
 */
public class Proxy extends Thread{

	private final String clientProxyServerName;
	private final int toServerPort;
	private final Message outMessage;
	private final MessageWrapper result;

	/**
	 * Constructor of proxy.
	 *
	 * @param clientProxyServerName
	 * @param toServerPort
	 * @param result
	 * @param outMessage
	 */
	public Proxy(String clientProxyServerName, int toServerPort, MessageWrapper result, Message outMessage) {
		this.clientProxyServerName = clientProxyServerName;
		this.toServerPort = toServerPort;
		this.outMessage = outMessage;
		this.result = result;
	}

	/**
	 * Proxy wrapper.
	 *
	 * @param logServerName
	 * @param logServerPort
	 * @param m
	 * @return
	 */
	public static MessageWrapper connect(String logServerName, int logServerPort, Message m) {
		MessageWrapper result = new MessageWrapper();

		Proxy cp = new Proxy(logServerName, logServerPort, result, m);

		cp.start();

		try {
			cp.join();
		} catch (InterruptedException ex) {
			Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (result.getMessage().getType() != MessageType.ACK) {
			System.out.println("Tipo Inválido. Message:" + result.getMessage().toString());
			System.exit(1);
		}

		return result;
	}

	/**
	 * Method to run the proxy.
	 */
	@Override
	public void run() {
		try {
			ClientChannel con = new ClientChannel(clientProxyServerName, toServerPort);

			while (!con.open()) {
				try {
					sleep((long) (10));
				} catch (InterruptedException e) {
				}
			}

			con.writeObject(outMessage);

			this.result.setMessage((Message) con.readObject());

			con.close();

		} catch (Exception ex) {
			Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
