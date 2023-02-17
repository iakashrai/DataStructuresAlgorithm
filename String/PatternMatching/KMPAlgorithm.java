package String.PatternMatching;

public class KMPAlgorithm {
    public static int[] generateLPS(String input) {
        int N = input.length();
        int[] lpsArray = new int[N];

        lpsArray[0] = 0;
        int i=1,j=0;
        while(i<N){
            if(input.charAt(i) == input.charAt(j)){
                lpsArray[i]=j+1;
                i++;
                j++;
            }
            else{
                if(j!=0){
                    j=lpsArray[j-1];
                }
                else{
                    lpsArray[i]=0;
                    i++;
                }
            }
        }
        return lpsArray;
    }

    public static void KMP(String text,String pattern) {
        int N = text.length();
        int M = pattern.length();

        int i=0,j=0;

        int[] lpsArray = generateLPS(pattern);

        while(i<N && j<M){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j!=0) j=lpsArray[j-1];
                else{
                    i++;
                }
            }
            if(j==M) {
                System.out.printf("\n Found at Index %d \n",i-M);
                j=0;
            }
        }
    }

    public static void main(String[] args) {
        KMP("abcxabxxabcxxabc", "abc");
    }

}
