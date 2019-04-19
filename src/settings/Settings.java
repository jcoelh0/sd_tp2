package settings;

import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author andre and joao
 */
public class Settings {

	/**
	 * Map of Server ports
	 */
	protected HashMap<String, Integer> SERVER_PORTS;

	/**
	 *
	 */
	protected HashMap<String, String> SERVER_HOSTS;

	/**
	 *
	 */
	public static boolean DEBUG = false;

	/**
	 * Number of customers.
	 */
	public static final int N_CUSTOMERS = 30;

	/**
	 * Number of mechanics.
	 */
	public static final int N_MECHANICS = 2;

	/**
	 * Number of managers.
	 */
	public static final int N_MANAGERS = 1;

	/**
	 * Number of replacement cars.
	 */
	public static final int N_REPLACEMENT_CARS = 3;

	/**
	 * Number of type of pieces.
	 */
	public static final int N_TYPE_PIECES = 3;


	/**
	 * Constructor of node settings, it will read and parse the jsonfilepath
	 * which contains the hosts.
	 *
	 * @param jsonfilepath
	 */
	public Settings(String jsonfilepath) {
		
		JSONTokener tokener = new JSONTokener(jsonfilepath);

		try {
			JSONObject obj = new JSONObject(tokener);
			JSONArray names = null;

			JSONArray json = obj.toJSONArray(names); ///CHANGE TO WHATEVER IS IN THE JSON FILE

			SERVER_HOSTS = jsonToHashMapString(json);
		} catch (JSONException ex) {
			Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
		} 
	
		// 22440 - 22449 server side shared and repository
		SERVER_PORTS = new HashMap<>();
		SERVER_PORTS.put("Lounge", 22440);
		SERVER_PORTS.put("OutsideWorld", 22441);
		SERVER_PORTS.put("Park", 22442);
		SERVER_PORTS.put("RepairArea", 22443);
		SERVER_PORTS.put("SupplierSite", 22444);
		//enumPiece e Piece tambem precisa de ir?
		SERVER_PORTS.put("RepairShop", 22446);
		SERVER_PORTS.put("Settings", 22447);

	}
	
	private static HashMap<String, String> jsonToHashMapString(JSONArray json) throws JSONException {
        HashMap<String, String> pairs = new HashMap<>();
        
        for (int i = 0; i < json.length(); i++) {
           JSONObject j = (JSONObject)json.get(i);
           Set<String> s = j.keySet();
           
           s.forEach((key) -> {
               String value = (String) j.get(key);
               pairs.put(key, value);
            });
        }
        
        return pairs;
    }
}
