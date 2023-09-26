public class Fak {
    public static void main(String[] args){
        System.out.print(fak(3));
    }
    public static int fak(int n) {
        if( n == 0 ){
            return 1;
        }else{
            return n*fak(n-1);
        }
    }      
}



