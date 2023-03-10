import java.util.HashMap;

public class Data {

    private static Data instance = null;
    HashMap<Integer, Streamer> streamers = new HashMap<>();
    HashMap<Integer, Stream> streams = new HashMap<>();
    HashMap<Integer, User> users = new HashMap<>();

    /*
     * Singleton pattern
     * Creaza o instanta unica a clasei Data
     */
    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    private final DataFacade facade = new DataFacade();

    void readData(String[] arguments) {
        facade.readStreamersData(streamers, arguments[0]);
        facade.readStreamsData(streams, arguments[1]);
        facade.readUsersData(users, arguments[2]);
    }

    void clearData() {
        streamers.clear();
        streams.clear();
        users.clear();
    }

}

