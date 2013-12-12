package br.edu.ifes.sr.leds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifes.sr.leds.model.Hospital;


@Repository
@Transactional
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
	
	
}
