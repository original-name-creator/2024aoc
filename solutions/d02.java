package solutions;

import java.io.File;
import java.util.Scanner;

public class d02 {
    public static void main(String[] args) throws Throwable{
        part1();
        part2();
    }


    public static void part1() throws Throwable{
        Scanner input = new Scanner(new File("inputs\\d02p01.txt"));
        int[] levels = new int[5];
        int totalSafe = 0;

        while(input.hasNextLine()){
            for (int i = 0; i < levels.length; i++) {
                levels[i] = input.nextInt();
            }
            if((increasing(levels) || decreasing(levels)) && notExtreme(levels)){
                totalSafe++;
            }
        }
        System.out.println(totalSafe);
    }

    public static boolean increasing(int[] levels){
        for (int i = 1; i < levels.length; i++) {
            if(levels[i-1] > levels[i]) return false;
        }
        return true;
    }

    public static boolean decreasing(int[] levels){
        for (int i = 1; i < levels.length; i++) {
            if(levels[i-1] < levels[i]) return false;
        }
        return true;
    }

    public static boolean notExtreme(int[] levels){
        for (int i = 1; i < levels.length; i++) {
            if(Math.abs(levels[i-1] - levels[i]) > 3) return false;
        }
        return true;
    }


    public static void part2(){}

}
