package ch.serial.game.skipass.domain.model;

import java.math.BigDecimal;

public class Resort {

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
