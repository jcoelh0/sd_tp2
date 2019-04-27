/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.SupplierSiteMessage;

import repository.Piece;

/**
 *
 * @author andre
 */
public class SupplierSiteMessage {
    
    private int msg = -1;
    
    public static final int GO_TO_SUPPLIER = 1;
    
    private Piece piece;
    
    public SupplierSiteMessage(int msg, Piece piece) {
        this.msg = msg;
        this.piece = piece;
    }
    
    public int getMessageType() {
        return this.msg;
    }
    
    public Piece getPiece() {
        return this.piece;
    }
}
