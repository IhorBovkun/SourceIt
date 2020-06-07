package hw8_Multithreading;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Part2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{'\n'});
        Spam.main(new String[] {});
        TimeUnit.SECONDS.sleep(1);
        System.setIn(bais);
    }
}