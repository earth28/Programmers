class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int index, int sum) {
        // 종료 조건
        if (index == numbers.length) {
            return (sum == target) ? 1 : 0;
        }
        
        // +, - 두 가지 경우 탐색
        int plus = dfs(numbers, target, index + 1, sum + numbers[index]);
        int minus = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        return plus + minus;
    }
}
