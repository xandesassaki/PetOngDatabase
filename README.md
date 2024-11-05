# Pet Organization Database

##  What was used

- Install [IntelliJ IDE](https://www.jetbrains.com/pt-br/idea/)
- Install [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Install [Maven](https://maven.apache.org/download.cgi)

## How to start

- Create *_local.env_* at project root to use it as .env option and fill using example below:

```
#System Port
SYSTEM_CUSTOM_PORT=

#flyway migrations classpath
FLYWAY_CLASSPATH=

#PostgreSQL
POSTGRES_URL=
POSTGRES_PORT=
POSTGRES_DATABASE_NAME=
POSTGRES_USERNAME=
POSTGRES_PASSWORD=
```

- Run mvn to install packages (recommended run clean -> compile -> package -> install)
- At main class, press *Run Button*
  - Make sure the local.env is filled and selected as run option
- Access your localhost:{port}/swagger-ui/index.html to see the documentation