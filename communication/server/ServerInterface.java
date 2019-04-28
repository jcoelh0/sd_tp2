/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication.server;

import communication.ServerChannel;
import communication.message.Message;
import java.net.SocketException;

/**
 *
 * @author andre and joao
 */
public interface ServerInterface {

	/**
	 * Method to process a message and reply.
	 *
	 * @param inMessage
	 * @param scon
	 * @return
	 * @throws SocketException
	 */
	public Message processAndReply(Message inMessage, ServerChannel scon) throws SocketException;

	/**
	 * Method to get the service name. Service name
	 *
	 * @return
	 */
	public String serviceName();

	/**
	 * Method to retrieve the flag of the end of the service. Service end
	 *
	 * @return
	 */
	public boolean serviceEnded();
}
