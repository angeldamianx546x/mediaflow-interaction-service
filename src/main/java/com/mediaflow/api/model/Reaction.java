package com.mediaflow.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reactions")
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reaction_id")
    private Integer reactionId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "content_id", nullable = false)
    private Integer contentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emotion_id", nullable = false)
    private Emotion emotion;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructors
    public Reaction() {
    }

    public static ReactionBuilder builder() {
        return new ReactionBuilder();
    }

    // Getters and Setters
    public Integer getReactionId() {
        return reactionId;
    }

    public void setReactionId(Integer reactionId) {
        this.reactionId = reactionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Builder class
    public static class ReactionBuilder {
        private Integer reactionId;
        private Integer userId;
        private Integer contentId;
        private Emotion emotion;
        private LocalDateTime createdAt;

        public ReactionBuilder reactionId(Integer reactionId) {
            this.reactionId = reactionId;
            return this;
        }

        public ReactionBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public ReactionBuilder contentId(Integer contentId) {
            this.contentId = contentId;
            return this;
        }

        public ReactionBuilder emotion(Emotion emotion) {
            this.emotion = emotion;
            return this;
        }

        public ReactionBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Reaction build() {
            Reaction reaction = new Reaction();
            reaction.reactionId = this.reactionId;
            reaction.userId = this.userId;
            reaction.contentId = this.contentId;
            reaction.emotion = this.emotion;
            reaction.createdAt = this.createdAt;
            return reaction;
        }
    }
}
