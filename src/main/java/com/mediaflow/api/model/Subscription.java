package com.mediaflow.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private Integer subscriptionId;

    @Column(name = "follower_id", nullable = false)
    private Integer followerId;

    @Column(name = "following_id", nullable = false)
    private Integer followingId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructors
    public Subscription() {
    }

    public static SubscriptionBuilder builder() {
        return new SubscriptionBuilder();
    }

    // Getters and Setters
    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public Integer getFollowingId() {
        return followingId;
    }

    public void setFollowingId(Integer followingId) {
        this.followingId = followingId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Builder class
    public static class SubscriptionBuilder {
        private Integer subscriptionId;
        private Integer followerId;
        private Integer followingId;
        private LocalDateTime createdAt;

        public SubscriptionBuilder subscriptionId(Integer subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        public SubscriptionBuilder followerId(Integer followerId) {
            this.followerId = followerId;
            return this;
        }

        public SubscriptionBuilder followingId(Integer followingId) {
            this.followingId = followingId;
            return this;
        }

        public SubscriptionBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Subscription build() {
            Subscription subscription = new Subscription();
            subscription.subscriptionId = this.subscriptionId;
            subscription.followerId = this.followerId;
            subscription.followingId = this.followingId;
            subscription.createdAt = this.createdAt;
            return subscription;
        }
    }
}
