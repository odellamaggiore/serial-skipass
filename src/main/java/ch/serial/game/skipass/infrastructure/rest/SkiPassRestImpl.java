package ch.serial.game.skipass.infrastructure.rest;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.serial.game.skipass.application.SkiPassService;

@RestController
@RequestMapping("forfaits")
public class SkiPassRestImpl implements SkiPassRest {
	
	@Inject
	SkiPassService skipassService;
	
	@Override
    @PutMapping(value = "/{idSkiPass}/start")
    @ResponseStatus(HttpStatus.OK)
	public void startSession(@PathVariable Long idSkiPass, @RequestBody Long idResort) {
		skipassService.startSession(idSkiPass, idResort);
    }
    
	@Override
    @PutMapping(value = "/{idSkiPass}/stop")
    @ResponseStatus(HttpStatus.OK)
	public void stopSessions(@PathVariable Long idSkiPass) {
		skipassService.stopSessions(idSkiPass);
    }
    
}
