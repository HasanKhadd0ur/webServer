package task;

public final class TaskIncorrectParams extends TaskImpl {

    @Override
    public void execute() { }

    @Override
    public String getResult() {
        return "ERROR: A task must have 2 parameters.\n";
    }
}