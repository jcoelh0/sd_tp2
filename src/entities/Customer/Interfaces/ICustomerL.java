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
public interface ICustomerL {

	/**
	 *
	 * @param id
	 * @param state
	 */
	public void queueIn(int id, CustomerState state);

	/**
	 *
	 * @param carRepaired
	 * @param requiresCar
	 * @param idCustomer
	 */
	public void talkWithManager(boolean carRepaired, boolean requiresCar, int idCustomer);

	/**
	 *
	 * @param id
	 * @param state
	 * @return
	 */
	public boolean collectKey(int id, CustomerState state);

	/**
	 *
	 */
	public void payForTheService();

	/**
	 *
	 * @param id
	 * @return
	 */
	public int getCarReplacementId(int id);
}
