package shared.Lounge;

import shared.Lounge.Lounge;
import communication.ServerChannel;
import communication.message.Message;
import communication.message.MessageType;
import communication.server.ServerInterface;
import java.net.SocketException;
import repository.Piece;
import repository.RepairShopProxy;


/**
 *
 * @author andre and joao
 */
public class LoungeServer extends Lounge implements ServerInterface {
	
	private boolean serverEnded;
	private final String name;
	private int response_int;
	private boolean response_bool;
	private Piece response_piece;
	private String response_str;

	/**
	 * LoungeServer constructor.
	 *
	 * @param nCustomers
	 * @param nTypePieces
	 * @param repairShop
	 */
	public LoungeServer(int nCustomers, int nTypePieces, RepairShopProxy repairShop) {
		super(nCustomers, nTypePieces, repairShop);
		name = "Lounge Server";
		serverEnded = false;
	}

	@Override
	public Message processAndReply(Message inMessage, ServerChannel scon) throws SocketException {
		switch (inMessage.getType()) {
			case TERMINATE:
				serverEnded = true;
				break;
			case queueIn:
				super.queueIn(inMessage.getInteger1(), inMessage.getCustomerState());
				break;
			case talkWithManager:
				super.talkWithManager(inMessage.getBoolean1(), inMessage.getBoolean2(), inMessage.getInteger1());
				break;
			case collectKey:
				response_bool = super.collectKey(inMessage.getInteger1(), inMessage.getCustomerState());
				return new Message(MessageType.ACK, response_bool);
			case payForTheService:
				super.payForTheService();
				break;
			case getCarReplacementId:
				response_int = super.getCarReplacementId(inMessage.getInteger1());
				return new Message(MessageType.ACK, response_int);
			case talkWithCustomer:
				response_str = super.talkWithCustomer(inMessage.getBoolean1());
				return new Message(MessageType.ACK, response_str);
			case handCarKey:
				super.handCarKey(inMessage.getInteger1(), inMessage.getInteger2());
				break;
			case addToReplacementQueue:
				super.addToReplacementQueue(inMessage.getInteger1());
				break;
			case currentCustomer:
				response_int = super.currentCustomer(inMessage.getManagerState());
				return new Message(MessageType.ACK, response_int);
			case checkWhatToDo:
				super.checkWhatToDo(inMessage.getManagerState());
				break;
			case getIdToCall:
				response_int = super.getIdToCall(inMessage.getManagerState());
				return new Message(MessageType.ACK, response_int);
			case enoughWork:
				response_bool = super.enoughWork();
				return new Message(MessageType.ACK, response_bool);
			case alertCustomer:
				response_bool = super.alertCustomer(inMessage.getInteger1());
				return new Message(MessageType.ACK, response_bool);
			case getNextTask:
				super.getNextTask();
				break;
			case receivePayment:
				super.receivePayment();
				break;
			case appraiseSit:
				response_int = super.appraiseSit();
				return new Message(MessageType.ACK, response_int);
			case getPieceToReStock:
				response_piece = super.getPieceToReStock(inMessage.getManagerState());
				return new Message(MessageType.ACK, response_piece);
			case goReplenishStock:
				super.goReplenishStock(inMessage.getManagerState());
				break;
			case alertManager:
				super.alertManager(inMessage.getPiece(), inMessage.getInteger1(), inMessage.getInteger2(), inMessage.getMechanicState());
				break;
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
