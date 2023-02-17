package String.PatternMatching;

public class RabinKarp {

    public static void rabinKarpAlgorithm(String text,String pattern) {
        
        int M = pattern.length();
        int N = text.length();

        int d = 256; // As we have 256 characters;
        int p = 0;   // Hash Value of pattern
        int t = 0;   // Hash Value of Text
        int h = 1;   // will help use get position of character h = d^(m-1)
        int q = 101; // Any Prime number
        int j=0;
        
        // Calculating h
        for(int i=0;i<pattern.length()-1;i++){
            h=(h*d)%q;
        }

        // Calculating Hash Value of Pattern and Intial M window in text
        for(int i=0;i<M;i++){
            p = (d*p+pattern.charAt(i))%q;
            t = (d*t+text.charAt(i))%q;
        }

        for(int i=0;i<=N-M;i++){
            if(p==t){
                for(;j<M;j++){
                    if(text.charAt(i+j)!=pattern.charAt(j))
                        break;
                }
                if(j == M){ 
                    System.out.printf("\n Found at Index %d \n",i);
                }
            }
            if(i<N-M){
                t=(d*(t-text.charAt(i)*h)+text.charAt(i+M))%q;
                if(t<0) t=t+q;
            }
        }
    }
    
    public static void main(String[] args) {
        rabinKarpAlgorithm("abcaaxbbabcaabcaabc","abc");
    }
}
