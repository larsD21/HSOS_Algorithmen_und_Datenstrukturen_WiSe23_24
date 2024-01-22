public class LongestSubstring {
    public static void main(String[] args){
        System.out.println(longestSubstringLength("ABABA", "ABBABA"));
    }

    private static int longestSubstringLength(String a, String b){
        int[][] A = new int[a.length()+1][b.length()+1];
        int maxLength = 0;

        for(int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    A[i][j] = A[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength, A[i][j]);
                }
            }
        }
        return maxLength;
    }
}
