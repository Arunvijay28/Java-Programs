// Write quick sort pseudocode which chooses pivot as middle element in the array


import java.util.*;

class Sort4
{
    public static void swap(int arr[],int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static int partition4(int arr[],int lb,int ub)
    {
        int pivot=arr[ub];
        int start=lb-1;

        for(int j=lb;j<ub;j++)
        {
            if(arr[j]<=pivot)
            {
                start++;
                swap(arr,start,j);
            }
        }

        swap(arr,start+1,ub);
        return start+1;
    }

    public static void quicksort4(int arr[],int lb,int ub)
    {
        if(lb<ub)
        {
            int mid=(lb+ub)/2;
            swap(arr,lb,mid);

            int loc=partition4(arr,lb,ub);

            quicksort4(arr,lb,loc-1);
            quicksort4(arr,loc+1,ub);
        }
    }
}

public class Qicktest2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int size=sc.nextInt();

        int[] arr=new int[size];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        Sort4.quicksort4(arr,0,arr.length-1);

        System.out.println("Sorted Array is:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
