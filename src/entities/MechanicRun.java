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
public class MechanicRun {

	private static LoungeProxy lounge = new LoungeProxy();
	private static OutsideWorldProxy outsideWorld = new OutsideWorldProxy();
	private static RepairAreaProxy repairArea = new RepairAreaProxy();
	private static ParkProxy park = new ParkProxy();
	private static SupplierSiteProxy supplierSite = new SupplierSiteProxy();
	private static int id = 0;
	private static Mechanic mechanic;

	public static void main(String[] args) {
		SettingsProxy settingsProxy = new SettingsProxy();

		mechanic = new Mechanic((IMechanicP) park, (IMechanicRA) repairArea, (IMechanicL) lounge, id++);

		mechanic.start();

		try {
			System.out.println("Mechanic started!\n");
			mechanic.join();
			System.err.println("Mechanic Died");
		} catch (InterruptedException ex) {
			// do something in the future
		}
		
	}
}
