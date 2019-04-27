package shared.OutsideWorld;

import messages.OutsideWorldMessage.*;

public class OutsideWorldInterface {

    private OutsideWorld outsideWorld;
    private boolean status = true;

    public OutsideWorldInterface(OutsideWorld outsideWorld) {
        this.outsideWorld = outsideWorld;
    }

    public boolean getStatus() {
        return this.status;
    }

    public OutsideWorldMessage process(OutsideWorldMessage inMsg) throws OutsideWorldMessageException {

        OutsideWorldMessage outMsg = null;

        switch(inMsg.getMessageType()) {

            case OutsideWorldMessage.PHONE_CUSTOMER:
                break;

            case OutsideWorldMessage.BACK_TO_WORK_BY_BUS:
                break;

            case OutsideWorldMessage.BACK_TO_WORK_BY_CAR:
                break;

            case OutsideWorldMessage.DECIDE_ON_REPAIR:
                break;

        }

        return outMsg;
    }

}