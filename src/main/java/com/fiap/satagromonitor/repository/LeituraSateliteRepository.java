package com.fiap.satagromonitor.repository;

import com.fiap.satagromonitor.model.LeituraSatelite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeituraSateliteRepository extends JpaRepository<LeituraSatelite, Long> {
}