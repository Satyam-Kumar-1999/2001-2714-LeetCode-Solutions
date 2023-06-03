class Solution {
  public List<Integer> maxScoreIndices(int[] nums) {
    final int ones = Arrays.stream(nums).sum();
    final int zeros = nums.length - ones;
    // Division at index 0
    List<Integer> ans = new ArrayList<>(Arrays.asList(0));
    int leftZeros = 0;
    int leftOnes = 0;
    int maxScore = ones; // LeftZeros + rightOnes

    for (int i = 0; i < nums.length; ++i) {
      leftZeros += nums[i] == 0 ? 1 : 0;
      leftOnes += nums[i] == 1 ? 1 : 0;
      final int rightOnes = ones - leftOnes;
      final int score = leftZeros + rightOnes;
      if (maxScore == score) {
        ans.add(i + 1);
      } else if (maxScore < score) {
        maxScore = score;
        ans = new ArrayList<>(Arrays.asList(i + 1));
      }
    }

    return ans;
  }
}
