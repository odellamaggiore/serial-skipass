package ch.serial.game.skipass.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResortRepository extends JpaRepository<ResortEty, Long>, ResortRepositoryCustom {
    public ResortEty findByIdResort(Long idResort);
}