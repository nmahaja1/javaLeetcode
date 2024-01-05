package com.practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,13};
        int sum = 5;
        int size = arr.length;

        findKeyPair(arr, sum, size);
        usingTwoPointer(arr, sum, size);
    }

    private static void usingTwoPointer(int[] arr, int sum, int size) {
        int[] ans = new int[2];
        int i = 0;
        int j = size - 1;
        while(i < j){
            if(arr[i] + arr[j] == sum){
                ans[0] = i;
                ans[1] = j;
                System.out.println("pair found at index " + ans[0] + " " + ans[1]);
                break;
            }
            else if (arr[i] + arr[j] < sum)
                i++;

            else if (arr[i] + arr[j] > sum)
                j--;
        }

    }


    static void findKeyPair(int[] arr, int sum, int size) {
        Map<Integer, Integer> map1 = new HashMap();
        int i;
        for(i = 0; i<size; i++){
            int delta = sum - arr[i];

            if(map1.containsKey(delta)){
                System.out.println("pair found "+ arr[i] + ", " + delta);
                System.out.println("at index "+ i + ", "+ map1.get(delta));
            }else{
                map1.put(arr[i], i);
            }

        }
        if(i==size){
            System.out.println("no pair exist");
        }

    }
}
