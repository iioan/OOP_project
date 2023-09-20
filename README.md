# OOP project
## Introduction
The purpose of this project is to create a recommendation algorithm for streams (music, podcasts, or audiobooks) based on existing data about application users (listeners) and stream creators (musicians, podcast hosts, etc.) or data accumulated during the application's runtime. Details about the data format as well as the commands to be implemented are provided in the following sections.

The main method of the project will be located in the ProiectPOO class and will receive as parameters 3 CSV files (in the order streamers.csv, streams.csv, and users.csv) and a text file comenzi.txt, which will contain the commands issued during the application's runtime.

### Streamers
Information about stream creators, whether musicians, podcast hosts, or audiobook authors, will be stored in the streamers.csv file, where each line will represent the data of a streamer: `streamerType, id, name`

### Streams
The data about the streams posted in the application up to this point will be found in the streams.csv file, where each line will represent the data of a stream. `streamType, id, streamGenre, noOfStreams,streamerId,length,dateAdded,name`

### User
The data about a user of the streaming platform will be located in the input file users.csv, where each line will represent a user and will have the format: `id,name,streams`
    
In order to implement the smart recommendation system, the project implementation must be capable of modifying existing data when commands are executed by users or streams, to be able to make accurate recommendations (e.g., if a user listens to a new stream different from those listened to up to the point of reading from the users.txt file, then the user's history and the number of plays for that specific stream will change)

The commands that can be performed by streamers will be:
  - add stream
  - list streams
  - delete stream
  
The commands that can be performed by users will be:
- list listening history
- listen to a stream
- recommend 5 streams based on preferences
- recommend 3 surprise streams

## Design Patterns Used:
### SINGLETON PATTERN FOR DATA

-   ensures that a class creates only one instance and provides a global point of access to it
-   why? to have only one database in an application
-   it holds data for streamers, streams, and users
-   when we want to access it, we call `getinstance()`

### FACADE PATTERN FOR DATA AND COMMAND

-   offers a simplified interface to a complex system
-   why? to hide the complexity of the system above by creating a unified interface for accessing it
-   `Datafacade`/`CommandFacade` provides a simplified interface for reading data/ executing commands. Each contains objects of classes for processing data.
-   advantages:
    -   hides complexity: as above
    -   makes the system more modular and easier to understand
    -   makes it easier to test parts of the code
    -   makes the subsystem easier to use
    -   facilitates code maintenance and future changes (e.g. we can create new implementations: send data online, create a graphical interface, etc.)

### COMMAND PATTERN

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

### BUILDER PATTERN FOR EACH CLASS

-   to create complex objects through an incremental process
-   allows objects to be built modularly, making them easy to create and use
-   we get rid of long constructors

### FACTORY PATTERN

-   defines an interface for creating an object but lets subclasses decide which class to instantiate
-   the `getCommand` method returns an object of type `Command`
-   why?
    -   The `CommandsExecutor` class correctly iterates over the list of commands and invokes each command through the `CommandInvoker` class. The `CommandInvoker` class correctly holds the command and executes it when asked. The `CommandFactory` class correctly returns the correct command object based on the `CommandName`.
