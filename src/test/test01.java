package test;

/**
 * @author ：XiaoYu
 * @date ：2023/2/5 20:15
 * @version: :1.0
 * :
 */
public class test01 {

    public static void main(String[] args) {

        int[] k = {1, 2, 3, 5, 6, 7, 10, 45, 55, 123};
        int i = new test01().search(k, 100);
        System.out.println(i);

    }

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }

        return -1;
    }


}
