import java.util.ArrayList;
import java.util.HashMap;
public class Character {
    //These are the traits of the character object
    private String name;
    private int strength;
    private int intelligence;
    private int charisma;
    private int coordination;
    //Status refer to status effects that the player character can acrew over the course of play 
    private HashMap<Integer,Integer> quirks = new HashMap<>();
    //private String[] quirks = new String[2];

public Character(String name,int strength, int intelligence, int charisma, int coordination){

    this.name = name;
    this.strength = strength;
    this.intelligence = intelligence;
    this.charisma = charisma;
    this.coordination = coordination;
    //this.status = status;
    //this.quirks = quirks;
}
public void setQuirks(HashMap<Integer,Integer> quirks) {
    this.quirks = quirks;
}
}
