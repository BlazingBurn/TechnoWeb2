package fr.univparis8.iut.dut.vacation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VacationRepository extends JpaRepository<VacationDayEntity, Long> {



}