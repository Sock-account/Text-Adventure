import java.util.ArrayList;
public class Character {
    private String name;
    private int age; 
    private int strength;
    private int intelligence;
    private int charisma;
    private int coordination;
    private int[] stats = new int[5];
    private String[] quirks = new String[2];

public Character(String name, int age, int strength, int intelligence, int charisma, int coordination, int[] stats, String[] quirks){

    this.name = name;
    this.age = age;
    this.strength = strength;
    this.intelligence = intelligence;
    this.charisma = charisma;
    this.coordination = coordination;
    this.stats = stats;
    this.quirks = quirks;
}

}