package ManagedBeans;

import com.nackademin.WoodShop.EJB.WoodEntityHelper;
import com.nackademin.WoodShop.entities.Wood;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("controller")
@SessionScoped
public class Controller implements Serializable {

    @Inject
    Cart cart;
    @EJB
    WoodEntityHelper EntityHelper;
    List<Wood> items;

    public String add(int itemid) {
        cart.add(itemid);
        return "catalogue";
    }

    public String remove(int itemid) {
        cart.remove(itemid);
        updateCart();
        return "catalogue";
    }

    public String buy() {
        EntityHelper.buyWood(cart);
        return "index";
    }

    public String showCart() {
        items = EntityHelper.showCart(cart);
        return "showcart";
    }

    public String updateCart() {
        items = EntityHelper.updateCart(cart);
        return "showcart";
    }

    public List<Wood> getCartItems() {
        return items;
    }

    public List<Wood> getWoodList() {
        return EntityHelper.getWoodList();
    }

    public Cart getCart() {
        return cart;
    }

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

