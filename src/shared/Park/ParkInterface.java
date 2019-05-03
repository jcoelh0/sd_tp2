package shared.Park;

import messages.ParkMessage.*;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
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
        Object response = null;

        switch(inMsg.getMessageType()) {

            case ParkMessage.FIND_CAR:
                park.findCar(inMsg.getId(), inMsg.getCar());
                outMsg = new ParkMessage(ParkMessage.SUCCESS);
                break;

            case ParkMessage.GET_VEHICLE:
                park.getVehicle(inMsg.getCar(), inMsg.getId());
                outMsg = new ParkMessage(ParkMessage.SUCCESS);
                break;
            
            case ParkMessage.PARK_CAR:
                park.parkCar(inMsg.getId());
                outMsg = new ParkMessage(ParkMessage.SUCCESS);
                break;
            
            case ParkMessage.REPLACEMENT_CAR_AVAILABLE:
                response = park.replacementCarAvailable(inMsg.getId());
                outMsg = new ParkMessage(ParkMessage.SUCCESS, (boolean) response);
                break;
            
            case ParkMessage.RESERVE_CAR:
                response = park.reserveCar(inMsg.getId());
                outMsg = new ParkMessage(ParkMessage.SUCCESS, (int) response);
                break;
            
            case ParkMessage.RETURN_REPLACEMENT_CAR:
                park.returnReplacementCar(inMsg.getCar(), inMsg.getId());
                outMsg = new ParkMessage(ParkMessage.SUCCESS);
                break;
            
            case ParkMessage.RETURN_VEHICLE:
                park.returnVehicle(inMsg.getCar());
                outMsg = new ParkMessage(ParkMessage.SUCCESS);
                break;
                       
        }

        return outMsg;
    }

}