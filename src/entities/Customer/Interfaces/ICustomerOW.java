/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.Customer.Interfaces;

import entities.Customer.States.CustomerState;

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
	public boolean decideOnRepair(int id, CustomerState state);

	/**
	 *
	 * @param idCustomer
	 * @param state
	 */
	public void goToRepairShop(int idCustomer, CustomerState state);

	/**
	 *
	 * @param carRepaired
	 * @param id
	 * @param state
	 * @return
	 */
	public boolean backToWorkByBus(boolean carRepaired, int id, CustomerState state);

	/**
	 *
	 * @param idCustomer
	 * @param state
	 */
	public void goToReception(int idCustomer, CustomerState state);

	/**
	 *
	 * @param b
	 * @param replacementCar
	 * @param id
	 * @param state
	 * @return
	 */
	public boolean backToWorkByCar(boolean b, int replacementCar, int id, CustomerState state);
}
