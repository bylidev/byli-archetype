# 🍃 Springboot clean architecture archetype

This project follows Uncle Bob's Clean Architecture principles, using generics and interfaces to enforce consistent
implementation of use cases, domains, repositories, and entry points. This design ensures a clear separation of concerns
and makes the architecture flexible and easy to extend.

# Folder Structure

```plaintext
main
└── java
    └── dev.byli.robot.archetype
        ├── core
        │   ├── domain
        │   ├── mappers
        │   └── usecase.dummy
        │       ├── Dto
        │       ├── Repository
        │       └── UseCase
        ├── entrypoints
        │   ├── controllers
        │   │   └── DomainController
        │   └── events
        └── infrastructure.repository
            └── jooq
                ├── DummyRepository
                ├── JooqConfig
                └── Application
└── resources
└── test
```

## Technologies Used

- **Java 21**
- **Postgres**
- **JOOQ**
- **FlyWay**
- **Spring Actuator**

## How to Use

This project follows the **Database-First** approach. To get started, add your desired database migration. Once you've
added the migration, run the following command:

`mvn clean package`

Jooq will generate your Records and Classes on infrastructure.repository.jooq

