public class ListCommand extends Command {
    public static final String COMMAND = "list";

    @Override
    public void execute(List list, Ui ui, Storage storage) {
        ui.printList(list);
    }
}