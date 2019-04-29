package shared.OutsideWorld;

import entities.Customer.States.CustomerState;
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
        Object response = null;

        switch(inMsg.getMessageType()) {

            case OutsideWorldMessage.PHONE_CUSTOMER:
                response = outsideWorld.phoneCustomer(inMsg.getCustId());
                outMsg = new OutsideWorldMessage(OutsideWorldMessage.SUCCESS, (boolean) response);
                break;

            case OutsideWorldMessage.BACK_TO_WORK_BY_BUS:
                response = outsideWorld.backToWorkByBus(inMsg.getCarRepaired(), inMsg.getCustId());
                outMsg = new OutsideWorldMessage(OutsideWorldMessage.SUCCESS, (boolean) response);
                break;

            case OutsideWorldMessage.BACK_TO_WORK_BY_CAR:
                response = outsideWorld.backToWorkByCar(inMsg.getCarRepaired(), inMsg.getReplacementCar(), inMsg.getCustId());
                outMsg = new OutsideWorldMessage(OutsideWorldMessage.SUCCESS, (boolean) response);
                break;

            case OutsideWorldMessage.DECIDE_ON_REPAIR:
                response = outsideWorld.decideOnRepair(inMsg.getCustId());
                outMsg = new OutsideWorldMessage(OutsideWorldMessage.SUCCESS, (boolean) response);
                break;

        }

        return outMsg;
    }

}