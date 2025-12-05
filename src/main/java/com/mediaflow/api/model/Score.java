package com.mediaflow.api.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Integer scoreId;

    @Column(name = "likes", nullable = false)
    private Integer likes;

    @Column(name = "dislikes", nullable = false)
    private Integer dislikes;

    @Column(name = "calification", nullable = false, precision = 5, scale = 4)
    private BigDecimal calification;

    @Column(name = "views", nullable = false)
    private Integer views;

    @Column(name = "impact", nullable = false, precision = 10, scale = 4)
    private BigDecimal impact;

    @Column(name = "content_id", unique = true)
    private Integer contentId;

    // Constructors
    public Score() {
    }

    public static ScoreBuilder builder() {
        return new ScoreBuilder();
    }

    // Getters and Setters
    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public BigDecimal getCalification() {
        return calification;
    }

    public void setCalification(BigDecimal calification) {
        this.calification = calification;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public BigDecimal getImpact() {
        return impact;
    }

    public void setImpact(BigDecimal impact) {
        this.impact = impact;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    // Builder class
    public static class ScoreBuilder {
        private Integer scoreId;
        private Integer likes;
        private Integer dislikes;
        private BigDecimal calification;
        private Integer views;
        private BigDecimal impact;
        private Integer contentId;

        public ScoreBuilder scoreId(Integer scoreId) {
            this.scoreId = scoreId;
            return this;
        }

        public ScoreBuilder likes(Integer likes) {
            this.likes = likes;
            return this;
        }

        public ScoreBuilder dislikes(Integer dislikes) {
            this.dislikes = dislikes;
            return this;
        }

        public ScoreBuilder calification(BigDecimal calification) {
            this.calification = calification;
            return this;
        }

        public ScoreBuilder views(Integer views) {
            this.views = views;
            return this;
        }

        public ScoreBuilder impact(BigDecimal impact) {
            this.impact = impact;
            return this;
        }

        public ScoreBuilder contentId(Integer contentId) {
            this.contentId = contentId;
            return this;
        }

        public Score build() {
            Score score = new Score();
            score.scoreId = this.scoreId;
            score.likes = this.likes;
            score.dislikes = this.dislikes;
            score.calification = this.calification;
            score.views = this.views;
            score.impact = this.impact;
            score.contentId = this.contentId;
            return score;
        }
    }
}