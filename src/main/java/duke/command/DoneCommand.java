package duke.command;

import duke.TaskList;
import duke.Storage;
import duke.Ui;

import java.io.IOException;

public class DoneCommand extends Command {
    public static final String COMMAND = "done";
    private int taskNo;

    public DoneCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws
            ArrayIndexOutOfBoundsException,
            IOException {
        try {
            if (taskNo == -1 || taskNo + 1 > taskList.getList().size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            String display = taskList.complete(this.taskNo);
            storage.writeToFile(taskList);
            ui.printDone(display);
        } catch (ArrayIndexOutOfBoundsException e) {
            ui.printError(
                    "Eh... No such task found. Cannot mark as done.",
                    "(＃￣ω￣)"
            );
        }
    }
}