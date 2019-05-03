package entities.Mechanic.Interfaces;

import settings.Piece;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public interface IMechanicL {

	/**
	 *
	 * @param piece
	 * @param idCar
	 * @param idMechanic
	 */
	public void alertManager(Piece piece, int idCar, int idMechanic);
}
