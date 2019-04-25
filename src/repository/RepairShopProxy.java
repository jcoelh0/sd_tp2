package repository;

import communication.message.Message;
import communication.message.MessageType;
import communication.server.ClientProxy;
import entities.Customer.States.CustomerState;
import entities.Manager.States.ManagerState;
import entities.Mechanic.States.MechanicState;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author andre and joao
 */
public class RepairShopProxy extends ClientProxy {
    
    public RepairShopProxy(){
        super("RepairShop");
    }
	
	
	/**
	 *
	 * @param replacementQueue
	 * @param customersQueue
	 * @param carsRepaired
	 * @param requiresReplacementCar
	 */
	public void updateFromLounge(Queue<Integer> replacementQueue, Queue<Integer> customersQueue, Queue<Integer> carsRepaired, boolean[] requiresReplacementCar){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"1");
        communicate(new Message(mt, replacementQueue, customersQueue, carsRepaired, requiresReplacementCar));
	}
	
	/**
	 *
	 * @param replacementQueue
	 * @param customersQueue
	 * @param carsRepaired
	 * @param requiresReplacementCar
	 * @param idCustomer
	 * @param state
	 */
	public void updateFromLounge(Queue<Integer> replacementQueue, Queue<Integer> customersQueue, Queue<Integer> carsRepaired, boolean[] requiresReplacementCar, int idCustomer, CustomerState state){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"2");
        communicate(new Message(mt, replacementQueue, customersQueue, carsRepaired, requiresReplacementCar, idCustomer, state));
	}
	
	/**
	 *
	 * @param state
	 */
	public void updateFromLounge(ManagerState state){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"3");
        communicate(new Message(mt, state));
	}
	
	/**
	 *
	 * @param replacementQueue
	 * @param customersQueue
	 * @param carsRepaired
	 * @param requiresReplacementCar
	 * @param idMechanic
	 * @param state
	 */
	public void updateFromLounge(Queue<Integer> replacementQueue, Queue<Integer> customersQueue, Queue<Integer> carsRepaired, boolean[] requiresReplacementCar, int idMechanic, MechanicState state){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"4");
        communicate(new Message(mt, replacementQueue, customersQueue, carsRepaired, requiresReplacementCar, idMechanic, state));
	}
    
	/**
	 *
	 * @param carsParked
	 * @param replacementCars
	 */
	public void updateFromPark(List<Integer> carsParked, Queue<Integer> replacementCars){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"1");
        communicate(new Message(mt, carsParked, replacementCars));
	}
	
	/**
	 *
	 * @param carsParked
	 * @param replacementCars
	 * @param idCustomer
	 * @param state
	 */
	public void updateFromPark(List<Integer> carsParked, Queue<Integer> replacementCars, int idCustomer, CustomerState state){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"2");
        communicate(new Message(mt, carsParked, replacementCars, idCustomer, state));
	}
    
	/**
	 *
	 * @param carsParked
	 * @param replacementCars
	 * @param idMechanic
	 * @param state
	 */
	public void updateFromPark(List<Integer> carsParked, Queue<Integer> replacementCars, int idMechanic, MechanicState state){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"3");
        communicate(new Message(mt, carsParked, replacementCars, idMechanic, state));
	}
	
	/**
	 *
	 * @param vehicleDriven
	 */
	public void updateFromOutsideWorld(String[] vehicleDriven){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"1");
        communicate(new Message(mt, vehicleDriven));
	}
	
	/**
	 *
	 * @param vehicleDriven
	 * @param idCustomer
	 * @param state
	 */
	public void updateFromOutsideWorld(String[] vehicleDriven, int idCustomer, CustomerState state){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"2");
        communicate(new Message(mt, vehicleDriven, idCustomer, state));
	}
	
	/**
	 *
	 * @param piecesBought
	 */
	public synchronized void updateFromSupplierSite(int[] piecesBought){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, piecesBought));
	}
	
	/**
	 *
	 * @param nRequestsManager
	 * @param piecesToBeRepaired
	 * @param flagPartMissing
	 * @param stock
	 */
	public synchronized void updateFromRepairArea(int nRequestsManager, HashMap<Integer, Piece> piecesToBeRepaired, boolean[] flagPartMissing, HashMap<EnumPiece, Integer> stock){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"1");
        communicate(new Message(mt, nRequestsManager, piecesToBeRepaired, flagPartMissing, stock));
	}
	
	/**
	 *
	 * @param nRequestsManager
	 * @param piecesToBeRepaired
	 * @param flagPartMissing
	 * @param stock
	 * @param state
	 */
	public void updateFromRepairArea(int nRequestsManager, HashMap<Integer, Piece> piecesToBeRepaired, boolean[] flagPartMissing, HashMap<EnumPiece, Integer> stock, ManagerState state){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"2");
        communicate(new Message(mt, nRequestsManager, piecesToBeRepaired, flagPartMissing, stock, state));
	}
	
	/**
	 *
	 * @param nRequestsManager
	 * @param piecesToBeRepaired
	 * @param flagPartMissing
	 * @param stock
	 * @param idMechanic
	 * @param state
	 */
	public void updateFromRepairArea(int nRequestsManager, HashMap<Integer, Piece> piecesToBeRepaired, boolean[] flagPartMissing, HashMap<EnumPiece, Integer> stock, int idMechanic, MechanicState state){
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName()+"3");
        communicate(new Message(mt, nRequestsManager, piecesToBeRepaired, flagPartMissing, stock, idMechanic, state));
	}
	
	/**
	 *
	 */
	public void reportInitialStatus() {
        MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt));
    }
}
