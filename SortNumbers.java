
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortNumbers {
   
    // 标记开始的时间
    public static double startTime = System.nanoTime();

    public static void main(String[] args) {
        double middleTime = 0; // 初始化并归零用户输入时所用时间

        int n = 0; // 初始化要从键盘上获得的 n

        // 从键盘上获取用户输入的个数n, 并考虑到n<=0的情况
        for (; n <= 0;) {

            System.out.println("Please input the amount of random numbers you want.");

            double inputTime = System.currentTimeMillis();

            Scanner sc = new Scanner(System.in); // 获取用户的输入值
            n = sc.nextInt(); // 将用户输入的个数赋值给n

            // 记录用户输入时所用时间，以便最后除去
            inputTime = System.currentTimeMillis() - inputTime;
            middleTime += inputTime;
            inputTime = 0;

            // 如果n<=0, 则提示输入错误，并自动重新开始
            if (n <= 0) {
                System.out.println("Wrong:the amount of random numbers you want is null.");
                System.out.println("try again");
            }
        }

        int[] numbers = generatedRandomNumbers(n); // 生成随机数组

        // 排序数字
        System.out.println("Arrays without ordering: " + Arrays.toString(numbers));
        sortNumbers(numbers);
        System.out.println("Arrays after ordering0: " + Arrays.toString(numbers));

        // 输出运行所用的时间
        System.out.println("the time is " + myTimer(startTime, middleTime));
    }

    // 生成n个随机数方法的实例化
    public static int[] generatedRandomNumbers(int n) {
        int[] numbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            //通过for循环，将范围在1~10000的整数写入数组中
            numbers[i] = random.nextInt(10000) + 1;
        }
        return numbers;
    }

    // 排序数组方法的实例化
    public static void sortNumbers(int[] numbers) {
        Arrays.sort(numbers);
    }

    
    // 运行时间计算
    public static double myTimer(double startTime, double middleTime) {
        double t = 0;
        double currentTime = System.nanoTime();
        //末时间减去初始时间，由于计时单位是纳秒，考虑到实际情况，除以一百万，以毫秒表示
        t = (currentTime - startTime - middleTime)/1000000;
        return t;
    }
}
