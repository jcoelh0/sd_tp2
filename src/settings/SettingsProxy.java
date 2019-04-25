package settings;

import communication.message.Message;
import communication.message.MessageType;
import communication.message.MessageWrapper;
import communication.server.Proxy;
import java.util.HashMap;

/**
 *
 * @author andre and joao
 */
public class SettingsProxy {

    private final String SERVER_HOST;
    private final int SERVER_PORT;

    /**
     *
     */
    public SettingsProxy() {
        String json_path = "hosts.json";

        if (Settings.DEBUG) {
            json_path = "debug_hosts.json";
        }

        Settings settings = new Settings(json_path);

        this.SERVER_HOST = settings.SERVER_HOSTS.get("Settings");
        this.SERVER_PORT = settings.SERVER_PORTS.get("Settings");
    }

    /**
     * Method to communicate with the Settings server.
     */
    private MessageWrapper communicate(Message m) {
        return Proxy.connect(SERVER_HOST, SERVER_PORT, m);
    }

    /**
     * Method to return the SERVER HOSTS.
     *
     * @return
     */
    public HashMap<String, String> SERVER_HOSTS() {
        MessageType mt = MessageType.valueOf(new Object() {
        }.getClass().getEnclosingMethod().getName());
        MessageWrapper wp = communicate(new Message(mt));
        return (HashMap<String, String>) wp.getMessage().getMap1();
        //poderá estar um erro aqui com o getMap1
    }

    /**
     * Method to return the SERVER PORTS.
     *
     * @return
     */
    public HashMap<String, Integer> SERVER_PORTS() {
        MessageType mt = MessageType.valueOf(new Object() {
        }.getClass().getEnclosingMethod().getName());
        MessageWrapper wp = communicate(new Message(mt));
        return (HashMap<String, Integer>) wp.getMessage().getMap1();
        //poderá estar um erro aqui com o getMap1
    }

    /**
     * Method to return the number of customers.
     *
     * @return
     */
    public int N_CUSTOMERS() {
        MessageType mt = MessageType.valueOf(new Object() {
        }.getClass().getEnclosingMethod().getName());
        MessageWrapper wp = communicate(new Message(mt));
        return wp.getMessage().getInteger1();
    }

    /**
     * Method to return the size of mechanics.
     *
     * @return
     */
    public int N_MECHANICS() {
        MessageType mt = MessageType.valueOf(new Object() {
        }.getClass().getEnclosingMethod().getName());
        MessageWrapper wp = communicate(new Message(mt));
        return wp.getMessage().getInteger1();
    }

    /**
     * Method to return the number of managers.
     *
     * @return
     */
    public int N_MANAGERS() {
        MessageType mt = MessageType.valueOf(new Object() {
        }.getClass().getEnclosingMethod().getName());
        MessageWrapper wp = communicate(new Message(mt));
        return wp.getMessage().getInteger1();
    }

    /**
     * Method to return number of replacement cars.
     *
     * @return
     */
    public int N_REPLACEMENT_CARS() {
        MessageType mt = MessageType.valueOf(new Object() {
        }.getClass().getEnclosingMethod().getName());
        MessageWrapper wp = communicate(new Message(mt));
        return wp.getMessage().getInteger1();
    }

    /**
     * Method to return number of type of pieces.
     *
     * @return
     */
    public int N_TYPE_PIECES() {
        MessageType mt = MessageType.valueOf(new Object() {
        }.getClass().getEnclosingMethod().getName());
        MessageWrapper wp = communicate(new Message(mt));
        return wp.getMessage().getInteger1();
    }
}
