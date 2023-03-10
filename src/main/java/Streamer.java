public class Streamer {

    private int streamerType;
    private int id;

    public int getStreamerType() {
        return streamerType;
    }

    public void setStreamerType(int streamerType) {
        this.streamerType = streamerType;
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

    private String name;

    private Streamer(StreamerBuilder builder) {
        this.streamerType = builder.streamerType;
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class StreamerBuilder {
        private int streamerType;
        private int id;
        private String name;

        public StreamerBuilder setStreamerType(int streamerType) {
            this.streamerType = streamerType;
            return this;
        }

        public StreamerBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StreamerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Streamer build() {
            return new Streamer(this);
        }
    }

}
