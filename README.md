# 🍃 Fever challenge

This project follows Uncle Bob's Clean Architecture principles aka hexagonal architecture, using generics and interfaces to enforce consistent
implementation of use cases, domains, repositories, and entry points. This design ensures a clear separation of concerns
and makes the architecture flexible and easy to extend.

# Folder Structure

```plaintext
main
└── java
    └── com.feverup.challenge
        ├── core
        │   ├── domain
        │   └── application
        │       ├── dto
        │       ├── mappers
        │       └── usecases
        │       └── ports
        ├── entrypoints
        │   ├── controllers
        │   └── schedules
        └── infrastructure
            └── springboot
                ├── configs
                ├── controllers
                └── crons
                └── ports
└── resources
└── test
```

## Technologies Used

- **Java 21**
- **h2**
- **springcache**
- **springboot**

## Build the project

To build the project, use the following command:

```bash
mvn clean install
```

## Improvements
- **Cache Implementation**: Implementing a caching mechanism reduce latency and improve response times.

## Future Improvements

- **CQRS Implementation**: By implementing CQRS, we will separate command (provider pulling operation) and query (read) operations, enhancing performance and scalability.
- **Auto-scaling**: Polling services will automatically scale based on event volume.
