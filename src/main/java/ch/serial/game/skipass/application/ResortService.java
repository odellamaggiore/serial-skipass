package ch.serial.game.skipass.application;

import ch.serial.game.skipass.domain.model.Resort;

import java.util.List;

/**
 * Skipass application service interface
 * @author odellamaggiore
 */
public interface ResortService {

	public List<Resort> getResorts();
	
}
