package shared.Lounge;

import messages.LoungeMessage.*;

public class LoungeInterface {

    private Lounge lounge;
    private boolean status = true;

    public LoungeInterface(Lounge lounge) {
        this.lounge = lounge;
    }

    public boolean getStatus() {
        return this.status;
    }

    public LoungeMessage process(LoungeMessage inMsg) throws LoungeMessageException {
        
        LoungeMessage outMsg = null;

        switch(inMsg.getMessageType()) {

            case LoungeMessage.ADD_TO_REPLACEMENT_QUEUE:
                break;

            case LoungeMessage.ALERT_CUSTOMER:
                break;
                
            case LoungeMessage.ALERT_MANAGER:
                break;
                
            case LoungeMessage.APPRAISE_SIT:
                break;
                
            case LoungeMessage.CHECK_WHAT_TO_DO:
                break;
                
            case LoungeMessage.COLLECT_KEY:
                break;
                
            case LoungeMessage.CURRENT_CUSTOMER:
                break;
                
            case LoungeMessage.GET_ID_TO_CALL:
                break;
                
            case LoungeMessage.GET_NEXT_TASK:
                break;
                
            case LoungeMessage.GET_PIECE_TO_RESTOCK:
                break;
                
            case LoungeMessage.GET_REPLACEMENT_CAR:
                break;
                
            case LoungeMessage.GO_REPLENISH_STOCK:
                break;
                
            case LoungeMessage.HAND_CAR_KEY:
                break;
                
            case LoungeMessage.PAY_FOR_THE_SERVICE:
                break;
                
            case LoungeMessage.QUEUE_IN:
                break;
                
            case LoungeMessage.RECEIVE_PAYMENT:
                break;
                
            case LoungeMessage.TALK_WITH_CUSTOMER:
                break;
                
            case LoungeMessage.TALK_WITH_MANAGER:
                break;

            default:
                throw new LoungeMessageException("Invalid message type.", inMsg);
        }
        return outMsg;
    }

}