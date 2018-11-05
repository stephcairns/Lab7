import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Lab 07
 */
public class Lab7 {




    /** TODO 1: Use Threads to create 3 files on the Desktop

        Create a class called RandomFileCreator that implements Runnable

        In main of the Lab7 class create 3 RandomFileCreator objects and use threads to run them so that they
        write out random information into a file that will live in the current working directory

        The random data might be a bunch of randomly selected words from an array of Strings for instance:

        String[] OneMillionMonkeys
         = { "But", "it's", "all", "right", "I'm", "jumping", "jack", "flash", "it's", "a", "gas"};

        Then you could use a random number of random ints to select some words to write to the file.

        The names of the file created by your RandomFileCreator class should contain a random element but should follow
        some pattern for example:
        hello-random-number.txt or similar

     **/


    /** TODO 2: Use Threads to count the words in each File
     *
     * Using the Files class and Threads find and count all of the words in each of the above files you created
     * You should use Files (and Streams) to visit all files in the working directory matching your above pattern for names
     *
     * For each file that you created previously, launch a Thread to count the words in the File
     *
     * You can simply print out the total count for each file to the Screen
     *
     * You can create another class that implements Runnable to achieve this task
     *
     */


    /** TODO 3: Use a single variable to keep track of the total word counts
     *  Modify Step 2 above to keep track of the total word counts of all files in a single variable contained in the
     *  Lab7 class
     *
     *  You'll need an object to hold the single variable.
     *
     *  Create a Lab 7 object and pass it to version 2 of your class that counts words in files using threads.
     *
     *  add a method to Lab7 called addToTotal and ensure it uses a Lock to ensure no synchronization problems
     *
     *  Recall a Lock can be created (within the Lab7 class as:
     *
     *  Lock mLock;
     *
     *  mLock = new ReentrantLock()
     *
     */


    public static void main(String [] args) throws IOException
    {

        //Task 1:

        String[] random = { "But", "it's", "all", "right", "I'm", "jumping", "jack", "flash", "it's", "a", "gas"};

        RandomFileCreator randomFile1 = new RandomFileCreator(random);
        RandomFileCreator randomFile2 = new RandomFileCreator(random);
        RandomFileCreator randomFile3 = new RandomFileCreator(random);

        Thread t1 = new Thread(randomFile1);
        Thread t2 = new Thread(randomFile1);
        Thread t3 = new Thread(randomFile1);

        t1.start();
        t2.start();
        t3.start();


        //Task2:

        Files.list(Paths.get(""))
                .filter(s -> s.getFileName().toString().contains("hello-"))
                .forEach(s -> new Thread(new WordCounter(s)).start());




        //Task3:

    }

    public int addTotal()
    {
        return 0;
    }

}
