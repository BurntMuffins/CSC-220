// Shows the use of JavaDocs

class Sidekick{

}

/** This class describes a cool
 * superhero
 */

public class PotatoDog {
    /** an array of super powers */
    public String[] superPowers;

    /** Their sidekick */
    public Sidekick bat;

    /** Init sidekick */
    public PotatoDog(){
        
    }

    /** Use this method to attack
     * @param strength this is how strong you want the attack to be
     * @return the damage that the opponent will take
     */
    public int KarateChop (int strength){
        return strength * 500;
    }
}
