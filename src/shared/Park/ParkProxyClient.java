/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.Park;

import communication.ChannelServer;
import messages.ParkMessage.ParkMessage;
import messages.ParkMessage.ParkMessageException;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author Andre
 */
public class ParkProxyClient extends Thread {
    
    private ChannelServer cs;
    
    private ParkInterface parkInterface;
    
    public ParkProxyClient(ChannelServer cs, ParkInterface parkInterface) {
        this.cs = cs;
        this.parkInterface = parkInterface;
    }
    
    @Override
    public void run() {
        ParkMessage in;
        ParkMessage out = null;
        
        in = (ParkMessage) cs.readObject();
        
        try {
            out = parkInterface.process(in);
        }
        catch(ParkMessageException e) {
            System.out.println("Thread " + getName() + ": " + e.getMessage() + "!");
            System.out.println(e.getMsg().toString());
            System.out.println("Failed to process request : " + in);
            System.exit(1);
        }
        if(!this.parkInterface.getStatus()) {
            cs.writeObject(out);
            cs.close();
            throw new ParkMessageException("End message received", out);
        }
        else {
            cs.writeObject(out);
            cs.close();
        }
    }
    
}
