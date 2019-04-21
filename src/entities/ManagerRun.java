package entities;

import settings.SettingsProxy;
import shared.LoungeProxy;
import shared.OutsideWorldProxy;
import shared.ParkProxy;
import shared.RepairAreaProxy;
import shared.SupplierSiteProxy;

/**
 *
 * @author andre e joao
 */
public class ManagerRun {

	private static LoungeProxy lounge = new LoungeProxy();
	private static OutsideWorldProxy outsideWorld = new OutsideWorldProxy();
	private static RepairAreaProxy repairArea = new RepairAreaProxy();
	private static SupplierSiteProxy supplierSite = new SupplierSiteProxy();
	private static ParkProxy park = new ParkProxy();
	private static Manager manager;
	private static int nCustomers;
	public static void main(String[] args) {
		
		SettingsProxy settingsProxy = new SettingsProxy();
		nCustomers = settingsProxy.N_CUSTOMERS();

		manager = new Manager(lounge, repairArea, supplierSite, outsideWorld, park, nCustomers);

		manager.start();

		try {
			System.out.println("Manager started!\n");
			manager.join();
			System.err.println("Manager Died");
		} catch (InterruptedException ex) {
			// do something in the future
		}

	}
}
