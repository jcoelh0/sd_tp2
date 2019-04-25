package entities.Customer;

import entities.Customer.Customer;
import static settings.Constants.*;
import settings.SettingsProxy;
import shared.Lounge.LoungeProxy;
import shared.OutsideWorld.OutsideWorldProxy;
import shared.Park.ParkProxy;

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
        
        Customer[] customers = new Customer[N_CUSTOMERS];

        for(int i = 0; i < N_CUSTOMERS; i++) {
            customers[i] = new Customer(i);
            customers[i].start();
        }

        for(int i = 0; i < N_CUSTOMERS; i++) {
            try {
                customers[i].join();
            }
            catch(InterruptedException ex) {
                System.out.println("Customer " + i + " is dead!");
            }
        }

        // SettingsProxy settingsProxy = new SettingsProxy();
        
        // ArrayList<Customer> customers = new ArrayList<>(settingsProxy.N_CUSTOMERS());
        
        // for (int i = 0; i < settingsProxy.N_CUSTOMERS(); i++) {
        //     customers.add(new Customer((entities.Customer.Interfaces.ICustomerOW) outsideWorld, (entities.Customer.Interfaces.ICustomerP) park, (entities.Customer.Interfaces.ICustomerL) lounge, i+1));
        //     //id = i+1;
        // }
        
        // for(Customer customer : customers) {
        //     customer.start();
        // }
        
        // for(Customer customer: customers) {
        //     try {
        //         customer.join();
        //         System.err.printf("Customer %d died!\n", customer.getCustomerId());
        //     }
        //     catch(InterruptedException e) {}
        // }
        
        // // PROXY LOG

    }
}
