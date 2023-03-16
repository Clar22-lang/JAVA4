package farrukhsimran.amestris;

import lombok.Getter;
import lombok.Setter;

/**
 * The farrukhsimran.amestris.Goblin class extends the farrukhsimran.amestris.Monster class method and contains a swornEnemy
 * field. A goblin's swornEnemy can only be another goblin.
 *
 * @author SIMRAN
 */
@Getter
@Setter
public class Goblin extends Monster {

    private Goblin swornEnemy;

    @Override
    public void setClanAffiliation(Clan clanAffiliation) {
        if (this.clanAffiliation != null) {
            System.out.println(getMonsterType() + "s cannot change their clan affiliations once set");
        } else {
            this.clanAffiliation = clanAffiliation;
        }
    }

    @Override
    public String getMonsterType() {
        return "farrukhsimran.amestris.Goblin";
    }

    public void attack(Monster opponent) {
        if (!opponent.getMonsterType().equals("farrukhsimran.amestris.Goblin")) {
            System.out.println("Goblins can only attack their sworn enemies which can only be Goblins");
        }
        if (getHealth() > 0) {
            double score = getBattleScore();
            if (opponent.getBattleScore() > score) {
                subtractTreasure(1);
                subtractHealth(score);
            } else {
                addTreasure(1);
                opponent.subtractHealth(score);
            }
        } else {
            System.out.println("dead cannot attack");
        }
    }

    @Override
    public String toString() {
        return "\nfarrukhsimran.amestris.Goblin \nName: " + name + " | Sworn Enemy: " + swornEnemy + " | farrukhsimran.amestris.Clan: " + clanAffiliation + " | Battle Score: " + getBattleScore() + " | Treasure: " + treasure + " | Health: " + health;
    }

}