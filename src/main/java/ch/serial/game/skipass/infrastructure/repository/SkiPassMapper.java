package ch.serial.game.skipass.infrastructure.repository;

import org.mapstruct.Mapper;

import ch.serial.game.skipass.domain.model.SkiPass;

@Mapper(uses = { SkiSessionMapper.class }, componentModel = "spring")
public interface SkiPassMapper {

	SkiPassEty toSkiPassEty(SkiPass skipass);
	SkiPass fromSkiPassEty(SkiPassEty ety);
	
}
