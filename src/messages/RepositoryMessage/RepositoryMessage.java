package messages.RepositoryMessage;

import java.util.HashMap;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class RepositoryMessage {
    
    private int msg = -1;
    
    /**
     * END message.
     */
    public static final int END = 0;
    
    /**
     * SUCCESS message.
     */
    public static final int SUCCESS = 100;
    
    /**
     * MANAGER_STATE message.
     */
    public static final int MANAGER_STATE = 1;
    
    /**
     * MECHANIC_STATE message.
     */
    public static final int MECHANIC_STATE = 2;
    
    /**
     * CUSTOMER_STATE message.
     */
    public static final int CUSTOMER_STATE = 3;
    
    /**
     * SET_MANAGER_STATE message.
     */
    public static final int SET_MANAGER_STATE = 4;
    
    /**
     * SET_MECHANIC_STATE message.
     */
    public static final int SET_MECHANIC_STATE = 5;
    
    /**
     * SET_CUSTOMER_STATE message.
     */
    public static final int SET_CUSTOMER_STATE = 6;
    
    /**
     * VEHICLE_DRIVEN message.
     */
    public static final int VEHICLE_DRIVEN = 7;
    
    /**
     * REQUIRES_CAR message.
     */
    public static final int REQUIRES_CAR = 8;
    
    /**
     * REPAIRED_CAR message.
     */
    public static final int REPAIRED_CAR = 9;
    
    /**
     * NUMBER_IN_QUEUE message.
     */
    public static final int NUMBER_IN_QUEUE = 10;
    
    /**
     * WAITING_REPLACEMENT message.
     */
    public static final int WAITING_REPLACEMENT = 11;
    
    /**
     * NUMBER_CARS_REPAIRED message.
     */
    public static final int NUMBER_CARS_REPAIRED = 12;
    
    /**
     * NUMBER_NONREPCARS_PARKED message.
     */
    public static final int NUMBER_NONREPCARS_PARKED = 13;
    
    /**
     * NUMBER_REPCARS_PARKED message.
     */
    public static final int NUMBER_REPCARS_PARKED = 14;
    
    /**
     * NUMBER_SERVICES message.
     */
    public static final int NUMBER_SERVICES = 15;
    
    /**
     * NUMBER_PARTS message.
     */
    public static final int NUMBER_PARTS = 16;
    
    /**
     * NUMBER_VEHICLES_WAITING message.
     */
    public static final int NUMBER_VEHICLES_WAITING = 17;
    
    /**
     * PART_NEEDED message.
     */
    public static final int PART_NEEDED = 18;
    
    /**
     * NUMBER_PARTS_PURCHASED message.
     */
    public static final int NUMBER_PARTS_PURCHASED = 19;
    
    private String state;
    private int id;
    private int size;
    private HashMap hash;
    private boolean[] flag;
    private int[] piecesBought;
    private String[] vehicleDriven;
    
    /**
     * Contructor of RepositoryMessage.
     * @param msg 
     */
    public RepositoryMessage(int msg) {
        this.msg = msg;
    }
    
    /**
     * Contructor of RepositoryMessage.
     * @param msg
     * @param state 
     */
    public RepositoryMessage(int msg, String state) {
        this.msg = msg;
        this.state = state;
    }
    
    /**
     * Contructor of RepositoryMessage.
     * @param msg
     * @param state
     * @param id 
     */
    public RepositoryMessage(int msg, String state, int id) {
        this.msg = msg;
        this.state = state;
        this.id = id;
    }
    
    /**
     * Contructor of RepositoryMessage.
     * @param msg
     * @param size 
     */
    public RepositoryMessage(int msg, int size) {
        this.msg = msg;
        this.size = size;
    }
    
    /**
     * Contructor of RepositoryMessage.
     * @param msg
     * @param hash 
     */
    public RepositoryMessage(int msg, HashMap hash) {
        this.msg = msg;
        this.hash = hash;
    }
    
    /**
     * Contructor of RepositoryMessage.
     * @param msg
     * @param flag 
     */
    public RepositoryMessage(int msg, boolean[] flag) {
        this.msg = msg;
        this.flag = flag;
    }
    
    /**
     * Contructor of RepositoryMessage.
     * @param msg
     * @param piecesBought 
     */
    public RepositoryMessage(int msg, int[] piecesBought) {
        this.msg = msg;
        this.piecesBought = piecesBought;
    }
    
    /**
     * Contructor of RepositoryMessage.
     * @param msg
     * @param vehicleDriven 
     */
    public RepositoryMessage(int msg, String[] vehicleDriven) {
        this.msg = msg;
        this.vehicleDriven = vehicleDriven;
    }

    /**
     * Get method for msg.
     * @return msg
     */
    public int getMessageType() {
        return this.msg;
    }
    
    /**
     * Get method for state.
     * @return state
     */
    public String getState() {
        return this.state;
    }
    
    /**
     * Get method for id.
     * @return id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Get method for size.
     * @return size
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * Get method for hash.
     * @return hash
     */
    public HashMap getStock() {
        return this.hash;
    }
    
    /**
     * Get method for flag.
     * @return flag
     */
    public boolean[] getFlag() {
        return this.flag;
    }
    
    /**
     * Get method for piecesBought.
     * @return piecesBought
     */
    public int[] getPiecesBought() {
        return this.piecesBought;
    }
    
    /**
     * Get method for vehicleDriven.
     * @return vehicleDriven
     */
    public String[] getVehicleDriven() {
        return this.vehicleDriven;
    }
}
