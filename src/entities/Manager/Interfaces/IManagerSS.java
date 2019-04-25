package entities.Manager.Interfaces;

import repository.Piece;

/**
 *
 * @author andre e joao
 */
public interface IManagerSS {

	/**
	 *
	 * @param partNeeded
	 * @return
	 */
	public int goToSupplier(Piece partNeeded);
}
