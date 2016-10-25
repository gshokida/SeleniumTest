/**
 * Created by german.shokida on 25/10/2016.
 */
import utils.GoogleTest;
import utils.OpenCart2Test;

public class Program {
    public static void main ( String [] arguments )
    {
        GoogleTest test = new GoogleTest();

        try {

            test.setUp();

            test.testGoogle();

            test.tearDown();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Hello, world");
    }
}
