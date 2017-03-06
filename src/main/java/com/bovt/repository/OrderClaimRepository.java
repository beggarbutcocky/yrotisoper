package com.bovt.repository;

import com.bovt.models.OrderClaim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderClaimRepository extends JpaRepository<OrderClaim, Long> {
}
