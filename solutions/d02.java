package solutions;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class d02 {
    public static void main(String[] args) throws Throwable{
        part1();
        part2();
    }


    public static void part1() throws Throwable{
        Scanner input = new Scanner(new File("inputs\\d02p01.txt"));
        int totalSafe = 0;
        Scanner line;

        while(input.hasNextLine()){
            line = new Scanner(input.nextLine());
            ArrayList<Integer> levels = new ArrayList<Integer>();
            while(line.hasNext()){
                levels.add(line.nextInt());
            }
            if((increasing(levels) || decreasing(levels)) && notExtreme(levels)){
                totalSafe++;
            }
        }
        System.out.println(totalSafe);

        input.close();
    }

    public static boolean increasing(ArrayList<Integer> levels){
        for (int i = 1; i < levels.size(); i++) {
            if(levels.get(i-1) > levels.get(i)) return false;
        }
        return true;
    }

    public static boolean decreasing(ArrayList<Integer> levels){
        for (int i = 1; i < levels.size(); i++) {
            if(levels.get(i-1) < levels.get(i)) return false;
        }
        return true;
    }

    public static boolean notExtreme(ArrayList<Integer> levels){
        for (int i = 1; i < levels.size(); i++) {
            if(Math.abs(levels.get(i-1) - levels.get(i)) > 3 ||Math.abs(levels.get(i-1) - levels.get(i)) < 1) return false;
        }
        return true;
    }


    public static void part2() throws Throwable{


        Scanner input = new Scanner(new File("inputs\\d02p01.txt"));
        int totalSafe = 0;
        Scanner line;

        while(input.hasNextLine()){
            line = new Scanner(input.nextLine());
            ArrayList<Integer> levels = new ArrayList<Integer>();
            while(line.hasNext()){
                levels.add(line.nextInt());
            }
            if(safe(levels)) totalSafe++;
        }

        System.out.println(totalSafe);

    }

    public static boolean safe(ArrayList<Integer> levels){
            for (int i = 0; i < levels.size(); i++) {
                ArrayList<Integer> tempList = new ArrayList<>(levels);
                tempList.remove(i);
                if(isSafe(tempList)) return true;
            }
            return false;
    }

    public static boolean isSafe(ArrayList<Integer> levels){
        if((increasing(levels) || decreasing(levels)) && notExtreme(levels)){
            return true;
        }
        return false;
    }


}
