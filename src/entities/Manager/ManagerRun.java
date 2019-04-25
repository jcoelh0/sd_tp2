package entities.Manager;

import entities.Manager.Manager;
import settings.SettingsProxy;
import static settings.Constants.*;
import shared.Lounge.LoungeProxy;
import shared.OutsideWorld.OutsideWorldProxy;
import shared.Park.ParkProxy;
import shared.RepairArea.RepairAreaProxy;
import shared.SupplierSite.SupplierSiteProxy;

/**
 *
 * @author andre e joao
 */
public class ManagerRun {

    // private static LoungeProxy lounge = new LoungeProxy();
    // private static OutsideWorldProxy outsideWorld = new OutsideWorldProxy();
    // private static RepairAreaProxy repairArea = new RepairAreaProxy();
    // private static SupplierSiteProxy supplierSite = new SupplierSiteProxy();
    // private static ParkProxy park = new ParkProxy();
    // private static Manager manager;
    // private static int nCustomers;

    public static void main(String[] args) {

        Manager manager = new Manager(N_CUSTOMERS);

        manager.start();

        try {
            manager.join();
        }
        catch(InterruptedException ex) {

        }

        System.out.println("Manager died!");

        // SettingsProxy settingsProxy = new SettingsProxy();
        // nCustomers = settingsProxy.N_CUSTOMERS();

        // manager = new Manager((entities.Manager.Interfaces.IManagerL) lounge, (entities.Manager.Interfaces.IManagerRA) repairArea, (entities.Manager.Interfaces.IManagerSS) supplierSite, (entities.Manager.Interfaces.IManagerOW) outsideWorld, (entities.Manager.Interfaces.IManagerP) park, nCustomers);

        // manager.start();

        // try {
        //     System.out.println("Manager started!\n");
        //     manager.join();
        //     System.err.println("Manager Died");
        // } catch (InterruptedException ex) {
        //     // do something in the future
        // }

    }
}
