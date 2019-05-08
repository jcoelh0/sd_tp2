package messages.RepairAreaMessage;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class RepairAreaMessageException extends RuntimeException {

    private RepairAreaMessage msg;

    /**
     * Instantiation of RepairArea message exception.
     * @param error text with error
     * @param msg message with exception
     */ 
    public RepairAreaMessageException(String error, RepairAreaMessage msg) {
        super(error);
        this.msg = msg;
    }

    /**
     * Obtaining the RepairArea message with error.
     * @return message
     */
    public RepairAreaMessage getMsg() {
        return msg;
    }

}