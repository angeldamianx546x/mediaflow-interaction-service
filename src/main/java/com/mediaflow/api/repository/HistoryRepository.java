package com.mediaflow.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mediaflow.api.model.History;

public interface HistoryRepository extends JpaRepository<History, Integer> {

    @Query("SELECT h FROM History h WHERE h.userId = :userId ORDER BY h.viewedAt DESC")
    Page<History> findByUserId(@Param("userId") Integer userId, Pageable pageable);

    @Query("SELECT h FROM History h WHERE h.contentId = :contentId")
    Page<History> findByContentId(@Param("contentId") Integer contentId, Pageable pageable);

    boolean existsByUserIdAndContentId(Integer userId, Integer contentId);
}