package srс.commands;

import srс.console.Console;

public class Command_7 implements Commands {
    Console console;

    public Command_7(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        System.out.println(console.getPresenter().sortFamilyTree("age"));
    }

    @Override
    public String description() {
        return "сортировка членов семьи по возрасту";
    }
}