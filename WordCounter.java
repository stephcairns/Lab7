import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class WordCounter implements Runnable
{
    private Path mPath;

    public WordCounter(Path p)
    {
        mPath = p;
    }

    @Override
    public void run()
    {
        try {
            int count = Files.lines(mPath).mapToInt(p->p.split(" ").length).sum();
            System.out.println("Count for " + mPath.getFileName().toString() + ": " + count);
        }
        catch(IOException ex){}
    }
}
