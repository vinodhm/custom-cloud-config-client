package com.vino.pricing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class TestClass {
    public static void main(String[] args){
    String  s = "vin.test";
        System.out.println("ttttttttt::"+s.lastIndexOf("vin."));

        String[] ar=s.split("vin.");
        for (String ss : ar){
            System.out.println("dddddddd:"+ss);
        }
    }

   /* static Map<Integer, Long> sockMerchant(int n, int[] ar) {

        return IntStream.of(ar).collect(groupingBy(num -> num, counting())).
                *//*.collect(Collectors.toConcurrentMap(i->i, i->1,Integer::sum)
                        .combiner().*//*


    }*/
}
