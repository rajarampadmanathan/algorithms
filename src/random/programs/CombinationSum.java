package random.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		// List<List<Integer>> result= cs.combinationSum(new int[] {1,2}, 4);
		// List<List<Integer>> result= cs.combinationSum(new int[] {4,2,8}, 8);
		List<List<Integer>> result = cs.combinationSum(new int[] { 2,  4 }, 6);
		result.forEach((s) -> {
			System.out.println();
			s.forEach(System.out::print);
		});
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (int i = 0; i < candidates.length; i++) {
			if (candidates[i] == target) {
				List<Integer> combination = List.of(candidates[i]);
				results.add(combination);
			} else if (candidates[i] < target) {
				List<Integer> combination = new ArrayList<Integer>();
				combination.add(candidates[i]);
				int sum = candidates[i];
				sum = checkRecursively(candidates, results, combination, sum, target, i);
			}
		}
		return results;
	}

	private int checkRecursively(int[] candidates, List<List<Integer>> results, List<Integer> combination, int sum,
			int target, int index) {
		System.out.println(index);
		for (int i = index; i < candidates.length; i++) {
			if (sum + candidates[i] == target) {
				combination.add(candidates[i]);
				System.out.println(Arrays.asList(combination));
				results.add(combination);
				return sum + candidates[i];
			} else if (candidates[i] + sum < target) {
				List<Integer> combinationCpy = new ArrayList<Integer>(combination);
				combinationCpy.add(candidates[i]);
				checkRecursively(candidates, results, combinationCpy, sum + candidates[i], target, i);

			}
		}
		return sum;
	}

}
