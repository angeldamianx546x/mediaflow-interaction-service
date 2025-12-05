package com.mediaflow.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mediaflow.api.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    @Query("SELECT s FROM Subscription s WHERE s.followerId = :followerId")
    Page<Subscription> findByFollowerId(@Param("followerId") Integer followerId, Pageable pageable);

    @Query("SELECT s FROM Subscription s WHERE s.followingId = :followingId")
    Page<Subscription> findByFollowingId(@Param("followingId") Integer followingId, Pageable pageable);

    @Query("SELECT s FROM Subscription s WHERE s.followerId = :followerId AND s.followingId = :followingId")
    Optional<Subscription> findByFollowerIdAndFollowingId(@Param("followerId") Integer followerId,
            @Param("followingId") Integer followingId);

    long countByFollowingId(Integer followingId);

    long countByFollowerId(Integer followerId);
}
