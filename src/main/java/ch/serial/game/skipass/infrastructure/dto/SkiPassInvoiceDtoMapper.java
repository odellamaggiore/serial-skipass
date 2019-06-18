package ch.serial.game.skipass.infrastructure.dto;

import ch.serial.game.skipass.domain.model.SkiPassInvoice;
import org.mapstruct.Mapper;

@Mapper(uses = { SkiSessionDtoMapper.class }, componentModel = "spring")
public interface SkiPassInvoiceDtoMapper {

	SkiPassInvoiceDto toSkiPassInvoiceDto(SkiPassInvoice SkiPassInvoice);
	SkiPassInvoice fromSkiPassInvoiceDto(SkiPassInvoiceDto skiPassInvoiceDto);

}