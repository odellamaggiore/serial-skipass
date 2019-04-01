package ch.serial.game.skipass.infrastructure.dto;

import org.mapstruct.Mapper;

import ch.serial.game.skipass.domain.model.SkiSession;

@Mapper(componentModel = "spring")
public interface SkiSessionDtoMapper {

	public SkiSessionDto toConsoDto(SkiSession session);
	public SkiSession fromForfaitDto(SkiSessionDto sessionDto);
	
}
