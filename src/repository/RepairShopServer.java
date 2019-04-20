package repository;

import communication.ServerChannel;
import communication.message.Message;
import communication.message.MessageType;
import communication.server.ServerInterface;
import java.net.SocketException;

/**
 *
 * @author andre and joao
 */
public class RepairShopServer extends RepairShop implements ServerInterface {
	
	private boolean serverEnded;
	private final String name;
	
	public RepairShopServer(int nTypePieces, int nMechanics, int nCustomers, String fileName) {
		super(nTypePieces, nMechanics, nCustomers, fileName);
		name = "Repair Shop Server";
		serverEnded = false;
	}

	@Override
	public Message processAndReply(Message inMessage, ServerChannel scon) throws SocketException {
		switch (inMessage.getType()) {
			case TERMINATE:
				serverEnded = true;
				break;
			case updateFromLounge1:
				super.updateFromLounge(inMessage.getMessage_q1(), inMessage.getMessage_q2(), inMessage.getMessage_q3(), inMessage.getMessage_arrayBool());
				break;
			case updateFromLounge2:
				super.updateFromLounge(inMessage.getMessage_q1(), inMessage.getMessage_q2(), inMessage.getMessage_q3(), inMessage.getMessage_arrayBool(), inMessage.getInteger1(), inMessage.getCustomerState());
				break;
			case updateFromLounge3:
				super.updateFromLounge(inMessage.getManagerState());
				break;
			case updateFromLounge4:
				super.updateFromLounge(inMessage.getMessage_q1(), inMessage.getMessage_q2(), inMessage.getMessage_q3(), inMessage.getMessage_arrayBool(), inMessage.getInteger1(), inMessage.getMechanicState());
				break;
			case updateFromPark1:
				super.updateFromPark(inMessage.getMessage_l1(), inMessage.getMessage_q1());
				break;
			case updateFromPark2:
				super.updateFromPark(inMessage.getMessage_l1(), inMessage.getMessage_q1(), inMessage.getInteger1(), inMessage.getCustomerState());
				break;
			case updateFromPark3:
				super.updateFromPark(inMessage.getMessage_l1(), inMessage.getMessage_q1(), inMessage.getInteger1(), inMessage.getMechanicState());
				break;
			case updateFromOutsideWorld1:
				super.updateFromOutsideWorld(inMessage.getMessage_arrayStr());
				break;
			case updateFromOutsideWorld2:
				super.updateFromOutsideWorld(inMessage.getMessage_arrayStr(), inMessage.getInteger1(), inMessage.getCustomerState());
				break;
			case updateFromSupplierSite:
				super.updateFromSupplierSite(inMessage.getMessage_arrayInt());
				break;
			case updateFromRepairArea1:
				super.updateFromRepairArea(inMessage.getInteger1(), inMessage.getHashMapIntPiece(), inMessage.getMessage_arrayBool(), inMessage.getHashMapEnumPieceInt());
				break;
			case updateFromRepairArea2:
				super.updateFromRepairArea(inMessage.getInteger1(), inMessage.getHashMapIntPiece(), inMessage.getMessage_arrayBool(), inMessage.getHashMapEnumPieceInt(), inMessage.getManagerState());
				break;
			case updateFromRepairArea3:
				super.updateFromRepairArea(inMessage.getInteger1(), inMessage.getHashMapIntPiece(), inMessage.getMessage_arrayBool(), inMessage.getHashMapEnumPieceInt(), inMessage.getInteger2(), inMessage.getMechanicState());
				break;
			case reportInitialStatus:
				super.reportInitialStatus();
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
