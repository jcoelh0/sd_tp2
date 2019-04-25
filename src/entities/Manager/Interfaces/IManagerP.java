/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.Manager.Interfaces;

/**
 *
 * @author AndréOliveira
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
