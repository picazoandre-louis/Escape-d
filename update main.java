
import java.util.Scanner;

public class Main {

    public static Scanner scan;
    public static int moves = 30;
    public static String output = "You find yourself in a huge foyer. Like crazy huge. There is a shiny shiny door to the north. Next to it is a bench. You see a chest under the bench. It has some ice spilling out of it. In the center of the room is a floating candle. It's pretty loud in here. The candle has a brand new wick waiting to be lit.";

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
    public static boolean doorrrlock = true;
    public static boolean doorrropen = false;
    public static boolean finale = false;
    public static double t = 0;

    public static void main(String[] args) {

        System.out.printf("Welcome to the party House. You've got 30 moves to escape. verbs to use: open, close, light, read, write, play, look, get; nouns to use: door, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock; movement: north, south, east, west;\n\n");
        for (int i = 1; i < 31; i++) {
            gameUsage();
            moves--;
            if (finale) {
                break;
            }
        }
        if (finale) {
            System.out.printf("\nCongrAAAAAAAAAAAAATULATIONS! You have finessed this escape room challenge successfully with %d moves to spare. The frat has accepted you.", moves);
        }
        else {
            System.out.printf("\ndang you failed. that sucks. Try again with some real knowledge.");
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
        String sc = scan.nextLine();

        switch (sc) {

            case "look bench":
                output = "Under a pile of ashes, you find a note.";
                break;

            case "read note":
                output = "May my flame burn the path for you.";
                break;

            case "look chest":
                output = "the chest is closed. Go figure.";
                break;

            case "open chest":
                openchest = true;
                output = "There are matches in the chest. Amazing.";
                break;

            case "get matches":
               if (openchest) {
                   matches = true;
                   output = "You have a box of matches. Burn somethin.";
               }
                else {
                   output = "Where are these matches?";
               }
                break;

            case "light candle":
                if (matches) {
                    candlelit = true;
                    doorlock = false;
                    output = "The candle is lit. Don't Stop Me Now by Queen starts playing. You heard a *click* sound from the north.";
                }
                else {
                    output = "You don't have any matches. oops.";
                }
                break;

            case "look door":
                if (!doorlock) {
                    if (dooropen) {
                        output = "The door is unlocked and open. Let's go!!";
                    }
                    else {
                        output = "The door is unlocked, but closed. Dang.";
                    }
                }
                else {
                    output = "The door is locked. Oof.";
                }
                break;

            case "open door":
                if (!doorlock) {
                    dooropen = true;
                    output = "The north door is open. SICK.";
                }
                break;

            case "go north":
                if (dooropen) {
                    wfoyer = false;
                    wlibrary = true;
                    output = "You left the foyer. The door slammed and locked behind you. You are startled and jump, hitting your head.\n Ouch. You are now in a library. Sucks. There is another locked door to the north.\n In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll.\n There is another locked door to the north.";
                }
                break;

            default:
                output = "That's crazy nothing happened.";
        }
    }

    public static void library() {
        System.out.printf("%s You have %d moves left.\n>>", output, moves);
        scan = new Scanner(System.in);
        String sc = scan.nextLine();

        switch (sc) {

            case "look shelf":
                output = "You see a single book. Weird a library with only one book. A pen and scroll are also present.";
                break;

            case "look shelves":
                output = "You see a single book. Weird a library with only one book. A pen and scroll are also present.";
                break;

            case "look book":
                output = "There is a book titled 'The Autobiography of ' with empty space.";
                break;

            case "look pen":
                output = "Dang it's a Pilot G2 - 07. What's such a modern pen doing here?";
                break;

            case "get pen":
                haspen = true;
                output = "You have the pen.";
                break;

            case "look scroll":
                output = "It's an old scroll, probably has not been read in awhile. That's crazy.";
                break;

            case "read scroll":
                output = "the scroll says, 'What's your story.'";
                break;

            case "write book":
                write = true;
                doorrlock = false;
                output = "You have completed the autobiography You heard another *click* sound from the north. Skrillex starts playing.";
                break;

            case "look door":
                if (!doorrlock) {
                    if (doorropen) {
                        output = "The door is unlocked and open. Get this bread.";
                    }
                    else {
                        output = "The door is unlocked, but closed. Wild.";
                    }
                }
                else {
                    output = "The door is locked. Oof.";
                }
                break;

            case "open door":
                if (!doorrlock) {
                    doorropen = true;
                    output = "The door north is OPEN LET'S GO.";
                }
                break;

            case "go north":
                if (doorropen) {
                    wlibrary = false;
                    wconservatory = true;
                    output = " You left the library. The door slammed and locked behind you. You are now in the conservatory and cannot return to the library.\n Sheesh you should've learned by now.\n In the conservatory you see a trumpet, a piano, and a drum. A music sheet rests nearby. Play a lil sum.";
                }
                break;

            default:
                output = "That's crazy nothing happened.";
        }
    }

    public static void conservatory()  {
        System.out.printf("%s You have %d moves left.\n>>", output, moves);
        scan = new Scanner(System.in);
        String sc = scan.nextLine();

        switch (sc) {
            case "read music":
                output = "'Armstrong, Mozart, McCartney' it reads.";
                break;

            case "play trumpet":
                if (!piano && !drum) {
                    trumpet = true;
                    output = "*TRUMPET NOISE TRUMPET NOISE* Wow just like Armstrong himself.";
                }
                else {
                    output = "Something not right with the trumpet. Sounds weird. Fool.";
                    piano = false;
                    trumpet = false;
                    drum = false;
                }
                break;

            case "play piano":
                if (trumpet && !drum && t<1) {
                    piano = true;
                    output = "*imagine some sick piano sound* just like Mozart.";
                    t=t+1;
                }
                else {
                    output = "Piano just not working. Something's off. C'mon";
                    piano = false;
                    trumpet = false;
                    drum = false;
                    t=0;
                }
                break;

            case "play drum":
                if (trumpet && piano) {
                    drum = true;
                    doorrrlock = false;

                    output = "*PARUMP PARUMP* DrummER BOI like McCartney! WOOOOSH the last door has been unlocked";
                }
                else {
                    output = "That's not the noise of a drum. Perhaps order matters?";
                    drum = false;
                    piano = false;
                    trumpet = false;
                }
                break;

            case "open door":
                if (!doorrrlock) {
                    doorrropen = true;
                    output = "You look outside; and see the beautiful landscape of Los Angeles. What are you waiting for? Get outta here.";
                }
                else {
                    output = "Really. You had to unlock every door until now. Why'd it be different?";
                }
                break;

            case "go north":
                if (doorrropen) {
                    finale = true;
                }


            default:
                output = "That's crazy nothing happened.";
        }
    }
}
