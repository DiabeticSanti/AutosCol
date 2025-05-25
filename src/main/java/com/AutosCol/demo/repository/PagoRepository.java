package com.AutosCol.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AutosCol.demo.models.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}


