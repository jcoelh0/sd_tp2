package messages.RepositoryMessage;

import java.util.HashMap;
import settings.EnumPiece;

public class RepositoryMessage {
    
    private int msg = -1;
    
    public static final int END = 0;
    
    public static final int SUCCESS = 100;
    
    public static final int MANAGER_STATE = 1;
    
    public static final int MECHANIC_STATE = 2;
    
    public static final int CUSTOMER_STATE = 3;
    
    public static final int SET_MANAGER_STATE = 4;
    
    public static final int SET_MECHANIC_STATE = 5;
    
    public static final int SET_CUSTOMER_STATE = 6;
    
    public static final int VEHICLE_DRIVEN = 7;
    
    public static final int REQUIRES_CAR = 8;
    
    public static final int REPAIRED_CAR = 9;
    
    public static final int NUMBER_IN_QUEUE = 10;
    
    public static final int WAITING_REPLACEMENT = 11;
    
    public static final int NUMBER_CARS_REPAIRED = 12;
    
    public static final int NUMBER_NONREPCARS_PARKED = 13;
    
    public static final int NUMBER_REPCARS_PARKED = 14;
    
    public static final int NUMBER_SERVICES = 15;
    
    public static final int NUMBER_PARTS = 16;
    
    public static final int NUMBER_VEHICLES_WAITING = 17;
    
    public static final int PART_NEEDED = 18;
    
    public static final int NUMBER_PARTS_PURCHASED = 19;
    
    private String state;
    private int id;
    private int size;
    private HashMap hash;
    private boolean[] flag;
    private int[] piecesBought;
    private String[] vehicleDriven;
    
    public RepositoryMessage(int msg, String state) {
        this.msg = msg;
        this.state = state;
    }
    
    public RepositoryMessage(int msg, String state, int id) {
        this.msg = msg;
        this.state = state;
        this.id = id;
    }
    
    public RepositoryMessage(int msg, int size) {
        this.msg = msg;
        this.size = size;
    }
    
    public RepositoryMessage(int msg, HashMap hash) {
        this.msg = msg;
        this.hash = hash;
    }
    
    public RepositoryMessage(int msg, boolean[] flag) {
        this.msg = msg;
        this.flag = flag;
    }
    
    public RepositoryMessage(int msg, int[] piecesBought) {
        this.msg = msg;
        this.piecesBought = piecesBought;
    }
    
    public RepositoryMessage(int msg, String[] vehicleDriven) {
        this.msg = msg;
        this.vehicleDriven = vehicleDriven;
    }

    
    public int getMessageType() {
        return this.msg;
    }
    
    public String getState() {
        return this.state;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public HashMap getStock() {
        return this.hash;
    }
    
    public boolean[] getFlag() {
        return this.flag;
    }
    
    public int[] getPiecesBought() {
        return this.piecesBought;
    }
    
    public String[] getVehicleDriven() {
        return this.vehicleDriven;
    }
}
