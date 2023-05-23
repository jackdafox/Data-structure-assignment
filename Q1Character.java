/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class Q1Character {
    private String name;
    String armyType;
    int strength;
    int leadership;
    int intelligence;
    int politic;
    int hitPoint;
    
    public Q1Character(String name, String armyType, int strength, int leadership, int intelligence, int politic, int hitPoint) {
        this.setName(name);
        this.armyType = armyType;
        this.strength = strength;
        this.leadership = leadership;
        this.intelligence = intelligence;
        this.politic = politic;
        this.hitPoint = hitPoint;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}