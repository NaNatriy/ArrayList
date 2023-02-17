import intg.IntegerList;
import intg.IntegerListImpl;
import menu.StringList;
import menu.StringListImpl;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl(1);
        IntegerList integerList = new IntegerListImpl(100000);

        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int randomInt = random.nextInt(100000);
            integerList.add(randomInt);
        }



//        long start = System.currentTimeMillis();
//        System.out.println(System.currentTimeMillis() - start);

    }




}