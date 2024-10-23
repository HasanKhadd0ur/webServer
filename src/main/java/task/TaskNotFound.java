package task;

public final class TaskNotFound extends TaskImpl {

    @Override
    public void execute() { }

    @Override
    public String getResult() {
        return "ERROR: This task doesn't exist.\n";
    }
}
