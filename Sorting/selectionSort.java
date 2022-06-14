package Sorting;

class SelectionSort {
    
    public static void sort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int min_idx = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min_idx])
                    min_idx = j;
            }

            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }

    }

    public static void main(String[] args) {
        int a[]= {1,3,2,6,5,4,7,9,8};
        Sorting.SelectionSort.sort(a);
        for(int d:a) System.out.print(d+" ");
    }

}
