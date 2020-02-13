package csd.uoc.gr.A23.person;


/**
 * my Character Interface
 */
public interface Character {

    boolean isAlive();
    int getHealth();
    void damageHealth(int damage);
    int calculateAtomicPower();
}
