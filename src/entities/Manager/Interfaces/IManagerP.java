package entities.Manager.Interfaces;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public interface IManagerP {

	/**
	 *
	 * @param idCustomer
	 * @return
	 */
	public boolean replacementCarAvailable(int idCustomer);

	/**
	 *
	 * @param id
	 * @return
	 */
	public int reserveCar(int id);

	/**
	 *
	 * @param id
	 */
	public void waitForCustomer(int id);
}
