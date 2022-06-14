package Sorting;
import java.time.LocalTime;
import java.util.Random;

public class BubbleSort {
    
    public static void sort(int a[]){
        int n=a.length;
        LocalTime a1=LocalTime.now();
        System.out.println(a1);
        // for(int i=0;i<n-1;i++){
        //     for(int j=0;j<n-i-1;j++){
        //         if(a[j]>a[j+1]){
        //             int temp = a[j];
        //             a[j]=a[j+1];
        //             a[j+1]=temp;
        //         }
        //     }
        // }
        
        for(int i=0;i<n-1;i++){
            Boolean flag=false;
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=true;
                }
            }
            if(flag==false) break;
            n--;
        }
        
        LocalTime a2=LocalTime.now();
        System.out.println(a2);
    }

    // 12:29:14.450
    public static void main(String[] args) {
        Random rand = new Random();
        int a[] = {4,1,6,2,7,3,5,9,8};
        // int a[] = new int[100000];
        // System.out.print("\n");
        // for(int i=0;i<100000;i++){
        //     a[i]=rand.nextInt(10000);
        //     // System.out.print(a[i]+" ");
        // }
        System.out.print("\n");
        sort(a);
        for (int i : a) {
            System.out.print(i+" ");
        }

    }
}
