package ch.serial.game.skipass.infrastructure.rest;

import ch.serial.game.skipass.application.SkiPassInvoiceService;
import ch.serial.game.skipass.domain.model.SkiPassInvoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.Instant;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SkiPassRestImplTest {

    private MockMvc mockMvc;

    @MockBean
    private SkiPassInvoiceService skiPassInvoiceService;

    @Autowired
    private SkiPassRest skiPassRest;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(skiPassRest).build();
        Mockito.when(skiPassInvoiceService.genenerateCurrentMonthInvoiceForASkiPass(any(Long.class))).thenReturn(generateSimpleInvoice());
    }

    private SkiPassInvoice generateSimpleInvoice() {
        SkiPassInvoice spi = new SkiPassInvoice();
        spi.setIdSkiPass(Long.valueOf(200));
        spi.setInvoiceSessions(null);
        spi.setInvoicePeriodStartDate(Instant.parse("2019-05-31T22:00:00Z"));
        spi.setInvoicePeriodEndDate(Instant.parse("2019-06-29T22:00:00Z"));
        spi.setInvoiceGrossAmount(BigDecimal.ZERO);
        spi.setInvoiceNetAmount(BigDecimal.TEN);
        return spi;
    }

    @Test
    public void startSessionTest() {
    }

    @Test
    public void stopSessionsTest() {
    }

    @Test
    public void getCurrentMonthInvoice() throws Exception{
        mockMvc.perform(get("/rest/api/v1/forfaits/200/invoice"))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().encoding("UTF-8"))
                .andExpect(jsonPath("invoiceGrossAmount", is(0)))
                .andExpect(jsonPath("invoiceNetAmount", is(10)));
    }

}