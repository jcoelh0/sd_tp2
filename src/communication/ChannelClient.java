package communication;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class ChannelClient {

    private Socket communication_socket = null;

    private String server_name = null;

    private int server_port;

    private ObjectInputStream input_stream = null;

    private ObjectOutputStream output_stream = null;

    public ChannelClient (String name, int port){
        server_name = name;
        server_port = port;
    }
    
    public boolean open(){
        boolean success = true; 
        SocketAddress server_addr = new InetSocketAddress (this.server_name, this.server_port);
        
        try{
            communication_socket = new Socket();
            communication_socket.connect (server_addr);           
        }
        catch(UnknownHostException e){  
            System.out.println("Thread "+Thread.currentThread().getName() + ", unkown server :" + server_name);
            e.printStackTrace ();
            System.exit (1);
        }
        catch(NoRouteToHostException e){
            System.out.println("Thread "+Thread.currentThread().getName() + ", server could not be reached :" + server_name);
            e.printStackTrace ();
            System.exit (1);
        }
        catch(ConnectException e){ 
            System.out.println("Thread "+Thread.currentThread().getName() + ", no response from server at :" + server_name + "." + server_port);
            if (e.getMessage ().equals ("Connection refused"))
                success = false;
            else { 
                System.out.println("Thread "+Thread.currentThread().getName() + ", "+e.getMessage ());
                e.printStackTrace ();
                System.exit (1);
            }    
        }
        catch(SocketTimeoutException E){
            System.out.println("Thread "+Thread.currentThread().getName() + ", server timeout : "+ server_name + "." + server_port);
            success = false;
        }
        catch(IOException e){ // fatal error, other errors
            System.out.println("Thread "+Thread.currentThread().getName() + ", Unknown error : " + server_name + "." + server_port);
            e.printStackTrace ();
            System.exit (1);
        }
        
        if (!success)  return (success);
        
        try{ 
            output_stream = new ObjectOutputStream (communication_socket.getOutputStream());
        }
        catch (IOException e){      
            System.out.println("Thread "+Thread.currentThread().getName() + ", Could not open input socket channel : " + server_name + "." + server_port);
            e.printStackTrace ();
            System.exit (1);
        }

        try{
            input_stream = new ObjectInputStream (communication_socket.getInputStream());
        }
        catch (IOException e){ 
            System.out.println("Thread "+Thread.currentThread().getName() + ", Could not open output socket channel : " + server_name + "." + server_port);
            e.printStackTrace ();
            System.exit (1);
        }
        
        return (success);
    }
    
    public void close (){
        try{ 
            input_stream.close();
        }catch(IOException e){
            System.out.println(Thread.currentThread ().getName () + " - could not close input socket channel!");
            e.printStackTrace ();
            System.exit (1);
        }

        try{
            output_stream.close();
        }
        catch (IOException e){ 
            System.out.println(Thread.currentThread ().getName () + " - could not close output socket channel!");
            e.printStackTrace ();
            System.exit (1);
        }

        try{ 
            communication_socket.close();
        }
        catch (IOException e)
        { 
            System.out.println(Thread.currentThread ().getName () + " - could not close communication socket!");
            e.printStackTrace ();
            System.exit (1);
        }
        
    }
     
   public Object readObject(){
        // object 
        Object fromServer = null;

        try{
            fromServer = input_stream.readObject ();
        }
        catch(InvalidClassException e){ 
            System.out.println(Thread.currentThread ().getName () + " - could not deserialize object to be read!");
            e.printStackTrace ();
            System.exit (1);
        }
        catch (IOException e){ 
            System.out.println(Thread.currentThread ().getName () + " - error while reading object from the input channel of the communication socket!");
            e.printStackTrace ();
            System.exit (1);
        }
        catch (ClassNotFoundException e)
        { 
            System.out.println(Thread.currentThread ().getName () + " - read object corresponds to an unknown data type!");
            e.printStackTrace ();
            System.exit (1);
        }

        return fromServer;
    }

    public void writeObject (Object toServer){
        try{ 
            output_stream.writeObject (toServer);
        }
        catch (InvalidClassException e){ 
            System.out.println(Thread.currentThread ().getName () + " - could not deserialize object to be written!");
            e.printStackTrace ();
            System.exit (1);
        }
        catch (NotSerializableException e){ 
            System.out.println(Thread.currentThread ().getName () + " - object to be written belong to a data type not serializable!");
            e.printStackTrace ();
            System.exit (1);
        }
        catch (IOException e){ 
            System.out.println(Thread.currentThread ().getName () + " - error while writting object of the output channel communication socket!");
            e.printStackTrace ();
            System.exit (1);
        }
        
   }
}