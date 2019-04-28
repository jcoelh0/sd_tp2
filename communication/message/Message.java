/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication.message;

import entities.Customer.States.CustomerState;
import entities.Manager.States.ManagerState;
import entities.Mechanic.States.MechanicState;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import repository.EnumPiece;
import repository.Piece;

/**
 *
 * @author andre and joao
 */
public class Message {

	private static final long serialVersionUID = 19042019L;
	private boolean message_b1;
	private boolean message_b2;
	private Piece message_p1;
	private int message_i1;
	private int message_i2;
	private String message_s1;
	private MessageType type;
	private ManagerState managerState;
	private MechanicState mechanicState;
	private CustomerState customerState;
	private HashMap<?, ?> map1;
	private HashMap<Integer, Piece> mapIntegerPiece;
	private HashMap<EnumPiece, Integer> mapEnumPieceInteger;
	private Queue<Integer> message_q1, message_q2, message_q3;
	private boolean[] message_arrayBool;
	private HashMap<?, ?> map2;
	private String[] message_arrayStr;
	private List<Integer> message_l1;
	private int[] message_arrayInt;
	
	/**
	 * Constructor of Message.
	 *
	 * @param mt
	 * @param message
	 */
	public Message(MessageType mt, int message) {
		message_i1 = message;
		type = mt;
	}

	/**
	 *
	 * @param mt
	 * @param carRepaired
	 * @param requiresCar
	 * @param idCustomer
	 */
	public Message(MessageType mt, boolean carRepaired, boolean requiresCar, int idCustomer) {
		type = mt;
		message_b1 = carRepaired;
		message_b2 = requiresCar;
		message_i1 = idCustomer;
	}

	/**
	 *
	 * @param mt
	 * @param id
	 * @param state
	 */
	public Message(MessageType mt, int id, CustomerState state) {
		type = mt;
		message_i1 = id;
		customerState = state;
	}

	/**
	 *
	 * @param mt
	 * @param piece
	 * @param idCar
	 * @param idMechanic
	 * @param state
	 */
	public Message(MessageType mt, Piece piece, int idCar, int idMechanic, MechanicState state) {
		type = mt;
		message_p1 = piece;
		message_i1 = idCar;
		message_i2 = idMechanic;
		mechanicState = state;
	}

	public Message(MessageType mt, Queue<Integer> replacementQueue, Queue<Integer> customersQueue, Queue<Integer> carsRepaired, boolean[] requiresReplacementCar, int idCustomer, CustomerState state) {
		type = mt;
		message_q1 = replacementQueue;
		message_q2 = customersQueue;
		message_q3 = carsRepaired;
		message_arrayBool = requiresReplacementCar;
		message_i1 = idCustomer;
		customerState = state;
	}

	public Message(MessageType mt, Queue<Integer> replacementQueue, Queue<Integer> customersQueue, Queue<Integer> carsRepaired, boolean[] requiresReplacementCar) {
		type = mt;
		message_q1 = replacementQueue;
		message_q2 = customersQueue;
		message_q3 = carsRepaired;
		message_arrayBool = requiresReplacementCar;
	}

	public Message(MessageType mt, int nRequestsManager, HashMap<Integer, Piece> piecesToBeRepaired, boolean[] flagPartMissing, HashMap<EnumPiece, Integer> stock, int idMechanic, MechanicState state) {
		type = mt;
		message_i1 = nRequestsManager;
		map1 = piecesToBeRepaired;
		message_arrayBool = flagPartMissing;
		map2 = stock;
		message_i2 = idMechanic;
		mechanicState = state;
	}

	public Message(MessageType mt, int nRequestsManager, HashMap<Integer, Piece> piecesToBeRepaired, boolean[] flagPartMissing, HashMap<EnumPiece, Integer> stock, ManagerState state) {
		type = mt;
		message_i1 = nRequestsManager;
		map1 = piecesToBeRepaired;
		message_arrayBool = flagPartMissing;
		map2 = stock;
		managerState = state;
	}

	public Message(MessageType mt, int nRequestsManager, HashMap<Integer, Piece> piecesToBeRepaired, boolean[] flagPartMissing, HashMap<EnumPiece, Integer> stock) {
		type = mt;
		message_i1 = nRequestsManager;
		map1 = piecesToBeRepaired;
		message_arrayBool = flagPartMissing;
		map2 = stock;
	}

	public Message(MessageType mt, String[] vehicleDriven, int idCustomer, CustomerState state) {
		type = mt;
		message_arrayStr = vehicleDriven;
		message_i1 = idCustomer;
		customerState = state;
	}

	public Message(MessageType mt, List<Integer> carsParked, Queue<Integer> replacementCars, int idMechanic, MechanicState state) {
		type = mt;
		message_l1 = carsParked;
		message_q1 = replacementCars;
		message_i1 = idMechanic;
		mechanicState = state;
	}

