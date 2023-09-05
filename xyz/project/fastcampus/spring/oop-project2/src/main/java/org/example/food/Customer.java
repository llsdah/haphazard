package org.example.food;

public class Customer {

    public void order(String name, Menu menu, Cooking cooking){
        MenuItem menuItem = menu.chooes(name);
        Cook cook = cooking.makeCook(menuItem);
    }
}
