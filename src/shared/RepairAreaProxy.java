package shared;

import communication.message.Message;
import communication.message.MessageType;
import communication.message.MessageWrapper;
import communication.server.ClientProxy;
import entities.ManagerState;
import entities.MechanicState;
import java.util.HashMap;
import repository.Piece;

/**
 *
 * @author andre and joao
 */
public class RepairAreaProxy extends ClientProxy implements IManagerRA, IMechanicRA {

	public RepairAreaProxy(String proxyName) {
		super(proxyName);
	}
	
	public RepairAreaProxy(){
        super("RepairArea");
    }

	@Override
	public void registerService(int idCustomer, ManagerState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, idCustomer, state));
	}

	@Override
	public int storePart(Piece part, int quant) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, part, quant));
        return result.getMessage().getInteger1();
	}

	@Override
	public void enoughWork() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt));
	}

	@Override
	public boolean readThePaper(int idMechanic, MechanicState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, idMechanic, state));
        return result.getMessage().getBoolean1();
	}

	@Override
	public int startRepairProcedure() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt));
        return result.getMessage().getInteger1();
	}

	@Override
	public void getRequiredPart(int id) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, id));
	}

	@Override
	public void letManagerKnow(Piece piece, int idCarToFix) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt, piece, idCarToFix));
	}

	@Override
	public boolean partAvailable(Piece requiredPart, int idMechanic, MechanicState state) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, requiredPart, idMechanic, state));
        return result.getMessage().getBoolean1();
	}

	@Override
	public int fixIt(int id, Piece p) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, id, p));
        return result.getMessage().getInteger1();
	}

	@Override
	public void getNextTask() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt));
	}

	@Override
	public void resumeRepairProcedure() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt));
	}

	@Override
	public void repairConcluded() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        communicate(new Message(mt));
	}

	@Override
	public HashMap getPiecesToBeRepaired() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt));
        return result.getMessage().getMap1();
	}

	@Override
	public HashMap getPieces() {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt));
        return result.getMessage().getMap1();
	}
	
}
