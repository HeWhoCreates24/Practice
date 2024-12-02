public class bubbleSort{
    public static void bs(int arr[]) {
        int n=arr.length;
        boolean swapped;
        do { 
            swapped=false;
            for(int i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    swapped=true;
                }
            }
        } while (swapped);
    }
    public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        bs(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}