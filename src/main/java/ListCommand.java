public class ListCommand implements Command {

    private final String text;
    private Data data;

    public ListCommand(String line) {
        this.text = line;
        this.data = Data.getInstance();
    }

    @Override
    public void execute() {
        int id = Integer.parseInt(this.text.split(" ")[0]);
        if (this.data.streamers.containsKey(id)) {
            this.listStreamerCommand();
        }
        if (this.data.users.containsKey(id)) {
            this.listUserCommand();
        }
    }

    /*
     *  Listeaza toate stream-urile unui streamer.
     */
    void listStreamerCommand() {
        int id = Integer.parseInt(this.text.split(" ")[0]);
        Streamer streamer = this.data.streamers.get(id);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // intra in hashmap-ul de stream-uri si ia toate stream-urile care au id-ul streamer-ului
        for (Stream stream : this.data.streams.values()) {
            if (stream.getStreamerId() == streamer.getId()) {
                sb.append(stream.toJson());
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]\n");
        System.out.print(sb);
    }

    /*
     *  Listeaza istoria de ascultare a utilizatorului (aflat in lista streams).
     */
    void listUserCommand() {
        int id = Integer.parseInt(this.text.split(" ")[0]);
        User user = this.data.users.get(id);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int streamId : user.getStreams()) {
            // ia id-ul stream-ului din lista de stream-uri ascultate de user
            Stream stream = this.data.streams.get(streamId);
            sb.append(stream.toJson());
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]\n");
        System.out.print(sb);
    }
}
