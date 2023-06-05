# OOAD-UML-editor
My UML editor for the project of the course Object-Oriented Anaylysis and Design at NCU, Taiwan

## Environment
- openjdk 19.0.2
```
❯ java -version
openjdk version "19.0.2" 2023-01-17
OpenJDK Runtime Environment (build 19.0.2+7-44)
OpenJDK 64-Bit Server VM (build 19.0.2+7-44, mixed mode, sharing)
```

- linux kernel for WSL2  
It seems to work well in both WSL2 for Win10 & Win11
    - Win10 build 19045.2486
    ```
    ❯ uname -r
    5.15.90.1-microsoft-standard-WSL2
    ```
    - Win11 build 22000.1696
    ```
    ❯ uname -r
    5.15.90.1-microsoft-standard-WSL2
    ```

- gradle  
Using gradle to manage the project and build the UML editor application
```
❯ gradle -v

------------------------------------------------------------
Gradle 8.0.2
------------------------------------------------------------

Build time:   2023-03-03 16:41:37 UTC
Revision:     7d6581558e226a580d91d399f7dfb9e3095c2b1d

Kotlin:       1.8.10
Groovy:       3.0.13
Ant:          Apache Ant(TM) version 1.10.11 compiled on July 10 2021
JVM:          19.0.2 (Oracle Corporation 19.0.2+7-44)
OS:           Linux 5.15.90.1-microsoft-standard-WSL2 amd64
```

## To buld and run the editor application
`❯ ./gradlew run` in the shell (apparently, `gradle` is required to build and run the editor when use the command).

## About maintainability
- Config.java
    - The problem is: whenever a **new graphic class is introduced**, this file probably **needs to be changed**.  
    Maybe move these configuration setting to the corresponding graphic class will be better.
    - The solution is: (Refactor) **keep minimal, component independent** information such as `screenWidth`, `screenHeight` stored in Config.java. Move other component dependent info to their own classes.
- operation/OperationDispatcher.java
    - Serves as the controller of the application; works with Operation and its subclass to form the strategy/state pattern.
- graphics/UML
    - UMLObject.java
        - It's the base class of all UML graphic objects (includes lines and ports).
    - basicObject/BasicObject.java
        - It's the base class of all basic objects and extends UMLObject.
