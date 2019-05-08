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

    /**
     * ParkInterface constructor
     * @param park Park reference
     */
    public ParkInterface(Park park) {
        this.park = park;
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
     * @return ParkMessage reply
     * @throws ParkMessageException if the message contains an invalid request
     */
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
            
            case ParkMessage.END:
                System.out.println("End!");
                this.status = false;
                outMsg = new ParkMessage(ParkMessage.SUCCESS);
                break;
                
            default:
                throw new ParkMessageException("Invalid message type.", inMsg);
        }

        return outMsg;
    }

}