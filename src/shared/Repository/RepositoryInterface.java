/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.Repository;

import messages.RepositoryMessage.RepositoryMessage;
import messages.RepositoryMessage.RepositoryMessageException;

/**
 *
 * @author Andre
 */
public class RepositoryInterface {
    
    private Repository repository;
    private boolean status = true;
    
    public RepositoryInterface(Repository repository) {
        this.repository = repository;
    }
    
    public boolean getStatus() {
        return this.status;
    }
    
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
                break;
            
        }
        
        return outMsg;
    }
}
