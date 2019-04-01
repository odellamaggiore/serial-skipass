package ch.serial.game.skipass.infrastructure.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class SkiPassInvoiceDto {

 	private Long idSkiPass;
 	private List<SkiSessionDto> invoiceSessions;
 	private Instant invoicePeriodStartDate;
 	private Instant invoicePeriodEndDate;
 	private BigDecimal invoiceGrossAmount;
 	private BigDecimal invoiceNetAmount;
 	
	public Long getIdSkiPass() {
		return idSkiPass;
	}
	public void setIdSkiPass(Long idSkiPass) {
		this.idSkiPass = idSkiPass;
	}
	public List<SkiSessionDto> getInvoiceSessions() {
		return invoiceSessions;
	}
	public void setInvoiceSessions(List<SkiSessionDto> invoiceSessions) {
		this.invoiceSessions = invoiceSessions;
	}
	public Instant getInvoicePeriodStartDate() {
		return invoicePeriodStartDate;
	}
	public void setInvoicePeriodStartDate(Instant invoicePeriodStartDate) {
		this.invoicePeriodStartDate = invoicePeriodStartDate;
	}
	public Instant getInvoicePeriodEndDate() {
		return invoicePeriodEndDate;
	}
	public void setInvoicePeriodEndDate(Instant invoicePeriodEndDate) {
		this.invoicePeriodEndDate = invoicePeriodEndDate;
	}
	public BigDecimal getInvoiceGrossAmount() {
		return invoiceGrossAmount;
	}
	public void setInvoiceGrossAmount(BigDecimal invoiceGrossAmount) {
		this.invoiceGrossAmount = invoiceGrossAmount;
	}
	public BigDecimal getInvoiceNetAmount() {
		return invoiceNetAmount;
	}
	public void setInvoiceNetAmount(BigDecimal invoiceNetAmount) {
		this.invoiceNetAmount = invoiceNetAmount;
	}
	
}
