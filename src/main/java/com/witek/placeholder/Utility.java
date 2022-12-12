package com.witek.placeholder;

import java.util.Arrays;

public class Utility {
        public static int mostFrequent(int[] arr)
        {
            int maxcount = 0;
            int element_having_max_freq = 0;
            for (int i = 0; i < arr.length; i++) {
                int count = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }

                if (count > maxcount) {
                    maxcount = count;
                    element_having_max_freq = arr[i];
                }
            }

            return element_having_max_freq;
        }

        public static int[][][] cloneArray(int[][][] array){
            int[][][] cloned_array = new int[array.length][][];
            for (int i = 0; i < array.length; i++) {
                cloned_array[i] = new int[array[i].length][];
                for (int j = 0; j < array[i].length; j++)
                    cloned_array[i][j] = Arrays.copyOf(array[i][j], array[i][j].length);
            }
            return cloned_array;
        }

}


