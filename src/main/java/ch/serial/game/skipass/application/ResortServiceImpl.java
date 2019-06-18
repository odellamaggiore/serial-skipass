package ch.serial.game.skipass.application;

import ch.serial.game.skipass.domain.model.Resort;
import ch.serial.game.skipass.infrastructure.repository.ResortMapper;
import ch.serial.game.skipass.infrastructure.repository.ResortRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResortServiceImpl implements ResortService {

	@Inject
	ResortRepository resortRepository;

	@Inject
	ResortMapper resortMapper;

	@Override
	public List<Resort> getResorts() {
		return resortRepository.findAll().stream().map(resortEty -> resortMapper.fromResortEty(resortEty)).collect(Collectors.toList());
	}
}
