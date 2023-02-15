import menu.StringList;
import menu.StringListImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringList list = new StringListImpl(1);

        list.add("gog");
        list.add("steam");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");
        list.add("epic");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}