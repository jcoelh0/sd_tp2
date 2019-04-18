/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication.message;

/**
 *
 * @author andre and joao
 */
public enum MessageType {
	/* Manager messages */
	
    /* Mechanic messages */
    readThePaper, startRepairProcedure, getRequiredPart, letManagerKnow, partAvailable, fixIt, getNextTask, resumeRepairProcedure, repairConcluded, getPiecesToBeRepaired, getPieces,
	getVehicle, returnVehicle,
	alertManager,
	/* Customer messages */
	
    /* To compile */
    ACK, TERMINATE, SERVER_PORTS, SERVER_HOSTS,
    /* Vars */
    N_CUSTOMERS, N_MECHANICS, N_MANAGERS, N_REPLACEMENT_CARS, N_TYPE_PIECES,
    /* Log messages */
    setSpectatorAmount, setBrokerState, setHorseJockeyState, setSpectatorState,
    /* Races messages */
    chooseBet, horseHasBeenSelectedToRace, setHorseJockeyStepSize, getHorseJockeyStepSize, getWinner, hasMoreRaces, getHorseIteration,
    getStandingPosition, nextMovingHorse, horseFinished, horsesFinished, getNRunningHorses, getCurrentRaceDistance, getStartTheRace,
    setStartTheRace, getWakedHorsesToPaddock, addWakedHorsesToPaddock, getAnnouncedNextRace, setAnnouncedNextRace, allSpectatorsArrivedAtPaddock,
    addNSpectatorsArrivedAtPaddock, allHorseJockeyLeftThePadock, addNHorseJockeyLeftThePadock, setReportResults, getReportResults,
    setProceedToPaddock, getProceedToPaddock, allNHorsesInPaddock, addNHorsesInPaddock, waitAddedBet, allSpectatorsBettsAceppted,
    addBetOfSpectator, allSpectatorsBetted, waitAcceptedTheBet, acceptBet, poolWaitingToBePaidSpectators, addWaitingToBePaidSpectator,
    allSpectatorsPaid, getPaidSpectators, setPaidSpectators, getSpectatorBet, getHorseOdd, getHorsePosition, selectedHorseId
}
