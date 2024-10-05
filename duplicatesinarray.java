class duplicatesinarray {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i =0;i<nums.length;){
            int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }
            else{
                i++;
            }

        }
        for(int j =0;j<nums.length;j++){
            if(nums[j]!=j+1){
                list.add(nums[j]);
            }
        }
        return list;
    }
    static void swap(int[] arr, int x , int y){
        int temp = arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}