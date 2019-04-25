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
public interface ICustomerP {

	/**
	 *
	 * @param id
	 * @param state
	 */
	public void parkCar(int id, CustomerState state);

	/**
	 *
	 * @param id
	 */
	public void collectCar(int id);
    //public  findCar(int id, CustomerState state);

	/**
	 *
	 * @param replacementCar
	 * @param id
	 * @param state
	 */
    public void returnReplacementCar(int replacementCar, int id, CustomerState state);

	/**
	 *
	 * @param id
	 * @param state
	 * @param replacementCar
	 */
	public void findCar(int id, CustomerState state, int replacementCar);
}
