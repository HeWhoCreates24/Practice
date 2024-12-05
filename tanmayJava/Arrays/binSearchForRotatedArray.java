public class binSearchForRotatedArray{
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,1,2,3};
        int target = 1;
        int st=0;
        int en=nums.length-1;
        while(st<=en){
            int mid=st+(en-st)/2;
            if(nums[mid]==target){
                System.out.println("TARGET found at index "+mid);
                return;
            }
            else if(nums[mid]>nums[st]){
                if(nums[st]<=target&&target<=nums[mid]){
                    en=mid-1;
                }
                else{
                    st=mid+1;
                }
            }
            else{
                if(nums[mid]<=target&&target<=nums[en]){
                    st=mid+1;
                }
                else{
                    en=mid-1;
                }
            }
        }
        System.out.println("Target not found!!");
    }
}