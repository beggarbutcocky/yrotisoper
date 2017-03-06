package com.bovt.repository;

import com.bovt.models.Bounty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BountyRepository extends JpaRepository<Bounty, Long> {
}
