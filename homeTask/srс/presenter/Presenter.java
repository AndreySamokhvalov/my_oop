package srс.presenter;

import java.util.ArrayList;

import srс.FamilyTree;
import srс.Human;

public class Presenter<T extends Human> {

    private FamilyTree familyTree;

    public Presenter(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void setFamilyTree(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void saveFamilyTree() {
        familyTree.saveFamilyTree();
    }

    public void printFamilyTree() {
        familyTree.printHumans();
    }

    public void addNewHuman(T newHuman) {
        familyTree.addNewHuman(newHuman);
    }

    public  T searchHuman(String str) {
        return (T) familyTree.searchName(str);
    }

    public ArrayList<Human> getAllChildren(String str) {
        return familyTree.searchName(str).getChildren();
    }

    public FamilyTree sortFamilyTree(String sortParameter) {
        familyTree.sortFamilyTree(sortParameter);
        return familyTree;
    }
    // public void sortFamilyTreeName() {
    //     familyTree.sortByName();
    //     familyTree.printHumans();
    //     // return familyTree;
    // }

    // public void sortFamilyTreeAge() {
    //     familyTree.sortByAge();
    //     familyTree.printHumans();
    // }

}