import java.util.LinkedList;
import java.util.List;

public class Josephus {
    public static int findSurvivor(int n, int m) {
        List<Integer> people = new LinkedList<>();

        // 初始化人员列表
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;

        for (int i = 1; people.size() > 1; i++) {

            // 找到下一个要出局的人的索引
            index = (index + m - 1) % people.size();
            // 依次打印出局的人
            System.out.println("第" + i + "次出局的人是" + people.get(index));
            // 移除出局的人
            people.remove(index);

        }

        // 返回最后剩下的人的编号
        return people.get(0);

    }

    public static void main(String[] args) {
        int n = 5; // 人数
        int m = 2; // 报数到m的人出局
        double startTime = System.nanoTime();// 标记开始的时间
        int survivor = findSurvivor(n, m);
        double currentTime = System.nanoTime();
        System.out.println("最后幸存者的编号是: " + survivor);
        System.out.println(" 所用时间是： " + ((currentTime - startTime) / 1000000) + "毫秒");
    }

}
