import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CommandFacade {
    /*
     * CommandFacade este o fatada care ascunde complexitatea claselor CommandReader si CommandsExecutor
     */
    private final CommandReader commandReader = new CommandReader();
    private final CommandsExecutor commandsExecutor = new CommandsExecutor();

    public List<String> readCommands(String file) {
        return commandReader.readCommands(file);
    }

    public void executeCommands(List<String> commands) {
        commandsExecutor.executeCommands(commands);
    }
}

/*
 * Este folosita pentru a citi comenzile din fisier, pe care le adauga intr-o lista
 */
class CommandReader {
    public List<String> readCommands(String file) {
        String fileName = System.getProperty("user.dir") + "/src/main/resources/" + file;
        try {
            List<String> commands = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String st;
            while ((st = br.readLine()) != null) {
                commands.add(st);
            }
            br.close();
            return commands;
        } catch (Exception e) {
            System.out.println("Error reading commands");
            e.printStackTrace();
        }
        return null;
    }
}

/*
 * Se foloseste de command pattern pentru a executa comenzile
 */
class CommandsExecutor {
    public void executeCommands(List<String> commands) {
        CommandInvoker invoker = new CommandInvoker();
        for (String line : commands) {
            String commandName = line.split(" ")[1];
            Command command = CommandFactory.getCommand(commandName, line);
            invoker.setCommand(command);
            invoker.executeCommand();
        }
    }
}
