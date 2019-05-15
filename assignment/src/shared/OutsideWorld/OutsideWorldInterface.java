package shared.OutsideWorld;

import messages.OutsideWorldMessage.*;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class OutsideWorldInterface {

    private OutsideWorld outsideWorld;
    private boolean status = true;
    
    /**
     * OutsideWorldInterface constructor
     * @param outsideWorld OutsideWorld reference
     */
    public OutsideWorldInterface(OutsideWorld outsideWorld) {
        this.outsideWorld = outsideWorld;
    }

    /**
     * Checks if the server is running.
     * @return boolean to determine server status.
     */
    public boolean getStatus() {
        return this.status;
    }

    /**
     * Method that processes the message received and executes the operation
     * associated to that message.
     * 
     * @param inMsg message that contains a given request
     * @return OutsideWorldMessage reply
     * @throws OutsideWorldMessageException if the message contains an invalid request
     */
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
            
            case OutsideWorldMessage.END:
                System.out.println("Closing outside world server!");
                this.status = false;
                outMsg = new OutsideWorldMessage(OutsideWorldMessage.SUCCESS);
                break;
                
            default:
                throw new OutsideWorldMessageException("Invalid message type.", inMsg);
        }

        return outMsg;
    }

}