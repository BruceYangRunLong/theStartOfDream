package communication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PCMEncode {
    private static final double delta = 1.0 / 2048; // Δ的值

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("PCMEncode.txt"));
            String normalizedAmplitude;
            double normalizedAmplitud = 0;
            int i = 0;
            while ((normalizedAmplitude = reader.readLine()) != null) {

                i++;
                System.out.println(
                        "this is the " + i + "th amplitude received\nthe amplitude I get is:" + normalizedAmplitude);

                String encodedSignal = encodeALaw(normalizedAmplitud);

            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        double normalizedAmplitude = 0.2;
        String encodedSignal = encodeALaw(normalizedAmplitude);
        System.out.println("Encoded signal: " + encodedSignal);
    }

    public static String encodeALaw(double normalizedAmplitude) {
        // 确定极性码
        char polarityCode = (normalizedAmplitude >= 0) ? '1' : '0';

        // 归一化抽样信号的绝对值
        double absAmplitude = Math.abs(normalizedAmplitude);

        // 确定大段落码
        char segmentCode;
        if (absAmplitude < 256 * delta) {
            segmentCode = '0'; // 在第0大段
        } else if (absAmplitude < 512 * delta) {
            segmentCode = '1'; // 在第1大段
        } else {
            segmentCode = '1'; // 在第1大段
            absAmplitude = 512 * delta; // 将绝对值限制在第1大段范围内
        }

        // 计算小段内码
        int segment = (int) (absAmplitude / 16 / delta); // 小段号
        int level = (int) ((absAmplitude - segment * 16 * delta) / delta - 0.5); // 小段内偏移

        // 转换为二进制字符串
        String segmentCodeStr = Integer.toBinaryString(segment);
        while (segmentCodeStr.length() < 3) {
            segmentCodeStr = "0" + segmentCodeStr; // 补足3位
        }

        String levelCodeStr = Integer.toBinaryString(level);
        while (levelCodeStr.length() < 4) {
            levelCodeStr = "0" + levelCodeStr; // 补足4位
        }

        // 组合成8位编码
        String encodedSignal = "" + polarityCode + segmentCode + segmentCodeStr + levelCodeStr;

        return encodedSignal;
    }
}
