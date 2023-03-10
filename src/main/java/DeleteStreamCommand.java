public class DeleteStreamCommand implements Command {

    private Data data;

    private final String text;

    public DeleteStreamCommand(String line) {
        this.text = line;
        this.data = Data.getInstance();
    }

    /*
     * Metoda este folosita pentru a sterge un stream din lista de streamuri
     * si din lista de streamuri asculate ale utilizatorilor
     */
    @Override
    public void execute() {
        String[] tokens = this.text.split(" ");
        int streamId = Integer.parseInt(tokens[2]);
        this.data.streams.remove(streamId);
        for (User user : this.data.users.values())
            if (user.getStreams().contains(streamId))
                user.getStreams().remove(streamId);
    }
}
