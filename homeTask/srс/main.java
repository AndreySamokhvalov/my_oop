package srс;


import srс.presenter.Presenter;
import srс.console.Console;

import java.util.Scanner;

public class main {


        public static void main(String[] args) {
            FileHandler fileHandler = new FileHandler();
            FamilyTree<Human> familyTree = new FamilyTree<>(fileHandler);
            Presenter presenter = new Presenter(familyTree);
            Console console = new Console(familyTree, fileHandler, presenter);
            console.go();
    
        }
    }


