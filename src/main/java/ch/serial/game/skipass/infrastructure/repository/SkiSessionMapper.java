package ch.serial.game.skipass.infrastructure.repository;

import java.util.List;

import org.mapstruct.Mapper;

import ch.serial.game.skipass.domain.model.SkiSession;

@Mapper( componentModel = "spring" )
public interface SkiSessionMapper {

	SkiSessionEty toSessionEty(SkiSession session);
	SkiSession fromSessionEty(SkiSessionEty ety);
	List<SkiSessionEty> toSessionEtys(List<SkiSession> sessions);
	
}
