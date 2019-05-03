package messages.OutsideWorldMessage;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class OutsideWorldMessageException extends RuntimeException {

    private OutsideWorldMessage msg;

    /**
     * Instantiation of OutsideWorld message exception.
     * @param error text with error
     * @param msg message with exception
     */ 
    public OutsideWorldMessageException(String error, OutsideWorldMessage msg) {
        super(error);
        this.msg = msg;
    }

    /**
     * Obtaining the OutsideWorld message with error.
     * @return message
     */
    public OutsideWorldMessage getMsg() {
        return msg;
    }

}