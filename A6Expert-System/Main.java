import java.util.ArrayList;
import java.util.Scanner;

class Patient 
{
    String name;
    int age;
    String[] symptoms;
    String diagnosis;
    String doctor;
    String medicine;

    Patient(String name, int age, String[] symptoms) 
    {
        this.name = name;
        this.age = age;
        this.symptoms = symptoms;
    }

    void displayInfo() 
    {
        System.out.println("\nPatient Name: " + name);
        System.out.println("Age: " + age);
        System.out.print("Symptoms: ");
        for (String s : symptoms) 
        {
            System.out.print(s + ", ");
        }
        System.out.println("\nDiagnosis: " + (diagnosis != null ? diagnosis : "Pending"));
        System.out.println("Assigned Doctor: " + (doctor != null ? doctor : "Not Assigned"));
        System.out.println("Suggested Medicine: " + (medicine != null ? medicine : "Not Prescribed"));
    }
}

class HospitalExpertSystem 
{
    ArrayList<Patient> patients = new ArrayList<>();

    void addPatient(Patient patient) 
    {
        patients.add(patient);
        diagnosePatient(patient);
    }

    void diagnosePatient(Patient patient) 
    {
        int fever = 0, cough = 0, fatigue = 0, headache = 0, stomach = 0;

        for (String symptom : patient.symptoms) 
        {
            String s = symptom.toLowerCase().trim();
            if (s.contains("fever")) fever++;
            if (s.contains("cough")) cough++;
            if (s.contains("fatigue")) fatigue++;
            if (s.contains("headache")) headache++;
            if (s.contains("stomach")) stomach++;
        }


        if (fever > 0 && cough > 0 && fatigue > 0) 
        {
            patient.diagnosis = "Influenza (Flu)";
            patient.doctor = "Dr. Sharma";
            patient.medicine = "Paracetamol, Cough Syrup";
        } 
        else if (fever > 0 && headache > 0) 
        {
            patient.diagnosis = "Viral Fever";
            patient.doctor = "Dr. Gupta";
            patient.medicine = "Ibuprofen";
        } 
        else if (stomach > 0 && fatigue > 0) 
        {
            patient.diagnosis = "Gastritis";
            patient.doctor = "Dr. Patel";
            patient.medicine = "Antacid";
        } 
        else if (cough > 0) 
        {
            patient.diagnosis = "Mild Cough";
            patient.doctor = "Dr. Singh";
            patient.medicine = "Cough Drops";
        } 
        else 
        {
            patient.diagnosis = "Consult Specialist";
            patient.doctor = "Not Assigned";
            patient.medicine = "Not Prescribed";
        }
    }

    void displayPatients() 
    {
        for (Patient p : patients) 
        {
            p.displayInfo();
        }
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        HospitalExpertSystem system = new HospitalExpertSystem();

        while (true) 
        {
            System.out.println("\n1. Add Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) 
            {
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Symptoms (comma separated): ");
                String input = sc.nextLine();

                String[] symptoms = input.split(",");

                Patient p = new Patient(name, age, symptoms);
                system.addPatient(p);

                System.out.println("\nPatient Added Successfully!");
                p.displayInfo();

            } 
            else if (choice == 2) 
            {
                system.displayPatients();

            } 
            else if (choice == 3) 
            {
                System.out.println("Exiting...");
                break;

            } 
            else 
            {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
