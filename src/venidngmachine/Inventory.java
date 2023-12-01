package venidngmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Inventory<T> {

    private final Map<T, Integer> inventory = new HashMap<>();


    public int getQuantity(T item){
        Integer quantity = inventory.get(item);
        return Objects.nonNull(quantity) ? quantity : 0;
    }
    public Boolean hasItem(T item){
        return getQuantity(item) > 0;
    }

    public void put(T item, int amount){
        inventory.put(item, amount);
    }

    public void withdrawItem(T item){
            inventory.put(item, getQuantity(item) - 1) ;
    }
    public void depositItem(T item){
        inventory.put(item, getQuantity(item) + 1);
    }
    public void resetInventory(){
        inventory.clear();
    }
}
