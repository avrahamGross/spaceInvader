public class BlueAstronaut extends Player implements Crewmate {
private int numTask;
private int taskSpeed;

public BlueAstronaut (String name, int susLevel, int numTask, int taskSpeed) {
        super(name, susLevel);
        if (numTask >= 0) {
                this.numTask = numTask;
        }
        else {
                this.numTask = 0;
        }
}

public BlueAstronaut (String name) {
        this(name, 15, 6, 10);
}

public void emergencyMeeting() {
        if (this.isFrozen()) {
                return;
        }
        int x = 0;
        while (getPlayers()[x].isFrozen()) {
                x++;
        }
        int baseSusLevel = getPlayers()[x].getSusLevel();
        int comparableSusLevel;
        int indexOfHighSusLevel = 0;
        boolean isEqualSusLevel = false;
        for (int index = 1; index < getPlayers().length; index++) {
                if (getPlayers()[index].isFrozen()) {
                        continue;
                }
                comparableSusLevel = getPlayers()[index].getSusLevel();
                if (baseSusLevel == comparableSusLevel) {
                        isEqualSusLevel = true;
                }
                if (baseSusLevel < comparableSusLevel) {
                        baseSusLevel = comparableSusLevel;
                        indexOfHighSusLevel = index;
                        isEqualSusLevel = false;
                }
        }
        if (isEqualSusLevel == true) {
                return;
        }

        getPlayers()[indexOfHighSusLevel].setFrozen(true);
        gameOver();
}

public void completeTask() {
        if (!this.isFrozen()) {
                if (this.getTaskSpeed() > 20) {
                        this.setNumTask(this.getNumTask() -2);
                }
                else {
                        this.setNumTask(getNumTask() - 1);
                }
                if (this.getNumTask() < 0) {
                        this.setNumTask(0);
                }
                if (this.getNumTask() == 0) {
                        System.out.println("I have completed all my tasks");
                        this.setSusLevel((this.getSusLevel()) *(1/2));
                }
        }
}

public boolean equals (Object o) {
        if (o instanceof BlueAstronaut) {
                BlueAstronaut blueAstronaut = (BlueAstronaut) o;
                return this.getName().equals(blueAstronaut.getName()) && this.isFrozen() == blueAstronaut.isFrozen()
                       && this.getSusLevel() == blueAstronaut.getSusLevel() && this.getNumTask() == blueAstronaut.getNumTask()
                       && this.getTaskSpeed() == blueAstronaut.getTaskSpeed();
        }
        return false;
}

public String toString() {
        String taskStatement = "I have " + getNumTask() + " tasks left over";
        if (getSusLevel() > 15) {
                return super.toString().toUpperCase() + " " + taskStatement.toUpperCase();
        }
        else {
                return super.toString() + " " + taskStatement;
        }
}

public int getTaskSpeed() {
        return taskSpeed;
}

public int getNumTask() {
        return numTask;
}

public void setTaskSpeed(int taskSpeed) {
        if (taskSpeed >= 0) {
                this.taskSpeed = taskSpeed;
        }
        else {
                this.taskSpeed = 0;
        }
}

public void setNumTask(int numTask) {
        this.numTask = numTask;
}
}
