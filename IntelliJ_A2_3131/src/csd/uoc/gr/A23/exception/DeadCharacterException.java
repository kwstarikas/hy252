package csd.uoc.gr.A23.exception;

import csd.uoc.gr.A23.person.Member;

public class DeadCharacterException extends Exception {

    /**
     * making the dead character exceotion
     */

    public DeadCharacterException(){
        super("Character is dead");
    }



}
