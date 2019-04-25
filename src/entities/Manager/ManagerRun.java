package entities.Manager;

import static settings.Constants.*;

/**
 *
 * @author andre e joao
 */
public class ManagerRun {

    public static void main(String[] args) {
        Manager manager = new Manager(N_CUSTOMERS);
        manager.start();
        try {
            manager.join();
        }
        catch(InterruptedException ex) {
            System.out.println("Manager died!");
        }
    }
}
