package messages.RepositoryMessage;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class RepositoryMessageException extends RuntimeException {

    private RepositoryMessage msg;

    /**
     * Instantiation of Repository message exception.
     * @param error text with error
     * @param msg message with exception
     */ 
    public RepositoryMessageException(String error, RepositoryMessage msg) {
        super(error);
        this.msg = msg;
    }

    /**
     * Obtaining the Repository message with error.
     * @return message
     */
    public RepositoryMessage getMsg() {
        return msg;
    }

}