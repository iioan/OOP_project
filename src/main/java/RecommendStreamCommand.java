import java.util.*;

public class RecommendStreamCommand implements Command {

    private Data data;

    private final String text;

    public RecommendStreamCommand(String line) {
        this.text = line;
        this.data = Data.getInstance();
    }

    /*
     * Metoda este folosita pentru a recomanda un stream utilizatorului
     */
    @Override
    public void execute() {
        String[] tokens = this.text.split(" ");
        int userId = Integer.parseInt(tokens[0]);
        User user = this.data.users.get(userId);
        // userStreams = lista de streamuri ascultate de utilizator
        List<Integer> userStreams = user.getStreams();
        // streamerSet = lista de streameri ale caror streamuri au fost ascultate de utilizator
        Set<Integer> streamerSet = new HashSet<>();
        for (Stream stream : this.data.streams.values())
            if (userStreams.contains(stream.getId())) {
                streamerSet.add(stream.getStreamerId());
            }
        // se iau streamurile ale caror streameri au fost ascultati de utilizator
        // si care nu au fost deja ascultate de utilizator
        // in caz afirmativ se adauga in lista de streamuri recomandate
        List<Stream> recommendedStreams = new ArrayList<>();
        for (Stream stream : this.data.streams.values()) {
            if (streamerSet.contains(stream.getStreamerId()) && !userStreams.contains(stream.getId())) {
                recommendedStreams.add(stream);
            }
        }
        // se sorteaza lista de streamuri recomandate in functie de numarul de ascultari
        recommendedStreams.sort(new Comparator<>() {
            @Override
            public int compare(Stream o1, Stream o2) {
                return (int) (o2.getNoOfStreams() - o1.getNoOfStreams());
            }
        });
        // se cere Top 5 streamuri recomandate, daca exista mai multe se returneaza doar primele 5
        if (recommendedStreams.size() > 5)
            recommendedStreams = recommendedStreams.subList(0, 5);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Stream stream : recommendedStreams) {
            sb.append(stream.toJson());
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }
}
