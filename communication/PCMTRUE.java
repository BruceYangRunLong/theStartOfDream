package communication;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class PCMTRUE {
    // 如果用一个不存在的文件构造 Scanner 可能会抛出I/O异常

    public static void main(String[] args) throws IOException {
        // File 类是一个代表文件或目录的类,通常使用路径来初始化,允许使用绝对路径和相对路径
        // 此处使用相对路径
        File file = new File("PCM.txt");

        if (file.exists()) {
            System.out.println("file already exist.");
            // System.exit(0);
        }

        randonNumberMaker(file);

    }

    public static void randonNumberMaker(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file, true); // 第二个参数为true，表示追加模式
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int a = 5; a >= 1; a--) {
                for (int b = 8; b >= 1; b--) {
                    Random random = new Random();

                    int randomNumber = random.nextInt(2);
                    bufferedWriter.write(randomNumber);
                }
                bufferedWriter.write(" ");
            }

            fileWriter.close();
            bufferedWriter.close();
            // System.out.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
