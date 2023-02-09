package test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：XiaoYu
 * @date ：2023/2/9 21:43
 * @version: :1.0
 * :  练习迭代器和增强for
 */


public class CollectionTest {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        List list1 = new ArrayList<Dog>();
        list1.add( new Dog("德牧", 12));
        list1.add( new Dog("边牧", 6));
        list1.add(new Dog("秋田", 8));

        for (Object o : list1) {
            System.out.println(o);
        }

        List list2 = new ArrayList<Dog>();
        list2.addAll(list1);

        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);

        }


    }


}



