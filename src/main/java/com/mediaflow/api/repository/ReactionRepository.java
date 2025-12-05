package com.mediaflow.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mediaflow.api.model.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, Integer> {

    @Query("SELECT r FROM Reaction r WHERE r.contentId = :contentId")
    Page<Reaction> findByContentId(@Param("contentId") Integer contentId, Pageable pageable);

    @Query("SELECT r FROM Reaction r WHERE r.userId = :userId")
    Page<Reaction> findByUserId(@Param("userId") Integer userId, Pageable pageable);

    @Query("SELECT r FROM Reaction r WHERE r.contentId = :contentId AND r.userId = :userId")
    Optional<Reaction> findByContentIdAndUserId(@Param("contentId") Integer contentId, @Param("userId") Integer userId);

    @Query("SELECT COUNT(r) FROM Reaction r WHERE r.contentId = :contentId AND r.emotion.name = :emotionName")
    long countByContentIdAndEmotionName(@Param("contentId") Integer contentId,
            @Param("emotionName") String emotionName);
}
