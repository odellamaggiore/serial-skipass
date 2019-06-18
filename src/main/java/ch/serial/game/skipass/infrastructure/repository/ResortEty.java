package ch.serial.game.skipass.infrastructure.repository;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "resort")
public class ResortEty {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @Column
    private Long idResort;

    @Column
    private String resortName;

    @Column
    private BigDecimal hourlyGrossPrice;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
