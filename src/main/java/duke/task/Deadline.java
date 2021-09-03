package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDateTime by;
    private DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd MMM uuuu HHmm");
    private DateTimeFormatter saveFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HHmm");

    /**
     * Constructor
     *
     * @param description task description
     * @param by due date
     */
    public Deadline(String description, LocalDateTime by) {
        super(description, false);
        this.by = by;
    }

    /**
     * Constructor for reading file from storage
     *
     * @param description task description
     * @param isDone check
     * @param by due date
     */
    public Deadline(String description, String isDone, LocalDateTime by) {
        super(description, isDone.equals("1"));
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(displayFormatter) + ")";
    }

    @Override
    public String toSaveString() {
        return "D|" + super.toSaveString() + "|" + by.format(saveFormatter);
    }
}
