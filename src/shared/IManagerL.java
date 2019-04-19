package shared;

import repository.Piece;
import entities.ManagerState;

/**
 *
 * @author andre e joao
 */
public interface IManagerL {

	/**
	 *
	 * @param availableCar
	 * @return
	 */
	public String talkWithCustomer(boolean availableCar);

	/**
	 *
	 * @param replacementCarId
	 * @param idCustomer
	 */
	public void handCarKey(int replacementCarId, int idCustomer);

	/**
	 *
	 * @param idCustomer
	 */
	public  void addToReplacementQueue(int idCustomer);

	/**
	 *
	 * @param state
	 * @return
	 */
	public int currentCustomer(ManagerState state);

	/**
	 *
	 * @param state
	 */
	public void checkWhatToDo(ManagerState state);

	/**
	 *
	 * @param state
	 * @return
	 */
	public int getIdToCall(ManagerState state);

	/**
	 *
	 * @return
	 */
	public boolean enoughWork();

	/**
	 *
	 * @param id
	 * @return
	 */
	public boolean alertCustomer(int id);

	/**
	 *
	 */
	public void getNextTask();

	/**
	 *
	 */
	public void receivePayment();

	/**
	 *
	 * @return
	 */
	public int appraiseSit();

	/**
	 *
	 * @param state
	 * @return
	 */
	public Piece getPieceToReStock(ManagerState state);

	/**
	 *
	 * @param state
	 */
	public void goReplenishStock(ManagerState state);
}
