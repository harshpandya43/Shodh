package com.shodh.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tool_calls")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolCall {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "step_id", nullable = false)
    private AgentStep step;

    @Column(nullable = false)
    private String toolName;

    @Column(columnDefinition = "text")
    private String inputJson;

    @Column(columnDefinition = "text")
    private String outputJson;

    @Column(nullable = false)
    private Boolean success;

    private String errorMessage;

    private Long durationMs;

    @CreationTimestamp
    private Instant createdAt;

}
