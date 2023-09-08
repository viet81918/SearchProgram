
package controller;



import Common.Algorithm;
import Common.Library;
import model.Element;
import view.Menu;

/**
 *
 * @author ACER
 */
public class SearchProgram extends Menu<String> {

    static String[] mc = {"Search", "Exit"};

    protected Library library;
    protected Algorithm algorithm;
    protected int[] array;
    protected int size_array;

    public SearchProgram(Element element) {
        super("PROGRAMMING", mc);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
        //1. Enter a possitive number
        //size_array = library.getInt("Enter number of array", 1, 100);
        //2. Create array by generate random integer in range
        //array = library.createArray(size_array);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> search();
            case 2 -> System.exit(0);
        }
    }
        public void search() {
        final String[] mcSearch = {"Linear Search", "Binary Search", "Exit"};
        class SearchMenu extends Menu<String> {

            public SearchMenu() {
                super("Search Option", mcSearch);
            }

            @Override
            public synchronized void execute(int n) {
                algorithm.buddleSort(array);
                switch (n) {
                    case 1 :
                        int value =library.getValueSearch(array);
                        System.out.println("Found value: "+ value + " at index : " + algorithm.linearSearch(array,value));
                        break;
                    case 2 :
                        value =library.getValueSearch(array);
                        System.out.println("Found value: " + value + " at index: " + algorithm.binarySearch(array, value));
                        break;
                    case 3 :
                        System.exit(0);
                        
                }
            }
        }
        SearchMenu sm = new SearchMenu();
        sm.run();
    }
       
}