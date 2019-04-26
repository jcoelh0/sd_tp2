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
    
    public static int REPLACEMENT_CAR_AVAILABLE = 1;
    
    public static int RESERVE_CAR = 2;
    
    public static int GET_VEHICLE = 3;
    
    public static int RETURN_VEHICLE = 4;
    
    public static int PARK_CAR = 5;
    
    public static int RETURN_REPLACEMENT_CAR = 6;
    
    public static int FIND_CAR = 7;
    
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
