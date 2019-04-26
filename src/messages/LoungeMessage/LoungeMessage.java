/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.LoungeMessage;

import java.io.Serializable;
import repository.Piece;
/**
 *
 * @author andre
 */
public class LoungeMessage implements Serializable {
    
    private int msg = -1;
    
    public static final int COLLECT_KEY = 1;
    
    public static final int GET_REPLACEMENT_CAR = 2;
    
    public static final int QUEUE_IN = 3;
    
    public static final int TALK_WITH_MANAGER = 4;
    
    public static final int PAY_FOR_THE_SERVICE = 5;
    
    public static final int CHECK_WHAT_TO_DO = 6;
    
    public static final int GET_NEXT_TASK = 7;
    
    public static final int APPRAISE_SIT = 8;
    
    public static final int CURRENT_CUSTOMER = 9;
    
    public static final int TALK_WITH_CUSTOMER = 10;
    
    public static final int HAND_CAR_KEY = 11;
 
    public static final int ADD_TO_REPLACEMENT_QUEUE = 12;
    
    public static final int RECEIVE_PAYMENT = 13;
    
    public static final int GET_PIECE_TO_RESTOCK = 14;
    
    public static final int GET_ID_TO_CALL = 15;
    
    public static final int ALERT_CUSTOMER = 16;
    
    public static final int GO_REPLENISH_STOCK = 17;
    
    public static final int ALERT_MANAGER = 18;
    
    private int cust_id;
    private boolean carRepaired;
    private boolean requiresCar;
    private int mech_id;
    private Piece piece;
    private int car_id;
    
    public LoungeMessage(int msg) {
        this.msg = msg;
    }
    
    public LoungeMessage(int msg, int cust_id) {
        this.msg = msg;
        this.cust_id = cust_id;
    }
    
    public LoungeMessage(int msg, int cust_id, boolean carRepaired, boolean requiresCar) {
        this.msg = msg;
        this.cust_id = cust_id;
        this.carRepaired = carRepaired;
        this.requiresCar = requiresCar;
    }
    
    public LoungeMessage(int msg, int mech_id, Piece piece, int cust_id) {
        this.msg = msg;
        this.mech_id = mech_id;
        this.piece = piece;
        this.cust_id = cust_id;
    }
    
    public LoungeMessage(int msg, int car_id, int cust_id) {
        this.msg = msg;
        this.car_id = car_id;
        this.cust_id = cust_id;
    }
    
    public int getMessageType() {
        return this.msg;
    }
    
    public int getCustId() {
        return this.cust_id;
    }
    
    public boolean getCarRepaired() {
        return this.carRepaired;
    }
    
    public boolean getRequiresCar() {
        return this.requiresCar;
    }
    
    public int getMechId() {
        return this.mech_id;
    }
    
    public int getCarId() {
        return this.car_id;
    }
    
    public Piece getPiece() {
        return this.piece;
    }
    
}
