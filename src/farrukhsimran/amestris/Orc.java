package farrukhsimran.amestris;

import lombok.Getter;
import lombok.Setter;

/**
 * The farrukhsimran.amestris.Orc class extends the farrukhsimran.amestris.Monster class. The farrukhsimran.amestris.Orc class is also a super class
 * for Infantry and farrukhsimran.amestris.Warlord classes.
 *
 * @author SIMRAN
 */
@Getter
@Setter
public class Orc extends Monster {

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
        return "farrukhsimran.amestris.Orc";
    }
}