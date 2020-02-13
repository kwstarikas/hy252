package csd.uoc.gr.A23.person;

import csd.uoc.gr.A23.armor.Gun;
import csd.uoc.gr.A23.armor.Rifle;


public class PoliceInspector extends Member {
    public PoliceInspector(String name, Gun gun, boolean bodyArmor, int iq, int physocalStrenght){
        super(name, 12, gun, false, iq ,physocalStrenght);
    }
}
