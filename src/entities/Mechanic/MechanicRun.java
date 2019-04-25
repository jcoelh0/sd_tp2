package entities.Mechanic;

import entities.Mechanic.Mechanic;
import java.util.ArrayList;
import static settings.Constants.*;
import settings.SettingsProxy;
import entities.Mechanic.Interfaces.IMechanicL;
import entities.Mechanic.Interfaces.IMechanicP;
import entities.Mechanic.Interfaces.IMechanicRA;
import shared.Lounge.LoungeProxy;
import shared.OutsideWorld.OutsideWorldProxy;
import shared.Park.ParkProxy;
import shared.RepairArea.RepairAreaProxy;
import shared.SupplierSite.SupplierSiteProxy;

/**
 *
 * @author andre and joao
 */
public class MechanicRun {

    // private static LoungeProxy lounge = new LoungeProxy();
    // private static OutsideWorldProxy outsideWorld = new OutsideWorldProxy();
    // private static RepairAreaProxy repairArea = new RepairAreaProxy();
    // private static ParkProxy park = new ParkProxy();
    // private static SupplierSiteProxy supplierSite = new SupplierSiteProxy();
    // private static int id = 0;
    // //private static Mechanic mechanic;

    public static void main(String[] args) {

        Mechanic[] mechanics = new Mechanic[N_MECHANICS];

        for(int i = 0; i < N_MECHANICS; i++) {
            mechanics[i] = new Mechanic(i);
            mechanics[i].start();
        }

        for(int i = 0; i < N_MECHANICS; i++) {
            try {
                mechanics[i].join();
            }
            catch(Exception e) {
                System.out.println("Mechanic " + i + " has died!");
            }
        }

        // SettingsProxy settingsProxy = new SettingsProxy();

        // ArrayList<Mechanic> mechanics = new ArrayList<>(settingsProxy.N_MECHANICS());
        
        // for(int i = 0; i < settingsProxy.N_MECHANICS(); i++) {
        //     mechanics.add(new Mechanic((IMechanicP) park, (IMechanicRA) repairArea, (IMechanicL) lounge, i+1));
        //     //id = i+1;
        // }
        
        // for(Mechanic mechanic : mechanics) {
        //     mechanic.start();
        // }
        
        // for(Mechanic mechanic : mechanics) {
        //     try {
        //         mechanic.join();
        //         System.err.printf("Mechanic %d died!\n", mechanic.getMechanicId());
        //     } catch(InterruptedException e) {}
        // }
    }
}
