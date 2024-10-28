import java.util.Scanner;
public class squareroot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int x = sc.nextInt();
        int start = 0 ;
        int end = x;
        int mid = 0;
        while(start<=end){
         mid = (start+end)/2;
            if(mid*mid==x)
            break;
            else if(mid*mid>x)
            end = mid-1;
            else if(mid*mid<x)
            start=mid+1;
        }
        System.out.println(mid+" is the square root of the number");
        sc.close();
    }
    //code only for perfect square numbers
}
