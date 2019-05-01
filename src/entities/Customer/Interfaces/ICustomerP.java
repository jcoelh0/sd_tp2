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
public interface ICustomerP {

	/**
	 *
	 * @param id
	 */
	public void parkCar(int id);

	/**
	 *
	 * @param replacementCar
	 * @param id
	 */
    public void returnReplacementCar(int replacementCar, int id);

	/**
	 *
	 * @param id
	 * @param state
	 * @param replacementCar
	 */
	public void findCar(int id, int replacementCar);
}
