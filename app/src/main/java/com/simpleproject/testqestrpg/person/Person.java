package com.simpleproject.testqestrpg.person;


public class Person {

    private String name;
    private int health;
    private int damage;
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public Person(String name){
        this.name = name;
    }
    public Person(String name, int health){
        this.name = name;
        this.health = health;
    }
    public Person(String name, int health, int damage){
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    public Person(String name,int health,int damage, int money){
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.money = money;
    }

    public String getName(){
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
