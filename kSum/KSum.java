package kSum;

import java.util.*;
/**
 * KSum
 */
public class KSum {

    private static List<List<Integer>> ksum(int[] arr,int k,int start,int target) {
        
        int n = arr.length;
        List<List<Integer>> res  = new ArrayList<List<Integer>>();
        if(n-k<0) return res;
        if(k == 2){
            int low = 0,high = n-1;
            while(low<high){
                int val = arr[low]+arr[high];
                if(val == target){
                    ArrayList<Integer> slist = new ArrayList<>();
                    slist.add(arr[low]);
                    slist.add(arr[high]);
                    while(low < high && arr[low] == arr[low+1]) low++;
                    while(low < high && arr[high] == arr[high+1]) high--;
                    low++;
                    high--;
                    res.add(slist);
                }
                else if(val<target) low++;
                else high--;
            }
        }
        else{
            for(int i = start;i<n-k;i++){
                if(i!=start && arr[i] == arr[i-1]) continue;
                List<List<Integer>> sList = ksum(arr, k-1, start+1, target-arr[i]);
                for (List<Integer> list : sList) {
                    list.add(0,arr[i]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}