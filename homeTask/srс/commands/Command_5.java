package srс.commands;

import srс.Human;
import srс.console.Console;


public class Command_5 implements Commands {
    Console console;

    public Command_5(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        String str = console.getName();
        System.out.println(console.getPresenter().getAllChildren(str));
    }

    @Override
    public String description() {
        return "показать всех детей члена семьи";
    }
}