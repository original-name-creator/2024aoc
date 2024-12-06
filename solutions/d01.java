package solutions;

import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;

public class d01 {
    public static void main(String[] args) throws Throwable{
        part1();
        part2();
    }



    static void part1() throws Exception{
        Scanner input = new Scanner(new File("inputs\\d01p01.txt"));
        PriorityQueue<Integer> leftList = new PriorityQueue<>();
        PriorityQueue<Integer> rightList = new PriorityQueue<>();
        
        while(input.hasNextLine()){
            leftList.add(input.nextInt());
            rightList.add(input.nextInt());
        }

        int diff = 0;

        while(!leftList.isEmpty()){
            diff += Math.abs(leftList.poll()-rightList.poll());
        }
        
        System.out.println("Part 1: " + diff);
    }


    static void part2() throws Throwable{
        Scanner input = new Scanner(new File("inputs\\d01p01.txt"));
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> leftList = new ArrayList<Integer>();
        PriorityQueue<Integer> rightList = new PriorityQueue<>();

        while(input.hasNextLine()){
            leftList.add(input.nextInt());
            rightList.add(input.nextInt());
        }

        for (int i = 0; i < leftList.size(); i++) {
            if(!freqMap.containsKey(leftList.get(i))) freqMap.put(leftList.get(i), 0);
        }

        while (!rightList.isEmpty()) {
            int key = rightList.poll();
            if(freqMap.containsKey(key)){
                int temp = freqMap.get(key) + 1;
                freqMap.replace(key, temp);
            }
        }

        BigInteger tot = new BigInteger("0");
        for (int i = 0; i < leftList.size(); i++) {
            long temp = leftList.get(i) * freqMap.get(leftList.get(i));
            tot = tot.add(new BigInteger(Long.toString(temp)));
        }

        System.out.println("Part 2: " + tot);

    }

    

}
