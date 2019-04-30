package shared.RepairArea;

import java.util.HashMap;
import messages.RepairAreaMessage.*;

public class RepairAreaInterface {

    private RepairArea repairArea;
    private boolean status = true;

    public RepairAreaInterface(RepairArea repairArea) {
        this.repairArea = repairArea;
    }

    public boolean getStatus() {
        return this.status;
    }

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
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS, (HashMap) response);
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

            case RepairAreaMessage.REPAIR_CONCLUDED:
                repairArea.repairConcluded();
                outMsg = new RepairAreaMessage(RepairAreaMessage.SUCCESS);
                break;

            case RepairAreaMessage.RESUME_REPAIR_PROCEDURE:
                repairArea.resumeRepairProcedure();
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

        }

        return outMsg;
    }

}