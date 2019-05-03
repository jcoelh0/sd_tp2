package entities.Customer.Interfaces;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public interface ICustomerOW {

	/**
	 * decideOnRepair method.
	 * @param id
	 * @return
	 */
	public boolean decideOnRepair(int id);

	/**
	 * backToWorkByBus method.
	 * @param carRepaired
	 * @param id
	 * @return
	 */
	public boolean backToWorkByBus(boolean carRepaired, int id);

	/**
	 * backToWorkByCar method.
	 * @param b
	 * @param replacementCar
	 * @param id
	 * @return
	 */
	public boolean backToWorkByCar(boolean b, int replacementCar, int id);
}
