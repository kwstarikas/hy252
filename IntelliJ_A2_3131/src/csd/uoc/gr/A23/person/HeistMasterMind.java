package csd.uoc.gr.A23.person;

import csd.uoc.gr.A23.armor.Gun;

public class HeistMasterMind extends Member {

    /**
     * constructor to set a HeistMastermind
     * @param name
     * @param gun
     * @param bodyarmor
     * @param iq
     * @param physicalStrength
     */
    public HeistMasterMind(String name, Gun gun, int bodyarmor, int iq, int physicalStrength){
        super(name,15, gun,false, iq, physicalStrength);

    }
}
