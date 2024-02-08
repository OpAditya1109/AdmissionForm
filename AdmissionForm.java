import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdmissionForm extends JFrame implements ActionListener {

    private JLabel nameLabel, ageLabel, genderLabel, addressLabel, phoneLabel, emailLabel, programLabel,
            previousSchoolLabel;
    private JTextField nameField, ageField, addressField, phoneField, emailField, previousSchoolField;
    private JComboBox<String> genderComboBox, programComboBox;
    private JButton submitButton;

    public AdmissionForm() {

        setTitle("Admission Form Of I2IT");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));
        getContentPane().setBackground(new Color(240, 240, 240));

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 20, 56);
        nameField = new JTextField();
        ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        genderLabel = new JLabel("Gender:");
        String[] genders = { "Male", "Female", "Other" };
        genderComboBox = new JComboBox<>(genders);
        addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        programLabel = new JLabel("Program:");
        String[] programs = { "Computer Science", "IT", "ENTC", "Other" };
        programComboBox = new JComboBox<>(programs);
        previousSchoolLabel = new JLabel("Previous School:");
        previousSchoolField = new JTextField();
        submitButton = new JButton("Submit");

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        nameLabel.setFont(labelFont);

        ageLabel.setFont(labelFont);
        genderLabel.setFont(labelFont);
        addressLabel.setFont(labelFont);
        phoneLabel.setFont(labelFont);
        emailLabel.setFont(labelFont);
        programLabel.setFont(labelFont);
        previousSchoolLabel.setFont(labelFont);

        nameField.setBackground(Color.lightGray);
        ageField.setBackground(Color.LIGHT_GRAY);
        addressField.setBackground(Color.LIGHT_GRAY);
        phoneField.setBackground(Color.LIGHT_GRAY);
        emailField.setBackground(Color.lightGray);
        previousSchoolField.setBackground(Color.lightGray);

        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(50, 150, 250));
        submitButton.setForeground(Color.WHITE);

        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(genderLabel);
        add(genderComboBox);
        add(addressLabel);
        add(addressField);
        add(phoneLabel);
        add(phoneField);
        add(emailLabel);
        add(emailField);
        add(programLabel);
        add(programComboBox);
        add(previousSchoolLabel);
        add(previousSchoolField);
        add(new JLabel());
        add(submitButton);

        submitButton.addActionListener(this);

        setLocationRelativeTo(null);

        setVisible(true);
        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
        submitButton.setCursor(handCursor);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {

            String name = nameField.getText();
            String age = ageField.getText();
            String gender = (String) genderComboBox.getSelectedItem();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String program = (String) programComboBox.getSelectedItem();
            String previousSchool = previousSchoolField.getText();

            JOptionPane.showMessageDialog(this,
                    "Name: " + name + "\n" +
                            "Age: " + age + "\n" +
                            "Gender: " + gender + "\n" +
                            "Address: " + address + "\n" +
                            "Phone: " + phone + "\n" +
                            "Email: " + email + "\n" +
                            "Program: " + program + "\n" +
                            "Previous School: " + previousSchool,
                    "Admission Form Submission",
                    JOptionPane.INFORMATION_MESSAGE);

            nameField.setText("");
            ageField.setText("");
            genderComboBox.setSelectedIndex(0);
            addressField.setText("");
            phoneField.setText("");
            emailField.setText("");
            programComboBox.setSelectedIndex(0);
            previousSchoolField.setText("");

        }

    }

    public static void main(String[] args) {

        new AdmissionForm();
    }
}
