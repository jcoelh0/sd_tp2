/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import communication.ServerChannel;
import communication.message.Message;
import communication.message.MessageType;
import communication.server.ServerInterface;
import java.net.SocketException;
import repository.RepairShop;
import repository.RepairShopProxy;

/**
 *
 * @author andre and joao
 */
public class SupplierSiteServer extends SupplierSite implements ServerInterface {
	private boolean serverEnded;
	private final String name;
	private int response_int;
	
	public SupplierSiteServer(int nTypePieces, RepairShopProxy repairShop) {
		super(nTypePieces, repairShop);
		name = "SupplierSite Server";
		serverEnded = false;
	}

	@Override
	public Message processAndReply(Message inMessage, ServerChannel scon) throws SocketException {
		switch (inMessage.getType()) {
			case TERMINATE:
				serverEnded = true;
				break;
			case goToSupplier:
				response_int = super.goToSupplier(inMessage.getMessage_p1());
				return new Message(MessageType.ACK, response_int);
			
		}
		return new Message(MessageType.ACK);
	}

	@Override
	public String serviceName() {
		return name;
	}

	@Override
	public boolean serviceEnded() {
		return serverEnded;
	}
	
}
