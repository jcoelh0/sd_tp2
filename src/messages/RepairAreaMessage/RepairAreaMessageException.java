package messages.RepairAreaMessage;

public class RepairAreaMessageException extends RuntimeException {

    private RepairAreaMessage msg;

    public RepairAreaMessageException(String error, RepairAreaMessage msg) {
        super(error);
        this.msg = msg;
    }

    public RepairAreaMessage getMsg() {
        return msg;
    }

}