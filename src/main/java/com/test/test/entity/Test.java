package com.test.test.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer testId;

    @Column(length = 100)
    private String testContents;

    @Builder
    public Test(Integer testId, String testContents) {
        this.testId = testId;
        this.testContents = testContents;
    }
}