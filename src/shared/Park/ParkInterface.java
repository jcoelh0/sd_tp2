package shared.Park;

import messages.ParkMessage.*;

public class ParkInterface {

    private Park park;
    private boolean status = true;

    public ParkInterface(Park park) {
        this.park = park;
    }

    public boolean getStatus() {
        return this.status;
    }

    public ParkMessage process(ParkMessage inMsg) throws ParkMessageException {

        ParkMessage outMsg = null;

        switch(inMsg.getMessageType()) {

            case ParkMessage.FIND_CAR:
                break;

            case ParkMessage.GET_VEHICLE:
                break;
            
            case ParkMessage.PARK_CAR:
                break;
            
            case ParkMessage.REPLACEMENT_CAR_AVAILABLE:
                break;
            
            case ParkMessage.RESERVE_CAR:
                break;
            
            case ParkMessage.RETURN_REPLACEMENT_CAR:
                break;
            
            case ParkMessage.RETURN_VEHICLE:
                break;
                       
        }

        return outMsg;
    }

}