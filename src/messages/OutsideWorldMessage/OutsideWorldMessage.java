package messages.OutsideWorldMessage;

import java.io.Serializable;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class OutsideWorldMessage implements Serializable {
    
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
     * PHONE_CUSTOMER message.
     */
    public static final int PHONE_CUSTOMER = 1;
    
    /**
     * DECIDE_ON_REPAIR message.
     */
    public static final int DECIDE_ON_REPAIR = 2;
    
    /**
     * BACK_TO_WORK_BY_CAR message.
     */
    public static final int BACK_TO_WORK_BY_CAR = 3;
    
    /**
     * BACK_TO_WORK_BY_BUS message.
     */
    public static final int BACK_TO_WORK_BY_BUS = 4;
    
    private int cust_id;
    private boolean carRepaired;
    private int replacementCar;
    private boolean boolResponse;
    
    /**
     * Constructor of OutsideWorldMessage.
     * @param msg type of message received
     */
    public OutsideWorldMessage(int msg) {
        this.msg = msg;
    }
    
    /**
     * Constructor of OutsideWorldMessage.
     * @param msg type of message received
     * @param cust_id id of the customer
     */
    public OutsideWorldMessage(int msg, int cust_id) {
        this.msg = msg;
        this.cust_id = cust_id;
    }
    
    /**
     * Constructor of OutsideWorldMessage.
     * @param msg type of message received
     * @param cust_id id of the customer
     * @param carRepaired boolean signalizing if car is repaired
     */
    public OutsideWorldMessage(int msg, int cust_id, boolean carRepaired) {
        this.msg = msg;
        this.cust_id = cust_id;
        this.carRepaired = carRepaired;
    }
    
    /**
     * Constructor of OutsideWorldMessage.
     * @param msg type of message received
     * @param cust_id id of the customer
     * @param carRepaired boolean signalizing if car is repaired
     * @param replacementCar id of the replacement car
     */
    public OutsideWorldMessage(int msg, int cust_id, boolean carRepaired, int replacementCar) {
        this.msg = msg;
        this.cust_id = cust_id;
        this.carRepaired = carRepaired;
        this.replacementCar = replacementCar;
    }
    
    /**
     * Constructor of OutsideWorldMessage.
     * @param msg type of message received
     * @param boolResponse boolean response received 
     */
    public OutsideWorldMessage(int msg, boolean boolResponse) {
        this.msg = msg;
        this.boolResponse = boolResponse;
    }
    
    /**
     * Get method for msg.
     * @return msg
     */
    public int getMessageType() {
        return this.msg;
    }
    
    /**
     * Get method for cust_id.
     * @return cust_id
     */
    public int getCustId() {
        return this.cust_id;
    }
    
    /**
     * Get method for carRepaired.
     * @return carRepaired
     */
    public boolean getCarRepaired() {
        return this.carRepaired;
    }
    
    /**
     * Get method for replacementCar.
     * @return replacementCar
     */
    public int getReplacementCar() {
        return this.replacementCar;
    }
    
    /**
     * Get method for boolResponse.
     * @return boolResponse
     */
    public boolean getBoolResponse() {
        return this.boolResponse;
    }
    
}
