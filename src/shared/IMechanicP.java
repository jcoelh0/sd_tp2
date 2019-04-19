package shared;

import entities.MechanicState;

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
	public void getVehicle(int id, int idMechanic, MechanicState state);

	/**
	 *
	 * @param id
	 */
	public void returnVehicle(int id);
}
