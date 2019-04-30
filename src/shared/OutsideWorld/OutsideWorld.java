package shared.OutsideWorld;

import entities.Manager.Interfaces.IManagerOW;
import entities.Customer.Interfaces.ICustomerOW;
import entities.Customer.Customer;
import entities.Customer.States.CustomerState;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author andre and joao
 */
public class OutsideWorld implements ICustomerOW, IManagerOW {

    private final List<Integer> repairedCars;
    private final List<Integer> waitingForCar;
    private final String[] vehicleDriven;

    /**
     *
     * @param nCustomers
     * @param repairShop
     */
    public OutsideWorld(int nCustomers) {
        this.waitingForCar = new ArrayList<>();
        this.repairedCars = new ArrayList<>();
        vehicleDriven = new String[nCustomers];

        for (int i = 0; i < nCustomers; i++) {
            if (i < 10) {
                vehicleDriven[i] = "0" + Integer.toString(i);
            } else {
                vehicleDriven[i] = Integer.toString(i);
            }
        }
    }
    
    /**
     * Customer's method. The customer starts his life span in the outside world
     * until he decides do repair his car. Furthermore, he also decides if he is
     * going to need a replacement car or not.
     *
     * @param id
     * @param state
     * @return
     */
    @Override
    public synchronized boolean decideOnRepair(int id) {
        Random requires = new Random();
        Random n = new Random();
        int randomNum = 0;
        while (randomNum != 1) {
            randomNum = n.nextInt((100 - 1) + 1) + 1;
        }
        return requires.nextBoolean();
    }

    /**
     * Customer's method. After going back to work by bus, the customer waits
     * for the manager to tell him that his car has been repaired.
     *
     * @param carRepaired
     * @param id
     * @param state
     * @return
     */
    @Override
    public synchronized boolean backToWorkByBus(boolean carRepaired, int id) {
        vehicleDriven[id] = "--";
        if (!carRepaired) {
            waitingForCar.add(id);
            notifyAll();
            while (!repairedCars.contains(id)) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            //System.out.println(id + " called");
            //System.out.println(repairedCars.toString());
            repairedCars.remove(new Integer(id));//repairedCars.remove(new Integer(id));
            //System.out.println(id + "acordado");
            return true;
        }
        return carRepaired;
    }

    /**
     * Customer's method. After going back to work by car (with replacement
     * car), the customer waits for the manager to tell him that his car has
     * been repaired.
     *
     * @param carRepaired
     * @param replacementCar
     * @param id
     * @param state
     * @return
     */
    @Override
    public synchronized boolean backToWorkByCar(boolean carRepaired, int replacementCar, int id) {
        if (replacementCar == -1) {
            if (id < 10) {
                vehicleDriven[id] = "0" + Integer.toString(id);
            } else {
                vehicleDriven[id] = Integer.toString(id);
            }
        } else {
            vehicleDriven[id] = "R" + Integer.toString(replacementCar);
        }
        if (!carRepaired) {
            waitingForCar.add(id);
            notifyAll();
            while (!repairedCars.contains(id)) {
                try {
                    wait();

                } catch (InterruptedException e) {

                }
            }
            return true;
        }
        return carRepaired;
    }

    /**
     * Customer's method. When the customer decides that he wants to repair his
     * car, he goes to the repair shop's park to park his car.
     *
     * @param idCustomer
     * @param state
     */
    @Override
    public synchronized void goToRepairShop(int idCustomer) {
    }

    /**
     * Customer's method. After parking his car, the customer goes to the
     * reception to speak to the manager.
     *
     * @param idCustomer
     * @param state
     */
    @Override
    public synchronized void goToReception(int idCustomer) {
    }

    /**
     * Manager's method. After knowing that the car is ready by the mechanic,
     * the manager calls the customer to get his car back.
     *
     * @param id customer's id which car is ready to be picked up
     * @return a boolean representing if the customer is ready to pick up the
     * car
     */
    @Override
    public synchronized boolean phoneCustomer(int id) {
        while (!waitingForCar.contains(id)) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        if (waitingForCar.contains(id)) {
            repairedCars.add(id);
            notifyAll();
            waitingForCar.remove(new Integer(id));
            return true;
        } else {
            return false;
        }
    }
}
