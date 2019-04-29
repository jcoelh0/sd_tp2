package entities.Manager.Interfaces;

import repository.Piece;
import entities.Manager.States.ManagerState;

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
	public String talkWithCustomer();

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
	public int currentCustomer();

	/**
	 *
	 * @param state
	 */
	public void checkWhatToDo();

	/**
	 *
	 * @param state
	 * @return
	 */
	public int getIdToCall();

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
	public Piece getPieceToReStock();

	/**
	 *
	 * @param state
	 */
	public void goReplenishStock();
}
