package controller;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name="menuCli",
    subcommands = {
        listMenu.class,
        deleteMenu.class
    }
)
public class menuController implements Runnable {

    public static void main(String[] args) {
        CommandLine.run(new menuController(), args);
    }

    @Override
    public void run() {
        System.out.println();
    }


}
