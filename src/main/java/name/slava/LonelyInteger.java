package name.slava;


import java.util.*;

public class LonelyInteger {
    public static void main(String[] args) {
        List<Integer> a = List.of(1,2,3,4,3,2,1);

        var result = lonelyinteger(a);

        System.out.println(result);
    }

    private static int lonelyinteger(List<Integer> a) {
        Map<Integer, Integer> numberToQuantity = new HashMap<>();
        for(var number: a){
            numberToQuantity.merge(number, 1, Integer::sum);
        }

        for(var entry: numberToQuantity.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException();
    }
}
