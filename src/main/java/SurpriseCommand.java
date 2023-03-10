import java.util.*;

public class SurpriseCommand implements Command {

    private final String text;
    private Data data;

    public SurpriseCommand(String line) {
        this.text = line;
        this.data = Data.getInstance();
    }

    /*
     * Metoda este folosita pentru a recomanda un stream
     * utilizatorului, in functie de streamerii pe care nu i-a ascultat
     */
    @Override
    public void execute() {
        int userId = Integer.parseInt(text.split(" ")[0]);
        User user = this.data.users.get(userId);
        // Lista contine id-urile stream-urilor ascultate de utilizator
        List<Integer> userStreams = user.getStreams();
        // Set-ul contine id-urile streamerilor care au stream-uri ascultate de utilizator
        Set<Integer> streamerSet = new HashSet<>();
        for (Integer stream : userStreams) {
            streamerSet.add(this.data.streams.get(stream).getStreamerId());
        }
        // Lista contine stream-uri care nu au fost ascultate de utilizator
        // si ai caror nici streameri nu au fost ascultati de utilizator
        List<Stream> surpriseStreams = new ArrayList<>();
        for (Stream stream : this.data.streams.values()) {
            if (!streamerSet.contains(stream.getStreamerId())) {
                surpriseStreams.add(stream);
            }
        }
        // se sorteaza lista de stream-uri in functie de data adaugarii stream-urilor
        // iar in caz de egalitate, dupa numarul de ascultari
        surpriseStreams.sort(new Comparator<>() {
            @Override
            public int compare(Stream o1, Stream o2) {
                if (o2.getDateAdded() == o1.getDateAdded())
                    return (int) (o2.getNoOfStreams() - o1.getNoOfStreams());
                return (int) (o2.getDateAdded() - (o1.getDateAdded()));
            }
        });
        // Trebuie alese 3 stream-uri, daca sunt mai multe, se vor lua primele 3
        if (surpriseStreams.size() > 3)
            surpriseStreams = surpriseStreams.subList(0, 3);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Stream stream : surpriseStreams) {
            sb.append(stream.toJson());
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }
}
