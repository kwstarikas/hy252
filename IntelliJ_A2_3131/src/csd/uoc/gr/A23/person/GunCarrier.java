package csd.uoc.gr.A23.person;

import csd.uoc.gr.A23.armor.Gun;

public class GunCarrier {
    Gun gun;

    /**
     * make gun constractor
     * @param gun
     */
    GunCarrier(Gun gun){
        this.gun = gun;
    }

    /**
     *
     * @return gun
     */
    public Gun getGun() {
        return gun;
    }

    /**
     *
     * @param gun
     */
    public void setGun(Gun gun) {
        this.gun = gun;
    }
}
