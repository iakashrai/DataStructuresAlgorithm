package Sorting;

/**
 * StableSelectionSort
 */
public class StableSelectionSort {

   public static void main(String[] args) {
    int a[]={4,2,5,1,3,7,6,9,8};
    int n=a.length;

    for(int i=0;i<n;i++){
        int min_idx = i;
        for(int j=i+1;j<n;j++) if(a[j]<a[min_idx]) min_idx=j;
        int temp = a[min_idx];

        while(min_idx>i){
            a[min_idx]=a[min_idx-1];
            min_idx--;
        }

        a[i]=temp;
    }

    for(int x:a) System.out.print(x+" ");
   }

}