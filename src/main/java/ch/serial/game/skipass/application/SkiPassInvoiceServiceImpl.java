package ch.serial.game.skipass.application;

import ch.serial.game.skipass.domain.model.SkiPassInvoice;
import ch.serial.game.skipass.domain.model.SkiSession;
import ch.serial.game.skipass.infrastructure.repository.ResortRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class SkiPassInvoiceServiceImpl implements SkiPassInvoiceService {

    @Value("${tva.rate}")
    private int tva;

    @Inject
    SkiPassService skiPassService;

    @Inject
    ResortRepository resortRepository;

    @Override
    public SkiPassInvoice genenerateCurrentMonthInvoiceForASkiPass(Long idSkiPass) {
        List<SkiSession> skiSessions = skiPassService.getSkipass(idSkiPass).getSessions();
        LocalDate now = LocalDate.now();
        SkiPassInvoice spi = new SkiPassInvoice();
        spi.setIdSkiPass(idSkiPass);
        spi.setInvoiceSessions(skiSessions);
        spi.setInvoicePeriodStartDate(now.withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        spi.setInvoicePeriodEndDate(now.withDayOfMonth(now.lengthOfMonth()).atStartOfDay(ZoneId.systemDefault()).toInstant());
        skiSessions.stream().forEach(skiSession ->  skiSession.setSkiSessionCost(computeGrossAmountForASession(skiSession)));
        BigDecimal grossAmount = skiSessions.stream().map(skiSession ->  skiSession.getSkiSessionCost()).reduce(BigDecimal.ZERO, BigDecimal::add);
        spi.setInvoiceGrossAmount(grossAmount.setScale(2, RoundingMode.CEILING));
        spi.setInvoiceNetAmount(grossAmount.multiply(BigDecimal.valueOf(tva+100).divide(BigDecimal.valueOf(100))).setScale(2, RoundingMode.CEILING));
        return spi;
    }

    private BigDecimal computeGrossAmountForASession(SkiSession skiSession) {
        BigDecimal skiSessionGrossPrice = resortRepository.hourlyGrossPriceForAResort(skiSession.getIdResort());
        return skiSessionGrossPrice.multiply(BigDecimal.valueOf((skiSession.getEndDate().getEpochSecond() - skiSession.getStartDate().getEpochSecond())/3600));
    }
}
