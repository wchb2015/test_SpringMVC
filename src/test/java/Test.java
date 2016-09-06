import java.util.ArrayList;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test01() {
        StringBuilder mobileNumbers = new StringBuilder();
        List<String> list = new ArrayList<String>();
        list.add("1111");
        list.add("2222");
        list.add("3333");
        list.add("4444");
        list.add("5555");
        list.add("6666");
        list.add("7777");
        list.add("8888");
        list.add("9999");
        list.add("1000");
        list.add("1001");
        list.add("1002");
        list.add("1003");

        int count = 0;
        for (String s : list) {
            if (count != 0) {
                mobileNumbers.append(",");
            }
            mobileNumbers.append(s);

            count++;
            if (count % 2 == 0) {
                count = 0;
                System.out.println(mobileNumbers.toString());
                mobileNumbers = new StringBuilder();
            }
        }

        if (count != 0) {
            System.out.println(mobileNumbers.toString());
        }
    }
}
