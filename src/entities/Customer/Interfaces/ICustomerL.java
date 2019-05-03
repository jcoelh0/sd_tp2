package entities.Customer.Interfaces;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public interface ICustomerL {

	/**
	 * queueIn method.
	 * @param id
	 */
	public void queueIn(int id);

	/**
	 * talkWithManager method.
	 * @param carRepaired
	 * @param requiresCar
	 * @param idCustomer
	 */
	public void talkWithManager(boolean carRepaired, boolean requiresCar, int idCustomer);

	/**
	 * collectKey method.
	 * @param id
	 * @return
	 */
	public boolean collectKey(int id);

	/**
	 * payForTheService method.
	 */
	public void payForTheService();

	/**
	 * getCarReplacementId method.
	 * @param id
	 * @return
	 */
	public int getCarReplacementId(int id);
}
