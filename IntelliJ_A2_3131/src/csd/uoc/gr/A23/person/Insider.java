package csd.uoc.gr.A23.person;
import csd.uoc.gr.A23.armor.Gun;

public class Insider extends Member{

    /**
     * constructor to set an insider
     * @param name
     * @param gun
     * @param bodyArmor
     * @param iq
     * @param physicalStrength
     */
    public Insider(String name, Gun gun, boolean bodyArmor, int iq, int physicalStrength){
        super(name,17, gun, bodyArmor, iq, physicalStrength);
    }
}
