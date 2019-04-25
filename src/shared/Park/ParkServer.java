/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.Park;

import communication.ServerChannel;
import communication.message.Message;
import communication.message.MessageType;
import communication.server.ServerInterface;
import entities.Customer.States.CustomerState;
import entities.Mechanic.States.MechanicState;
import java.net.SocketException;
import repository.RepairShopProxy;

/**
 *
 * @author andre and joao
 */
public class ParkServer extends Park implements ServerInterface{
	private boolean serverEnded;
	private String name;
	private boolean response_bool;
	private int response_int;
	
	public ParkServer(int nReplacementCars, RepairShopProxy repairShop) {
		super(nReplacementCars, repairShop);
		name = "Park";
		serverEnded = false;
	}

	@Override
	public Message processAndReply(Message inMessage, ServerChannel scon) throws SocketException {
		switch (inMessage.getType()) {
			case TERMINATE:
				serverEnded = true;
				break;
			case getVehicle:
				super.getVehicle(inMessage.getInteger1(), inMessage.getInteger2(), inMessage.getMechanicState());
				break;
			case returnVehicle:
				super.returnVehicle(inMessage.getInteger1());
				break;
			case replacementCarAvailable:
				response_bool = super.replacementCarAvailable(inMessage.getInteger1());
				return new Message(MessageType.ACK, response_bool);
			case reserveCar:
				response_int = super.reserveCar(inMessage.getInteger1());
				return new Message(MessageType.ACK, response_int);
			case waitForCustomer:
				super.waitForCustomer(inMessage.getInteger1());
				break;
			case parkCar:
				super.parkCar(inMessage.getInteger1(), inMessage.getCustomerState());
				break;
			case collectCar:
				super.collectCar(inMessage.getInteger1());
				break;
			case returnReplacementCar:
				super.returnReplacementCar(inMessage.getInteger1(), inMessage.getInteger2(), inMessage.getCustomerState());
				break;
			case findCar:
				super.findCar(inMessage.getInteger1(), inMessage.getCustomerState(), inMessage.getInteger2());
				break;
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
