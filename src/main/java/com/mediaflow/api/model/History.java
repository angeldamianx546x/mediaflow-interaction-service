package com.mediaflow.api.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Historys")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer historyId;

    @Column(name = "viewed_at", nullable = false)
    private LocalDate viewedAt;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "content_id", nullable = false)
    private Integer contentId;

    // Constructors
    public History() {
    }

    public static HistoryBuilder builder() {
        return new HistoryBuilder();
    }

    // Getters and Setters
    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public LocalDate getViewedAt() {
        return viewedAt;
    }

    public void setViewedAt(LocalDate viewedAt) {
        this.viewedAt = viewedAt;
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

    // Builder class
    public static class HistoryBuilder {
        private Integer historyId;
        private LocalDate viewedAt;
        private Integer userId;
        private Integer contentId;

        public HistoryBuilder historyId(Integer historyId) {
            this.historyId = historyId;
            return this;
        }

        public HistoryBuilder viewedAt(LocalDate viewedAt) {
            this.viewedAt = viewedAt;
            return this;
        }

        public HistoryBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public HistoryBuilder contentId(Integer contentId) {
            this.contentId = contentId;
            return this;
        }

        public History build() {
            History history = new History();
            history.historyId = this.historyId;
            history.viewedAt = this.viewedAt;
            history.userId = this.userId;
            history.contentId = this.contentId;
            return history;
        }
    }
}
