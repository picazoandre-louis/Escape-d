
import java.util.Scanner;

public class Main {

    public static Scanner scan;
    public static int moves = 30;
    public static String output = "You find yourself in a large foyer. There is a shiny shiny door to the north. To the west is a nice boujee bench against the wall. To the east is a chest on the floor. It has some ice spilling out of it. In the center of the room is a large candle. It's pretty loud in here. The candle is unlit.";

    public static boolean wfoyer = true;
    public static boolean wlibrary = false;
    public static boolean wconservatory = false;


    public static boolean openchest = false;
    public static boolean matches = false;
    public static boolean candlelit = false;
    public static boolean doorlock = true;
    public static boolean dooropen = false;


    public static boolean haspen = false;
    public static boolean write = false;
    public static boolean doorrlock = true;
    public static boolean doorropen = false;


    public static boolean trumpet = false;
    public static boolean piano = false;
    public static boolean drum = false;

    public static void main(String[] args) {

        System.out.printf("Welcome to the party House. You have 30 moves to escape. verbs to use: open, close, light, read, write, play, look, get; nouns to use: door, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock; movement: north, south, east, west;\n\n");
        for (int i = 1; i < 31; i++) {
            gameUsage();
            moves--;
            if (trumpet && piano && drum) {
                break;
            }
        }
        if (trumpet && piano && drum) {
            System.out.printf("\nCongrAAAAAAAAAAAAATULATIONS! You have finessed this escape room challenge successfully with %d moves to spare.", moves);
        }
        else {
            System.out.printf("\ndang you failed. that sucks. Try again!");
        }
    }

    public static void gameUsage() {
        if (wfoyer) {
            foyer();
        }
        else if (wlibrary) {
            library();
        }
        else if (wconservatory) {
            conservatory();
        }
    }

    public static void foyer() {
        System.out.printf("%s You've got %d moves left.\n>>", output, moves);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look bench":
                output = "There is a note on the bench.";
                break;

            case "read note":
                output = "May my light show you the way.";
                break;

            case "look chest":
                output = "the chest is closed.";
                break;

            case "open chest":
                openchest = true;
                output = "There are matches in the chest.";
                break;

            case "get matches":
                matches = true;
                output = "You have a box of matches.";
                break;

            case "light candle":
                if (matches) {
                    candlelit = true;
                    doorlock = false;
                    output = "The candle is lit. Don't Stop Me Now by Queen starts playing. You heard a metal grinding sound from the north.";
                }
                else {
                    output = "You don't have any matches.";
                }
                break;

            case "look door":
                if (!doorlock) {
                    if (dooropen) {
                        output = "The door is unlocked and open.";
                    }
                    else {
                        output = "The door is unlocked, but closed.";
                    }
                }
                else {
                    output = "The door is locked.";
                }
                break;

            case "open door":
                if (!doorlock) {
                    dooropen = true;
                    output = "The north door is open.";
                }
                break;

            case "north":
                if (dooropen) {
                    wfoyer = false;
                    wlibrary = true;
                    output = "You have left the foyer. On your way out, the door slammed and locked. You are startled and jump, hitting your head. You are now in the library and cannot return to the foyer. Sucks. In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.";
                }
                break;
        }
    }

    public static void library() {
        System.out.printf("%s You have %d moves left.\n>>", output, moves);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look bookshelf":
                output = "There is a book titled 'The Autobiography of ...' with the rest of the title empty.";
                break;

            case "get pen":
                haspen = true;
                output = "You have acquired the pen.";
                break;

            case "read scroll":
                output = "the scroll says, 'Share your story.'";
                break;

            case "write book":
            case "write name":
                write = true;
                doorrlock = false;
                output = "You have completed the autobiography You heard a metal grinding sound from the north. Skrillex starts playing.";
                break;

            case "look door":
                if (!doorrlock) {
                    if (doorropen) {
                        output = "The door is unlocked and open.";
                    }
                    else {
                        output = "The door is unlocked, but closed.";
                    }
                }
                else {
                    output = "The door is locked.";
                }
                break;

            case "open door":
                if (!doorrlock) {
                    doorropen = true;
                    output = "The north door is open.";
                }
                break;

            case "north":
                if (dooropen) {
                    wlibrary = false;
                    wconservatory = true;
                    output = " You have left the library. On your way out, the door slammed and locked. You are now in the conservatory and cannot return to the library. Sheesh you should've learned by now. In the conservatory there are there are three instruments: a trumpet, a piano, and a drum. There is a sheet of music on a stand. Play a lil sum.";
                }
                break;

            default:
                output = "In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.";
        }
    }

    public static void conservatory()  {
        System.out.printf("%s You have %d moves left.\n>>", output, moves);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {
            case "read music":
                output = "Timbre, Tone, Time";
                break;

            case "play trumpet":
                if (!piano && !drum) {
                    trumpet = true;
                    output = "*trumpet noise*";
                }
                else {
                    output = "Hmm... Something seems to be wrong with the trumpet. It isn't playing correctly. Fool.";
                }
                break;

            case "play piano":
                if (trumpet && !drum) {
                    piano = true;
                    output = "*piano noise*";
                }
                else {
                    output = "Hmm... Something seems to be wrong with the piano. It isn't playing correctly. C'mon";
                }
                break;

            case "play drum":
                if (trumpet && piano) {
                    drum = true;
                    output = "*drum noise*";
                }
                else {
                    output = "Hmm... Something seems to be wrong with the drum. It isn't playing correctly. PARUMP PARUMP.";
                }
                break;

            default:
                output = "In the conservatory there are there are three instruments: a trumpet, a piano, and a drum. There is a sheet of music on a stand.";
        }
    }
}
