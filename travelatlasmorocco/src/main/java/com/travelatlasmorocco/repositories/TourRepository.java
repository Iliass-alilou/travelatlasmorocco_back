package com.travelatlasmorocco.repositories;

import com.travelatlasmorocco.entities.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {
    TourEntity findByNom(String nom);
}
