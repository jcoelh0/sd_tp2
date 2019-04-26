/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.RepairAreaMessage;

import repository.Piece;

/**
 *
 * @author andre
 */
public class RepairAreaMessage {
    
    private int msg = -1;
    
    public static int ENOUGH_WORK = 1;
    
    public static int REGISTER_SERVICE = 2;
    
    public static int STORE_PART = 3;
    
    public static int READ_THE_PAPER = 4;
    
    public static int START_REPAIR_PROCEDURE = 5;
    
    public static int GET_PIECES_TO_BE_REPAIRED = 6;
    
    public static int GET_REQUIRED_PART = 7;
    
    public static int FIX_IT = 8;
    
    public static int REPAIR_CONCLUDED = 9;
    
    public static int PART_AVAILABLE = 10;
    
    public static int LET_MANAGER_KNOW = 11;
    
    public static int RESUME_REPAIR_PROCEDURE = 12;
    
    private int id;
    private Piece piece;
    private int quant;
    private int car;
    
    public RepairAreaMessage(int msg) {
        this.msg = msg;
    }
    
    public RepairAreaMessage(int msg, int id) {
        this.msg = msg;
        this.id = id;
    }
    
    public RepairAreaMessage(int msg, int id, Piece piece, int car) {
        this.msg = msg;
        this.id = id;
        this.piece = piece;
        this.car = car;
    }
    
    public RepairAreaMessage(int msg, int id, Piece piece) {
        this.msg = msg;
        this.id = id;
        this.piece = piece;
    }
    
    public RepairAreaMessage(int msg, int id, int car) {
        this.msg = msg;
        this.id = id;
        this.car = car;
    }
    
    public RepairAreaMessage(int msg, Piece piece, int quant) {
        this.msg = msg;
        this.quant = quant;
        this.piece = piece;
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
    
    public Piece getPiece() {
        return this.piece;
    }
    
    public int getQuant() {
        return this.quant;
    }
    
}
