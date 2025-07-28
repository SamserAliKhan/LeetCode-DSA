class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;
        k=k%n;
        int[] arr = new int[n];
        int t=k;
        int i=nums.length-1;
        while(t!=0){
            arr[i]=nums[n-t];
            i--;
            t--;
        }
        i=0;
        t=n-k-1;
        while(t>=0){
            arr[i]=nums[t--];
            i++;
        }
        i=0;
        t=n-1;
        for(i=0;i<n;i++,t--){
            nums[i]=arr[t];
        }

    }
}