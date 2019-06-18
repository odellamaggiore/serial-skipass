package ch.serial.game.skipass.infrastructure.dto;

import ch.serial.game.skipass.domain.model.Resort;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResortDtoMapper {

	ResortDto toResortDto(Resort resort);
	Resort fromResortDto(ResortDto resortDto);
	
}
