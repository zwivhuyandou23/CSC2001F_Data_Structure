import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Optimize extends LPHashTable {
    public static void main(String[] args) throws IOException {
        int[] elements = {1, 2, 3, 4, 1, 2, 3, 4, 1};
        List<List<Integer>> permutations = permute(elements);
        int noOfWeightsWithLowProbeCount = 0;
        int minProbeCount = 1000;
        for (List<Integer> permutation : permutations) {
            
            
            LPHashTable table = makeTable(37);
            int[] array = permutation.stream().mapToInt(Integer::intValue).toArray();

           // System.out.println(array.toString());

            table.setWeights(array);
            

            BufferedReader fileIn = new BufferedReader( new FileReader("mydata.txt"));
            String a = fileIn.readLine();
            
            
                    while (a != null)
                    {
                        table.insert(a);
                       // System.out.println(a);
                        a = fileIn.readLine();
                    }
                    
                if(minProbeCount>table.getProbeCount())
                {
                    minProbeCount = table.getProbeCount();
                    noOfWeightsWithLowProbeCount = 0;
                }
                if(minProbeCount == table.getProbeCount())
                {
                    noOfWeightsWithLowProbeCount++;
                }
               // System.out.println(minProbeCount+" "+noOfWeightsWithLowProbeCount);
               
               
            fileIn.close();
        }
        System.out.println(minProbeCount+" "+noOfWeightsWithLowProbeCount);
    }

    protected static LPHashTable makeTable(final int size) {
        return new LPHashTable(size);
    }

    public static List<List<Integer>> permute(int[] elements) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[elements.length]; // Track elements that have been used in the current permutation
        backtrack(result, new ArrayList<>(), elements, used);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> currentPermutation, int[] elements, boolean[] used) {
        if (currentPermutation.size() == elements.length) {
            result.add(new ArrayList<>(currentPermutation)); // Found a complete permutation, add it to the result
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (used[i]) {
                    continue; // Skip if the element is already used
                }
                currentPermutation.add(elements[i]); // Add the element to the current permutation
                used[i] = true; // Mark the element as used
                backtrack(result, currentPermutation, elements, used); // Recursively find the remaining elements
                currentPermutation.remove(currentPermutation.size() - 1); // Remove the last added element
                used[i] = false; // Mark the element as unused (backtrack)
            }
        }
    }
}
