import java.util.Random;

public class ArraySorting {
    public static void main(String[] args) {
        int n = 0;
        
        for (int a = 1; a < 11; a++) {

            int[] numbers = generatedRandomNumbers(n); // 生成随机数组

            // 记录开始时间
            double startTime = System.nanoTime();

            // 调用排序方法对数组进行排序
            bubbleSort(numbers);

            // 记录结束时间
            double endTime = System.nanoTime();

            // 打印排序后的数组
            /* for (int num : numbers) {
             System.out.print(num + " ");
             }
*/
            // 计算排序所花费的时间
            double duration = endTime - startTime;
            System.out.println("第" + a + "次， n=" + n + ", 排序所花费的时间：" + duration/1000000 + "毫秒");
            n = n + 1000;
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // 如果当前元素大于下一个元素，则交换它们的位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 生成n个随机数方法的实例化
    public static int[] generatedRandomNumbers(int n) {
        int[] numbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            // 通过for循环，将范围在1~10000的整数写入数组中
            numbers[i] = random.nextInt(10000) + 1;
        }
        return numbers;
    }

}
