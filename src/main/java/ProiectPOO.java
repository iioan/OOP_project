public class ProiectPOO {

    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Nothing to read here");
        } else {
            Data data = Data.getInstance();
            data.clearData();
            data.readData(args);
            Commands commands = new Commands(args);
            commands.run();
        }
    }
}
