package entities.Mechanic.Interfaces;

import entities.Mechanic.States.MechanicState;

/**
 *
 * @author andre e joao
 */
public interface IMechanicP {

	/**
	 *
	 * @param id
	 * @param idMechanic
	 * @param state
	 */
	public void getVehicle(int id, int idMechanic);

	/**
	 *
	 * @param id
	 */
	public void returnVehicle(int id);
}
