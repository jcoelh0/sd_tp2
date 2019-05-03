package messages.ParkMessage;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class ParkMessage {
    
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
     * REPLACEMENT_CAR_AVAILABLE message.
     */
    public static final int REPLACEMENT_CAR_AVAILABLE = 1;
    
    /**
     * RESERVE_CAR message.
     */
    public static final int RESERVE_CAR = 2;
    
    /**
     * GET_VEHICLE message.
     */
    public static final int GET_VEHICLE = 3;
    
    /**
     * RETURN_VEHICLE message.
     */
    public static final int RETURN_VEHICLE = 4;
    
    /**
     * PARK_CAR message.
     */
    public static final int PARK_CAR = 5;
    
    /**
     * RETURN_REPLACEMENT_CAR message.
     */
    public static final int RETURN_REPLACEMENT_CAR = 6;
    
    /**
     * FIND_CAR message.
     */
    public static final int FIND_CAR = 7;
    
    private int id;
    private int car;
    private boolean boolResponse;
    
    /**
     * Constructor of ParkMessage.
     * @param msg type of message received
     */
    public ParkMessage(int msg) {
        this.msg = msg;
    }
    
    /**
     * Constructor of ParkMessage.
     * @param msg type of message received
     * @param boolResponse boolean received
     */
    public ParkMessage(int msg, boolean boolResponse) {
        this.msg = msg;
        this.boolResponse = boolResponse;
    }
    
    /**
     * Constructor of ParkMessage.
     * @param msg type of message received
     * @param id int received
     */
    public ParkMessage(int msg, int id) {
        this.msg = msg;
        this.id = id;
    }
    
    /**
     * Constructor of ParkMessage.
     * @param msg type of message received
     * @param id id received
     * @param car car received
     */
    public ParkMessage(int msg, int id, int car) {
        this.msg = msg;
        this.id = id;
        this.car = car;
    }
    
    /**
     * Get method for msg.
     * @return msg
     */
    public int getMessageType() {
        return this.msg;
    }
    
    /**
     * Get method for id.
     * @return id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Get method for car.
     * @return car
     */
    public int getCar() {
        return this.car;
    }
    
    /**
     * Get method for boolResponse.
     * @return boolResponse
     */
    public boolean getBoolResponse() {
        return this.boolResponse;
    }
    
}
