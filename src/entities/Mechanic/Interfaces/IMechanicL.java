package entities.Mechanic.Interfaces;

import entities.Mechanic.States.MechanicState;
import settings.Piece;

/**
 *
 * @author andre e joao
 */
public interface IMechanicL {

	/**
	 *
	 * @param piece
	 * @param idCar
	 * @param idMechanic
	 * @param state
	 */
	public void alertManager(Piece piece, int idCar, int idMechanic);
}
