/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.Customer.Interfaces;

/**
 *
 * @author andre
 */
public interface ICustomerOW {

	/**
	 *
	 * @param id
	 * @param state
	 * @return
	 */
	public boolean decideOnRepair(int id);

	/**
	 *
	 * @param idCustomer
	 * @param state
	 */
	public void goToRepairShop(int idCustomer);

	/**
	 *
	 * @param carRepaired
	 * @param id
	 * @param state
	 * @return
	 */
	public boolean backToWorkByBus(boolean carRepaired, int id);

	/**
	 *
	 * @param idCustomer
	 * @param state
	 */
	public void goToReception(int idCustomer);

	/**
	 *
	 * @param b
	 * @param replacementCar
	 * @param id
	 * @param state
	 * @return
	 */
	public boolean backToWorkByCar(boolean b, int replacementCar, int id);
}
