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

    public String getAllChildren(String str) {
        if (familyTree.searchName(str)!=null) {
            return familyTree.searchName(str).getAllChildren();
        } else return String.format("%s нет в FamilyTree!", str);
}

    public FamilyTree sortFamilyTree(String sortParameter) {
        familyTree.sortFamilyTree(sortParameter);
        return familyTree;
    }
}