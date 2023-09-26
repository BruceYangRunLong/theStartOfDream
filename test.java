public class test {

    public static void main(String[] args) {

        int m  = 0;

        for (int a = 0; a < 4; a++) {
            m = m +5;
            double startTime = System.nanoTime();// 标记开始的时间


            int sum = 0;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < i * i; j++) {
                    if (j % i == 0) {
                        for (int k = 0; k < j; k++) {
                            sum++;
                        }
                    }
                }
            }
            

            
            





            double t=myTimer(startTime);
            int b=a+1;
            System.out.println("第"+b+"次， n="+m+", 所用时间是： " + t+"毫秒"+sum);
        }
    }

    // 运行时间计算
    public static double myTimer(double startTime) {
        double t = 0;
        double currentTime = System.nanoTime();
        t = (currentTime - startTime) / 1000000;
        return t;
    }
}
