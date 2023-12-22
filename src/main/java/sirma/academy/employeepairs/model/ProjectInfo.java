package sirma.academy.employeepairs.model;

public class ProjectInfo {
    private int projectID;
    private long daysTogether;

    public ProjectInfo(int projectID, long daysSpentTogether) {
        this.projectID = projectID;
        this.daysTogether = daysSpentTogether;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public long getDaysTogether() {
        return daysTogether;
    }

    public void setDaysTogether(long daysTogether) {
        this.daysTogether = daysTogether;
    }

    @Override
    public String toString() {
        return "projectID: " + projectID +
                ", days together: " + daysTogether + "\n   ";
    }
}
