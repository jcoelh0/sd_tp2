/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.OutsideWorld;

import entities.Manager.Interfaces.IManagerOW;
import entities.Customer.Interfaces.ICustomerOW;
import communication.message.Message;
import communication.message.MessageType;
import communication.message.MessageWrapper;
import communication.server.ClientProxy;
import entities.Customer.States.CustomerState;

/**
 *
 * @author andre and joao
 */
public class OutsideWorldProxy extends ClientProxy implements ICustomerOW, IManagerOW{
	
	public OutsideWorldProxy(String proxyName) {
		super(proxyName);
	}
	
	public OutsideWorldProxy() {
		super("Outside World");
	}

	@Override
	public boolean decideOnRepair(int id, CustomerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, id, state));
        return result.getMessage().getBoolean1();
	}

	@Override
	public void goToRepairShop(int idCustomer, CustomerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, idCustomer, state));
    }

	@Override
	public boolean backToWorkByBus(boolean carRepaired, int id, CustomerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, carRepaired, id, state));
        return result.getMessage().getBoolean1();
	}

	@Override
	public void goToReception(int idCustomer, CustomerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, idCustomer, state));
	}
	
	@Override
	public boolean backToWorkByCar(boolean b, int replacementCar, int id, CustomerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, b, replacementCar, id, state));
        return result.getMessage().getBoolean1();
	}

	@Override
	public boolean phoneCustomer(int id) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, id));
        return result.getMessage().getBoolean1();
	}
	
}
