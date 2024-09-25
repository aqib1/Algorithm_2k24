public class RemoveElement {

  // Extra space O(n)
  // Time complexity O(n)

  public int removeElement(int[] nums, int val) {
        int[] removed = new int[nums.length];
        int i = 0;
        for(int n: nums) {
            if(n != val) {
                removed[i++] = n;
            }
        }

        System.arraycopy(removed, 0, nums, 0, removed.length);

        return i;
    }


  public int removeElementConstantSpace(int[] nums, int val) {
        if(nums.length == 0) return 0;
        

        int start = 0, end = nums.length - 1, i = 0;
        while(start <= end) {
            if(nums[end] == val) {
                end--;
                continue;
            }

            if(nums[start] == val) {
                nums[start] = nums[end];
                end--;
            }
            
            i++;
            if(start == end) break;

            start++;
        }

        return i;
    }
  
}
