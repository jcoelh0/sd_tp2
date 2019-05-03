package messages.LoungeMessage;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class LoungeMessageException extends RuntimeException {

    private LoungeMessage msg;

    /**
     * Instantiation of Lounge message exception.
     * @param error text with error
     * @param msg message with exception
     */ 
    public LoungeMessageException(String error, LoungeMessage msg) {
        super(error);
        this.msg = msg;
    }

    /**
     * Obtaining the Lounge message with error.
     * @return message
     */
    public LoungeMessage getMsg() {
        return msg;
    }

}