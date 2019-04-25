package entities.Customer;

import static settings.Constants.*;

/**
 *
 * @author andre and joao
 */
public class CustomerRun {

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
    }
}
