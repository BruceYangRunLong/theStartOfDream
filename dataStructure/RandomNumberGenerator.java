package communication;

import java.io.*;
import java.util.Random;

public class RandomNumberGenerator {

    private static final int NUM_GENERATIONS = 10;
    private static final int NUM_VALUES = 8;

    public static void main(String[] args) {
        generateRandomNumbers();
        processNumbers();
    }

    private static void generateRandomNumbers() {
        // try {
        //     FileWriter fileWriter = new FileWriter("numbers.txt", true);
        //     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        //     for (int i = 0; i < NUM_GENERATIONS; i++) {
        //         StringBuilder stringBuilder = new StringBuilder();

        //         for (int j = 0; j < NUM_VALUES; j++) {
        //             int randomNumber = getRandomNumber();
        //             stringBuilder.append(randomNumber).append(" ");
        //         }

        //         bufferedWriter.write(stringBuilder.toString());
        //         bufferedWriter.newLine();
        //     }

        //     bufferedWriter.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        System.out.println("cesh ");
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(2);
    }

    private static void processNumbers() {
        try {
            File file = new File("numbers.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] numbers = line.trim().split(" ");
                StringBuilder processedNumbers = new StringBuilder();

                for (int i = 0; i < NUM_VALUES; i++) {
                    int number = Integer.parseInt(numbers[i]);

                    processedNumbers.append(number).append(" ");
                }

                System.out.println("Processed numbers: " +
                        processedNumbers.toString().trim());

                clearLineFromFile(file);
                writeDoubledNumbersToFile(file, processedNumbers.toString().trim());
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clearLineFromFile(File file) {
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            long length = raf.length() - 1;
            byte b;
            do {
                length -= 1;
                raf.seek(length);
                b = raf.readByte();
            } while (b != 10);

            raf.setLength(length + 1);
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDoubledNumbersToFile(File file, String numbers) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String[] numberArray = numbers.trim().split(" ");
            StringBuilder doubledNumbers = new StringBuilder();

            for (String number : numberArray) {
                int doubledNumber = Integer.parseInt(number) * 2;
                doubledNumbers.append(doubledNumber).append(" ");
            }

            bufferedWriter.write(doubledNumbers.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
