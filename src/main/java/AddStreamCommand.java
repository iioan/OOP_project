import java.util.Calendar;

public class AddStreamCommand implements Command {

    private Data data;
    private final String text;

    AddStreamCommand(String line) {
        this.data = Data.getInstance();
        this.text = line;
    }

    /*
     * Metoda este folosita pentru a adauga un stream in lista de streamuri
     */
    @Override
    public void execute() {
        String[] tokens = text.split(" ");
        int streamerId = Integer.parseInt(tokens[0]);
        int streamType = Integer.parseInt(tokens[2]);
        int streamId = Integer.parseInt(tokens[3]);
        int streamGenre = Integer.parseInt(tokens[4]);
        long length = Long.parseLong(tokens[5]);
        StringBuilder sb = new StringBuilder();
        for (int i = 6; i < tokens.length; i++) {
            sb.append(tokens[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        String name = sb.toString();
        Stream stream = new Stream.StreamBuilder()
                .setStreamType(streamType)
                .setId(streamId)
                .setStreamGenre(streamGenre)
                .setNoOfStreams(0)
                .setStreamerId(streamerId)
                .setLength(length)
                .setDateAdded(Calendar.getInstance().getTimeInMillis() / 1000)
                .setName(name)
                .build();
        data.streams.put(streamId, stream);
    }
}
