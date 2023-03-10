import java.util.List;

public class Commands {
    String fileName;

    public Commands(String[] args) {
        this.fileName = args[3];
    }

    void run() {
        // metodele sunt implementate in clasa
        CommandFacade commandFacade = new CommandFacade();
        List<String> commands = commandFacade.readCommands(fileName);
        commandFacade.executeCommands(commands);
    }

}
