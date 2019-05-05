package shared.Repository;

import messages.RepositoryMessage.RepositoryMessage;
import messages.RepositoryMessage.RepositoryMessageException;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public class RepositoryInterface {
    
    private Repository repository;
    private boolean status = true;
    
    /**
     * RepositoryInterface constructor
     * @param repository Repository reference
     */
    public RepositoryInterface(Repository repository) {
        this.repository = repository;
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
     * @return RepositoryMessage reply
     * @throws RepositoryMessageException if the message contains an invalid request
     */
    public RepositoryMessage process(RepositoryMessage inMsg) throws RepositoryMessageException {
        
        RepositoryMessage outMsg = null;
        
        switch(inMsg.getMessageType()) {
            
            case RepositoryMessage.SET_CUSTOMER_STATE:
                repository.setCustomerState(inMsg.getState(), inMsg.getId());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.SET_MANAGER_STATE:
                repository.setManagerState(inMsg.getState());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.SET_MECHANIC_STATE:
                repository.setMechanicState(inMsg.getState(), inMsg.getId());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.NUMBER_CARS_REPAIRED:
                repository.setNumCarsRepaired(inMsg.getSize());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.NUMBER_IN_QUEUE:
                repository.setCustomersQueue(inMsg.getSize());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.NUMBER_NONREPCARS_PARKED:
                repository.setCustomersParked(inMsg.getSize());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.NUMBER_REPCARS_PARKED:
                repository.setReplacementParked(inMsg.getSize());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.NUMBER_SERVICES:
                repository.setRequests(inMsg.getSize());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.REPAIRED_CAR:
                repository.setNumCarsRepaired(inMsg.getSize());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.WAITING_REPLACEMENT:
                repository.setReplacementQueue(inMsg.getSize());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.REQUIRES_CAR:
                repository.setRequiresCar(inMsg.getState(), inMsg.getId());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.VEHICLE_DRIVEN:
                repository.setVehicleDriven(inMsg.getState(), inMsg.getId());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.NUMBER_VEHICLES_WAITING:
                break;
            
            case RepositoryMessage.PART_NEEDED:
                repository.setManagerNotifed(inMsg.getVehicleDriven());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.NUMBER_PARTS:
                repository.setPiecesStock(inMsg.getStock());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.NUMBER_PARTS_PURCHASED:
                repository.setBoughtPieces(inMsg.getPiecesBought());
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            case RepositoryMessage.END:
                System.out.println("End!");
                this.status = false;
                outMsg = new RepositoryMessage(RepositoryMessage.SUCCESS);
                break;
            
            default:
                throw new RepositoryMessageException("Invalid message type.", inMsg);
        }
        
        return outMsg;
    }
}
