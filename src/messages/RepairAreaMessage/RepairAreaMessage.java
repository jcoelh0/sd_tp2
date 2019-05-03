package messages.RepairAreaMessage;

import java.util.HashMap;
import settings.Piece;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class RepairAreaMessage {
    
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
     * ENOUGH_WORK message.
     */
    public static final int ENOUGH_WORK = 1;
    
    /**
     * REGISTER_SERVICE message.
     */
    public static final int REGISTER_SERVICE = 2;
    
    /**
     * STORE_PART message.
     */
    public static final int STORE_PART = 3;
    
    /**
     * READ_THE_PAPER message.
     */
    public static final int READ_THE_PAPER = 4;
    
    /**
     * START_REPAIR_PROCEDURE message.
     */
    public static final int START_REPAIR_PROCEDURE = 5;
    
    /**
     * GET_PIECES_TO_BE_REPAIRED message.
     */
    public static final int GET_PIECES_TO_BE_REPAIRED = 6;
    
    /**
     * GET_REQUIRED_PART message.
     */
    public static final int GET_REQUIRED_PART = 7;
    
    /**
     * FIX_IT message.
     */
    public static final int FIX_IT = 8;
    
    /**
     * REPAIR_CONCLUDED message.
     */
    public static final int REPAIR_CONCLUDED = 9;
    
    /**
     * PART_AVAILABLE message.
     */
    public static final int PART_AVAILABLE = 10;
    
    /**
     * LET_MANAGER_KNOW message.
     */
    public static final int LET_MANAGER_KNOW = 11;
    
    /**
     * RESUME_REPAIR_PROCEDURE message.
     */
    public static final int RESUME_REPAIR_PROCEDURE = 12;
    
    private int id;
    private Piece piece;
    private int quant;
    private int car;
    private boolean boolResponse;
    private HashMap<Integer, Piece> hashResponse;
    
    /**
     * Contructor of RepairAreaMessage.
     * @param msg 
     */
    public RepairAreaMessage(int msg) {
        this.msg = msg;
    }
    
    /**
     * Contructor of RepairAreaMessage.
     * @param msg
     * @param id 
     */
    public RepairAreaMessage(int msg, int id) {
        this.msg = msg;
        this.id = id;
    }
    
    /**
     * Contructor of RepairAreaMessage.
     * @param msg
     * @param id
     * @param piece
     * @param car 
     */
    public RepairAreaMessage(int msg, int id, Piece piece, int car) {
        this.msg = msg;
        this.id = id;
        this.piece = piece;
        this.car = car;
    }
    
    /**
     * Contructor of RepairAreaMessage.
     * @param msg
     * @param id
     * @param piece 
     */
    public RepairAreaMessage(int msg, int id, Piece piece) {
        this.msg = msg;
        this.id = id;
        this.piece = piece;
    }
    
    /**
     * Contructor of RepairAreaMessage.
     * @param msg
     * @param id
     * @param car 
     */
    public RepairAreaMessage(int msg, int id, int car) {
        this.msg = msg;
        this.id = id;
        this.car = car;
    }
    
    /**
     * Contructor of RepairAreaMessage.
     * @param msg
     * @param piece
     * @param quant 
     */
    public RepairAreaMessage(int msg, Piece piece, int quant) {
        this.msg = msg;
        this.quant = quant;
        this.piece = piece;
    }
    
    /**
     * Contructor of RepairAreaMessage.
     * @param msg
     * @param boolResponse 
     */
    public RepairAreaMessage(int msg, boolean boolResponse) {
        this.msg = msg;
        this.boolResponse = boolResponse;
    }
    
    /**
     * Contructor of RepairAreaMessage.
     * @param msg
     * @param hashResponse 
     */
    public RepairAreaMessage(int msg, HashMap hashResponse) {
        this.msg = msg;
        this.hashResponse = hashResponse;
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
     * Get method for piece.
     * @return piece
     */
    public Piece getPiece() {
        return this.piece;
    }
    
    /**
     * Get method for quant.
     * @return quant
     */
    public int getQuant() {
        return this.quant;
    }
    
    /**
     * Get method for boolResponse.
     * @return boolResponse
     */
    public boolean getBoolResponse() {
        return this.boolResponse;
    }
    
    /**
     * Get method for hashResponse.
     * @return hashResponse
     */
    public HashMap getHashResponse() {
        return this.hashResponse;
    }
}
