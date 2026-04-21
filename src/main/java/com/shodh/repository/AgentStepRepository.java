package com.shodh.repository;

import com.shodh.domain.AgentStep;
import com.shodh.domain.StepType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AgentStepRepository extends JpaRepository<AgentStep, UUID> {
    List<AgentStep> findByJobIdOrderByCreatedAtAsc(UUID jobId);

    List<AgentStep> findByJobIdAndType(UUID jobId, StepType type);

    long countByJobId(UUID jobId);

}
