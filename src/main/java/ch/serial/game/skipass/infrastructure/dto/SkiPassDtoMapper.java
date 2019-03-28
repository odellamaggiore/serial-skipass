package ch.serial.game.skipass.infrastructure.dto;

import org.mapstruct.Mapper;

import ch.serial.game.skipass.domain.model.forfait.SkiPass;

@Mapper(uses = { SkiSessionDtoMapper.class }, componentModel = "spring")
public interface SkiPassDtoMapper {

	public SkiPassDto toForfaitDto(SkiPass skiPass);
	public SkiPass fromForfaitDto(SkiPassDto skiPassDto);
	
}
