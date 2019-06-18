package ch.serial.game.skipass.infrastructure.repository;

import java.math.BigDecimal;

public interface ResortRepositoryCustom {
    BigDecimal hourlyGrossPriceForAResort(Long idResort);
}