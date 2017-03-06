package com.bovt.repository;

import com.bovt.models.Waybill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaybillRepository extends JpaRepository<Waybill, Long> {
}
