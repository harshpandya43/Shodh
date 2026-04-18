-- =============================================
-- research_jobs — top level research container
-- =============================================
CREATE TABLE research_jobs
(
    id                UUID         NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    query             VARCHAR(2000) NOT NULL,
    status            VARCHAR(20)  NOT NULL DEFAULT 'PENDING',
    final_report      TEXT,
    total_tokens_used INTEGER,
    created_at        TIMESTAMPTZ  NOT NULL DEFAULT now(),
    updated_at        TIMESTAMPTZ  NOT NULL DEFAULT now()
);

CREATE INDEX idx_research_jobs_status ON research_jobs (status);
CREATE INDEX idx_research_jobs_created_at ON research_jobs (created_at DESC);

-- =============================================
-- agent_steps — one step in the agent's reasoning
-- =============================================
CREATE TABLE agent_steps
(
    id          UUID        NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    job_id      UUID        NOT NULL REFERENCES research_jobs (id) ON DELETE CASCADE,
    type        VARCHAR(20) NOT NULL,
    content     TEXT,
    tokens_used INTEGER,
    duration_ms BIGINT,
    created_at  TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_agent_steps_job_id ON agent_steps (job_id);
CREATE INDEX idx_agent_steps_created_at ON agent_steps (created_at ASC);

-- =============================================
-- tool_calls — one tool invocation within a step
-- =============================================
CREATE TABLE tool_calls
(
    id            UUID        NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    step_id       UUID        NOT NULL REFERENCES agent_steps (id) ON DELETE CASCADE,
    tool_name     VARCHAR(100) NOT NULL,
    input_json    TEXT,
    output_json   TEXT,
    success       BOOLEAN     NOT NULL DEFAULT false,
    error_message TEXT,
    duration_ms   BIGINT,
    created_at    TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_tool_calls_step_id ON tool_calls (step_id);
CREATE INDEX idx_tool_calls_tool_name ON tool_calls (tool_name);