package com.indu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indu.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    Subscription findByUserId(Long userId);
}
