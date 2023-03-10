import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateLengthFormatter {
    /*
     * Formateaza data si lungimea unui stream in formatul dorit
     * Ambele variabile sunt de tipul long
     */

    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private long dateAdded;
    private long length;

    public DateLengthFormatter(Builder builder) {
        this.dateAdded = builder.dateAdded;
        this.length = builder.length;
    }

    /*
     * Formateaza data in formatul dd-MM-yyyy
     */
    String formatDate() {
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.dateAdded *= 1000L;
        return formatter.format(this.dateAdded);
    }

    /*
     * Formateaza lungimea in formatul HH:mm:ss sau mm:ss
     */
    String formatLength() {
        long secondsPerHour = 3600;
        if (this.length > secondsPerHour) {
            int hours = (int) (this.length / secondsPerHour);
            int minutes = (int) ((this.length % secondsPerHour) / 60);
            int seconds = (int) (this.length % 60);
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            int minutes = (int) (this.length / 60);
            int seconds = (int) (this.length % 60);
            return String.format("%02d:%02d", minutes, seconds);
        }
    }

    public static class Builder {
        private long dateAdded;
        private long length;

        public Builder setDateAdded(long dateAdded) {
            this.dateAdded = dateAdded;
            return this;
        }

        public Builder setLength(long length) {
            this.length = length;
            return this;
        }

        public DateLengthFormatter build() {
            return new DateLengthFormatter(this);
        }
    }

}
