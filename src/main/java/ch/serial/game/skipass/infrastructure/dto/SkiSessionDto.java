package ch.serial.game.skipass.infrastructure.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class SkiSessionDto {

    private UUID idSession;
    private Instant startDate;
    private Instant endDate;
    private Long idResort;
    private Long idSkiPass;
    private BigDecimal skiSessionCost;

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Long getIdResort() {
        return idResort;
    }

    public void setIdResort(Long idResort) {
        this.idResort = idResort;
    }

    public UUID getIdSession() {
        return idSession;
    }

    public void setIdSession(UUID idSession) {
        this.idSession = idSession;
    }

    public Long getIdSkiPass() {
        return idSkiPass;
    }

    public void setIdSkiPass(Long idSkiPass) {
        this.idSkiPass = idSkiPass;
    }

    public BigDecimal getSkiSessionCost() {
        return skiSessionCost;
    }

    public void setSkiSessionCost(BigDecimal skiSessionCost) {
        this.skiSessionCost = skiSessionCost;
    }
}

