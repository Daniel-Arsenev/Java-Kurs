import java.util.Scanner;

public class Taschenrechner {
    static Scanner scanner = new Scanner(System.in);
    


    static complex getUserNumber(int num){
        complex ret = new complex();
        
        System.out.println("Komplexe Zahl " + num);

        System.out.print("Re Teil: ");
        ret.re = scanner.nextDouble();

        System.out.print("Im Teil: ");
        ret.im = scanner.nextDouble();

        System.out.println();

        return ret;
    }

    static void printComplex(complex z1){
        System.out.println(z1.re + " + " + z1.im + "i");
    }



    public static void main(String[] args) {
        System.out.print("Operation: ");
        String op = scanner.next();
        System.out.println();

        complex res = new complex();
        complex z1 = new complex();
        complex z2 = new complex();
        switch(op) {
            case "Addition":
                z1 = getUserNumber(1);
                z2 = getUserNumber(2);

                res = complex.add(z1, z2);
                break;

            case "Subtraktion":
                z1 = getUserNumber(1);
                z2 = getUserNumber(2);

                res = complex.sub(z1, z2);
                break;

            case "Multiplikation":
                z1 = getUserNumber(1);
                z2 = getUserNumber(2);

                res = complex.mul(z1, z2);
                break;

            case "Konjugation":
                z1 = getUserNumber(1);
                res = complex.conj(z1);
                break;

            case "Betrag":
                z1 = getUserNumber(1);
                res = complex.abs(z1);
                break;

            case "Division":
                z1 = getUserNumber(1);
                z2 = getUserNumber(2);

                res = complex.div(z1, z2);
                break;

            default:
                System.out.println("nicht valide Operation (ache auf richtige Schreibweise?)");
                System.out.println();
                return;
        }

        printComplex(res);


    }

    
}