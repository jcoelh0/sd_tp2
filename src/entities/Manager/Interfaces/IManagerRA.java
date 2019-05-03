package entities.Manager.Interfaces;

import settings.Piece;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public interface IManagerRA {

	/**
	 *
	 * @param idCustomer
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
	 * enoughWork method.
	 */
	public void enoughWork();
}
