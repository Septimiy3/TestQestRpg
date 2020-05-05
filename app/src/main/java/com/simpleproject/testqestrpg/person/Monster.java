package com.simpleproject.testqestrpg.person;

public class Monster {

    private String name;
    private int health;
    private int damage;
    private int money;

    public Monster(String name, int health, int damage, int money) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.money = money;
    }

    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



}
