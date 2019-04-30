package entities.Manager.Interfaces;

import entities.Manager.States.ManagerState;
import settings.Piece;

/**
 *
 * @author andre e joao
 */
public interface IManagerRA {

	/**
	 *
	 * @param idCustomer
	 * @param state
	 */
	public void registerService(int idCustomer);

	/**
	 *
	 * @param part
	 * @param quant
	 * @return
	 */
	public int storePart(Piece part, int quant);

	/**
	 *
	 */
	public void enoughWork();
}
