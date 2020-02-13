package csd.uoc.gr.A23.battle;

import csd.uoc.gr.A23.person.Member;
import csd.uoc.gr.A23.utilities.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Group {


    private String groupName;
    private List<Member> members ;


    /**
     * Finds and returns a random integer number
     *
     * @param name the name of a group

     * @return the random integer
     */
    Group(String name){

        groupName = name;
        if (name.equals("")) throw  new IllegalArgumentException("Name is empy");

      //  else if(members.contains(groupName)) System.out.println("Member already exists");

        else  members = new ArrayList<Member>();

    }


    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }


    /**
     * @return the size of member list
     */
    int getSize(){
        return members.size();
    }


    /**
     * @return the Number of alive members in the list
     */
    public int getNumberOfAliveMembers(){
        int alive = 0;

        for(int i=0; i<members.size(); i++){
            if(members.get(i).isAlive()){
                alive++;
            }
        }
        return alive;

    }


    /**
     * @return false if the list has alive members
     * @return true if not
     */
    public boolean isDefeated(){

        for(int i=0; i<members.size(); i++){
            if(members.get(i).isAlive()) return false ;
        }
        return true;
    }


    /**
    picks a random Member
    getRandomVal couldnt work here :( dunno why
    @returns a Members field

     */
    public Member pickRandomAliveMember(){

        if(members.isEmpty() || isDefeated()) return null;
        Random rand = new Random();
        int pick = rand.nextInt(members.size()  + 1) ;
        return members.get(pick);
    }


    /**
     * Adds a new member;
     * @param member
     */
    public void addMember(Member member){
        if (member == null)  throw new IllegalArgumentException("member is null") ;
        else members.add(member);
    }


}
