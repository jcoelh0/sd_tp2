/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.ParkMessage;

/**
 *
 * @author andre
 */
public class ParkMessage {
    
    private int msg = -1;
    
    public static final int END = 0;
    
    public static final int REPLACEMENT_CAR_AVAILABLE = 1;
    
    public static final int RESERVE_CAR = 2;
    
    public static final int GET_VEHICLE = 3;
    
    public static final int RETURN_VEHICLE = 4;
    
    public static final int PARK_CAR = 5;
    
    public static final int RETURN_REPLACEMENT_CAR = 6;
    
    public static final int FIND_CAR = 7;
    
    private int id;
    private int car;
    
    public ParkMessage(int msg, int id) {
        this.msg = msg;
        this.id = id;
    }
    
    public ParkMessage(int msg, int id, int car) {
        this.msg = msg;
        this.id = id;
        this.car = car;
    }
    
    public int getMessageType() {
        return this.msg;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getCar() {
        return this.car;
    }
    
}
