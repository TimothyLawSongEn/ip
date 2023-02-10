package duke.command;

import duke.Duke;
import duke.Storage;
import duke.TaskList;
import duke.Ui;


public class ExitCommand extends Command {
    //only show prevstate when closing file!!!

    public String execute(TaskList l, Ui ui, Storage s, Command prevCommand, Duke duke) {
        String errorMsg = saveToFile(s, l, ui, prevCommand);

        return ui.showFullReplyMsg(errorMsg, ui.showExit());
    }

    @Override
    public boolean isExit() {
        return true;
    }

}
