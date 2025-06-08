import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {

        Scanner scan = new Scanner ( System.in );

        System.out.print("skriv ett nummer:");
        String strNr = scan.next();
        int nr = Integer.parseInt(strNr);
        nr = nr + 100 ;
        System.out.print("Ditt nummer plus 100 blir: ");
        system.out.print(nr);
        scan.close();


    }
}
