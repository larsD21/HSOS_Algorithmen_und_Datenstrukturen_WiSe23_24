public class Hanoi {
    public static void main(String[] args){
        towerOfHanoi(3, "A", "B", "C");
    }

    public static void towerOfHanoi(int n, String EINS, String ZWEI, String DREI){
        if(n==0){
            return;
        } else{
           towerOfHanoi(n-1, EINS, DREI, ZWEI);
           System.out.println("Bewege: " + n + " von " + EINS + " nach " + DREI);
           towerOfHanoi(n-1, ZWEI, EINS ,DREI); 
        }
    }
}