package messages.OutsideWorldMessage;

public class OutsideWorldMessageException extends RuntimeException {

    private OutsideWorldMessage msg;

    public OutsideWorldMessageException(String error, OutsideWorldMessage msg) {
        super(error);
        this.msg = msg;
    }

    public OutsideWorldMessage getMsg() {
        return msg;
    }

}