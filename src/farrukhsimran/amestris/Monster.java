package farrukhsimran.amestris;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * The farrukhsimran.amestris.Monster class is an abstract class with the fields and methods generic to
 * farrukhsimran.amestris.Monster type that can be inherited by other farrukhsimran.amestris.Monster type classes
 *
 * @author SIMRAN
 */
@RequiredArgsConstructor
@Getter
@Setter
public abstract class Monster {

    protected String name;
    protected Clan clanAffiliation;
    protected int ferocity, defense, magic = 0;
    protected int treasure = 0;
    protected int health = 100;

    public abstract void setClanAffiliation(Clan clanAffiliation);

    public abstract String getMonsterType();

    public void addTreasure(double treasure) {
        if (health > 0) {
            this.treasure += treasure;
        }
    }

    public void subtractTreasure(double treasure) {
        if (health > 0) {
            this.treasure -= treasure;
            if (this.treasure < 0) {
                this.treasure = 0;
            }
        }
    }

    public void addHealth(double amount) {
        if (health > 0) {
            health += amount;
        }
    }

    public void subtractHealth(double score) {
        if (health > 0) {
            health -= score;
            if (health < 0) {
                health = 0;
            }
        }
    }

    public double getBattleScore() {
        if (health <= 0) {
            return 0;
        }
        return (ferocity + defense + magic) / 3.0;
    }

    public void attack(Monster opponent) {
        if (getHealth() > 0) {
            double score = getBattleScore();
            if (opponent.getBattleScore() > score) {
                addTreasure(1);
                subtractHealth(score);
            } else {
                subtractTreasure(1);
                opponent.subtractHealth(score);
            }
        } else {
            System.out.println("dead cannot attack");
        }
    }

}
