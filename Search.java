import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {

    private static Scanner scan;
    private static String input = "";

    public static void main(String[] args) {
        
        initialPrints();

        scan = new Scanner(System.in);
        while (!input.equals("exit")) {
            input = scan.nextLine();
            System.out.println("");
            String[] split = input.split(" ");
            switch (split[0]) {
                case "exit":
                    break;
                case "search":
                    search(split);
                    break;
                default:
                    System.out.println("Unknown command");
                    System.out.println("");
            }
        }
        scan.close();
    }

    private static void search(String[] args) {
        //Check if nbr of arguments are correct
        if (args.length != 3) {
            System.out.println("ERROR");
            System.out.println("search takes 2 arguments, not " + (args.length-1));
            System.out.println("");
            return;
        }

        //Check if file is found
        File file;
        Scanner reader;
        try {
            file = new File(args[2]);
            reader = new Scanner(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        //Search the file
        int nbrOfHits = 0;
        while (reader.hasNextLine()) {
            String next = reader.nextLine();
            if (next.toUpperCase().contains(args[1].toUpperCase())) {
                nbrOfHits++;
                System.out.println(next);
            }
        }
        reader.close();
        if (nbrOfHits == 0) {
            System.out.println("No matches found for " + args[1]);
            System.out.println("");
        } else {
            System.out.println("");
        }
    }

    private static void initialPrints() {
        System.out.println("Starting pattern search program");
        System.out.println("");
        System.out.println("Commands:");
        System.out.println("exit");
        System.out.println("search <pattern> <file>");
        System.out.println("");
    }
}