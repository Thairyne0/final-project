package com.epicEnergyServices.repository;

import com.epicEnergyServices.entity.Indirizzo;
import com.epicEnergyServices.entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long>{

}
