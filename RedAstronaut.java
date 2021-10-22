import java.util.Arrays;
public class RedAstronaut extends Player implements Impostor {
private String skill;
private String[] validSkills = {"inexperienced", "experienced", "expert"};

public RedAstronaut(String name) {
        this(name, 15, "experienced");
}
public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        for (int index = 0; index < validSkills.length; index++) {
                if (skill.equalsIgnoreCase(validSkills[index])) {
                        this.skill = skill;
                }
                else {
                        this.skill = "experienced";
                }
        }
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
        for (int index = x + 1; index < getPlayers().length; index++) {
                if (getPlayers()[index].isFrozen()) {
                        continue;
                }
                comparableSusLevel = getPlayers()[index].getSusLevel();
                if (baseSusLevel == comparableSusLevel) {
                        isEqualSusLevel = true;
                }
                else if (baseSusLevel < comparableSusLevel) {
                        baseSusLevel = comparableSusLevel;
                        indexOfHighSusLevel = index;
                        isEqualSusLevel = false;
                }
        }
        if ((getPlayers()[indexOfHighSusLevel]).equals(this)) {
                return;
        }
        if (isEqualSusLevel == true) {
                return;
        }
        getPlayers()[indexOfHighSusLevel].setFrozen(true);
        gameOver();
}

public void freeze(Player p) {
        if (p instanceof Impostor) {
                return;
        }
        if (!this.isFrozen() && !p.isFrozen()) {
                if (this.getSusLevel() < p.getSusLevel()) {
                        p.setFrozen(true);
                }
                else {
                        this.setSusLevel((this.getSusLevel()) * 2);
                }
                gameOver();
        }
}

public void sabotage(Player p) {
        if (p instanceof Impostor) {
                return;
        }
        else {
                if ((!this.isFrozen()) && (!p.isFrozen())) {
                        int userSusLevel = this.getSusLevel();
                        if(userSusLevel < 20) {
                                p.setSusLevel((int)((double)p.getSusLevel() * 1.5));
                        }
                        else {
                                p.setSusLevel((int)((double)p.getSusLevel() * 1.25));
                        }
                }
        }
}

public boolean equasls(Object o) {
        if (o instanceof RedAstronaut) {
                RedAstronaut redAstronaut = (RedAstronaut) o;
                return this.getName().equals(redAstronaut.getName()) && this.isFrozen() == redAstronaut.isFrozen() &&
                       this.getSusLevel() == redAstronaut.getSusLevel() && this.getSkill() == redAstronaut.getSkill();
        }
        return false;
}

public String toString() {
        String skillStatement = "I am an " + getSkill() + " player!";
        if (getSusLevel() > 15) {
                return super.toString().toUpperCase() + " " + skillStatement.toUpperCase();
        }
        else {
                return super.toString() + " " + skillStatement;
        }
}

public String getSkill() {
        return skill;
}

public void setSkill(String skill) {
        this.skill = skill;
}
}
