package String.PatternMatching;

public class ZAlgorithm {

    public static int[] generateZArray(String input) {
        int N = input.length();
        int[] zarray  = new int[N];

        int left=0,right=0;
        zarray[0] = 0;

        for(int i=1;i<N;i++){
            if(i>right){
                left=right=i;
                while(right<N && input.charAt(right)==input.charAt(right-left))
                    right++;
                zarray[i] = right-left;
                right--;
            }
            else{
                int k1=i-left;
                if(zarray[k1]<right-i+1){
                    zarray[i]=zarray[k1];
                }
                else{
                    left=i;
                    while(right<N && input.charAt(right)==input.charAt(right-left))
                        right++;
                    zarray[i] = right-left;
                    right--;
                }
            }
        }
        return zarray;
    }

    public static void main(String[] args) {
        String pattern = "abc";
        String text = "abcaaxbbabcaabcaabc";
        String input = pattern+"$"+text;
        int[] zarray = generateZArray(input);
        for(int i=0;i<zarray.length;i++){
            if(zarray[i]==pattern.length()){
                System.out.printf("\n Found at Index %d \n",(i-pattern.length()-1));
            }   
        }
    }
}
