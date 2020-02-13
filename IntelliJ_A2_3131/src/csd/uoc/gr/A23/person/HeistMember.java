package csd.uoc.gr.A23.person;
import csd.uoc.gr.A23.armor.Gun;


public class HeistMember extends Member {

    /**
     * constructor to set a HeistMember
     * @param name
     * @param gun
     * @param bodyArmor
     * @param iq
     * @param physicalStrength
     */
    public HeistMember(String name, Gun gun, boolean bodyArmor, int iq, int physicalStrength) {
        super(name, 10, gun, bodyArmor, iq, physicalStrength);
    }
}
