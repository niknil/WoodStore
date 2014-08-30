
package com.nackademin.WoodShop.EJB;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Singleton
@Startup
public class CreateEntities {

    @EJB
    private WoodEntityHelper request;

    @PostConstruct
    public void createData() {
        request.createWoodEntities(1, 15.75, "Bark", 25);
        request.createWoodEntities(2, 9.95, "Oak", 30);
        request.createWoodEntities(3, 19.95, "Cedar", 20);
        request.createWoodEntities(4, 20.95, "Pine", 20);
        request.createWoodEntities(5, 30.95, "Birch", 20);
    }
}
