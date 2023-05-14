/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.struc.assignment;

import java.util.*;

/**
 *
 * @author HP
 */
public class Q1main {

    public static void main(String[] args) {
        //create a hierarchy
        Q1WuKingdomHierarchy hierarchy = new Q1WuKingdomHierarchy();
        hierarchy.traverse(hierarchy.root);
        
        //sort according to ability
        System.out.println("Enter which attributes to search for: ");
        Scanner in = new Scanner(System.in);
        String attribute = in.nextLine();
        
        //binary search for specific value of ability
        System.out.println("Enter desired value of specific abilities");
        Scanner in2 = new Scanner(System.in);
        int keyValue = in2.nextInt();

        ArrayList<Q1General> sortedGeneral = new ArrayList<>();
        switch (attribute) {
            case "Strength":
                sortedGeneral = hierarchy.sortByStrength();
                ArrayList<Q1General> matchingGeneral = hierarchy.searchByStrength(keyValue, sortedGeneral);
                if (!matchingGeneral.isEmpty()) {
                    System.out.println("\nSearched general: ");
                    for (Q1General general : matchingGeneral) {
                        System.out.println("General name: " + general.name);
                        System.out.println("General strength: " + general.strength);
                    }
                } else {
                    System.out.println("\nGeneral with the specified ability not found.");
                }
                break;
            default:
                System.out.println("Please enter correct attribute");
        }
        
        //suggest teams
        System.out.println("Suggested team:");
        System.out.println("S team: \n");
        for(int i=0;i<hierarchy.buildTeam(250, 300, sortedGeneral).size();i++){
            for(int j=0;j<hierarchy.buildTeam(250, 300, sortedGeneral).get(i).size();j++){
                System.out.print(hierarchy.buildTeam(250, 300, sortedGeneral).get(i).get(j).name + ", ");
            }
            System.out.println("");
        }
        
        System.out.println("\nA team: \n");
        for(int i=0;i<hierarchy.buildTeam(220, 329, sortedGeneral).size();i++){
            for(int j=0;j<hierarchy.buildTeam(220, 329, sortedGeneral).get(i).size();j++){
                System.out.print(hierarchy.buildTeam(220, 329, sortedGeneral).get(i).get(j).name + ", ");
            }
            System.out.println("");
        }
        System.out.println("\nB team: \n");
        for(int i=0;i<hierarchy.buildTeam(190, 219, sortedGeneral).size();i++){
            for(int j=0;j<hierarchy.buildTeam(190, 219, sortedGeneral).get(i).size();j++){
                System.out.print(hierarchy.buildTeam(190, 219, sortedGeneral).get(i).get(j).name + ", ");
            }
            System.out.println("");
        }
        System.out.println("\nC team: \n");
        for(int i=0;i<hierarchy.buildTeam(0, 189, sortedGeneral).size();i++){
            for(int j=0;j<hierarchy.buildTeam(0, 189, sortedGeneral).get(i).size();j++){
                System.out.print(hierarchy.buildTeam(0, 189, sortedGeneral).get(i).get(j).name + ", ");
            }
            System.out.println("");
        }
    }
}
