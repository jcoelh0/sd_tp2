package entities.Manager.Interfaces;

import settings.Piece;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public interface IManagerL {

	/**
	 *
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
	 * @return
	 */
	public int currentCustomer();

	/**
	 * checkWhatToDo method.
	 */
	public void checkWhatToDo();

	/**
	 *
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
	 * getNextTask method.
	 */
	public void getNextTask();

	/**
	 * receivePayment method.
	 */
	public void receivePayment();

	/**
	 *
	 * @return
	 */
	public int appraiseSit();

	/**
	 *
	 * @return
	 */
	public Piece getPieceToReStock();

	/**
	 * goReplenishStock method.
	 */
	public void goReplenishStock();
}
