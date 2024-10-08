public class BinarySearch {
    public static int binarySearch(int numbers[],int key){
      int start=0, end = numbers.length-1;

      while (start<=end){
           int mid =(start+end)/2;
           if(numbers[mid] == key){
               return mid;
           }
           else if(numbers[mid]>key){ // left
               end = mid-1;
           }else{
               start=mid+1;
           }
      }
      return -1;
    }

    public static void main(String[] args){
        int arr[]={3,4,3,2,6,7};
        int key=7;
        System.out.println(binarySearch(arr, key));
    }
}
