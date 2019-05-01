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
            
            case RepositoryMessage.MANAGER_STATE:
                break;
            
            case RepositoryMessage.CUSTOMER_STATE:
                break;
            
            case RepositoryMessage.END:
                break;
            
            case RepositoryMessage.MECHANIC_STATE:
                break;
            
            case RepositoryMessage.NUMBER_CARS_REPAIRED:
                break;
            
            case RepositoryMessage.NUMBER_IN_QUEUE:
                break;
            
            case RepositoryMessage.NUMBER_NONREPCARS_PARKED:
                break;
            
            case RepositoryMessage.NUMBER_PARTS:
                break;
            
            case RepositoryMessage.NUMBER_PARTS_PURCHASED:
                break;
            
            case RepositoryMessage.NUMBER_REPCARS_PARKED:
                break;
            
            case RepositoryMessage.NUMBER_SERVICES:
                break;
            
            case RepositoryMessage.NUMBER_VEHICLES_WAITING:
                break;
            
            case RepositoryMessage.PART_NEEDED:
                break;
            
            case RepositoryMessage.REPAIRED_CAR:
                break;
            
            case RepositoryMessage.REQUIRES_CAR:
                break;
            
            case RepositoryMessage.SET_CUSTOMER_STATE:
                break;
            
            case RepositoryMessage.SET_MANAGER_STATE:
                break;
            
            case RepositoryMessage.SUCCESS:
                break;
            
            case RepositoryMessage.VEHICLE_DRIVEN:
                break;
            
            case RepositoryMessage.WAITING_REPLACEMENT:
                break;
            
        }
        
        return outMsg;
    }
}
