package messages.ParkMessage;

public class ParkMessageException extends RuntimeException {

    private ParkMessage msg;

    public ParkMessageException(String error, ParkMessage msg) {
        super(error);
        this.msg = msg;
    }

    public ParkMessage getMsg() {
        return msg;
    }

}