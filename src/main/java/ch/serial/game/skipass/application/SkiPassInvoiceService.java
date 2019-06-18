package ch.serial.game.skipass.application;

import ch.serial.game.skipass.domain.model.SkiPassInvoice;

/**
 * Skipass application service interface
 * @author odellamaggiore
 */
public interface SkiPassInvoiceService {
	public SkiPassInvoice genenerateCurrentMonthInvoiceForASkiPass(final Long idSkiPass);
}
