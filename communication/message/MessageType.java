package communication.message;

/**
 *
 * @author andre and joao
 */
public enum MessageType {
	/* Manager messages */
	talkWithCustomer, handCarKey, getIdToCall, addToReplacementQueue, currentCustomer, checkWhatToDo, alertCustomer, receivePayment, appraiseSit, getPieceToReStock, goReplenishStock, getNextTask,
	//outsideWorld
	phoneCustomer,
	//park
	replacementCarAvailable, reserveCar, waitForCustomer,
	//ss
	goToSupplier,
	//repairArea
	registerService, storePart, enoughWork,
	
    /* Mechanic messages */
    readThePaper, startRepairProcedure, getRequiredPart, letManagerKnow, partAvailable, fixIt, resumeRepairProcedure, repairConcluded, getPiecesToBeRepaired, getPieces, getVehicle, returnVehicle, alertManager,
	
	/* Customer messages */
	talkWithManager, collectKey, payForTheService, getCarReplacementId, queueIn,
	//outsideWorld
	decideOnRepair,goToRepairShop, backToWorkByBus, backToWorkByCar, goToReception,
	//park
	parkCar, collectCar, returnReplacementCar, findCar,
	
    /* To compile */
	ACK, TERMINATE, SERVER_PORTS, SERVER_HOSTS,
    /* Vars */
	N_CUSTOMERS, N_MECHANICS, N_MANAGERS, N_REPLACEMENT_CARS, N_TYPE_PIECES,
    
    /* RepairShop messages */
	updateFromLounge1, updateFromLounge2, updateFromLounge3, updateFromLounge4, updateFromPark1, updateFromPark2, updateFromPark3, updateFromOutsideWorld1, updateFromOutsideWorld2, updateFromSupplierSite, updateFromRepairArea1, updateFromRepairArea2, updateFromRepairArea3, reportInitialStatus
}