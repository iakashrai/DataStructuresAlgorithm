package Sorting;

public class InsertationSort {
    
    public static void sort(int a[]) {
        int n = a.length;
        for(int i=1;i<n;++i){
            int key = a[i];
            int j = i-1;
            while(j>=0 && a[j]>key){ 
                a[j+1]=a[j]; 
                j--;
            }
            a[j+1]=key;
        }
    }
    
    public static void main(String[] args) {
        int a[] = {4,1,6,2,8,3,5,9,7,8};
        sort(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
