package srс.commands;

import srс.Human;
import srс.console.Console;

public class Command_3 implements Commands {
    Console console;

    public Command_3(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {

        Human human = console.getHuman(console.getFamilyTree());

        console.getPresenter().addNewHuman(human);

    }

    @Override
    public String description() {
        return "добавить нового члена семьи";
    }
}