package entities;

import java.util.ArrayList;
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
    //private static Mechanic mechanic;

    public static void main(String[] args) {
        SettingsProxy settingsProxy = new SettingsProxy();

        ArrayList<Mechanic> mechanics = new ArrayList<>(settingsProxy.N_MECHANICS());
        
        for(int i = 0; i < settingsProxy.N_MECHANICS(); i++) {
            mechanics.add(new Mechanic((IMechanicP) park, (IMechanicRA) repairArea, (IMechanicL) lounge, i+1));
            //id = i+1;
        }
        
        for(Mechanic mechanic : mechanics) {
            mechanic.start();
        }
        
        for(Mechanic mechanic : mechanics) {
            try {
                mechanic.join();
                System.err.printf("Mechanic %d died!\n", mechanic.getMechanicId());
            } catch(InterruptedException e) {}
        }
    }
}
