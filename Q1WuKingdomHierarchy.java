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
public class Q1WuKingdomHierarchy {

    ArrayList<Q1General> generals = new ArrayList<>();
    Q1TreeNode root;

    public Q1WuKingdomHierarchy() {
        //Tree map function
        root = new Q1TreeNode(new Q1Emperor("Sun Quan", "Cavalry", 96, 98, 72, 77, 95));
        Q1TreeNode militaryChief = new Q1TreeNode(new Q1Chief("Zhang Zhao", "Archer", 22, 80, 89, 99, 60));
        Q1TreeNode managementChief = new Q1TreeNode(new Q1Chief("Zhou Yu", "Cavalry", 80, 86, 97, 80, 90));
        root.addChild(militaryChief);
        root.addChild(managementChief);

        generals.add(new Q1General("Xu Sheng", "Archer", 70, 78, 72, 40, 94));
        generals.add(new Q1General("Zhu Ge Jin", "Archer", 70, 61, 88, 82, 71));
        generals.add(new Q1General("Lu Su", "Infantry", 43, 87, 84, 88, 54));
        generals.add(new Q1General("Tai Shi Ci", "Cavalry", 96, 81, 43, 33, 97));
        generals.add(new Q1General("Xiao Qiao", "Infantry", 42, 52, 89, 77, 34));
        generals.add(new Q1General("Da Qiao", "Cavalry", 39, 62, 90, 62, 41));
        generals.add(new Q1General("Zhou Tai", "Infantry", 92, 89, 72, 43, 99));
        generals.add(new Q1General("Gan Ning", "Archer", 98, 92, 45, 23, 97));
        generals.add(new Q1General("Lu Meng", "Cavalry", 70, 77, 93, 82, 88));
        generals.add(new Q1General("Huang Gai", "Infantry", 83, 98, 72, 42, 99));

        for (Q1General general : generals) {
            Q1TreeNode node = new Q1TreeNode(general);
            if (general.intelligence > general.strength) {
                managementChief.addChild(node);
            } else {
                militaryChief.addChild(node);
            }
        }

    }

    //sorting functions
    void traverse(Q1TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.emperor.name);
        for (Q1TreeNode child : node.children) {
            System.out.println("--" + child.chief.name); // Display the Chiefs
            for (Q1TreeNode grandchild : child.children) {
                System.out.println("----" + grandchild.general.name); // Display the Generals
            }
        }
    }
    
    //strength
    ArrayList<Q1General> sortByStrength() {
        ArrayList<Q1General> sortedGenerals = new ArrayList<>(generals);
        Collections.sort(sortedGenerals, Comparator.comparingInt(a -> a.strength));
        for (Q1General general : sortedGenerals) {
            System.out.println(general.name + " " + general.strength);
        }
        return sortedGenerals;
    }


    ArrayList<Q1General> searchByStrength(int keyStrength, ArrayList<Q1General> sortedGenerals) {
        ArrayList<Q1General> matchingGenerals = new ArrayList<>();
        int left = 0;
        int right = sortedGenerals.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Q1General currentGeneral = sortedGenerals.get(mid);

            if (currentGeneral.strength == keyStrength) {
                matchingGenerals.add(currentGeneral);
                // Check for other generals with the same strength to the left
                int prev = mid-1;
                while(prev>=0 && sortedGenerals.get(prev).strength == keyStrength){
                    matchingGenerals.add(sortedGenerals.get(prev));
                    prev--;
                }
                // Check for other generals with the same strength to the right
                int next = mid+1;
                while(next<sortedGenerals.size() && sortedGenerals.get(next).strength == keyStrength){
                    matchingGenerals.add(sortedGenerals.get(next));
                    next++;
                }
                return matchingGenerals;
            } else if (currentGeneral.strength < keyStrength) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return matchingGenerals; // General with the specified ability not found
    }
    
    ArrayList<ArrayList<Q1General>> buildTeam(int minStrength, int maxStrength, ArrayList<Q1General> sortedGenerals){
        
        ArrayList<ArrayList<Q1General>>totalTeamStrength = new ArrayList<>();
        
        int N = sortedGenerals.size();
        for(int i=0;i<N-2;i++){
            int left = i+1;
            int right = N-1;
            
            while(left<right){
                int currentSumStrength = sortedGenerals.get(i).strength + sortedGenerals.get(left).strength + sortedGenerals.get(right).strength;
                    
                if(currentSumStrength >= minStrength && currentSumStrength <= maxStrength ){
                    ArrayList<Q1General> teamStrength = new ArrayList<>();
                    teamStrength.add(sortedGenerals.get(i));
                    teamStrength.add(sortedGenerals.get(left));
                    teamStrength.add(sortedGenerals.get(right));
                    totalTeamStrength.add(teamStrength);
                    left++;
                    right--;
                }
                else if(currentSumStrength < minStrength){
                    left ++;
                }
                else{
                    right--;
                }
                
            }
        }
        return totalTeamStrength;
    }

}
