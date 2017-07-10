package utilities;

/**
 * Created by rober on 10.07.2017.
 */

public class Task {

    private String taskNameGer;
    private String taskNameEng;
    private boolean extroverted;
    private boolean introverted;
    private boolean sexual;
    private boolean senseless;
    private Integer points;
    private boolean men;
    private boolean women;

    public Task(String taskNameGer, String taskNameEng, boolean extroverted, boolean introverted, boolean sexual, boolean senseless, Integer points, boolean men, boolean women) {
        this.taskNameGer = taskNameGer;
        this.taskNameEng = taskNameEng;
        this.extroverted = extroverted;
        this.introverted = introverted;
        this.sexual = sexual;
        this.senseless = senseless;
        this.points = points;
        this.men = men;
        this.women = women;
    }


    public String getTaskNameGer() {
        return taskNameGer;
    }

    public void setTaskNameGer(String taskNameGer) {
        this.taskNameGer = taskNameGer;
    }

    public String getTaskNameEng() {
        return taskNameEng;
    }

    public void setTaskNameEng(String taskNameEng) {
        this.taskNameEng = taskNameEng;
    }

    public boolean isExtroverted() {
        return extroverted;
    }

    public void setExtroverted(boolean extroverted) {
        this.extroverted = extroverted;
    }

    public boolean isIntroverted() {
        return introverted;
    }

    public void setIntroverted(boolean introverted) {
        this.introverted = introverted;
    }

    public boolean isSexual() {
        return sexual;
    }

    public void setSexual(boolean sexual) {
        this.sexual = sexual;
    }

    public boolean isSenseless() {
        return senseless;
    }

    public void setSenseless(boolean senseless) {
        this.senseless = senseless;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public boolean isMen() {
        return men;
    }

    public void setMen(boolean men) {
        this.men = men;
    }

    public boolean isWomen() {
        return women;
    }

    public void setWomen(boolean women) {
        this.women = women;
    }
}
