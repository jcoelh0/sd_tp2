package messages.SupplierSiteMessage;

import settings.Piece;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class SupplierSiteMessage {
    
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
     * GO_TO_SUPPLIER message.
     */
    public static final int GO_TO_SUPPLIER = 1;
    
    private Piece piece;
    private int intResponse;
    
    /**
     * Contructor of SupplierSiteMessage.
     * @param msg type of message received
     * @param piece piece received
     */
    public SupplierSiteMessage(int msg, Piece piece) {
        this.msg = msg;
        this.piece = piece;
    }
    
    /**
     * Contructor of SupplierSiteMessage.
     * @param msg type of message received
     * @param intResponse int response received
     */
    public SupplierSiteMessage(int msg, int intResponse) {
        this.msg = msg;
        this.intResponse = intResponse;
    }
    
    /**
     * Get method for msg.
     * @return msg
     */
    public int getMessageType() {
        return this.msg;
    }
    
    /**
     * Get method for piece.
     * @return piece
     */
    public Piece getPiece() {
        return this.piece;
    }
    
    /**
     * Get method for intResponse.
     * @return intResponse
     */
    public int getIntResponse() {
        return this.intResponse;
    }
}
