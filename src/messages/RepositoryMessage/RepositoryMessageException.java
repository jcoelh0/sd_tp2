package messages.RepositoryMessage;

public class RepositoryMessageException extends RuntimeException {

    private RepositoryMessage msg;

    public RepositoryMessageException(String error, RepositoryMessage msg) {
        super(error);
        this.msg = msg;
    }

    public RepositoryMessage getMsg() {
        return msg;
    }

}