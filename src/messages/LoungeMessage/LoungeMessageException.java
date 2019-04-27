package messages.LoungeMessage;

public class LoungeMessageException extends RuntimeException {

    private LoungeMessage msg;

    public LoungeMessageException(String error, LoungeMessage msg) {
        super(error);
        this.msg = msg;
    }

    public LoungeMessage getMsg() {
        return msg;
    }

}