package shared.RepairArea;

import java.util.HashMap;
import messages.RepairAreaMessage.*;
import settings.Piece;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
@SuppressWarnings("unchecked")
public class RepairAreaInterface {

    private RepairArea repairArea;
    private boolean status = true;

    /**
     * RepairAreaInterface constructor
     * @param repairArea RepairArea reference
     */
    public RepairAreaInterface(RepairArea repairArea) {
        this.repairArea = repairArea;
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
     * @return RepairAreaMessage reply
     * @throws RepairAreaMessageException if the message contains an invalid request
     */
    public RepairAreaMessage process(RepairAreaMessage inMsg) throws RepairAreaMessageException {

        RepairAreaMessage outMsg = null;
        Object response;

        switch(inMsg.getMessageType()) {

            case RepairAreaMessage.ENOUGH_WORK:
                repairArea.enoughWork();
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS);
                break;

            case RepairAreaMessage.FIX_IT:
                response = repairArea.fixIt(inMsg.getId(), inMsg.getPiece());
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS, (int) response);
                break;

            case RepairAreaMessage.GET_PIECES_TO_BE_REPAIRED:
                response = repairArea.getPiecesToBeRepaired();
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS, (HashMap<Integer,Piece>) response);
                break;

            case RepairAreaMessage.GET_REQUIRED_PART:
                repairArea.getRequiredPart(inMsg.getId());
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS);
                break;

            case RepairAreaMessage.LET_MANAGER_KNOW:
                repairArea.letManagerKnow(inMsg.getPiece(), inMsg.getCar());
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS);
                break;

            case RepairAreaMessage.PART_AVAILABLE:
                response = repairArea.partAvailable(inMsg.getPiece(), inMsg.getId());
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS, (boolean) response);
                break;

            case RepairAreaMessage.READ_THE_PAPER:
                response = repairArea.readThePaper(inMsg.getId());
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS, (boolean) response);
                break;

            case RepairAreaMessage.REGISTER_SERVICE:
                repairArea.registerService(inMsg.getId());
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS);
                break;

            case RepairAreaMessage.START_REPAIR_PROCEDURE:
                response = repairArea.startRepairProcedure();
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS, (int) response);
                break;

            case RepairAreaMessage.STORE_PART:
                response = repairArea.storePart(inMsg.getPiece(), inMsg.getQuant());
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS, (int) response);
                break;
                
            case RepairAreaMessage.END:
                System.out.println("End!");
                this.status = false;
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS);
                break;
                
            default:
                throw new RepairAreaMessageException("Invalid message type.", inMsg);

        }

        return outMsg;
    }

}