package messages.ParkMessage;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class ParkMessageException extends RuntimeException {

    private ParkMessage msg;

    /**
     * Instantiation of Park message exception.
     * @param error text with error
     * @param msg message with exception
     */ 
    public ParkMessageException(String error, ParkMessage msg) {
        super(error);
        this.msg = msg;
    }

    /**
     * Obtaining the Park message with error.
     * @return message
     */
    public ParkMessage getMsg() {
        return msg;
    }

}