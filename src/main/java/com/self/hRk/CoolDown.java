package com.self.hRk;

import java.util.*;

public class CoolDown {

    public static int getProcessingTime(List<String> tasks, Map<String, Integer> cooldownmap) {

        Map<String, Integer> timeSlot = new HashMap<>();
        int result = 0;
        int taskIndex = 0;

        while ( taskIndex < tasks.size() ) {
            String task = tasks.get(taskIndex);
            Integer occurance = timeSlot.get(task);
            if ( occurance == null || result - occurance > cooldownmap.get(task) ) {
                timeSlot.put(task, result);
                taskIndex++;
            }
            result++;
        }

        return result;
    }
    static int maximumToys(int[] prices, int k) {
        int result = 0;
        int paiso = 0;
        Arrays.sort(prices);
        for(int pr = 0;pr < prices.length;pr++){
            if(paiso < k){
                paiso += prices[pr];
                result++;
            }else{
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Map<String, Integer> coolDownPeriod = new HashMap<>();
        coolDownPeriod.put("A",3);
        coolDownPeriod.put("B",2);
        coolDownPeriod.put("C",1);
        coolDownPeriod.put("D",2);
        List<String> l = new ArrayList<String>();
        l.add("A");
        l.add("A");
        l.add("A");
        //l.add("B");
        int slots = getProcessingTime(l, coolDownPeriod);
        System.out.println(slots); //Answer is 6

    }

}
