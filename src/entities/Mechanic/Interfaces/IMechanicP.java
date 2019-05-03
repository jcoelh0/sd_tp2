package entities.Mechanic.Interfaces;


/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public interface IMechanicP {

	/**
	 *
	 * @param id
	 * @param idMechanic
	 */
	public void getVehicle(int id, int idMechanic);

	/**
	 *
	 * @param id
	 */
	public void returnVehicle(int id);
}
