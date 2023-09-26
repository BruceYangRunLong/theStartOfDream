package communication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PCMDecode {
    private static final double delta = 1.0 / 2048; // Δ的值

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("PCM.txt"));
            String encodedSignal;
            int i = 0;
            while ((encodedSignal = reader.readLine()) != null) {
                i++;
                System.out.println("this is the "+i+"th code received\nthe Decoded amplitude I get is:"+ encodedSignal);

                double decodedAmplitude = decodeALaw(encodedSignal);
                char polarityCode = encodedSignal.charAt(0);
                
                if (polarityCode == '1') {
                    System.out.println("So its encoded signal is:\n\t\t +" + decodedAmplitude + "Δ  or +"+ decodedAmplitude*delta+"\n");
                } else {
                    System.out.println("So its Decoded amplitude is:\n\t\t -" + decodedAmplitude + "Δ  or -"+ decodedAmplitude*delta+"\n");
                }

            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static double decodeALaw(String encodedSignal) {
        // 解析极性码、段落码和电平码
        char polarityCode = encodedSignal.charAt(0);
        String segmentCode = encodedSignal.substring(1, 4);
        String levelCode = encodedSignal.substring(4);

        // 确定极性
        boolean isPositive = polarityCode == '1';

        // 确定抽样信号所处的大段落和小段内

        int segment = (Integer.parseInt(segmentCode, 2) + 1);
        int segmentNode = 0;
        int levelNode = 0;
        switch (segment) {
            case 1:
                segmentNode = 16;
                levelNode = 1;
                break;
            case 2:
                segmentNode = 16;
                levelNode = 1;
                break;
            case 3:
                segmentNode = 32;
                levelNode = 2;
                break;
            case 4:
                segmentNode = 64;
                levelNode = 4;
                break;
            case 5:
                segmentNode = 128;
                levelNode = 8;
                break;
            case 6:
                segmentNode = 256;
                levelNode = 16;
                break;
            case 7:
                segmentNode = 512;
                levelNode = 32;
                break;
            case 8:
                segmentNode = 1024;
                levelNode = 64;
                break;
            default:
                System.out.println("mitstake,segmentNode out of boundary.");

        }
        int level = (Integer.parseInt(levelCode, 2) + 1);

        // System.out.println(segmentNode);
        // 计算解码结果
        double decodedAmplitude;
        
        decodedAmplitude = segmentNode + (level - 1 + 0.5) * levelNode;

        // 归一化
        // decodedAmplitude *= delta;

        return decodedAmplitude;
    }
}
