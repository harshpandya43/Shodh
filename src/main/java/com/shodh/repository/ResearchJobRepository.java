package com.shodh.repository;

import com.shodh.domain.JobStatus;
import com.shodh.domain.ResearchJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ResearchJobRepository extends JpaRepository<ResearchJob, UUID> {
    List<ResearchJob> findByStatusOrderByCreatedAtDesc(JobStatus status);

    List<ResearchJob> findAllByOrderByCreatedAtDesc();
}
