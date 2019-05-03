package shared.Repository;

import entities.Customer.States.CustomerState;
import entities.Manager.States.ManagerState;
import entities.Mechanic.States.MechanicState;
import static settings.Constants.N_CUSTOMERS;
import static settings.Constants.N_REPLACEMENT_CARS;
import static settings.Constants.N_TYPE_PIECES;
import genclass.FileOp;
import genclass.GenericIO;
import genclass.TextFile;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import settings.EnumPiece;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class Repository {
    
    private final String file_name = "log.txt";
    TextFile log = new TextFile();
    
    public PrintWriter writer;
    
    private String managerState;  
    private String[] customerState;
    private String[] mechanicState;
    
    private String[] carsDriven = new String[N_CUSTOMERS];
    private String[] requiresCar = new String[N_CUSTOMERS];
    private String[] repairedCars = new String[N_CUSTOMERS];
    
    private int customersQueue = 0;
    private int replacementQueue = 0;
    private int numCarsRepaired = 0;
    
    private int customersParked = 0;
    private int replacementParked = 0;
    
    private int requests = 0;
    private int[] piecesStock = new int[N_TYPE_PIECES];
    private int[] piecesRequired = new int[N_TYPE_PIECES];
    private String[] managerNotified = new String[N_TYPE_PIECES];
    
    private int[] boughtPieces = new int[N_TYPE_PIECES];
    
    public Repository() {
        if(FileOp.exists(".", file_name)) {
            FileOp.deleteFile(".", file_name);
        }
        
        Arrays.fill(mechanicState, MechanicState.WAITING_FOR_WORK.toString());
        Arrays.fill(customerState, CustomerState.NORMAL_LIFE_WITH_CAR.toString());
        managerState = ManagerState.CHECKING_WHAT_TO_DO.toString();
        
        for(int i = 0; i < carsDriven.length; i++) {
            carsDriven[i] = Integer.toString(i);
        }
        
        Arrays.fill(requiresCar, "F");
        Arrays.fill(repairedCars, "F");
        Arrays.fill(piecesStock, 10);
        Arrays.fill(piecesRequired, 0);
        Arrays.fill(managerNotified, "F");
        Arrays.fill(boughtPieces, 0);        
    }
    
    public void updateLog() {
        if(!log.openForAppending(".", file_name)) {
            GenericIO.writelnString("Couldn't create " + file_name + "!");
            System.exit(1);
        }
        
        String s = managerState;
        
        s += String.format("\t%s %s\t", mechanicState[0], mechanicState[1]);
        
        for(int i = 0; i < customerState.length; i++) {
            s += String.format("\t%s %s %s %s", customerState[i], carsDriven[i], requiresCar[i], repairedCars[i]);
            if((i + 1) % 10 == 0)
                s += "\n\t\t";
        }
        
        s += String.format("\t%d %d %d", customersQueue, replacementQueue, numCarsRepaired);
        s += String.format("\t%d %d", customersParked, replacementParked);
        s += String.format("\t%d", requests);
        
        for(int i = 0; i < piecesStock.length; i++) {
            s += String.format("\t %d %d %s\t", piecesStock[i], piecesRequired[i], managerNotified[i]);
        }
        
        for(int i = 0; i < boughtPieces.length; i++) {
            s += String.format(" %d", boughtPieces[i]);
        }
        
        s += "\n";
        
        log.writelnString(s);
        if(!log.close()) {
            GenericIO.writelnString("Couldn't close " + file_name + "!");
            System.exit(1);
        }
    }
    
    public synchronized void setManagerState(String state) {
        managerState = state;
        updateLog();
    }
    
    public synchronized void setCustomerState(String state, int i) {
        customerState[i] = state;
        updateLog();
    }
    
    public synchronized void setMechanicState(String state, int i) {
        mechanicState[i] = state;
        updateLog();
    }
    
    public synchronized void setCustomersQueue(int size) {
        customersQueue = size;
        updateLog();
    }
    
    public synchronized void setReplacementQueue(int size) {
        replacementQueue = size;
        updateLog();
    }
    
    public synchronized void setNumCarsRepaired(int size) {
        numCarsRepaired = size;
        updateLog();
    }
    
    public synchronized void setCustomersParked(int n) {
        customersParked = n;
        updateLog();
    }
    
    public synchronized void setReplacementParked(int n) {
        replacementParked = n;
        updateLog();
    }
    
    public synchronized void setRequests(int n) {
        requests = n;
        updateLog();
    }
    
    public synchronized void setPiecesStock(HashMap<EnumPiece, Integer> pieces) {
        int i = 0;
        for(EnumPiece key : pieces.keySet()) {
            piecesStock[i] = pieces.get(key);
            i++;
        }
        updateLog();
    }
    
    public synchronized void setPiecesRequired(int[] pieces) {
        piecesRequired = pieces;
        updateLog();
    }
    
    public synchronized void setManagerNotifed(String[] not) {
        managerNotified = not;
        updateLog();
    }
    
    public synchronized void setBoughtPieces(int[] pieces) {
        for(int i = 0; i < boughtPieces.length; i++) {
            boughtPieces[i] += pieces[i];
        }
        updateLog();
    }
    
    public synchronized void setRequiresCar(String s, int i) {
        requiresCar[i] = s;
        updateLog();
    }
    
    public synchronized void setVehicleDriven(String s, int i) {
        carsDriven[i] = s;
        updateLog();
    }
}
