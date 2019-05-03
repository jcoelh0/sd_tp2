package messages.LoungeMessage;

import java.io.Serializable;
import settings.Piece;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class LoungeMessage implements Serializable {
    
    private int msg = -1;
    
    /**
     * END message.
     */
    public static final int END = 0;
    
    /**
     * COLLECT_KEY message.
     */
    public static final int COLLECT_KEY = 1;
    
    /**
     * GET_REPLACEMENT_CAR message.
     */
    public static final int GET_REPLACEMENT_CAR = 2;
    
    /**
     * QUEUE_IN message.
     */
    public static final int QUEUE_IN = 3;
    
    /**
     * TALK_WITH_MANAGER message.
     */
    public static final int TALK_WITH_MANAGER = 4;
    
    /**
     * PAY_FOR_THE_SERVICE message.
     */
    public static final int PAY_FOR_THE_SERVICE = 5;
    
    /**
     * CHECK_WHAT_TO_DO message.
     */
    public static final int CHECK_WHAT_TO_DO = 6;
    
    /**
     * GET_NEXT_TASK message.
     */
    public static final int GET_NEXT_TASK = 7;
    
    /**
     * APPRAISE_SIT message.
     */
    public static final int APPRAISE_SIT = 8;
    
    /**
     * CURRENT_CUSTOMER message.
     */
    public static final int CURRENT_CUSTOMER = 9;
    
    /**
     * TALK_WITH_CUSTOMER message.
     */
    public static final int TALK_WITH_CUSTOMER = 10;
    
    /**
     * HAND_CAR_KEY message.
     */
    public static final int HAND_CAR_KEY = 11;
 
    /**
     * ADD_TO_REPLACEMENT_QUEUE message.
     */
    public static final int ADD_TO_REPLACEMENT_QUEUE = 12;
    
    /**
     * RECEIVE_PAYMENT message.
     */
    public static final int RECEIVE_PAYMENT = 13;
    
    /**
     * GET_PIECE_TO_RESTOCK message.
     */
    public static final int GET_PIECE_TO_RESTOCK = 14;
    
    /**
     * GET_ID_TO_CALL message.
     */
    public static final int GET_ID_TO_CALL = 15;
    
    /**
     * ALERT_CUSTOMER message.
     */
    public static final int ALERT_CUSTOMER = 16;
    
    /**
     * GO_REPLENISH_STOCK message.
     */
    public static final int GO_REPLENISH_STOCK = 17;
    
    /**
     * ALERT_MANAGER message.
     */
    public static final int ALERT_MANAGER = 18;
    
    /**
     * SUCCESS message.
     */
    public static final int SUCCESS = 100;
    
    private int cust_id;
    private boolean carRepaired;
    private boolean requiresCar;
    private int mech_id;
    private Piece piece;
    private int car_id;
    private String strResponse;
    private boolean boolResponse;
    private Piece pieceResponse;
    
    /**
     * Constructor of LoungeMessage.
     * @param msg 
     */
    public LoungeMessage(int msg) {
        this.msg = msg;
    }
    
    /**
     * Constructor of LoungeMessage.
     * @param msg
     * @param cust_id 
     */
    public LoungeMessage(int msg, int cust_id) {
        this.msg = msg;
        this.cust_id = cust_id;
    }
    
    /**
     * Constructor of LoungeMessage.
     * @param msg
     * @param cust_id
     * @param carRepaired
     * @param requiresCar 
     */
    public LoungeMessage(int msg, int cust_id, boolean carRepaired, boolean requiresCar) {
        this.msg = msg;
        this.cust_id = cust_id;
        this.carRepaired = carRepaired;
        this.requiresCar = requiresCar;
    }
    
    /**
     * Constructor of LoungeMessage.
     * @param msg
     * @param mech_id
     * @param piece
     * @param cust_id 
     */
    public LoungeMessage(int msg, int mech_id, Piece piece, int cust_id) {
        this.msg = msg;
        this.mech_id = mech_id;
        this.piece = piece;
        this.cust_id = cust_id;
    }
    
    /**
     * Constructor of LoungeMessage.
     * @param msg
     * @param car_id
     * @param cust_id 
     */
    public LoungeMessage(int msg, int car_id, int cust_id) {
        this.msg = msg;
        this.car_id = car_id;
        this.cust_id = cust_id;
    }
    
    /**
     * Constructor of LoungeMessage.
     * @param msg
     * @param strResponse 
     */
    public LoungeMessage(int msg, String strResponse) {
        this.msg = msg;
        this.strResponse = strResponse;
    }
    
    /**
     * Constructor of LoungeMessage.
     * @param msg
     * @param boolResponse 
     */
    public LoungeMessage(int msg, boolean boolResponse) {
        this.msg = msg;
        this.boolResponse = boolResponse;
    }
    
    /**
     * Constructor of LoungeMessage.
     * @param msg
     * @param pieceResponse 
     */
    public LoungeMessage(int msg, Piece pieceResponse) {
        this.msg = msg;
        this.pieceResponse = pieceResponse;
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
     * Get method for requiresCar.
     * @return requiresCar
     */
    public boolean getRequiresCar() {
        return this.requiresCar;
    }
    
    /**
     * Get method for mech_id.
     * @return mech_id
     */
    public int getMechId() {
        return this.mech_id;
    }
    
    /**
     * Get method for car_id.
     * @return car_id
     */
    public int getCarId() {
        return this.car_id;
    }
    
    /**
     * Get method for piece.
     * @return piece
     */
    public Piece getPiece() {
        return this.piece;
    }
    
    /**
     * Get method for strResponse.
     * @return strResponse
     */
    public String getStrResponse() {
        return this.strResponse;
    }
    
    /**
     * Get method for boolResponse.
     * @return boolResponse
     */
    public boolean getBoolResponse() {
        return this.boolResponse;
    }
    
    /**
     * Get method for pieceResponse.
     * @return pieceResponse
     */
    public Piece getPieceResponse() {
        return this.pieceResponse;
    }
    
}
