package ch.serial.game.skipass.infrastructure.rest;

import ch.serial.game.skipass.infrastructure.dto.SkiPassInvoiceDto;


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
	
	/**
	 * Get current month invoice for a ski pass
	 * @param Ski pass id 
	 * @return Invoice of the current month for the ski pass
	 */
	SkiPassInvoiceDto getCurrentMonthInvoice(Long idSkiPass);
	
}
