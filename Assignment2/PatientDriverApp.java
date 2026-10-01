/*
 * Class: CMSC203 
 * Instructor:Ahmed Tarek
 * Description: Make a program where it asks a patient to enter certain data in order to display the patient's information,
 *  the three medical procedures, and the total charges for those procedures.
 * Due: 9/30/2026
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Yizhu Wang
*/

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PatientDriverApp {

    public static void main(String[] args) {

        Patient patient = new Patient();
        Procedure procedure1 = new Procedure();
        Procedure procedure2 = new Procedure();
        Procedure procedure3 = new Procedure();

        JFrame frame = new JFrame("Patient & Procedure Info");
        frame.setSize(950, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel patientPanel = new JPanel(new GridLayout(10, 2, 5, 5));
        patientPanel.setBorder(
                BorderFactory.createTitledBorder("Patient Information"));

        JTextField firstName = new JTextField();
        JTextField middleName = new JTextField();
        JTextField lastName = new JTextField();
        JTextField address = new JTextField();
        JTextField city = new JTextField();
        JTextField state = new JTextField();
        JTextField zip = new JTextField();
        JTextField phone = new JTextField();
        JTextField emergencyName = new JTextField();
        JTextField emergencyPhone = new JTextField();

        patientPanel.add(new JLabel("First Name:"));
        patientPanel.add(firstName);
        patientPanel.add(new JLabel("Middle Name:"));
        patientPanel.add(middleName);
        patientPanel.add(new JLabel("Last Name:"));
        patientPanel.add(lastName);
        patientPanel.add(new JLabel("Address:"));
        patientPanel.add(address);
        patientPanel.add(new JLabel("City:"));
        patientPanel.add(city);
        patientPanel.add(new JLabel("State:"));
        patientPanel.add(state);
        patientPanel.add(new JLabel("ZIP:"));
        patientPanel.add(zip);
        patientPanel.add(new JLabel("Phone:"));
        patientPanel.add(phone);
        patientPanel.add(new JLabel("Emergency Name:"));
        patientPanel.add(emergencyName);
        patientPanel.add(new JLabel("Emergency Phone:"));
        patientPanel.add(emergencyPhone);

        JButton savePatient = new JButton("Save Patient");

        JPanel patientArea = new JPanel(new BorderLayout());
        patientArea.add(patientPanel, BorderLayout.CENTER);
        patientArea.add(savePatient, BorderLayout.SOUTH);

        JPanel procedures = new JPanel(new GridLayout(1, 3, 8, 8));
        procedures.setBorder(
                BorderFactory.createTitledBorder("Procedures"));

        JPanel procedure1Panel = new JPanel(new GridLayout(5, 2, 5, 5));
        procedure1Panel.setBorder(
                BorderFactory.createTitledBorder("Procedure 1"));

        JTextField name1 = new JTextField();
        JTextField date1 = new JTextField();
        JTextField practitioner1 = new JTextField();
        JTextField charge1 = new JTextField();

        procedure1Panel.add(new JLabel("Name:"));
        procedure1Panel.add(name1);
        procedure1Panel.add(new JLabel("Date:"));
        procedure1Panel.add(date1);
        procedure1Panel.add(new JLabel("Practitioner:"));
        procedure1Panel.add(practitioner1);
        procedure1Panel.add(new JLabel("Charge ($):"));
        procedure1Panel.add(charge1);

        JButton save1 = new JButton("Save Procedure 1");
        procedure1Panel.add(new JLabel(""));
        procedure1Panel.add(save1);

        JPanel procedure2Panel = new JPanel(new GridLayout(5, 2, 5, 5));
        procedure2Panel.setBorder(
                BorderFactory.createTitledBorder("Procedure 2"));

        JTextField name2 = new JTextField();
        JTextField date2 = new JTextField();
        JTextField practitioner2 = new JTextField();
        JTextField charge2 = new JTextField();

        procedure2Panel.add(new JLabel("Name:"));
        procedure2Panel.add(name2);
        procedure2Panel.add(new JLabel("Date:"));
        procedure2Panel.add(date2);
        procedure2Panel.add(new JLabel("Practitioner:"));
        procedure2Panel.add(practitioner2);
        procedure2Panel.add(new JLabel("Charge ($):"));
        procedure2Panel.add(charge2);

        JButton save2 = new JButton("Save Procedure 2");
        procedure2Panel.add(new JLabel(""));
        procedure2Panel.add(save2);

        JPanel procedure3Panel = new JPanel(new GridLayout(5, 2, 5, 5));
        procedure3Panel.setBorder(
                BorderFactory.createTitledBorder("Procedure 3"));

        JTextField name3 = new JTextField();
        JTextField date3 = new JTextField();
        JTextField practitioner3 = new JTextField();
        JTextField charge3 = new JTextField();

        procedure3Panel.add(new JLabel("Name:"));
        procedure3Panel.add(name3);
        procedure3Panel.add(new JLabel("Date:"));
        procedure3Panel.add(date3);
        procedure3Panel.add(new JLabel("Practitioner:"));
        procedure3Panel.add(practitioner3);
        procedure3Panel.add(new JLabel("Charge ($):"));
        procedure3Panel.add(charge3);

        JButton save3 = new JButton("Save Procedure 3");
        procedure3Panel.add(new JLabel(""));
        procedure3Panel.add(save3);

        procedures.add(procedure1Panel);
        procedures.add(procedure2Panel);
        procedures.add(procedure3Panel);

        JPanel top = new JPanel(new BorderLayout(10, 10));
        top.add(patientArea, BorderLayout.WEST);
        top.add(procedures, BorderLayout.CENTER);

        JTextArea output = new JTextArea();
        output.setEditable(false);

        JScrollPane scroll = new JScrollPane(output);

        JButton showOutput = new JButton("Show Output");
        JButton exit = new JButton("Exit");

        JPanel buttons = new JPanel();
        buttons.add(showOutput);
        buttons.add(exit);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(buttons, BorderLayout.NORTH);
        bottom.add(scroll, BorderLayout.CENTER);

        savePatient.addActionListener(e -> {
            patient.setFirstName(firstName.getText());
            patient.setMiddleName(middleName.getText());
            patient.setLastName(lastName.getText());
            patient.setStreetAddress(address.getText());
            patient.setCity(city.getText());
            patient.setState(state.getText());
            patient.setZipCode(zip.getText());
            patient.setPhoneNumber(phone.getText());
            patient.setEmergencyName(emergencyName.getText());
            patient.setEmergencyPhone(emergencyPhone.getText());

            JOptionPane.showMessageDialog(frame, "Patient saved.");
        });

        save1.addActionListener(e -> {
            procedure1.setProcedureName(name1.getText());
            procedure1.setProcedureDate(date1.getText());
            procedure1.setPractitionerName(practitioner1.getText());
            procedure1.setCharges(Double.parseDouble(charge1.getText()));

            JOptionPane.showMessageDialog(frame, "Procedure 1 saved.");
        });

        save2.addActionListener(e -> {
            procedure2.setProcedureName(name2.getText());
            procedure2.setProcedureDate(date2.getText());
            procedure2.setPractitionerName(practitioner2.getText());
            procedure2.setCharges(Double.parseDouble(charge2.getText()));

            JOptionPane.showMessageDialog(frame, "Procedure 2 saved.");
        });

        save3.addActionListener(e -> {
            procedure3.setProcedureName(name3.getText());
            procedure3.setProcedureDate(date3.getText());
            procedure3.setPractitionerName(practitioner3.getText());
            procedure3.setCharges(Double.parseDouble(charge3.getText()));

            JOptionPane.showMessageDialog(frame, "Procedure 3 saved.");
        });

        showOutput.addActionListener(e -> {

            double total = calculateTotalCharges(
                    procedure1, procedure2, procedure3);

            output.setText(
                    patient.toString()
                    + "\n\n"
                    + procedure1.toString()
                    + "\n\n"
                    + procedure2.toString()
                    + "\n\n"
                    + procedure3.toString()
                    + "\n\n"
                    + "Total Charges: $"
                    + String.format("%.2f", total));
        });

        exit.addActionListener(e -> {
            System.exit(0);
        });

        frame.add(top, BorderLayout.NORTH);
        frame.add(bottom, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void displayPatient(Patient patient) {
        System.out.println(patient);
    }

    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure);
    }

    public static double calculateTotalCharges(
            Procedure procedure1,
            Procedure procedure2,
            Procedure procedure3) {

        double total = procedure1.getCharges()
                + procedure2.getCharges()
                + procedure3.getCharges();

        return total;
    }
}