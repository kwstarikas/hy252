package csd.uoc.gr.A21;
import java.util.Scanner;



public class main {


    public static void main(String[] args) {
    /*System.out.println(new SolidShape(2, 1, 5.12));
    System.out.println(new Sphere(2,1,5.12,10));
    System.out.println(new Cube(2,1,5.12,5));
    System.out.println(new Cylinder(2,1,5.12,10,3));
*/

        Drawing  x = new Drawing();

        int j,flag;
        Scanner myInput = new Scanner( System.in );
        System.out.println("Enter an intiger to make speres");
        j = myInput.nextInt();

        Sphere spere;
        Cube cube;
        flag = j;
        for (int i=0; i<50; i++){
            spere = new Sphere(2,1,5.12,flag);
            flag++;
            x.add(spere);
        }
        System.out.println("(c-i) :\n"+x);

        for (int i=0; i<25; i++){
            spere = new Sphere(2,1,5.12,j);
            cube = new Cube(2,1,5.12,j);
            j++;
            x.add(spere);
            x.add(cube);
        }
        System.out.println("\n(c-ii) :\n"+x);
    }

}
