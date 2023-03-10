public class ListenStreamCommand implements Command {
    private Data data = Data.getInstance();
    private final String text;

    public ListenStreamCommand(String line) {
        this.text = line;
    }

    /*
     * Metoda este folosita pentru a 'asculta' un stream
     * si pentru a actualiza numarul de ascultari al streamului,
     * respectiv lista de streamuri ascultate de utilizator
     */
    @Override
    public void execute() {
        String[] tokens = this.text.split(" ");
        int userId = Integer.parseInt(tokens[0]);
        int streamId = Integer.parseInt(tokens[2]);
        this.data.users.get(userId).getStreams().add(streamId);
        Stream stream = this.data.streams.get(streamId);
        stream.setNoOfStreams(stream.getNoOfStreams() + 1);
    }
}
