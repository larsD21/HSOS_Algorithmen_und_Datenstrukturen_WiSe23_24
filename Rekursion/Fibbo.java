public class Fibbo {
    public static void main(String[] args){
        System.out.println(fibbo(12));
    }

    private static long fibbo(long n){
        if(n == 0){
            return 0;
        }else if(n ==1){
            return 1;
        } else{
            long num = 0;
            num = fibbo(n-1) + fibbo(n-2);
            return num;
        }
    }
}