package farrukhsimran.amestris;

import java.util.Scanner;

/**
 * Runner Class
 *
 * @author SIMRAN
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("SETUP CLAN AFFILIATIONS FOR MONSTERS.");
        System.out.println("You can add, remove, or comment out set up for monsters in the main class as shown below");
        Goblin goblin = new Goblin();
        getClanAffiliationAndNameInput(input, goblin);
        getFerocityDefenseMagic(input, goblin);

        Goblin goblin2 = new Goblin();
        getClanAffiliationAndNameInput(input, goblin2);
        getFerocityDefenseMagic(input, goblin2);

        Warlord warlord = new Warlord();
        getClanAffiliationAndNameInput(input, warlord);
        getFerocityDefenseMagic(input, warlord);

        Warlord warlord2 = new Warlord();
        getClanAffiliationAndNameInput(input, warlord2);
        getFerocityDefenseMagic(input, warlord2);

        Soldier soldier = new Soldier();
        getNameInput(input, soldier);
        getFerocityDefenseMagic(input, soldier);
        Soldier soldier2 = new Soldier();
        getNameInput(input, soldier2);
        getFerocityDefenseMagic(input, soldier2);
        Soldier soldier3 = new Soldier();
        getNameInput(input, soldier3);
        getFerocityDefenseMagic(input, soldier3);
        Soldier soldier4 = new Soldier();
        getNameInput(input, soldier4);
        getFerocityDefenseMagic(input, soldier4);
        Soldier soldier5 = new Soldier();
        getNameInput(input, soldier5);
        getFerocityDefenseMagic(input, soldier5);
        Soldier soldier6 = new Soldier();
        getNameInput(input, soldier6);
        getFerocityDefenseMagic(input, soldier6);
        Soldier soldier7 = new Soldier();
        getNameInput(input, soldier7);
        getFerocityDefenseMagic(input, soldier7);
        Soldier soldier8 = new Soldier();
        getNameInput(input, soldier8);
        getFerocityDefenseMagic(input, soldier8);

        Manticore manticore = new Manticore();
        getClanAffiliationAndNameInput(input, manticore);
        getFerocityDefenseMagic(input, manticore);

        Manticore manticore2 = new Manticore();
        getClanAffiliationAndNameInput(input, manticore2);
        getFerocityDefenseMagic(input, manticore2);

        System.out.println("TRYING TO MODIFY CLAN AFFILIATIONS OF OTHER MONSTERS");
        System.out.println("Only Manticores are allowed to change clan affiliations");
        System.out.println(goblin);
        goblin.setClanAffiliation(Clan.valueOf(input.next().toUpperCase()));
        System.out.println(goblin);
        System.out.println(warlord);
        warlord.setClanAffiliation(Clan.valueOf(input.next().toUpperCase()));
        System.out.println(warlord);
        System.out.println(manticore);
        manticore.setClanAffiliation(Clan.valueOf(input.next().toUpperCase()));
        System.out.println(manticore);

        System.out.println("WARLORDS ARE ADDING SOLDIERS TO THEIR INFANTRY");
        System.out.println("Warlords cannot add dead soldiers and cannot exceed more than 5 soldiers at a time");
        warlord.addInfantry(soldier);
        warlord.addInfantry(soldier2);
        warlord.addInfantry(soldier3);
        warlord.addInfantry(soldier4);
        warlord.addInfantry(soldier5);
        warlord.addInfantry(soldier6);
        warlord2.addInfantry(soldier7);
        warlord2.addInfantry(soldier8);

        System.out.println("SETTING SWORN ENEMIES FOR GOBLINS (as each other)");
        goblin.setSwornEnemy(goblin2);
        goblin2.setSwornEnemy(goblin);
        System.out.println(goblin);
        System.out.println(goblin2);

        System.out.println("INITIATING BATTLES BETWEEN MONSTERS");
        System.out.println("You can add, remove, or comment out monster battles in the main class as shown below");
        battle(warlord, warlord2);
        battle(manticore2, soldier2);
        battle(soldier6, goblin2);
        battle(goblin2, goblin);

        System.out.println("SETTING INFANTRY MONSTER'S HEALTH TO 0 TO CHECK IF IT IS REMOVED FROM WARLORD'S INFANTRY");
        System.out.println("Once a monster dies, it cannot attack, gain health boosts, or gain treasures");
        System.out.println("If SOLDIER dies, it is removed from warlord's infantry, decreasing the " +
                "warlord's leadership rating by 1");
        soldier.setHealth(0);

        System.out.println("THE WARLORDS BATTLE CRY WILL BOOST THE HEALTHS OF ONLY ALIVE INFANTRY SOLDIERS");
        System.out.println("The health boost is equal to the warlord's leadership rating * 5");
        warlord.soundBattleCry();

        System.out.println("FINAL STATS:");
        System.out.println(goblin);
        System.out.println(warlord);
        System.out.println(warlord2);
        System.out.println(soldier);
        System.out.println(soldier7);
        System.out.println(manticore);
    }

    private static void getClanAffiliationAndNameInput(Scanner input, Monster monster) {
        System.out.println("\nEnter a name for the new " + monster.getMonsterType());
        monster.setName(input.next());
        System.out.println("Enter " + monster.getName() + "'s clan affiliation. Your choices are: \nGORGUN\nSALAMANDAR\nUZAMAKI\nLITHIAL\nJOAKS");
        monster.setClanAffiliation(Clan.valueOf(input.next().toUpperCase()));
    }

    private static void getNameInput(Scanner input, Monster monster) {
        System.out.println("\nEnter a name for the new " + monster.getMonsterType());
        monster.setName(input.next());
    }

    public static void getFerocityDefenseMagic(Scanner input, Monster monster) {
        System.out.println("Enter " + monster.getName() + "'s ferocity. Do not exceed 10 points.");
        monster.setFerocity(getDoubleInput(input));
        System.out.println("Enter " + monster.getName() + " defense. Do not exceed 10 points.");
        monster.setDefense(getDoubleInput(input));
        System.out.println("Enter " + monster.getName() + " magic. Do not exceed 10 points.");
        monster.setMagic(getDoubleInput(input));
    }

    public static int getDoubleInput(Scanner in) {
        int input;
        while (true) {
            input = in.nextInt();
            if (input <= 20 && input >= 1) // Break if you got the RIGHT number.
                break;
            System.out.print("Invalid input.\nEnter the number of points again (between 1-20):");
        }
        return input;
    }

    public static void battle(Monster monster1, Monster monster2) {
        Scanner input = new Scanner(System.in);
        boolean decide;
        do {
            monster1.attack(monster2);
            System.out.println(monster1);
            System.out.println(monster2);
            System.out.println("do you want to continue");
            decide = input.nextBoolean();
        }
        while (decide);
    }
}
