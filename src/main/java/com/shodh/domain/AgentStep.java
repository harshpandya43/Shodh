package com.shodh.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "agent_steps")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentStep {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private ResearchJob job;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StepType type;

    @Column(columnDefinition = "text")
    private String content;

    private Integer tokensUsed;

    private Long durationMs;

    @CreationTimestamp
    private Instant createdAt;

    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("createdAt ASC")
    @Builder.Default
    private List<ToolCall> toolCalls = new ArrayList<>();
}
