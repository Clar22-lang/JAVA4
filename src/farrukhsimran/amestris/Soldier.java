package farrukhsimran.amestris;

import lombok.Getter;
import lombok.Setter;

/**
 * The Infantry class extends the farrukhsimran.amestris.Orc class and contains the same methods it
 * does. The infantry class also has two super constructors and one field
 * constructor.
 *
 * @author SIMRAN
 */
@Getter
@Setter
public class Soldier extends Orc {

    private Warlord commanderWarlord;

    @Override
    public String getMonsterType() {
        return "Infantry farrukhsimran.amestris.Soldier (farrukhsimran.amestris.Orc)";
    }

    public void setCommanderWarlord(Warlord commanderWarlord) {
        this.commanderWarlord = commanderWarlord;
    }

    public void healthBoost() {
        if (getHealth() > 0) {
            addHealth(commanderWarlord.getLeadershipRating() * 5);
        } else {
            System.out.println("Dead monsters cannot be revived");
        }
    }

    @Override
    public String toString() {
        return "\nfarrukhsimran.amestris.Orc (Infantry) \nName: " + name + " | farrukhsimran.amestris.Clan: " + clanAffiliation + " | Battle Score: " + getBattleScore() + " | Treasure: " + treasure + " | Health: " + health;
    }

}
