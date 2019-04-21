package entities;

import settings.SettingsProxy;
import shared.IMechanicL;
import shared.IMechanicP;
import shared.IMechanicRA;
import shared.LoungeProxy;
import shared.OutsideWorldProxy;
import shared.ParkProxy;
import shared.RepairAreaProxy;
import shared.SupplierSiteProxy;

/**
 *
 * @author andre and joao
 */
public class CustomerRun {
	private static LoungeProxy lounge = new LoungeProxy();
	private static OutsideWorldProxy outsideWorld = new OutsideWorldProxy();
	private static ParkProxy park = new ParkProxy();
	private static int id = 0;
	private static Customer customer;

	public static void main(String[] args) {
		SettingsProxy settingsProxy = new SettingsProxy();

		customer = new Customer(outsideWorld, park, lounge, id++);

		customer.start();

		try {
			System.out.println("Ccustomer started!\n");
			customer.join();
			System.err.println("Customer Died");
		} catch (InterruptedException ex) {
			// do something in the future
		}
		
	}
}
