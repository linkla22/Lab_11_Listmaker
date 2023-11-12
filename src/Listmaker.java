
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Listmaker {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean running = true;
        final String menuPrompt = " A - Add an Item D - Delete an item P - Print (i.e. display) Q- Quit ";
        final String quitPrompt = "List is stored in memory and will disappear when you exit the program\n"
                + "Are you sure you want to Quit?";
        String rec = "";
        String userCmd = "";
        String quitYNResp = "";
        int userSelectedDex = -1;
        int convertedDex = -1;
        do {
            displayMenu();
            userCmd = SafeInput.getRegExString(console, menuPrompt, "[AaDdPpQq]");
            switch (userCmd) {
                case "A":
                case "B":
                    displaySelectorList();
                    rec = SafeInput.getNonZeroLengthString(console, "Enter your new List item:");
                    list.add(rec);
                    System.out.println("\nDebug:rec added" + rec);
                    break;
                case "D":
                case "d":
                    if (list.size() > 0)
                {
                    displaySelectorList();
                    userSelectedDex = SafeInput.getRangedInt(console, "\n"
                            + "Enter the # for the item to delete", 1, list.size());
                    convertedDex = userSelectedDex - 1;
                    list.remove(convertedDex);
                }
                    else
                {
                    System.out.println("No items in the list to delete!");
                }
                break;
                case "p":
                    displaySelectorList();
                    break;
                case "Q":
                case "q":
                    if (SafeInput.getYNConfirm(console, quitPrompt)) ;
                {
                    System.out.println("Thank you for running listmaker!");
                    System.exit(0);

                }
                break;


                default:


            }
        }while(running);
    }

        private static void displayMenu ()
        {
            String menuBar = "\n++";
            displaySelectorList();
            System.out.println(menuBar);
        }


        private static void displayList ()
        {
            if (list.size() < 0)
            {
                for(int i = 0; i < list.size(); i++) {
                    System.out.printf("%-35s\n", list.get( i ));
                }
            } else
                System.out.println("\n[List is empty!]\n");
        }

        private static void displaySelectorList() {
            System.out.println("debug running display selector list:");
            if (list.size() > 0) {
                for (int i = 1; i <= list.size(); i++) {
                    System.out.printf("%3d\t%-35s\n", i, list.get(i - 1));

                }
            } else
                System.out.println("\n[List is empty!]\n");

        }
    }












