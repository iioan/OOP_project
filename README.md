# OOPproject
## SINGLETON PATTERN FOR DATA

-   ensures that a class creates only one instance and provides a global point of access to it
-   why? to have only one database in an application
-   it holds data for streamers, streams, and users
-   when we want to access it, we call `getinstance()`

## FACADE PATTERN FOR DATA AND COMMAND

-   offers a simplified interface to a complex system
-   why? to hide the complexity of the system above by creating a unified interface for accessing it
-   `Datafacade`/`CommandFacade` provides a simplified interface for reading data/ executing commands. Each contains objects of classes for processing data.
-   advantages:
    -   hides complexity: as above
    -   makes the system more modular and easier to understand
    -   makes it easier to test parts of the code
    -   makes the subsystem easier to use
    -   facilitates code maintenance and future changes (e.g. we can create new implementations: send data online, create a graphical interface, etc.)

## COMMAND PATTERN

-   encapsulates a request as an object
-   we use it when we want objects to perform different actions
-   structuring the system around high-level operations, built on top of primitive operations
-   SO WE HAVE:
    -   command interface with `execute()`
    -   `commandinvoker` - the receiver that performs operations
    -   the client (class `CommandsExecutor`) that creates objects of type `ComandaConcerta`
    -   `ComandaConcerta` (`AddStreamCommand`, `ListCommand`, etc.) - which implements the command interface with the `execute()` method
    -   the client specifies the receiver
    -   the invoker sends a request by calling `execute()` -> goes to the concrete command
    -   the concrete command invokes operations on the receiver to carry out the requests

## BUILDER PATTERN FOR EACH CLASS

-   to create complex objects through an incremental process
-   allows objects to be built modularly, making them easy to create and use
-   we get rid of long constructors

## FACTORY PATTERN

-   defines an interface for creating an object but lets subclasses decide which class to instantiate
-   the `getCommand` method returns an object of type `Command`
-   why?
    -   The `CommandsExecutor` class correctly iterates over the list of commands and invokes each command through the `CommandInvoker` class. The `CommandInvoker` class correctly holds the command and executes it when asked. The `CommandFactory` class correctly returns the correct command object based on the `CommandName`.
