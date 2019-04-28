/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import communication.ServerChannel;
import communication.server.ServerInterface;
import communication.message.Message;
import communication.message.MessageType;
import java.net.SocketException;

/**
 *
 * @author andre and joao
 */
public class SettingsServer extends Settings implements ServerInterface {
	private boolean serverEnded;
    private String name;
    
    /**
     * Constructor of node settings server.
     * @param jsonfilepath
     */
    public SettingsServer(String jsonfilepath) {
        super(jsonfilepath);
        this.name = "Node Setts Server";
        this.serverEnded = false;
    }
    
    /**
    * Process and reply all the messages
	 * @param inMessage
	 * @param scon
	 * @return
     * @throws java.net.SocketException
    */
    @Override
    public Message processAndReply(Message inMessage, ServerChannel scon) throws SocketException {
        switch(inMessage.getType()){
            case TERMINATE:
                this.serverEnded = true;
                break;
            case SERVER_PORTS:
                return new Message(MessageType.ACK, super.SERVER_PORTS);
            case SERVER_HOSTS:
                return new Message(MessageType.ACK, super.SERVER_HOSTS);
            case N_CUSTOMERS:
                return new Message(MessageType.ACK, super.N_CUSTOMERS);
            case N_MECHANICS:
                return new Message(MessageType.ACK, super.N_MECHANICS);
            case N_MANAGERS:
                return new Message(MessageType.ACK, super.N_MANAGERS);
            case N_REPLACEMENT_CARS:
                return new Message(MessageType.ACK, super.N_REPLACEMENT_CARS);
            case N_TYPE_PIECES:
                return new Message(MessageType.ACK, super.N_TYPE_PIECES);
        }
		
        return new Message(MessageType.ACK);   
    }

    /**
    * Method for return the service end flag
    * @return 
    */
    @Override
    public boolean serviceEnded() {
        return serverEnded;
    }
    
    /**
    * Method to return the service name.
    * @return
    */
    @Override
    public String serviceName() {
        return this.name;
    }
}
