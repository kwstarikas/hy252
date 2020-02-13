package csd.uoc.gr.A23.person;

import csd.uoc.gr.A23.armor.Gun;
import csd.uoc.gr.A23.exception.DeadCharacterException;

import java.util.Random;

public abstract class Member extends GunCarrier implements Character {

    private final String name;
    private int health;
    private final boolean armor;
    private final int iq;
    private final int physicalStrength;

    /**
     * constructor to set a member
     * @param name
     * @param health
     * @param gun
     * @param bodyArmor
     * @param iq
     * @param physicalStrength
     */
    public Member(String name, int health, Gun gun, boolean bodyArmor, int iq, int physicalStrength){
        super(gun);
        this.name = name;
        this.health = health;
        this.armor = bodyArmor;
        this.iq = iq;
        this.physicalStrength = physicalStrength;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     *
     * @return true if Member is alive
     * @return false if Member is dead
     */
    public boolean isAlive(){

        if(health > 0) return true;
        return false;

    }

    /**
     *
     * @return true if Member has bodyArmor
     * @return false if Member has not bodyArmor
     */
    boolean hasBodyArmor(){
        if (armor) return true;
        return false;
    }

    /**
     * reduces the health by damage param
     * @param damage
     */
    public void damageHealth(int damage){
        health -= damage;
    }

    /**
     *
     * @return the sum of the iq and physicalStrength of a Member
     */
    public int calculateAtomicPower(){
        return iq+physicalStrength;
    }

    /**
     * calculate the damage is done
     * @param adversary
     * @throws DeadCharacterException
     */
    public void fight(Character adversary) throws DeadCharacterException { // VALE TO EXCEPTION
        int memberPower = gun.getPower();
        if(adversary instanceof Member ){
            if(adversary instanceof Insider )
                health -= 2;
            else{
                if(((Member) adversary).hasBodyArmor()) {
                    health = health - (memberPower/2 + ( (Member.this.calculateAtomicPower()-adversary.calculateAtomicPower()))
                    +handleHostage());
                }else {
                    health = health - (memberPower +
                            (Member.this.calculateAtomicPower()-adversary.calculateAtomicPower())
                    +handleHostage());
                }
            }

        }
        else{
            if(((Member) adversary).hasBodyArmor()) {
                health = health - (memberPower/2 + ( (Member.this.calculateAtomicPower()-adversary.calculateAtomicPower()))
                        +handleHostage());
            }else {
                health = health - (memberPower +
                        (Member.this.calculateAtomicPower()-adversary.calculateAtomicPower())
                        +handleHostage());
            }

        }
    }

    /**
     *
     * @return a rundom int
     * -2 2 hostages released
     * -1 1 hostage released
     * 0 0 hostages released 0 taken
     * 1 1 man was held hostage during the battle
     * 2 2 man was held hostage during the battle
     *
     */
    int handleHostage(){
        Random r = new Random();
        return r.nextInt((2 - -2) + 1) -2;

    }

}
