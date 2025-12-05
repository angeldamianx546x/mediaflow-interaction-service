package com.mediaflow.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediaflow.api.model.Emotion;

public interface EmotionRepository extends JpaRepository<Emotion, Integer> {
    Optional<Emotion> findByName(String name);
}