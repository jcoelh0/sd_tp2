package entities;

import java.util.ArrayList;
import settings.Settings;
import settings.SettingsProxy;
import shared.LoungeProxy;
import shared.OutsideWorldProxy;
import shared.ParkProxy;

/**
 *
 * @author andre and joao
 */
public class CustomerRun {

    private static LoungeProxy lounge = new LoungeProxy();
    private static OutsideWorldProxy outsideWorld = new OutsideWorldProxy();
    private static ParkProxy park = new ParkProxy();
    private static int id = 0;

    public static void main(String[] args) {
        
        SettingsProxy settingsProxy = new SettingsProxy();
        
        ArrayList<Customer> customers = new ArrayList<>(settingsProxy.N_CUSTOMERS());
        
        for (int i = 0; i < settingsProxy.N_CUSTOMERS(); i++) {
            customers.add(new Customer((shared.ICustomerOW) outsideWorld, (shared.ICustomerP) park, (shared.ICustomerL) lounge, i+1));
            //id = i+1;
        }
        
        for(Customer customer : customers) {
            customer.start();
        }
        
        for(Customer customer: customers) {
            try {
                customer.join();
                System.err.printf("Customer %d died!\n", customer.getCustomerId());
            }
            catch(InterruptedException e) {}
        }
        
        // PROXY LOG

    }
}
