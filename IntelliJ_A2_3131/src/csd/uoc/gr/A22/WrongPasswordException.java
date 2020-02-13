package csd.uoc.gr.A22;

public class WrongPasswordException extends Exception {


    /**
     * @see throws an exception if the password is incorect
     */
    WrongPasswordException(){
        super("Wrong Password");
    }
}
