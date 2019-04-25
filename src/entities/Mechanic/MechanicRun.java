package entities.Mechanic;

import static settings.Constants.*;

/**
 *
 * @author andre and joao
 */
public class MechanicRun {

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
            catch(InterruptedException e) {
                System.out.println("Mechanic " + i + " has died!");
            }
        }
    }
}
