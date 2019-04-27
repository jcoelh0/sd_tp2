/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.OutsideWorldMessage;

/**
 *
 * @author andre
 */
public class OutsideWorldMessage {
    
    private int msg = -1;
    
    public static final int PHONE_CUSTOMER = 1;
    
    public static final int DECIDE_ON_REPAIR = 2;
    
    public static final int BACK_TO_WORK_BY_CAR = 3;
    
    public static final int BACK_TO_WORK_BY_BUS = 4;
    
    private int cust_id;
    private boolean carRepaired;
    private boolean replacementCar;
    
    public OutsideWorldMessage(int msg, int cust_id) {
        this.msg = msg;
        this.cust_id = cust_id;
    }
    
    public OutsideWorldMessage(int msg, int cust_id, boolean carRepaired) {
        this.msg = msg;
        this.cust_id = cust_id;
        this.carRepaired = carRepaired;
    }
    
    public OutsideWorldMessage(int msg, int cust_id, boolean carRepaired, boolean replacementCar) {
        this.msg = msg;
        this.cust_id = cust_id;
        this.carRepaired = carRepaired;
        this.replacementCar = replacementCar;
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
    
    public boolean getReplacementCar() {
        return this.replacementCar;
    }
    
}
