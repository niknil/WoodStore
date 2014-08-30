package ManagedBeans;

import java.io.Serializable;
import java.util.HashMap;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Cart implements Serializable {

    HashMap<Integer, CartItem> items = new HashMap<>();


    public Cart() {

    }

    public void add(int woodId) {
        if (items.containsKey(woodId)) {
            CartItem currentItem = (CartItem) items.get(woodId);
            currentItem.incrementQuantity();
        } else {
            CartItem newItem = new CartItem();
            items.put(woodId, newItem);
        }
    }

    public HashMap getItems() {

        return items;

    }

    public void clear() {
        items.clear();
    }

    public void remove(int woodId) {
        if (items.containsKey(woodId)) {
            CartItem currentItem = (CartItem) items.get(woodId);
            if (currentItem.getQuantity() > 1) {
                currentItem.decrementQuantity();
            } else {
                items.remove(woodId);

            }
        }

    }

    public int getItemQuantity(int woodId) {
        int i = 0;
        if (items.containsKey(woodId)) {
            CartItem currentItem = (CartItem) items.get(woodId);
            i = currentItem.getQuantity();

        }
        return i;
    }

}
