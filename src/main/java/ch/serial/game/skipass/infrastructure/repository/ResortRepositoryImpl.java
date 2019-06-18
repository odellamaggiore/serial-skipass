package ch.serial.game.skipass.infrastructure.repository;

import javax.inject.Inject;
import java.math.BigDecimal;

public class ResortRepositoryImpl implements ResortRepositoryCustom {

    @Inject
    ResortRepository resortRepository;

    @Override
    public BigDecimal hourlyGrossPriceForAResort(Long idResort){
        return resortRepository.findByIdResort(idResort).getHourlyGrossPrice();
    }


}