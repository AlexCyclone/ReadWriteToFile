package icu.cyclone.alex;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String filename = "arr.txt";
        File f = new File(filename);
        if (!f.exists()) {
            writeToFile(randArray(), filename);
        }
        printArray(readFromFile(filename));
    }

    private static int[][] randArray() {
        int n = (int) (Math.random() * 100);
        int m = (int) (Math.random() * 100);
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100);
            }
        }
        return arr;
    }

    private static void writeToFile(int[][] arr, String filename) {
        try (PrintWriter a = new PrintWriter(filename)) {
            for (int i = 0; i < arr.length; i++) {
                a.println(Arrays.toString(arr[i]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    private static int[][] readFromFile(String filename) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
            String text;
            while ((text = br.readLine()) != null) {
                int[] arr = strToIntArr(text);
                if (arr != null) {
                    arrayList.add(arr);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        int[][] result = new int[arrayList.size()][];
        arrayList.toArray(result);
        return result;
    }

    private static int[] strToIntArr(String text) {
        if (text.length() == 0 || (text.charAt(0) != '[' && text.charAt(text.length() - 1) != ']')) {
            return null;
        }
        String[] sArr = text.substring(1, text.length() - 1).split(", ");
        int[] iArr = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            iArr[i] = Integer.parseInt(sArr[i]);
        }
        return iArr;
    }

    private static void printArray(int[][] arr) {
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }
}
