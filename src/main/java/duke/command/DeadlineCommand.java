package duke.command;

import java.io.IOException;
import java.time.LocalDateTime;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Deadline;


public class DeadlineCommand extends Command {
    public static final String COMMAND = "deadline";
    private String desc;
    private LocalDateTime by;

    /**
     * Constructor of Deadline Command
     *
     * @param desc the description of the task
     * @param by due date
     *
     */
    public DeadlineCommand(String desc, LocalDateTime by) {
        this.desc = desc;
        this.by = by;
    }

    /**
     * Executes Deadline Command, adds a deadline task to the list, prints response
     * and stores updated list in file
     *
     * @param taskList current list
     * @param ui current ui to access print responses
     * @param storage current storage
     * @throws IOException when there is file save error
     *
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws IOException {
        Deadline newDeadline = new Deadline(this.desc, this.by);
        taskList.add(newDeadline);
        storage.writeToFile(taskList);
        ui.printAdd(newDeadline, taskList.getList().size());
    }
}
