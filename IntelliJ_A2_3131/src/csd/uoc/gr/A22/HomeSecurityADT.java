package csd.uoc.gr.A22;

public abstract class  HomeSecurityADT {


    /**
     *checks the current state of an alarm
     * @param status
     * @return status -1 if its not armed 0 stay condition 1 armed
     */
    public int checkAlarmStatus(int status ){
        return status ;
    };

    /**
     *sets an alarm
     * @return true
     */
    public boolean armAlarm() throws DoorsOpenException{
        return true;
    };


    /**
     *
     * @return true if stay is enable
     */
    public boolean stayEnable() throws DoorsOpenException,NotDisarmedException{
        return true;
    }

    /**
     * if the password is corrent , enable stay or arm status
     *
     * @param pass the current password
     * @return status
     */
    public abstract int disableArmStay(int[] pass);


    /**
     *
     * creates a new password
     *
     * @param pass
     * @return a new password
     */
    abstract public int[] changePass(int[] pass) throws NotDisarmedException;
}
