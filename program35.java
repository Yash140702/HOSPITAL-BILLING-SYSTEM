
              // ######************* HOSPITAL BILL SYSTEM ***********##############
                                                                          // Designed By: YASH BATRA

import java.util.Scanner;

public class program35 {
    float treatmentcost;
    double discount;
    String PATname, Disorder, Treatment;
    char SEX, bloodreq, BG;
    long mob;
    int age, bloodcost;

    void patientDetails(String Pname, String Dis, String treat, char bgroup, char sex, long mobile, int AGE,
            char blrequire) {
        PATname = Pname;
        Disorder = Dis;
        Treatment = treat;
        BG = bgroup;
        SEX = sex;
        mob = mobile;
        age = AGE;
        bloodreq = blrequire;

    }

    void showPatient() {

        System.out.println("=> PATIENT NAME: " + PATname);
        System.out.println("=> DISORDER: " + Disorder);
        System.out.println("=> TREATMENT: " + Treatment);
        System.out.println("=> BLOOD REQUIRED: " + bloodreq);
        System.out.println("=> BLOOD GROUP: " + BG+"+");
        System.out.println("=> SEX: " + SEX);
        System.out.println("=> MOBILE NO.: " + mob);
        System.out.println("=> AGE: " + age);
    }

    int bloodNeed(char bg, int n) {

        switch (bg) {
            case 'A': {
                bloodcost = 1100;
                System.out.println("=> The price of A bloodgroup per bottle is: " + bloodcost);
                System.out.println("=> The total bloodcost is: " + (bloodcost * n));
            }
                break;
            case 'B': {
                bloodcost = 1200;
                System.out.println("=> The price of B bloodgroup per bottle is: " + bloodcost);
                System.out.println("=> The total bloodcost is: " + (bloodcost * n));
            }
                break;
            case 'C': {
                bloodcost = 2100;
                System.out.println("=> The price of AB(or C) bloodgroup per bottle is: " + bloodcost);
                System.out.println("=> The total bloodcost is: " + (bloodcost * n));
            }
                break;
            case 'O': {
                bloodcost = 950;
                System.out.println("=> The price of O bloodgroup per bottle is: " + bloodcost);
                System.out.println("=> The total bloodcost is: " + (bloodcost * n));
            }
                break;
            default:
                System.out.println("=> You entered wrong blood group");
        }

        return (bloodcost * n);
    }

    float treatment(String treat) {
        if (treat.equalsIgnoreCase("TARGETED")) {
            treatmentcost = 25000;
            System.out.println("=> Targetedtherapy Treatment cost: " + treatmentcost);
        }
        if (treat.equalsIgnoreCase("CHEMO")) {
            treatmentcost = 300000;
            System.out.println("=> Chemotherapy Treatment cost: " + treatmentcost);
        }
        if (treat.equalsIgnoreCase("SURGERY")) {
            treatmentcost = 8000;
            System.out.println("=> Surgery Treatment cost: " + treatmentcost);
        }
        if (treat.equalsIgnoreCase("RADIATION")) {
            treatmentcost = 150000;
            System.out.println("=> Radiationtherapy Treatment cost: " + treatmentcost);
        }
        return treatmentcost;
    }

    double discount(int age) {
        if (age > 70) {
            discount = 0.2;
            System.out.println("(Senior citizen above 70 years of age gets 20% discount)");

        } else {
            discount = 0.05;
            System.out.println("(Below 70 years of age gets 5% discount)");
        }
        return discount;
    }

    void showBill(float bcost, float tre, double dis) {
        System.out.println("=> The bill without including discount is: " + (bcost + tre));
        double finalcost = (bcost + tre) - dis * (bcost + tre);
        System.out
                .println("=> The final bill to be paid by the patient to the hospital after discount is: " + finalcost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter patient name: ");
        String patname = sc.nextLine();
        System.out.println();
        System.out.println("DISORDER: ");
        String Disorder = sc.nextLine();
        System.out.println();
        System.out.println("TREATMENT: ");
        String treatment = sc.nextLine();
        System.out.println();
        System.out.println("BLOOOD GROUP(for AB blood group type C): ");
        char bg = sc.next().charAt(0);
        System.out.println();
        System.out.println("SEX (Enter M for male & F for female): ");
        char sex = sc.next().charAt(0);
        System.out.println();
        System.out.println("BLOOD REQUIRED (If required,then press Y): ");
        char blreq = sc.next().charAt(0);
        System.out.println();
        System.out.println("MOBILE NUMBER: ");
        long mobile = sc.nextLong();
        System.out.println();
        System.out.println("AGE: ");
        int age = sc.nextInt();
        System.out.println("******************************************************");
        program35 obj = new program35();
        obj.patientDetails(patname, Disorder, treatment, bg, sex, mobile, age, blreq);
        obj.showPatient();
        int bcost = 0;
        if (blreq == 'Y') {
            System.out.println("NO. OF BOTTLE NEEDED: ");
            int c = sc.nextInt();

            bcost = obj.bloodNeed(bg, c);
        }
        System.out.println("***************************************************************************");
        float tre = obj.treatment(treatment);
        double dis = obj.discount(age);
        obj.showBill(bcost, tre, dis);

        sc.close();

    }
}
