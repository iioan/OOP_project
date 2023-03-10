import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Integer> streams;

    private User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.streams = builder.streams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getStreams() {
        return streams;
    }

    public void setStreams(List<Integer> streams) {
        this.streams = streams;
    }

    /*
     * Clasa UserBuilder este folosita pentru a construi un obiect de tip User
     */
    public static class UserBuilder {
        private int id;
        private String name;
        private List<Integer> streams = new ArrayList<>();

        public UserBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder addStream(int stream) {
            this.streams.add(stream);
            return this;
        }

        public UserBuilder setAllStreams(List<Integer> streams) {
            this.streams.addAll(streams);
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
