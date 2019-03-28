package ch.serial.game.skipass.infrastructure.rest;


/**
 * Skipass management rest interface
 * @author odellamaggiore
 */
public interface SkiPassRest {
	
	/**
	 * Starts a session for a skipass/resort
	 * @param idSkiPass ski pass id
	 * @param idResort resort id
	 */
	void startSession(Long idSkiPass, Long idResort);
	
	/**
	 * Stops all opened sessions for a ski pass
	 * @param idSkiPass ski pass id
	 */
	void stopSessions(Long idSkiPass);

}
