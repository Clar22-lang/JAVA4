# The Inhabitants of Amestris
In the town of Amestris in the magical land of Fairytale there are three kinds of Monsters:
```bash
* Orcs
* Goblins
* Manticores 
``` 

## Attributes
- All Monsters have a clan affiliation that cannot change.
- They all have numeric ratings for three basic attributes that describe their
  abilities:
```bash
* Ferocity
* Defense
* Magic
``` 
- These attributes can be raised or lowered by one point at a time, within the range of 0 to 20.
- The clan affiliation and basic attributes of a Monster are obvious and can be easily retrieved by anyone.
- All Monsters have 0 or more treasure.
- They all have a numeric health rating. If they have health > 0 they
  are alive, otherwise, they are dead.
- The clan affiliation of a Monster cannot change, unless that monster is a Manticore – they’re fickle and change clans all the time.
- Every Goblin has exactly one other Goblin that is its sworn enemy. This enemy is fixed at birth and never changes, even if it dies.
- An Orc can be Infantry or Warlord. Warlords have an integer leadership rating from 1 to 5. This rating can be raised or lowered by 1 point at a time.
- Every warlord has exactly 5 Infantry in his or her command, and every Infantry member has exactly one Warlord that commands it.
- The assignments of Infantry to Warlord are frequently changed.

## Abilities
### Attack and Defense
- When a Monster attacks, it produces a battle score equal to the average of its Ferocity, Defense, and Magic scores. If its opponent’s attack score is higher, it loses health points equal to the difference in attack scores. (e.g. if a Manticore with an attack score of 18.5 fights a Goblin with an attack score of 10.7, the Goblin will lose 7.8 health.)
- When a Manticore or a Warlord attacks, its battle score is greater than a normal Monster’s score by a factor of 1.5.
- Dead Monsters cannot attack or defend themselves.

### Healing
- When a Warlord sounds its battle cry, it produces a health boost score equal to its leadership rating multiplied by 5 and raises the health score of each of the Infantry in its command by that amount.
- Dead Warlords cannot sound their battle cry and dead Infantry cannot be healed.

### Treasure
- A monster can gain or lose treasure as a result of a fight.
- A Dead monster cannot gain treasure.
