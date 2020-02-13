package csd.uoc.gr.A23.person;
import csd.uoc.gr.A23.armor.Gun;
import csd.uoc.gr.A23.armor.Rifle;

public class PoliceOfficer extends Member {

    /**
     * constructor to set a Police Officer
     * @param name
     * @param gun
     * @param bodyArmor
     * @param iq
     * @param physicalStrength
     */
    public PoliceOfficer(String name, Gun gun, boolean bodyArmor, int iq, int physicalStrength){
        super(name,10, gun, bodyArmor, iq, physicalStrength);
    }


}
