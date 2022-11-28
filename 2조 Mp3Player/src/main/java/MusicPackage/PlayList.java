package MusicPackage;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private Command theCommand;
    private List<Command>addCommands = new ArrayList<>();
    private List<Command>deleteCommands = new ArrayList<>();
    public static int MAX_COUNT = 5;
    
    public PlayList() {
        Command noCommand = new NoCommand();
        for(int i = 0; i<MAX_COUNT ; i++) {
            addCommands.add(i, noCommand);
            deleteCommands.add(i, noCommand);
        }
    }
    public void setCommand(int slot, Command addCommand, Command deleteCommand) {
        addCommands.set(slot, addCommand);
        deleteCommands.set(slot, deleteCommand);
    }
    public void runAddCommand(int slot) {
        addCommands.get(slot).execute();
    }
    public void runDeleteCommand(int slot) {
        deleteCommands.get(slot).execute();
    }
}
