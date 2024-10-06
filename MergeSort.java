

import java.util.Scanner;

class Merge1
{
    public static void merge(int arr[], int left, int right, int mid)
    {
         int n1=mid-left+1;
         int n2=right-mid;

         int[] L=new int[n1];
         int[] R=new int[n2];

         for(int i=0;i<L.length;i++)
         {
             L[i]=arr[left+i];
         }

         for(int j=0;j<R.length;j++)
         {
             R[j]=arr[mid+1+j];
         }

         int i=0;
         int j=0;
         int k=left;
         while(i<n1 && j<n2)
         {
             if(L[i]<=R[j])
             {
                 arr[k]=L[i];
                 i++;
             }
             else
             {
                 arr[k]=R[j];
                 j++;
             }
             k++;
         }

         while(i<n1)
         {
             arr[k]=L[i];
             i++;
             k++;
         }

         while(j<n2)
         {
             arr[k]=R[j];
             j++;
             k++;
         }
    }

    public static void mergesort(int arr[],int left,int right)
    {
        if(left<right)
        {
            int mid=(left+right)/2;

            mergesort(arr,left,mid);
            mergesort(arr,mid+1,right);

            merge(arr,left,right,mid);
        }
    }
}

public class MergeSort
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

        Merge1.mergesort(arr,0,arr.length-1);

        System.out.println("Sorted Array is:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
