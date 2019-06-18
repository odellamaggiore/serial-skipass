package ch.serial.game.skipass.infrastructure.repository;

import ch.serial.game.skipass.domain.model.Resort;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResortMapper {

	SkiPassEty toResortEty(Resort skipass);
	Resort fromResortEty(ResortEty ety);

}
