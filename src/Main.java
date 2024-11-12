import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * @param nums   输入数组
     * @param target 目标之和
     * @return 返回数组
     */
    static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}