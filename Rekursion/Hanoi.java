public class Hanoi {
    public static long count = 0;
    public static void main(String[] args){
        towerOfHanoi(30, "A", "B", "C");
        System.out.println(count);
    }

    public static void towerOfHanoi(int n, String EINS, String ZWEI, String DREI){
        if(n==0){
            return;
        } else{
           towerOfHanoi(n-1, EINS, DREI, ZWEI);
           System.out.println("Bewege: " + n + " von " + EINS + " nach " + DREI);
           count++;
           towerOfHanoi(n-1, ZWEI, EINS ,DREI); 
        }
    }
}