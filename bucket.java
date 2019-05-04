
import java.util.ArrayList;
import java.util.Collections;

/**
 * @auther tl
 * @create 2019-05-02 16:35
 */
public class bucket {
    public static void bucketSort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        //桶数
        int bucketNum = (max - min) / array.length + 1;
        ArrayList<ArrayList<Integer>> bucketarray = new ArrayList<ArrayList<Integer>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketarray.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for (int i = 0; i < array.length; i++) {
            int num = (array[i] - min) / (array.length);
            bucketarray.get(num).add(array[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketarray.size(); i++) {
            Collections.sort(bucketarray.get(i));
        }

        System.out.println(bucketarray.toString());
    }

    public static void main(String[] args) {
        int[] array = new int[]{11, 32, 63, 6, 3, 3, 1};
        bucketSort(array);
    }
}
