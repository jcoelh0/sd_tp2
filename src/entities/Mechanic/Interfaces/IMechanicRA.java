package entities.Mechanic.Interfaces;

import entities.Mechanic.States.MechanicState;
import java.util.HashMap;
import repository.Piece;

/**
 *
 * @author andre e joao
 */
public interface IMechanicRA {

	/**
	 *
	 * @param idMechanic
	 * @param state
	 * @return
	 */
	public boolean readThePaper(int idMechanic, MechanicState state);

	/**
	 *
	 * @return
	 */
	public int startRepairProcedure();

	/**
	 *
	 * @param id
	 */
	public void getRequiredPart(int id);

	/**
	 *
	 * @param piece
	 * @param idCarToFix
	 */
	public void letManagerKnow(Piece piece, int idCarToFix);

	/**
	 *
	 * @param requiredPart
	 * @param idMechanic
	 * @param state
	 * @return
	 */
	public boolean partAvailable(Piece requiredPart, int idMechanic, MechanicState state);

	/**
	 *
	 * @param id
	 * @param p
	 * @return
	 */
	public int fixIt(int id, Piece p);

	/**
	 *
	 */
	public void getNextTask();

	/**
	 *
	 */
	public void resumeRepairProcedure();

	/**
	 *
	 */
	public void repairConcluded();

	/**
	 *
	 * @return
	 */
	public HashMap getPiecesToBeRepaired();

	/**
	 *
	 * @return
	 */
	public HashMap getPieces();
}