import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomFileCreator implements Runnable
{
    private String mFileName;
    private String[] mRandomWords;

    public RandomFileCreator(String[] randomWords)
    {
        mFileName = null;
        mRandomWords = randomWords;
    }

    public void run()
    {
        try
        {

            Random random = new Random();
            int numberOfWords = random.nextInt(mRandomWords.length);

            PrintWriter out = new PrintWriter("hello-" + random.nextInt(1000) + ".txt");


            for(int i = 0; i < numberOfWords; i++)
            {
                out.print(mRandomWords[random.nextInt(mRandomWords.length)+1] + " ");
            }


            out.close();
        }
        catch(IOException ex){System.out.print("IOException!");}

    }
}
