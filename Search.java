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
            print("");
            String[] split = input.split(" ");
            switch (split[0]) {
                case "exit":
                    break;
                case "search":
                    search(split);
                    break;
                default:
                    print("Unknown command");
                    print("");
            }
        }
        scan.close();
    }

    private static void search(String[] args) {
        //Check if nbr of arguments are correct
        if (args.length != 3) {
            print("ERROR");
            print("search takes 2 arguments, not " + (args.length-1));
            print("");
            return;
        }

        //Check if file is found
        File file;
        Scanner reader;
        try {
            file = new File(args[2]);
            reader = new Scanner(file);

        } catch (FileNotFoundException e) {
            print("ERROR");
            print("File with path " + args[2] + " cannot be found");
            print("");
            return;
        }

        //Search the file
        int nbrOfHits = 0;
        while (reader.hasNextLine()) {
            String next = reader.nextLine();
            if (next.toUpperCase().contains(args[1].toUpperCase())) {
                nbrOfHits++;
                print(next);
            }
        }
        reader.close();
        if (nbrOfHits == 0) {
            print("No matches found for " + args[1]);
            print("");
        } else {
            print("");
        }
    }

    private static void initialPrints() {
        print("Starting pattern search program");
        print("");
        print("Commands:");
        print("exit");
        print("search <pattern> <file>");
        print("");
    }

    private static void print(String string) {
        System.out.println(string);
    }
}