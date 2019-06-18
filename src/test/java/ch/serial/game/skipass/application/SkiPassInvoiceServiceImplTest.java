package ch.serial.game.skipass.application;

import ch.serial.game.skipass.domain.model.SkiPass;
import ch.serial.game.skipass.domain.model.SkiPassInvoice;
import ch.serial.game.skipass.domain.model.SkiSession;
import ch.serial.game.skipass.infrastructure.repository.ResortRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkiPassInvoiceServiceImplTest {

    @Value("${tva.rate}")
    private int tva;

    @MockBean
    private SkiPassService skiPassService;

    @MockBean
    private ResortRepository resortRepository;

    @Autowired
    private SkiPassInvoiceService skiPassInvoiceService;

    @Before
    public void setUp() {
        Mockito.when(skiPassService.getSkipass(any(Long.class))).thenReturn(generateSampleSkipass());
        Mockito.when(resortRepository.hourlyGrossPriceForAResort(Long.valueOf(1))).thenReturn(BigDecimal.valueOf(100));
        Mockito.when(resortRepository.hourlyGrossPriceForAResort(Long.valueOf(2))).thenReturn(BigDecimal.valueOf(200));
    }

    private SkiPass generateSampleSkipass() {
        Instant now = Instant.now();
        SkiPass skiPassSample = new SkiPass();
        List<SkiSession> sessionsListSample = new ArrayList();
        sessionsListSample.add(new SkiSession(now, now.plus(1, ChronoUnit.HOURS), Long.valueOf(1), Long.valueOf(200)));
        sessionsListSample.add(new SkiSession(now, now.plus(3, ChronoUnit.HOURS), Long.valueOf(2), Long.valueOf(200)));
        skiPassSample.setSessions(sessionsListSample);
        return skiPassSample;
    }

    @Test
    public void genenerateCurrentMonthInvoiceForASkiPass() {
        SkiPassInvoice invoice = skiPassInvoiceService.genenerateCurrentMonthInvoiceForASkiPass(Long.valueOf(1));
        assertThat(invoice.getInvoiceSessions().size(), equalTo(2));
        assertThat(invoice.getInvoiceSessions().get(0).getSkiSessionCost(), equalTo(BigDecimal.valueOf(100)));
        assertThat(invoice.getInvoiceSessions().get(1).getSkiSessionCost(), equalTo(BigDecimal.valueOf(600)));
        assertThat(invoice.getInvoiceGrossAmount(), equalTo(BigDecimal.valueOf(700).setScale(2, RoundingMode.CEILING)));
        BigDecimal netAmountExpected = invoice.getInvoiceGrossAmount().multiply(BigDecimal.valueOf(tva+100).divide(BigDecimal.valueOf(100))).setScale(2, RoundingMode.CEILING);
        assertThat(invoice.getInvoiceNetAmount(),equalTo(netAmountExpected.setScale(2, RoundingMode.CEILING)));
    }


}