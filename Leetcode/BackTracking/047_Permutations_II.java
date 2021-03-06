public class Solution {
    // O(n * n!) time:
    // 如果是add前去重, 解的个数还是n!
    // 解的个数: n!, 每个解的长度: n, 故 O(n * n!) running time
    // 但即便是循环去重, worset case 还是nums无dups, 为O(n * n!)

    // O(n) space:
    // one n for recursion stack
    // one n for status bool array
    // one n for created new linked list 
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return ret;
        List<Integer> path = new LinkedList<Integer>();
        Arrays.sort(nums);
        boolean[] status = new boolean[nums.length];
        doDFS(nums, status, path, ret);
        return ret;
    }
    
    private void doDFS(int[] nums, boolean[] status, List<Integer> path, List<List<Integer>> ret){
        if(path.size() == nums.length){
            List<Integer> list = new LinkedList<Integer>(path);
            ret.add(list);
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && status[i-1] == false)
                continue;
            if(!status[i]){
                status[i] = true;
                path.add(nums[i]);
                doDFS(nums, status, path, ret);
                path.remove(path.size()-1);
                status[i] = false;
            }
        }
    }
}