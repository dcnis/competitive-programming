package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintAnimalTree {

    private static class Relation{
        String parent;
        String child;
        public Relation(String parent, String child){
            this.parent = parent;
            this.child = child;
        }
    }

    public static void printTree(List<Relation> relations){

        // build the graph
        Map<String, List<String>> adjacencyMap = new HashMap<>();

        for(Relation rs : relations){
            if(!adjacencyMap.containsKey(rs.parent)){
                adjacencyMap.put(rs.parent, new ArrayList<>());
            }
            adjacencyMap.get(rs.parent).add(rs.child);
        }


        // Find the root
        Set<String> allChildren = new HashSet<>();
        for(Relation rs : relations){
            allChildren.add(rs.child);
        }

        /*
        * mammal
        * bird
        * animal
        * lion
        * cat
        * fish
        *
        * */

        Set<String> allAnimals = new HashSet<>();
        for(Relation rs : relations){
            allAnimals.add(rs.parent);
            allAnimals.add(rs.child);
        }

        /*
        * animal
        * mammal
        * bird
        * lifeform
        * cat
        * lion
        * fish
        * */

        String root = "";
        for(String  parent : allAnimals){
            if(!allChildren.contains(parent)){
                root = parent;
            }
        }

        // print the Tree
        printTreeWithLevels(root, adjacencyMap, 0);
    }

    private static void printTreeWithLevels(String parent, Map<String, List<String>> adjacencyMap, int level) {
        if(parent == null) return;
        for(int i = 0; i < level; i++){
            System.out.print(" ");
        }
        System.out.print(parent + "\n");

        if(adjacencyMap.get(parent) != null){
            for(String child : adjacencyMap.get(parent)){
                if(child != null){
                    printTreeWithLevels(child, adjacencyMap, level+1);
                }
            }
        }

    }

    public static void main(String[] args) {
        List<Relation> rs = new ArrayList<>();
        rs.add(new Relation("animal", "mammal"));
        rs.add(new Relation("animal", "bird"));
        rs.add(new Relation("lifeform", "animal"));
        rs.add(new Relation("cat", "lion"));
        rs.add(new Relation("mammal", "cat"));
        rs.add(new Relation("animal", "fish"));

        printTree(rs);
    }
}
