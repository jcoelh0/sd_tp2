package entities.Mechanic.Interfaces;

import java.util.HashMap;
import settings.Piece;

/**
 *
 * @author André Oliveira
 * @author João Coelho
 */
public interface IMechanicRA {

	/**
	 *
	 * @param idMechanic
	 * @return
	 */
	public boolean readThePaper(int idMechanic);

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
	 * @return
	 */
	public boolean partAvailable(Piece requiredPart, int idMechanic);

	/**
	 *
	 * @param id
	 * @param p
	 * @return
	 */
	public int fixIt(int id, Piece p);

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
