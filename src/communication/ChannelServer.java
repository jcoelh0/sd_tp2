package communication;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ChannelServer {

    private ServerSocket listening_socket = null;

    private Socket communication_socket = null;
    
    private int server_port;

    private ObjectInputStream input_stream = null;
    
    private ObjectOutputStream output_stream = null;

    public ChannelServer(int portNumb){
        server_port = portNumb;
    }

    public ChannelServer(int portNumb, ServerSocket lSocket){
        server_port = portNumb;
        listening_socket = lSocket;
    }

    public void start (){
        try{ 
            listening_socket = new ServerSocket (server_port);
        }
        catch (BindException e){
            System.out.println(Thread.currentThread ().getName () + " - could not link listening socket to port: " + server_port + "!");
            e.printStackTrace ();
            System.exit (1);
        }
        catch (IOException e){
            System.out.println(Thread.currentThread ().getName () + " - unkown error ocurred while linking listening socket to port: " + server_port + "!");
            e.printStackTrace ();
            System.exit (1);
        }
    }

    public void end (){
        try{ 
            listening_socket.close ();
        }
        catch (IOException e){
            System.out.println(Thread.currentThread ().getName () + " - não foi possível fechar o socket de escuta!");
            e.printStackTrace ();
            System.exit (1);
        }
    }  

    public ChannelServer accept (boolean... a){
        
        ChannelServer scon;

        scon = new ChannelServer(server_port, listening_socket);
        
        try{ 
            scon.communication_socket = listening_socket.accept();
        }
        catch (SocketException e){ 
            return scon;
        }
        catch (IOException e)
        { 
            System.out.println(Thread.currentThread ().getName () + " - could not open a communication channel for a pending request!");
            e.printStackTrace ();
            System.exit (1);
        }

        try{ 
            scon.input_stream = new ObjectInputStream (scon.communication_socket.getInputStream ());
        }
        catch (IOException e){ 
            System.out.println(Thread.currentThread ().getName () + " - could not open socket input channel!");
            e.printStackTrace ();
            System.exit (1);
        }

        try
        { 
            scon.output_stream = new ObjectOutputStream (scon.communication_socket.getOutputStream ());
        }
        catch (IOException e){
            System.out.println(Thread.currentThread ().getName () + " - could not open socket output channel");
            e.printStackTrace ();
            System.exit (1);
        }

        return scon;
    }

    public void close (){
        try{ 
            input_stream.close();
        }
        catch (IOException e){
            System.out.println(Thread.currentThread ().getName () + " - could not close socket input channel!");
            e.printStackTrace ();
            System.exit (1);
        }

        try{ 
            output_stream.close();
        }
        catch (IOException e){ 
            System.out.println(Thread.currentThread ().getName () + " - could not close socket output channel!");
            e.printStackTrace ();
            System.exit (1);
        }

        try{ 
            communication_socket.close();
        }
        catch (IOException e){
            System.out.println(Thread.currentThread ().getName () + " - could not close communication channel!");
            e.printStackTrace ();
            System.exit (1);
        }
    } 

    public Object readObject(){

        Object fromClient = null;

        try{ 
           fromClient = input_stream.readObject ();
        }
        catch (InvalidClassException e){
             System.out.println(Thread.currentThread ().getName () + " - could not deserialize object to be read!");
             e.printStackTrace ();
             System.exit (1);
        }
        catch (IOException e){
             System.out.println(Thread.currentThread ().getName () + " - error while reading object from the input channel of the communication socket!");
             e.printStackTrace ();
             System.exit (1);
        }
        catch (ClassNotFoundException e){ 
             System.out.println(Thread.currentThread ().getName () + " - read object corresponds to an unknown data type!");
             e.printStackTrace ();
             System.exit (1);
        }

        return fromClient;
    }

    public void writeObject (Object toClient){
      
        try{ 
            output_stream.writeObject (toClient);
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