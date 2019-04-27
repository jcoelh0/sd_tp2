package shared.RepairArea;

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

        switch(inMsg.getMessageType()) {

            case RepairAreaMessage.ENOUGH_WORK:
                break;

            case RepairAreaMessage.FIX_IT:
                break;

            case RepairAreaMessage.GET_PIECES_TO_BE_REPAIRED:
                break;

            case RepairAreaMessage.GET_REQUIRED_PART:
                break;

            case RepairAreaMessage.LET_MANAGER_KNOW:
                break;

            case RepairAreaMessage.PART_AVAILABLE:
                break;

            case RepairAreaMessage.READ_THE_PAPER:
                break;

            case RepairAreaMessage.REGISTER_SERVICE:
                break;

            case RepairAreaMessage.REPAIR_CONCLUDED:
                break;

            case RepairAreaMessage.RESUME_REPAIR_PROCEDURE:
                break;

            case RepairAreaMessage.START_REPAIR_PROCEDURE:
                break;

            case RepairAreaMessage.STORE_PART:
                break;

        }

        return outMsg;
    }

}