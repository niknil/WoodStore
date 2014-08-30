package com.nackademin.WoodShop.EJB;

import ManagedBeans.Cart;
import ManagedBeans.CartItem;
import com.nackademin.WoodShop.entities.Wood;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class WoodEntityHelper {

    @PersistenceContext
    private EntityManager em;

    public WoodEntityHelper() {
    }

    public void createWoodEntities(Integer woodId, Double price, String type,
            Integer stock) {
        try {
            Wood wood = new Wood(woodId, price, type, stock);
            em.persist(wood);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }

    public List<Wood> getWoodList() {
        return (List<Wood>) em.createNamedQuery("findWoodList").getResultList();
    }

    public void buyWood(Cart cart) {
        HashMap<Integer, CartItem> items = cart.getItems();

        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            Wood currentWood = em.find(Wood.class, entry.getKey());
            currentWood.setStock(currentWood.getStock() - entry.getValue().getQuantity());
            em.persist(currentWood);

        }

        cart.clear();

    }

    public List<Wood> showCart(Cart cart) {

        HashMap<Integer, CartItem> items = cart.getItems();
        ArrayList<Wood> woodItems = new ArrayList();
        
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            Wood currentWood = em.find(Wood.class, entry.getKey());
            woodItems.add(currentWood);

        }
        return woodItems;
    }

    public List<Wood> updateCart(Cart cart) {
        HashMap<Integer, CartItem> items = cart.getItems();
        ArrayList<Wood> woodItems = new ArrayList();
        
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            Wood currentWood = em.find(Wood.class, entry.getKey());
            woodItems.remove(currentWood);

        }
        return woodItems;
    }

}
