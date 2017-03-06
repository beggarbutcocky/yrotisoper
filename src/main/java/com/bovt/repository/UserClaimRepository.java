package com.bovt.repository;

import com.bovt.models.UserClaim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserClaimRepository extends JpaRepository<UserClaim, Long> {
}
