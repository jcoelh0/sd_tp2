package shared;

import communication.message.Message;
import communication.message.MessageType;
import communication.message.MessageWrapper;
import communication.server.ClientProxy;
import repository.Piece;

/**
 *
 * @author andre and joao
 * 
 */
public class SupplierSiteProxy extends ClientProxy implements IManagerSS{

	public SupplierSiteProxy(String proxyName) {
		super(proxyName);
	}
	
	public SupplierSiteProxy(){
        super("SupplierSite");
    }

	@Override
	public int goToSupplier(Piece partNeeded) {
		MessageType mt = MessageType.valueOf(new Object(){}.getClass().getEnclosingMethod().getName());
        MessageWrapper result = communicate(new Message(mt, partNeeded));
        return result.getMessage().getInteger1();
	}
	
}
