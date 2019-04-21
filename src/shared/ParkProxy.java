/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import communication.message.Message;
import communication.message.MessageType;
import communication.message.MessageWrapper;
import communication.server.ClientProxy;
import entities.CustomerState;
import entities.MechanicState;

/**
 *
 * @author andre and joao
 */
public class ParkProxy extends ClientProxy implements ICustomerP, IMechanicP, IManagerP{

	public ParkProxy(String proxyName) {
		super(proxyName);
	}
	
	public ParkProxy() {
		super("Park");
	}
	@Override
	public void parkCar(int id, CustomerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, id, state));
	}

	@Override
	public void collectCar(int id) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, id));
	}

	@Override
	public void returnReplacementCar(int replacementCar, int id, CustomerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, replacementCar, id, state));
	}

	@Override
	public void findCar(int id, CustomerState state, int replacementCar) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, id, state));
	}

	@Override
	public void getVehicle(int id, int idMechanic, MechanicState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, idMechanic, state));
	}

	@Override
	public void returnVehicle(int id) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, id));
	}

	@Override
	public boolean replacementCarAvailable(int idCustomer) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, idCustomer));
        return result.getMessage().getBoolean1();
	}

	@Override
	public int reserveCar(int id) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, id));
		return result.getMessage().getInteger1();
	}

	@Override
	public void waitForCustomer(int id) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, id));
	}
	
}
