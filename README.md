# Shodh — Autonomous AI Research Agent

Shodh (Sanskrit/Gujarati: *research, investigation*) is a production-grade
autonomous AI research agent built with Java 21, Spring Boot 3.5, and the
Anthropic Claude API.

## What it does
Give Shodh a research question. It plans, searches the web, reads articles,
reasons about findings, and delivers a cited research report — autonomously.
Every step is visible in real time on the dashboard.

## Tech Stack
- **Backend:** Java 21 (Virtual Threads), Spring Boot 3.5, Spring Data JPA
- **AI:** Anthropic Claude API (Tool use, streaming)
- **Database:** PostgreSQL 16 + pgvector, Flyway migrations
- **Cache:** Redis 7
- **Frontend:** React + Vite + TypeScript (Phase 2)
- **Infra:** Docker Compose (local), AWS ECS Fargate + RDS + SQS (Phase 4)
- **Observability:** Micrometer, Prometheus, Grafana, OpenTelemetry (Phase 3)

## Architecture
## Build Phases
| Phase | Description | Status |
|-------|-------------|--------|
| 1 | Foundation — domain model, REST API | 🔨 In Progress |
| 2 | Agent Intelligence — LLM, tools, React UI | ⬜ Upcoming |
| 3 | Production Hardening — queues, observability | ⬜ Upcoming |
| 4 | AWS Deployment — ECS, RDS, SQS | ⬜ Upcoming |
| 5 | Advanced — memory, multi-agent | ⬜ Upcoming |

## Running Locally

### Prerequisites
- Java 21
- Docker Desktop

### Start infrastructure
```bash
docker compose up -d
```

### Start the app
```bash
./gradlew bootRun
```

### Health check
```bash
curl http://localhost:8080/actuator/health
```

## Branch Strategy
| Branch | Purpose |
|--------|---------|
| `main` | Production — always stable |
| `staging` | Pre-production |
| `dev` | Integration — all features merge here |
| `feature/*` | Day-to-day feature work |
| `fix/*` | Bug fixes |