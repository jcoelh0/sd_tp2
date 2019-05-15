package shared.Lounge;

import messages.LoungeMessage.*;
import settings.Piece;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class LoungeInterface {

    private Lounge lounge;
    private boolean status = true;

    /**
     * LoungeInterface constructor
     * @param lounge Lounge reference
     */
    public LoungeInterface(Lounge lounge) {
        this.lounge = lounge;
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
     * @return LoungeMessage reply
     * @throws LoungeMessageException if the message contains an invalid request
     */
    public LoungeMessage process(LoungeMessage inMsg) throws LoungeMessageException {
        
        LoungeMessage outMsg = null;
        Object response = null;

        switch(inMsg.getMessageType()) {

            case LoungeMessage.ADD_TO_REPLACEMENT_QUEUE:
                lounge.addToReplacementQueue(inMsg.getCustId());
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;

            case LoungeMessage.ALERT_CUSTOMER:
                response = lounge.alertCustomer(inMsg.getCustId());
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS, (boolean) response);
                break;
                
            case LoungeMessage.ALERT_MANAGER:
                lounge.alertManager(inMsg.getPiece(), inMsg.getCustId(), inMsg.getMechId());
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;
                
            case LoungeMessage.APPRAISE_SIT:
                response = lounge.appraiseSit();
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS, (int) response);
                break;
                
            case LoungeMessage.CHECK_WHAT_TO_DO:
                lounge.checkWhatToDo();
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;
                
            case LoungeMessage.COLLECT_KEY:
                response = lounge.collectKey(inMsg.getCustId());
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS, (boolean) response);
                break;
                
            case LoungeMessage.CURRENT_CUSTOMER:
                response = lounge.currentCustomer();
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS, (int) response);
                break;
                
            case LoungeMessage.GET_ID_TO_CALL:
                response = lounge.getIdToCall();
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS, (int) response);
                break;
                
            case LoungeMessage.GET_NEXT_TASK:
                lounge.getNextTask();
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;
                
            case LoungeMessage.GET_PIECE_TO_RESTOCK:
                response = lounge.getPieceToReStock();
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS, (Piece) response);
                break;
                
            case LoungeMessage.GET_REPLACEMENT_CAR:
                response = lounge.getCarReplacementId(inMsg.getCustId());
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS, (int) response);
                break;
                
            case LoungeMessage.GO_REPLENISH_STOCK:
                lounge.goReplenishStock();
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;
                
            case LoungeMessage.HAND_CAR_KEY:
                lounge.handCarKey(inMsg.getCarId(), inMsg.getCustId());
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;
                
            case LoungeMessage.PAY_FOR_THE_SERVICE:
                lounge.payForTheService();
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;
                
            case LoungeMessage.QUEUE_IN:
                lounge.queueIn(inMsg.getCustId());
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;
                
            case LoungeMessage.RECEIVE_PAYMENT:
                lounge.receivePayment();
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;
                
            case LoungeMessage.TALK_WITH_CUSTOMER:
                response = lounge.talkWithCustomer();
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS, (String) response);
                break;
                
            case LoungeMessage.TALK_WITH_MANAGER:
                lounge.talkWithManager(inMsg.getCarRepaired(), inMsg.getRequiresCar(), inMsg.getCustId());
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;
                
            case LoungeMessage.END:
                System.out.println("Closing lounge server!");
                this.status = false;
                outMsg = new LoungeMessage(LoungeMessage.SUCCESS);
                break;

            default:
                throw new LoungeMessageException("Invalid message type.", inMsg);
        }
        return outMsg;
    }

}