	public Message(MessageType mt, List<Integer> carsParked, Queue<Integer> replacementCars, int idCustomer, CustomerState state) {
		type = mt;
		message_l1 = carsParked;
		message_q1 = replacementCars;
		message_i1 = idCustomer;
		customerState = state;
	}

	public Message(MessageType mt, List<Integer> carsParked, Queue<Integer> replacementCars) {
		type = mt;
		message_l1 = carsParked;
		message_q1 = replacementCars;
	}

	public Message(MessageType mt, Queue<Integer> replacementQueue, Queue<Integer> customersQueue, Queue<Integer> carsRepaired, boolean[] requiresReplacementCar, int idMechanic, MechanicState state) {
		type = mt;
		message_q1 = replacementQueue;
		message_q2 = customersQueue;
		message_q3 = carsRepaired;
		message_arrayBool = requiresReplacementCar;
		message_i1 = idMechanic;
		mechanicState = state;
	}

	public Message(MessageType mt, String response_str) {
		type = mt;
		message_s1 = response_str;
	}

	public Message(MessageType mt, boolean response_bool) {
		type = mt;
		message_b1 = response_bool;
	}

	public Message(MessageType mt, Piece response_piece) {
		type = mt;
		message_p1 = response_piece;
		
	}

	public Message(MessageType messageType) {
		type = messageType;
	}

	public Message(MessageType mt, int replacementCarId, int idCustomer) {
		type = mt;
		message_i1 = replacementCarId;
		message_i2 = idCustomer;		
	}

	public Message(MessageType mt, ManagerState state) {
		type = mt;
		managerState = state;
	}

	public Message(MessageType mt, String[] vehicleDriven) {
		type = mt;
		message_arrayStr = vehicleDriven;
	}

	public Message(MessageType mt, int[] piecesBought) {
		type = mt;
		message_arrayInt = piecesBought;
	}

	public Message(MessageType mt, HashMap<?, ?> map) {
		type = mt;
		map1 = map;
	}

	public Message(MessageType mt, boolean carRepaired, int id, CustomerState state) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public Message(MessageType mt, boolean b, int replacementCar, int id, CustomerState state) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public Message(MessageType mt, int replacementCar, int id, CustomerState state) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public Message(MessageType mt, int idMechanic, MechanicState state) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public Message(MessageType mt, int idCustomer, ManagerState state) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public Message(MessageType mt, Piece piece, int idCarToFix) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public Message(MessageType mt, Piece requiredPart, int idMechanic, MechanicState state) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public Message(MessageType mt, int id, Piece p) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	
	
	/**
	 * Return Message Hosts Map.
	 *
	 * @return
	 */
	public HashMap<?,?> getMap1() {
		return map1;
	}
	
	/**
	 * Return Message Type.
	 *
	 * @return
	 */
	public MessageType getType() {
		return type;
	}
	
	/**
	 * Return Integer message.
	 *
	 * @return
	 */
	public Integer getInteger1() {
		return message_i1;
	}

	/**
	 * Return Integer message.
	 *
	 * @return
	 */
	public int getInteger2() {
		return message_i2;
	}

	/**
	 *
	 * @return
	 */
	public String getString() {
		return message_s1;
	}

	/**
	 *
	 * @return
	 */
	public Piece getPiece() {
		return message_p1;
	}
	
	/**
	 * Return Boolean message.
	 *
	 * @return
	 */
	public boolean getBoolean1() {
		return message_b1;
	}
	/**
	 * Return Boolean message.
	 *
	 * @return
	 */
	public boolean getBoolean2() {
		return message_b2;
	}
	
	/**
	 * Return ManagerState message.
	 *
	 * @return
	 */
	public ManagerState getManagerState() {
		return managerState;
	}
	
	/**
	 * Return CustomerState message.
	 *
	 * @return
	 */
	public CustomerState getCustomerState() {
		return customerState;
	}
	
	/**
	 * Return MechanicState message.
	 *
	 * @return
	 */
	public MechanicState getMechanicState() {
		return mechanicState;
	}

	public Piece getMessage_p1() {
		return message_p1;
	}

	public Queue<Integer> getMessage_q1() {
		return message_q1;
	}

	public Queue<Integer> getMessage_q2() {
		return message_q2;
	}

	public Queue<Integer> getMessage_q3() {
		return message_q3;
	}

	public boolean[] getMessage_arrayBool() {
		return message_arrayBool;
	}

	public HashMap<?, ?> getMap2() {
		return map2;
	}

	public String[] getMessage_arrayStr() {
		return message_arrayStr;
	}

	public List<Integer> getMessage_l1() {
		return message_l1;
	}

	public int[] getMessage_arrayInt() {
		return message_arrayInt;
	}
	
	public HashMap<Integer, Piece> getHashMapIntPiece() {
		return mapIntegerPiece;
	}
	
	public HashMap<EnumPiece, Integer> getHashMapEnumPieceInt() {
		return mapEnumPieceInteger;
	}
}
