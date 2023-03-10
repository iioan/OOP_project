class CommandFactory {
    /*
     * Returneaza un obiect de comanda bazat pe commandName
     */
    public static Command getCommand(String commandName, String line) {
        switch (commandName) {
            case "LIST":
                return new ListCommand(line);
            case "ADD":
                return new AddStreamCommand(line);
            case "DELETE":
                return new DeleteStreamCommand(line);
            case "LISTEN":
                return new ListenStreamCommand(line);
            case "RECOMMEND":
                return new RecommendStreamCommand(line);
            case "SURPRISE":
                return new SurpriseCommand(line);
            default:
                throw new IllegalArgumentException("Unknown command");
        }
    }
}