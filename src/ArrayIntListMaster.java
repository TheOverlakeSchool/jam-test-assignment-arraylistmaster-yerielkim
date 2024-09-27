//import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ArrayIntListMaster {


    public static void main(String[] args) {
        boolean completed = false;
        ArrayIntList valuesList = new ArrayIntList();
        Scanner userSelector = new Scanner(System.in);
        String userSelection;
        // As long as you haven't noted to quit
        while (!(completed)) {
            // List all options
            System.out.println("Would you like to \n" +
                    "\'A\' to add to the end.\n" +
                    "\'I\' to insert in the middle.\n" +
                    "\'D\' to delete a value.\n" +
                    "\'P\' to print all of the values.\n" +
                    "\'Q\' to quit.\n");
            // Take in an option from the user
            userSelection = userSelector.next();
            userSelector.nextLine();
            // If "A", call the add method
            if (userSelection.equals("A"))
                addToArrayList(valuesList, userSelector);

            // If "I", call the insert method
            if (userSelection.equals("I"))
                insertIntoArrayList(valuesList, userSelector);

            // If"D", call the delete method
            if (userSelection.equals("D"))
                deleteFromArrayList(valuesList, userSelector);

            // If "P", call the print method
            if (userSelection.equals("P"))
                printArrayList(valuesList);
            // If "Q"
            if (userSelection.equals("Q"))
                completed = true;
        }
        userSelector.close();
        System.exit(0);
    }

    public static void printArrayList(ArrayIntList valuesList) {
        System.out.println(valuesList);
    }

    public static void addToArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("What value would you like to add?");
        int newValue = userSelector.nextInt();
        userSelector.nextLine();
        valuesList.add(newValue);
    }

    public static void deleteFromArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("Which index would you like to delete from?");
        int newSpot = userSelector.nextInt();
        userSelector.nextLine();
        if ((newSpot >= 0) && (newSpot < valuesList.size()))
            valuesList.remove(newSpot);
        else
            System.out.println("Invalid index received; no change");
    }

    public static void insertIntoArrayList(ArrayIntList valuesList, Scanner userSelector) {
        System.out.println("At which index would you like to insert a value?");
        int newSpot = userSelector.nextInt();
        userSelector.nextLine();
        if ((newSpot >= 0) && (newSpot <= valuesList.size()))
        {
            System.out.println("What value would you like to add?");
            int newValue = userSelector.nextInt();
            userSelector.nextLine();
            valuesList.add(newSpot, newValue);
        }
        else
        System.out.println("Invalid index received; no change");
    }
}


class ArrayIntList{
    private int[] content;
    private final int DEFAULT_SIZE = 10;
    private int currentLength;
    public ArrayIntList(){
        content = new int[DEFAULT_SIZE];
        currentLength = 0;
    }

    public void add(int newValue){
        if(content.length == currentLength){
            int[] arraytwo = new int[content.length*2];
            for(int i = 0; i < content.length; i++){
                arraytwo[i] = content[i];
            }
            content = arraytwo;
        }
        content[currentLength] = newValue;
        currentLength++;
    }

    public void add(int newSpot, int newValue){
        if(content.length == currentLength){
            int[] arraytwo = new int[content.length*2];
            for(int i = 0; i < content.length; i++){
                arraytwo[i] = content[i];
            }
            content = arraytwo;
        }
        for(int i = currentLength - 1; i > newSpot; i--){
            content[i] = content[i - 1];
        }
        content[newSpot] = newValue;
        currentLength++;
    }

    public void remove(int newSpot){
        for(int i = currentLength-1; i > newSpot; i++){
            content[i - 1] = content[i];
        }
        content[newSpot] = 0;
    }

    public int size(){
        return currentLength;
    }

    public String toString(){
        String intList = "";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < content.length; i++){
            sb.append(content[i]);
        }
        sb.append("]");
        return sb.toString();
    }


}