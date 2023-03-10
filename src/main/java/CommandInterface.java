interface Command {
    void execute(); // relevant for my design
}

class CommandInvoker {
    /*
     * Invoker-ul este un obiect care executa o comanda
     */
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}