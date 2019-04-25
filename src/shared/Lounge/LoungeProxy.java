package shared.Lounge;

import entities.Mechanic.Interfaces.IMechanicL;
import entities.Manager.Interfaces.IManagerL;
import entities.Customer.Interfaces.ICustomerL;
import communication.message.Message;
import communication.message.MessageType;
import communication.message.MessageWrapper;
import communication.server.ClientProxy;
import entities.Customer.States.CustomerState;
import entities.Manager.States.ManagerState;
import entities.Mechanic.States.MechanicState;
import repository.Piece;

/**
 *
 * @author andre and joao
 */
public class LoungeProxy extends ClientProxy implements ICustomerL, IManagerL, IMechanicL {

	/**
	 *
	 * @param proxyName
	 */
	public LoungeProxy(String proxyName) {
		super(proxyName);
	}
	/**
    * Constructor to lounge proxy.
    */
    public LoungeProxy(){
        super("Lounge");
    }
    
	/**
	 *
	 * @param id
	 * @param state
	 */
	@Override
	public void queueIn(int id, CustomerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, id, state));
	}

	/**
	 *
	 * @param carRepaired
	 * @param requiresCar
	 * @param idCustomer
	 */
	@Override
	public void talkWithManager(boolean carRepaired, boolean requiresCar, int idCustomer) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
		communicate(new Message(mt, carRepaired, requiresCar, idCustomer));
	}

	/**
	 *
	 * @param id
	 * @param state
	 * @return
	 */
	@Override
	public boolean collectKey(int id, CustomerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, id, state));
        return result.getMessage().getBoolean1();
	}

	/**
	 *
	 */
	@Override
	public void payForTheService() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
		communicate(new Message(mt));
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	@Override
	public int getCarReplacementId(int id) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, id));
        return result.getMessage().getInteger1();
	}

	/**
	 *
	 * @param availableCar
	 * @return
	 */
	@Override
	public String talkWithCustomer(boolean availableCar) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, availableCar));
        return result.getMessage().getString();
	}

	/**
	 *
	 * @param replacementCarId
	 * @param idCustomer
	 */
	@Override
	public void handCarKey(int replacementCarId, int idCustomer) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
		communicate(new Message(mt, replacementCarId, idCustomer));
	}

	/**
	 *
	 * @param idCustomer
	 */
	@Override
	public void addToReplacementQueue(int idCustomer) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
		communicate(new Message(mt, idCustomer));
	}

	/**
	 *
	 * @param state
	 * @return
	 */
	@Override
	public int currentCustomer(ManagerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, state));
        return result.getMessage().getInteger1();
	}

	/**
	 *
	 * @param state
	 */
	@Override
	public void checkWhatToDo(ManagerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
		communicate(new Message(mt, state));
	}

	/**
	 *
	 * @param state
	 * @return
	 */
	@Override
	public int getIdToCall(ManagerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, state));
        return result.getMessage().getInteger1();
	}

	/**
	 *
	 * @return
	 */
	@Override
	public boolean enoughWork() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt));
        return result.getMessage().getBoolean1();
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean alertCustomer(int id) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, id));
        return result.getMessage().getBoolean1();
	}

	/**
	 *
	 */
	@Override
	public void getNextTask() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt));
	}

	/**
	 *
	 */
	@Override
	public void receivePayment() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
		communicate(new Message(mt));
	}

	/**
	 *
	 * @return
	 */
	@Override
	public int appraiseSit() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt));
        return result.getMessage().getInteger1();
	}

	/**
	 *
	 * @param state
	 * @return
	 */
	@Override
	public Piece getPieceToReStock(ManagerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, state));
        return result.getMessage().getPiece();
	}

	/**
	 *
	 * @param state
	 */
	@Override
	public void goReplenishStock(ManagerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
		communicate(new Message(mt, state));
	}

	/**
	 *
	 * @param piece
	 * @param idCar
	 * @param idMechanic
	 * @param state
	 */
	@Override
	public void alertManager(Piece piece, int idCar, int idMechanic, MechanicState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
		communicate(new Message(mt, piece, idCar, idMechanic, state));
	}
}
