package entities.Customer.Interfaces;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public interface ICustomerP {

	/**
	 * parkCar method.
	 * @param id
	 */
	public void parkCar(int id);

	/**
	 * returnReplacementCar method.
	 * @param replacementCar
	 * @param id
	 */
    public void returnReplacementCar(int replacementCar, int id);

	/**
	 * findCar method.
	 * @param id
	 * @param replacementCar
	 */
	public void findCar(int id, int replacementCar);
}
