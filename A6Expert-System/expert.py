class Patient:
    def __init__(self, name, age, symptoms):
        self.name = name
        self.age = age
        self.symptoms = symptoms
        self.diagnosis = None
        self.doctor = None
        self.medicine = None

    def display_info(self):
        print("\nPatient Name:", self.name)
        print("Age:", self.age)
        print("Symptoms:", ", ".join(self.symptoms))
        print("Diagnosis:", self.diagnosis if self.diagnosis else "Pending")
        print("Assigned Doctor:", self.doctor if self.doctor else "Not Assigned")
        print("Suggested Medicine:", self.medicine if self.medicine else "Not Prescribed")


class HospitalExpertSystem:
    def __init__(self):
        self.patients = []

    def add_patient(self, patient):
        self.patients.append(patient)
        self.diagnose_patient(patient)

    def diagnose_patient(self, patient):
        fever = cough = fatigue = headache = stomach = 0

        for symptom in patient.symptoms:
            s = symptom.lower().strip()

            if "fever" in s:
                fever += 1
            if "cough" in s:
                cough += 1
            if "fatigue" in s:
                fatigue += 1
            if "headache" in s:
                headache += 1
            if "stomach" in s:
                stomach += 1

        if fever > 0 and cough > 0 and fatigue > 0:
            patient.diagnosis = "Influenza (Flu)"
            patient.doctor = "Dr. Sharma"
            patient.medicine = "Paracetamol, Cough Syrup"

        elif fever > 0 and headache > 0:
            patient.diagnosis = "Viral Fever"
            patient.doctor = "Dr. Gupta"
            patient.medicine = "Ibuprofen"

        elif stomach > 0 and fatigue > 0:
            patient.diagnosis = "Gastritis"
            patient.doctor = "Dr. Patel"
            patient.medicine = "Antacid"

        elif cough > 0:
            patient.diagnosis = "Mild Cough"
            patient.doctor = "Dr. Singh"
            patient.medicine = "Cough Drops"

        else:
            patient.diagnosis = "Consult Specialist"
            patient.doctor = "Not Assigned"
            patient.medicine = "Not Prescribed"

    def display_patients(self):
        for patient in self.patients:
            patient.display_info()


# Main Program
system = HospitalExpertSystem()

while True:
    print("\n1. Add Patient")
    print("2. Display Patients")
    print("3. Exit")

    choice = int(input("Enter choice: "))

    if choice == 1:
        name = input("Enter Name: ")
        age = int(input("Enter Age: "))

        symptoms_input = input("Enter Symptoms (comma separated): ")
        symptoms = symptoms_input.split(",")

        patient = Patient(name, age, symptoms)
        system.add_patient(patient)

        print("\nPatient Added Successfully!")
        patient.display_info()

    elif choice == 2:
        system.display_patients()

    elif choice == 3:
        print("Exiting...")
        break

    else:
        print("Invalid choice!")