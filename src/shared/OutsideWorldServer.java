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
import entities.CustomerState;
import java.net.SocketException;
import repository.Piece;
import repository.RepairShop;
import repository.RepairShopProxy;

/**
 *
 * @author jcoel
 */
public class OutsideWorldServer extends OutsideWorld implements ServerInterface{
	private boolean serverEnded;
	private final String name;
	private boolean response_bool;
	
	public OutsideWorldServer(int nCustomers, RepairShopProxy repairShop) {
		super(nCustomers, repairShop);
		name = "OutsideWorld";
		serverEnded = false;
	}

	@Override
	public Message processAndReply(Message inMessage, ServerChannel scon) throws SocketException {
		switch (inMessage.getType()) {
			case TERMINATE:
				serverEnded = true;
				break;
			case phoneCustomer:
				response_bool = super.phoneCustomer(inMessage.getInteger1());
				return new Message(MessageType.ACK, response_bool);
			case decideOnRepair:
				response_bool = super.decideOnRepair(inMessage.getInteger1(), inMessage.getCustomerState());
				return new Message(MessageType.ACK, response_bool);
			case goToRepairShop:
				super.goToRepairShop(inMessage.getInteger1(), inMessage.getCustomerState());
			case backToWorkByBus:
				response_bool = super.backToWorkByBus(inMessage.getBoolean1(), inMessage.getInteger1(), inMessage.getCustomerState());
				return new Message(MessageType.ACK, response_bool);
			case goToReception:
				super.goToReception(inMessage.getInteger1(), inMessage.getCustomerState());
				break;
			case backToWorkByCar:
				response_bool = super.backToWorkByCar(inMessage.getBoolean1(), inMessage.getInteger1(), inMessage.getInteger2(), inMessage.getCustomerState());
				return new Message(MessageType.ACK, response_bool);
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
