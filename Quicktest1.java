// Write quick sort pseudocode which chooses pivot as middle element in the array

package practice5;
import java.util.*;

class Sort3
{
    public static void swap(int arr[],int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static int partition3(int arr[],int lb,int ub)
    {
        int pivot=arr[lb];
        int start=lb;
        int end=ub;

        while(start<end)
        {
            while(arr[start]<=pivot)
            {
                start++;
            }
            while(arr[end]>pivot)
            {
                end--;
            }

            if(start<end)
            {
                swap(arr,start,end);
            }
        }
        swap(arr,lb,end);
        return end;
    }

    public static void quicksort3(int arr[],int lb,int ub)
    {
        if(lb<ub)
        {
            int mid=(lb+ub)/2;
            swap(arr,lb,mid);

            int loc=partition3(arr,lb,ub);

            quicksort3(arr,lb,loc-1);
            quicksort3(arr,loc+1,ub);
        }
    }
}

public class Quicktest1
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array is:");
        int size=sc.nextInt();

        int arr[]=new int[size];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]= sc.nextInt();
        }

        Sort3.quicksort3(arr,0,arr.length-1);

        System.out.println("Enter the elements of array:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
