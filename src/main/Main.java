package main;


import entities.Customer.Customer;
import entities.Manager.Manager;
import entities.Mechanic.Mechanic;
import repository.RepairShop;
import entities.Customer.Interfaces.ICustomerL;
import entities.Customer.Interfaces.ICustomerOW;
import entities.Customer.Interfaces.ICustomerP;
import entities.Manager.Interfaces.IManagerL;
import entities.Manager.Interfaces.IManagerOW;
import entities.Manager.Interfaces.IManagerP;
import entities.Manager.Interfaces.IManagerRA;
import entities.Manager.Interfaces.IManagerSS;
import entities.Mechanic.Interfaces.IMechanicL;
import entities.Mechanic.Interfaces.IMechanicP;
import entities.Mechanic.Interfaces.IMechanicRA;
import shared.Lounge.Lounge;
import shared.OutsideWorld.OutsideWorld;
import shared.Park.Park;
import shared.RepairArea.RepairArea;
import shared.SupplierSite.SupplierSite;

/**
 *
 * @author Andre e Joao
 */
public class Main {

	private static Lounge lounge;
	private static OutsideWorld outsideWorld;
	private static Park park;
	private static RepairArea repairArea;
	private static SupplierSite supplierSite;

	private static Manager manager;
	private static Mechanic mechanics[];
	private static Customer customers[];

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		/* 
         * There are 5 different locations: park, lounge, repair area, supplier
         * site and the outside world.
         * We assume that there are 30 customers, 2 mechanics and 1 manager.
         * Furthermore, there are 3 replacement vehicles and 3 distinct parts 
         * that can be repared.
		 */
		
		final int nCustomers = 30;
		final int nMechanics = 2;
		final int nManagers = 1;
		final int nReplacementCars = 3;
		final int nTypePieces = 3;
		String fileName = "repairShop.log";
		
		RepairShop repairShop;
		
		repairShop = new RepairShop(nTypePieces, nMechanics, nCustomers, fileName);
		
		

		lounge = new Lounge(nCustomers, nTypePieces, repairShop);
		outsideWorld = new OutsideWorld(nCustomers, repairShop);
		park = new Park(nReplacementCars, repairShop);
		repairArea = new RepairArea(nTypePieces, repairShop);
		supplierSite = new SupplierSite(nTypePieces, repairShop);

		// initialization of threads
		for (int i = 0; i < nManagers; i++) {
			manager = new Manager((IManagerL) lounge, (IManagerRA) repairArea, (IManagerSS) supplierSite, (IManagerOW) outsideWorld, (IManagerP) park, nCustomers);
			manager.start();
		}

		mechanics = new Mechanic[nMechanics];
		for (int i = 0; i < nMechanics; i++) {
			mechanics[i] = new Mechanic((IMechanicP) park, (IMechanicRA) repairArea, (IMechanicL) lounge, i);
			mechanics[i].start();
		}

		customers = new Customer[nCustomers];
		for (int i = 0; i < nCustomers; i++) {
			customers[i] = new Customer((ICustomerOW) outsideWorld, (ICustomerP) park, (ICustomerL) lounge, i);
			customers[i].start();
		}
		repairShop.reportInitialStatus();
		
		//reportInitialStatus(nMechanics, nCustomers);

        
		
		for (int j = 0; j < nCustomers; j++) {
			try {
				customers[j].join();
				System.err.println("Customer " + j + " Died ");
			} catch (InterruptedException ex) {
				//Escrever para o log
			}
        }
		
		for (int j = 0; j < nMechanics; j++) {
			try {
				mechanics[j].join();
				System.err.println("Mechanic " + j + " Died ");
			} catch (InterruptedException ex) {
				//Escrever para o log
			}
		}
        
		for (int j = 0; j < nManagers; j++) {
			try {
				manager.join();
				System.err.println("Manager " + j + " Died ");
			} catch (InterruptedException ex) {
				//Escrever para o log
			}
		}
	}
}
