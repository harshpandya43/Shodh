package com.shodh.repository;

import com.shodh.domain.ToolCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ToolCallRepository extends JpaRepository<ToolCall, UUID> {
    List<ToolCall> findByStepIdOrderByCreatedAtAsc(UUID stepId);

    List<ToolCall> findByToolNameOrderByCreatedAtDesc(String toolName);

    long countByStepId(UUID stepId);

    @Query("SELECT t.toolName, COUNT(t) FROM ToolCall t GROUP BY t.toolName ORDER BY COUNT(t) DESC")
    List<Object[]> countByToolName();
}
