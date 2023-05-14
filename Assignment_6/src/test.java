import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 4, 1, 2, 3, 4, 1}; // Replace with your set of elements
        List<List<Integer>> permutations = permute(elements);
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
            HashTable
        }
    }

    public static List<List<Integer>> permute(int[] elements) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), elements);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> currentPermutation, int[] elements) {
        if (currentPermutation.size() == elements.length) {
            result.add(new ArrayList<>(currentPermutation));
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (currentPermutation.contains(elements[i])) {
                    continue; // Skip if the element is already chosen
                }
                currentPermutation.add(elements[i]);
                backtrack(result, currentPermutation, elements);
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }
}
