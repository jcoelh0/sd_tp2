package shared;

import communication.ServerChannel;
import communication.message.Message;
import communication.message.MessageType;
import communication.server.ServerInterface;
import entities.ManagerState;
import entities.MechanicState;
import java.net.SocketException;
import java.util.HashMap;
import repository.Piece;
import repository.RepairShopProxy;

/**
 *
 * @author andre and joao
 */
public class RepairAreaServer extends RepairArea implements ServerInterface {
	
	private boolean serverEnded;
	private final String name;
	private int response_int;
	private boolean response_bool;
	private HashMap<?,?> response_hash;
	
	public RepairAreaServer(int nTypePieces, RepairShopProxy repairShop) {
		super(nTypePieces, repairShop);
		name = "RepairArea Server";
		serverEnded = false;
	}

	@Override
	public Message processAndReply(Message inMessage, ServerChannel scon) throws SocketException {
		switch (inMessage.getType()) {
			case TERMINATE:
				serverEnded = true;
				break;
			case registerService:
				super.registerService(inMessage.getInteger1(), inMessage.getManagerState());
				break;
			case storePart:
				response_int = super.storePart(inMessage.getMessage_p1(), inMessage.getInteger1());
				return new Message(MessageType.ACK, response_int);
			case enoughWork:
				super.enoughWork();
				break;
			case readThePaper:
				response_bool = super.readThePaper(inMessage.getInteger1(), inMessage.getMechanicState());
				return new Message(MessageType.ACK, response_bool);
			case startRepairProcedure:
				response_int = super.startRepairProcedure();
				return new Message(MessageType.ACK, response_int);
			case getRequiredPart:
				super.getRequiredPart(inMessage.getInteger1());
				break;
			case letManagerKnow:
				super.letManagerKnow(inMessage.getMessage_p1(), inMessage.getInteger1());
				break;
			case partAvailable:
				response_bool = super.partAvailable(inMessage.getMessage_p1(), inMessage.getInteger1(), inMessage.getMechanicState());
				return new Message(MessageType.ACK, response_bool);
			case fixIt:
				response_int = super.fixIt(inMessage.getInteger1(), inMessage.getMessage_p1());
				return new Message(MessageType.ACK, response_int);
			case getNextTask:
				super.getNextTask();
				break;
			case resumeRepairProcedure:
				super.resumeRepairProcedure();
				break;
			case repairConcluded:
				super.repairConcluded();
				break;
			case getPiecesToBeRepaired:
				response_hash = super.getPiecesToBeRepaired();
				return new Message(MessageType.ACK, response_bool);
			case getPieces:
				response_hash = super.getPieces();
				return new Message(MessageType.ACK, response_bool);
		}
		return new Message(MessageType.ACK);
	}

	@Override
	public String serviceName() {
		return name;
	}

	@Override
	public boolean serviceEnded() {
		return serverEnded;
	}
	
}
