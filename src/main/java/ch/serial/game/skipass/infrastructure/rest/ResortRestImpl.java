package ch.serial.game.skipass.infrastructure.rest;

import ch.serial.game.skipass.application.ResortService;
import ch.serial.game.skipass.infrastructure.dto.ResortDto;
import ch.serial.game.skipass.infrastructure.dto.ResortDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("rest/api/v1/resorts")
public class ResortRestImpl implements ResortRest {

	@Inject
	ResortService resortService;

	@Inject
	ResortDtoMapper resortDtoMapper;

	@Override
	@GetMapping
	public List<ResortDto> listResort() {
		return resortService.getResorts().stream().map(resort -> resortDtoMapper.toResortDto(resort)).collect(Collectors.toList());
	}
}
