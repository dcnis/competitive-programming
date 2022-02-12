package leetcode.greedy;

/*
*
* */
public class JumpGameI {

    /* 434ms */
    public boolean canJumpWithDP(int[] nums) {
        int[] memo = new int[nums.length];
        return canJumpStartingFrom(nums, 0, memo);
    }

    private boolean canJumpStartingFrom(int[] nums, int n, int[] memo){

        if(n >= nums.length-1){
            return true;
        }

        if(memo[n] == 1){
            return true;
        } else if (memo[n] == -1){
            return false;
        }

        boolean minOneTrue = false;

        for(int i = 0; i < nums[n]; i++){
            boolean res = canJumpStartingFrom(nums, n+i+1, memo);
            if(res){
                minOneTrue = true;
                break;
            }
        }

        if(minOneTrue){
            memo[n] = 1;
        } else {
            memo[n] = -1;
        }

        return minOneTrue;
    }

    /* 2ms */
    public boolean canJumpGreedy(int[] nums) {
        int farthest = 0;
        for (int i = 0; i <= farthest && i < nums.length; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
        }
        return farthest >= nums.length - 1;
    }

}
