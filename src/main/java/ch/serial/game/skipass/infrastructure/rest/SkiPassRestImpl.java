package ch.serial.game.skipass.infrastructure.rest;

import ch.serial.game.skipass.application.SkiPassInvoiceService;
import ch.serial.game.skipass.application.SkiPassService;
import ch.serial.game.skipass.domain.model.SkiPassInvoice;
import ch.serial.game.skipass.infrastructure.dto.SkiPassInvoiceDto;
import ch.serial.game.skipass.infrastructure.dto.SkiPassInvoiceDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("rest/api/v1/forfaits")
public class SkiPassRestImpl implements SkiPassRest {
	
	@Inject
	SkiPassService skipassService;

	@Inject
	SkiPassInvoiceService skiPassInvoiceService;

	@Inject
	SkiPassInvoiceDtoMapper skiPassInvoiceDtoMapper;

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

	@Override
	@GetMapping(value = "/{idSkiPass}/invoice")
	public SkiPassInvoiceDto getCurrentMonthInvoice(@PathVariable Long idSkiPass) {
	    SkiPassInvoice skiPassInvoice = skiPassInvoiceService.genenerateCurrentMonthInvoiceForASkiPass(idSkiPass);
	    return skiPassInvoiceDtoMapper.toSkiPassInvoiceDto(skiPassInvoice);
	}
		
}
