package test.collection;

/**
 * @author ：XiaoYu
 * @date ：2023/2/9 21:44
 * @version: :1.0
 * :
 */
public class Dog {
   private String name;
   private int age;

   public Dog() {
   }

   public Dog(String name, int age) {
      this.name = name;
      this.age = age;
   }

   @Override
   public String toString() {
      return "Dog{" +
              "name='" + name + '\'' +
              ", age=" + age +
              '}';
   }
}
