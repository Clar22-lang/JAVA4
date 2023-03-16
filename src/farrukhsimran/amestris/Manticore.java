package farrukhsimran.amestris;

import lombok.Getter;
import lombok.Setter;

/**
 * The farrukhsimran.amestris.Manticore class extends the farrukhsimran.amestris.Monster class and contains a modified attack
 * method.
 *
 * @author SIMRAN
 */
@Getter
@Setter
public class Manticore extends Monster {

    private final String type = "farrukhsimran.amestris.Manticore";

    @Override
    public void setClanAffiliation(Clan clanAffiliation) {
        this.clanAffiliation = clanAffiliation;
    }

    @Override
    public String getMonsterType() {
        return "farrukhsimran.amestris.Manticore";
    }

    @Override
    public void attack(Monster opponent) {
        if (getHealth() > 0) {
            double score = getBattleScore() * 1.5;
            if (opponent.getBattleScore() > score) {
                subtractTreasure(1);
                subtractHealth(score);
            } else {
                addTreasure(1);
                opponent.subtractHealth(score);
            }
        } else {
            System.out.println("Dead monsters cannot attack");
        }
    }

    @Override
    public String toString() {
        return "\nfarrukhsimran.amestris.Manticore \nName: " + name + " | farrukhsimran.amestris.Clan: " + clanAffiliation + " | Battle Score: " + getBattleScore() + " | Treasure: " + treasure + " | Health: " + health;

    }

}
