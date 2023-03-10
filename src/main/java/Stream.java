public class Stream {
    private int streamType;
    private int id;
    private int streamGenre;
    private long noOfStreams;
    private int streamerId;
    private long length;
    private long dateAdded;
    private String name;

    public int getStreamType() {
        return streamType;
    }

    public void setStreamType(int streamType) {
        this.streamType = streamType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStreamGenre() {
        return streamGenre;
    }

    public void setStreamGenre(int streamGenre) {
        this.streamGenre = streamGenre;
    }

    public long getNoOfStreams() {
        return noOfStreams;
    }

    public void setNoOfStreams(long noOfStreams) {
        this.noOfStreams = noOfStreams;
    }

    public int getStreamerId() {
        return streamerId;
    }

    public void setStreamerId(int streamerId) {
        this.streamerId = streamerId;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Stream(StreamBuilder builder) {
        this.id = builder.id;
        this.streamType = builder.streamType;
        this.streamGenre = builder.streamGenre;
        this.noOfStreams = builder.noOfStreams;
        this.streamerId = builder.streamerId;
        this.length = builder.length;
        this.dateAdded = builder.dateAdded;
        this.name = builder.name;
    }

    /*
     *  Printarea unui stream in format JSON
     */
    String toJson() {
        StringBuilder sb = new StringBuilder();
        String streamerName = Data.getInstance().streamers.get(this.streamerId).getName();
        DateLengthFormatter dlf = new DateLengthFormatter.Builder()
                .setDateAdded(this.dateAdded)
                .setLength(this.length)
                .build();
        sb.append("{");
        sb.append("\"id\":\"").append(this.id).append("\",");
        sb.append("\"name\":\"").append(this.name).append("\",");
        sb.append("\"streamerName\":\"").append(streamerName).append("\",");
        sb.append("\"noOfListenings\":\"").append(this.noOfStreams).append("\",");
        sb.append("\"length\":\"").append(dlf.formatLength()).append("\",");
        sb.append("\"dateAdded\":\"").append(dlf.formatDate()).append("\"},");
        return sb.toString();
    }

    public static class StreamBuilder {
        private int streamType;
        private int id;
        private int streamGenre;
        private long noOfStreams;
        private int streamerId;
        private long length;
        private long dateAdded;
        private String name;

        public StreamBuilder setStreamType(int streamType) {
            this.streamType = streamType;
            return this;
        }

        public StreamBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StreamBuilder setStreamGenre(int streamGenre) {
            this.streamGenre = streamGenre;
            return this;
        }

        public StreamBuilder setNoOfStreams(long noOfStreams) {
            this.noOfStreams = noOfStreams;
            return this;
        }

        public StreamBuilder setStreamerId(int streamerId) {
            this.streamerId = streamerId;
            return this;
        }

        public StreamBuilder setLength(long length) {
            this.length = length;
            return this;
        }

        public StreamBuilder setDateAdded(long dateAdded) {
            this.dateAdded = dateAdded;
            return this;
        }

        public StreamBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Stream build() {
            return new Stream(this);
        }
    }
}
