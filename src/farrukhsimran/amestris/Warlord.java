package farrukhsimran.amestris;

import lombok.Getter;
import lombok.Setter;

/**
 * The farrukhsimran.amestris.Warlord class extends the farrukhsimran.amestris.Orc class and contains the same methods it
 * does. The warlord class also has two super constructors and one field
 * constructor.
 *
 * @author SIMRAN
 */
@Getter
@Setter
public class Warlord extends Orc {

    private final Soldier[] infantries = new Soldier[5];

    private int leadershipRating = 0;

    @Override
    public String getMonsterType() {
        return "farrukhsimran.amestris.Warlord (farrukhsimran.amestris.Orc)";
    }

    public int getLeadershipRating() {
        for (Soldier soldier : infantries) {
            if (soldier != null) {
                if (soldier.getHealth() == 0) {
                    removeInfantry(soldier);
                }
            }
        }
        return leadershipRating;
    }

    public void soundBattleCry() {
        if (getHealth() > 0) {
            int boost = leadershipRating * 5;
            System.out.println("\n" + getClanAffiliation()
                    + " Commander sounds their battle cry, boosting the health of their Infantry by " + boost);
            for (Soldier soldier : infantries) {
                if (soldier != null) {
                    soldier.healthBoost();
                }
            }
        } else {
            System.out.println(getClanAffiliation() + " cannot sound their battle cry - they are dead");
        }

    }

    public void addInfantry(Soldier soldier) {
        boolean added = false;
        boolean dead = false;
        for (int i = 0; i < infantries.length; i++) {
            if (infantries[i] == null) {
                if (soldier.getHealth() > 0) {
                    infantries[i] = soldier;
                    soldier.setCommanderWarlord(this);
                    soldier.setClanAffiliation(this.clanAffiliation);
                    added = true;
                    break;
                } else {
                    dead = true;
                }
            }
        }
        if (!dead && !added) {
            System.out.println("This farrukhsimran.amestris.Warlord already has 5 soldiers in their Infantry");
        } else if (dead) {
            System.out.println("Dead soldiers cannot be added to Infantry");
        } else {
            System.out.println("farrukhsimran.amestris.Warlord added soldier " + soldier.getName() + " to Infantry");
            leadershipRating++;
        }
    }

    public void removeInfantry(Soldier soldier) {
        for (int i = 0; i < infantries.length; i++) {
            if (infantries[i] == soldier) {
                infantries[i] = null;
                soldier.setCommanderWarlord(null);
                break;
            }
        }
        leadershipRating--;
        System.out.println("\nfarrukhsimran.amestris.Warlord removed dead soldier from Infantry\n");
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
            addTreasure(treasure++);
            System.out.println("dead cannot attack");
        }
    }

    @Override
    public String toString() {
        return "\nfarrukhsimran.amestris.Orc (farrukhsimran.amestris.Warlord) \nName: " + name + " | Leadership Rating: " + leadershipRating + " | farrukhsimran.amestris.Clan: " + clanAffiliation + " | Battle Score: " + getBattleScore() + " | Treasure: " + treasure + " | Health: " + health;
    }

}