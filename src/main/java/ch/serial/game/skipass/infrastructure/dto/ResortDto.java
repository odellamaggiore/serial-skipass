package ch.serial.game.skipass.infrastructure.dto;

import java.math.BigDecimal;

/**
 * Public Resort Data Transfert Object
 * @author odellamaggiore
 */
public class ResortDto {

	private Long idResort;
	
	private String resortName;
	
	private BigDecimal hourlyGrossPrice;

	public Long getIdResort() {
		return idResort;
	}

	public void setIdResort(Long idResort) {
		this.idResort = idResort;
	}

	public String getResortName() {
		return resortName;
	}

	public void setResortName(String resortName) {
		this.resortName = resortName;
	}

	public BigDecimal getHourlyGrossPrice() {
		return hourlyGrossPrice;
	}

	public void setHourlyGrossPrice(BigDecimal hourlyGrossPrice) {
		this.hourlyGrossPrice = hourlyGrossPrice;
	}

}
