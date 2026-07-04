# spring-boot-skeleton

Gradle(Kotlin DSL) 기반의 Spring Boot 멀티 모듈 템플릿입니다. 공통 라이브러리(`lib-common`)와 3개의 API 앱(`api-external`, `api-internal`, `api-backoffice`)으로 구성됩니다.

> Production-oriented Spring Boot multi-module template: one shared library, three deployable API apps, single migration source, and ops-ready defaults (health checks, batch CLI).

## 설계 의도

실무에서 반복되는 "공통 코드 + 성격이 다른 여러 API(내부·외부·백오피스)" 구조를
처음부터 분리해 두기 위한 템플릿입니다.

- **멀티 모듈 분리** — 공통 도메인/설정은 `lib-common` 한 곳에, 배포 단위는 앱별로. 앱이 늘어나도 공통 코드가 복제되지 않습니다.
- **단일 마이그레이션 소스** — Flyway 디렉토리를 `lib-common`에 하나만 둬서 앱별 스키마 드리프트를 차단합니다.
- **운영 기본기 내장** — `/liveness`·`/readiness` 헬스체크(Kubernetes probe 호환), Picocli 기반 배치 서브커맨드를 기본 포함합니다.
- **web 없이도 실행** — 같은 앱을 API 서버로도, 일회성 배치 CLI로도 실행할 수 있게 구성했습니다.

## 구조
```
.
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── lib-common/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── kotlin/com/example/common/
│       └── resources/db/migration/
├── api-internal/
├── api-external/
└── api-backoffice/
```

## 요구사항
- Java 21
- Kotlin
- Gradle 9.x
- Spring Boot 4.0.2

## 빠른 시작
```bash
# 전체 빌드
gradle build

# 앱 실행 (예시)
gradle :api-internal:bootRun
gradle :api-external:bootRun
gradle :api-backoffice:bootRun

# CLI 실행 (예시, web 애플리케이션 비활성)
gradle :api-internal:bootRun --args="batch sample --limit 50" -Dspring.main.web-application-type=none
gradle :api-external:bootRun --args="batch sample --limit 50" -Dspring.main.web-application-type=none
gradle :api-backoffice:bootRun --args="batch sample --limit 50" -Dspring.main.web-application-type=none
```

## 공통 모듈(lib-common)
- 공통 엔티티(`SampleItem`)와 베이스 엔티티(`BaseEntity`)
- 글로벌 예외 처리(`GlobalExceptionHandler`)
- 단일 Flyway 마이그레이션 디렉토리

## 설정(application.yml)
- `.env`는 사용하지 않고 `application.yml` 중심으로 구성합니다.
- 공통 네이밍은 아래와 같습니다.
  - `app.name`, `app.env`, `app.log-level`
  - `db.url`, `db.username`, `db.password`, `db.pool-size`

## 마이그레이션(Flyway)
- 단일 마이그레이션 디렉토리를 `lib-common`에 유지합니다.
- 각 앱은 `classpath:db/migration`만 읽도록 구성합니다.
- 공통 마이그레이션 예시:
  - `lib-common/src/main/resources/db/migration/V0001__init.sql`

## Health Checks
모든 앱은 인증 없이 아래 엔드포인트를 제공합니다.
- `GET /liveness`
- `GET /readiness`

## CLI (Picocli)
- 각 앱에 `batch` 서브커맨드를 둡니다.
- 예시 명령: `api-internal batch sample --limit 100`
