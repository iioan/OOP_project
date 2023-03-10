import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataFacade {
    /*
     * Aceasta clasa este o fatada pentru clasele de citire a datelor
     */
    private final StreamData streamData = new StreamData();
    private final StreamerData streamerData = new StreamerData();
    private final UserData userData = new UserData();

    /*
     * Aceste metode sunt folosite pentru a citi datele din fisiere
     */
    public void readStreamsData(HashMap<Integer, Stream> streams, String file) {
        streamData.readData(streams, file);
    }

    public void readStreamersData(HashMap<Integer, Streamer> streamers, String file) {
        streamerData.readData(streamers, file);
    }

    public void readUsersData(HashMap<Integer, User> users, String file) {
        userData.readData(users, file);
    }
}

class StreamData {
    /*
     * Aceasta clasa este folosita pentru a citi datele din fisierul streams.csv
     */
    public void readData(HashMap<Integer, Stream> streams, String file) {
        String streamsFile = System.getProperty("user.dir") + "/src/main/resources/" + file;
        try {
            CSVReader reader = new CSVReader(new FileReader(streamsFile));
            String[] nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                int streamType = Integer.parseInt(nextLine[0]);
                int id = Integer.parseInt(nextLine[1]);
                int streamGenre = Integer.parseInt(nextLine[2]);
                long noOfStreams = Long.parseLong(nextLine[3]);
                int streamerId = Integer.parseInt(nextLine[4]);
                long length = Long.parseLong(nextLine[5]);
                long dateAdded = Long.parseLong(nextLine[6]);
                String name = nextLine[7];
                Stream stream = new Stream.StreamBuilder()
                        .setStreamType(streamType)
                        .setId(id)
                        .setStreamGenre(streamGenre)
                        .setNoOfStreams(noOfStreams)
                        .setStreamerId(streamerId)
                        .setLength(length)
                        .setDateAdded(dateAdded)
                        .setName(name)
                        .build();
                streams.put(id, stream);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading streams data");
            e.printStackTrace();
        }
    }
}

class StreamerData {
    public void readData(HashMap<Integer, Streamer> streamers, String file) {
        String streamsFile = System.getProperty("user.dir") + "/src/main/resources/" + file;
        try {
            CSVReader reader = new CSVReader(new FileReader(streamsFile));
            String[] nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                int streamerType = Integer.parseInt(nextLine[0]);
                int id = Integer.parseInt(nextLine[1]);
                String name = nextLine[2];
                Streamer streamer = new Streamer.StreamerBuilder()
                        .setStreamerType(streamerType)
                        .setId(id)
                        .setName(name)
                        .build();
                streamers.put(id, streamer);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading streamers data");
            e.printStackTrace();
        }
    }
}

class UserData {
    public void readData(HashMap<Integer, User> users, String file) {
        String streamsFile = System.getProperty("user.dir") + "/src/main/resources/" + file;
        try {
            CSVReader reader = new CSVReader(new FileReader(streamsFile));
            String[] nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                List<Integer> streams = getAllStreams(nextLine[2]);
                User user = new User.UserBuilder()
                        .setId(id)
                        .setName(name)
                        .setAllStreams(streams)
                        .build();
                users.put(id, user);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading users data");
            e.printStackTrace();
        }
    }

    List<Integer> getAllStreams(String line) {
        String[] split = line.split(" ");
        List<Integer> streams = new ArrayList<>();
        for (String s : split) {
            streams.add(Integer.parseInt(s));
        }
        return streams;
    }

}