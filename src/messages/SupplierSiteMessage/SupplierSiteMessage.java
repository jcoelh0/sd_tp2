/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.SupplierSiteMessage;

import settings.Piece;

/**
 *
 * @author andre
 */
public class SupplierSiteMessage {
    
    private int msg = -1;
    
    public static final int END = 0;
    
    public static final int SUCCESS = 100;
    
    public static final int GO_TO_SUPPLIER = 1;
    
    private Piece piece;
    private int intResponse;
    
    public SupplierSiteMessage(int msg, Piece piece) {
        this.msg = msg;
        this.piece = piece;
    }
    
    public SupplierSiteMessage(int msg, int intResponse) {
        this.msg = msg;
        this.intResponse = intResponse;
    }
    
    public int getMessageType() {
        return this.msg;
    }
    
    public Piece getPiece() {
        return this.piece;
    }
    
    public int getIntResponse() {
        return this.intResponse;
    }
}
