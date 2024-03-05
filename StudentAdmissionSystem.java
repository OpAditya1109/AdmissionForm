import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.MaskFormatter;
import java.io.*;

public class StudentAdmissionSystem extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel admissionFormPanel;
    private JPanel addressPanel;
    private JTextArea presentAddressArea;
    private JTextArea permanentAddressArea;
    private JPanel collegeDetailsPanel;
    private JTextField collegeNameField;
    private JFormattedTextField graduationDateField;
    private JTextArea schoolAddressArea;
    private JCheckBox accommodationCheckBox;
    private JProgressBar progressBar;

    private JPanel referralPanel;
    private JComboBox<String> referralComboBox;

    public StudentAdmissionSystem() {
        setTitle("Student Admission System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        // Title Panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Student Admission System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

// Referral Panel
        referralPanel = new JPanel();
        referralPanel.setLayout(new BorderLayout());

// Initialize referral source options
        String[] referralOptions = {"Website", "Friend", "Advertisement", "Event", "Other"};

// Initialize combo box
        referralComboBox = new JComboBox<>(referralOptions);

        referralPanel.add(new JLabel("Referral Source: "), BorderLayout.WEST);
        referralPanel.add(referralComboBox, BorderLayout.CENTER);

// Submit Button after Referral Panel
        JButton submitButtonReferral = new JButton("Submit Referral");
        submitButtonReferral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a confirmation dialog
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit referral?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    cardLayout.show(cardPanel, "feePanel");
                    progressBar.setValue(90); // Update progress bar value
                }
            }
        });
        referralPanel.add(submitButtonReferral, BorderLayout.SOUTH);

        cardPanel.add(referralPanel, "referralPanel");

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcLogin = new GridBagConstraints();
        gbcLogin.gridx = 0;
        gbcLogin.gridy = 0;
        gbcLogin.insets = new Insets(5, 5, 5, 5);
        gbcLogin.anchor = GridBagConstraints.WEST;

        JLabel loginTitleLabel = new JLabel("Login");
        loginTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        loginPanel.add(loginTitleLabel, gbcLogin);
        gbcLogin.gridy++;

        JLabel usernameLabel = new JLabel("Username:");
        loginPanel.add(usernameLabel, gbcLogin);
        gbcLogin.gridx++;
        usernameField = new JTextField(20);
        loginPanel.add(usernameField, gbcLogin);
        gbcLogin.gridx = 0;
        gbcLogin.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        loginPanel.add(passwordLabel, gbcLogin);
        gbcLogin.gridx++;
        passwordField = new JPasswordField(20);
        loginPanel.add(passwordField, gbcLogin);
        gbcLogin.gridx = 0;
        gbcLogin.gridy++;

        // Create a button to trigger the popup menu
        JButton popupButton = new JButton("Show Popup Menu");

        // Create a popup menu for login and signup
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem loginMenuItem = new JMenuItem("Login");
        JMenuItem signupMenuItem = new JMenuItem("Signup");

        // Add action listeners to menu items
        loginMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show login input fields
                cardLayout.show(cardPanel, "loginPanel");
            }
        });

        signupMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show signup input fields
                cardLayout.show(cardPanel, "signupPanel");
            }
        });

        // Add menu items to the popup menu
        popupMenu.add(loginMenuItem);
        popupMenu.add(signupMenuItem);

        // Add action listener to the button to show the popup menu
        popupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the popup menu relative to the button
                popupMenu.show(popupButton, 0, popupButton.getHeight());
            }
        });

        // Add the button to the login panel
        gbcLogin.gridx = 0;
        gbcLogin.gridy++;
        loginPanel.add(popupButton, gbcLogin);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement login logic here
                // For simplicity, let's assume login is successful
                cardLayout.show(cardPanel, "admissionFormPanel");
            }
        });
        loginPanel.add(loginButton, gbcLogin);
        gbcLogin.gridx++;
        JButton signupButton = new JButton("Submit");
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to signup page
                cardLayout.show(cardPanel, "admissionFormPanel");
            }
        });
        loginPanel.add(signupButton, gbcLogin);

        // Signup Panel
        JPanel signupPanel = new JPanel();
        signupPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcSignup = new GridBagConstraints();
        gbcSignup.gridx = 0;
        gbcSignup.gridy = 0;
        gbcSignup.insets = new Insets(5, 5, 5, 5);
        gbcSignup.anchor = GridBagConstraints.WEST;

        JLabel signupTitleLabel = new JLabel("Create Your Account");
        signupTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        signupPanel.add(signupTitleLabel, gbcSignup);
        gbcSignup.gridy++;

        JLabel createUsernameLabel = new JLabel("Create Username:");
        signupPanel.add(createUsernameLabel, gbcSignup);
        gbcSignup.gridx++;
        JTextField createUsernameField = new JTextField(20);
        signupPanel.add(createUsernameField, gbcSignup);
        gbcSignup.gridx = 0;
        gbcSignup.gridy++;

        JLabel createPasswordLabel = new JLabel("Create Password:");
        signupPanel.add(createPasswordLabel, gbcSignup);
        gbcSignup.gridx++;
        JPasswordField createPasswordField = new JPasswordField(20);
        signupPanel.add(createPasswordField, gbcSignup);
        gbcSignup.gridx = 0;
        gbcSignup.gridy++;

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = createUsernameField.getText();
                String password = new String(createPasswordField.getPassword());

                // Write account information to file
                writeAccountToFile(username, password);

                // Switch to admission form panel
                cardLayout.show(cardPanel, "loginPanel");
            }
        });
        signupPanel.add(createAccountButton, gbcSignup);

        // Admission Form Panel
        admissionFormPanel = new JPanel();
        admissionFormPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcAdmission = new GridBagConstraints();
        gbcAdmission.gridx = 0;
        gbcAdmission.gridy = 0;
        gbcAdmission.insets = new Insets(5, 5, 5, 5);
        gbcAdmission.anchor = GridBagConstraints.WEST;

        JLabel admissionFormTitleLabel = new JLabel("Admission Form - Personal Details");
        admissionFormTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        admissionFormPanel.add(admissionFormTitleLabel, gbcAdmission);
        gbcAdmission.gridy++;

        JLabel nameLabel = new JLabel("Student Name:");
        admissionFormPanel.add(nameLabel, gbcAdmission);
        gbcAdmission.gridx++;
        JTextField nameField = new JTextField(20);
        nameField.setName("name"); // Set the name for the name field
        admissionFormPanel.add(nameField, gbcAdmission);
        gbcAdmission.gridx = 0;
        gbcAdmission.gridy++;

        // Branch selection using JComboBox
        JLabel branchLabel = new JLabel("Branch Applied:");
        admissionFormPanel.add(branchLabel, gbcAdmission);
        gbcAdmission.gridx++;

        // Create JComboBox for branch selection
        String[] branches = {"Computer Science", "Electrical Engineering", "Mechanical Engineering", "Civil Engineering"};
        JComboBox<String> branchComboBox = new JComboBox<>(branches);
        admissionFormPanel.add(branchComboBox, gbcAdmission);

        // Date of Birth using JSpinner
        gbcAdmission.gridx = 0;
        gbcAdmission.gridy++;
        JLabel dobLabel = new JLabel("Date of Birth:");
        admissionFormPanel.add(dobLabel, gbcAdmission);
        gbcAdmission.gridx++;

        // Create JSpinner for date selection
        SpinnerDateModel dobModel = new SpinnerDateModel();
        JSpinner dobSpinner = new JSpinner(dobModel);
        JSpinner.DateEditor dobEditor = new JSpinner.DateEditor(dobSpinner, "MM/dd/yyyy");
        dobSpinner.setEditor(dobEditor);
        admissionFormPanel.add(dobSpinner, gbcAdmission);

        gbcAdmission.gridx = 0;
        gbcAdmission.gridy++;

        JLabel genderLabel = new JLabel("Gender:");
        admissionFormPanel.add(genderLabel, gbcAdmission);
        gbcAdmission.gridx++;
        JRadioButton maleRadio = new JRadioButton("Male");
        JRadioButton femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        admissionFormPanel.add(genderPanel, gbcAdmission);
        gbcAdmission.gridx = 0;
        gbcAdmission.gridy++;

        JLabel parentsLabel = new JLabel("Parent's Name:");
        admissionFormPanel.add(parentsLabel, gbcAdmission);
        gbcAdmission.gridx++;
        JTextField parentsField = new JTextField(20);
        admissionFormPanel.add(parentsField, gbcAdmission);
        gbcAdmission.gridx = 0;
        gbcAdmission.gridy++;

        gbcAdmission.gridwidth = 2;
        gbcAdmission.anchor = GridBagConstraints.CENTER;
        accommodationCheckBox = new JCheckBox("Require Accommodation");
        admissionFormPanel.add(accommodationCheckBox, gbcAdmission);
        gbcAdmission.gridy++;

        JButton submitButton1 = new JButton("Submit");
        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a confirmation dialog
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    cardLayout.show(cardPanel, "addressPanel");
                    progressBar.setValue(50); // Update progress bar value
                }
            }
        });
        admissionFormPanel.add(submitButton1, gbcAdmission);

        // Address Panel
        addressPanel = new JPanel();
        addressPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcAddress = new GridBagConstraints();
        gbcAddress.gridx = 0;
        gbcAddress.gridy = 0;
        gbcAddress.insets = new Insets(5, 5, 5, 5);
        gbcAddress.anchor = GridBagConstraints.WEST;

        JLabel addressTitleLabel = new JLabel("Address");
        addressTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        addressPanel.add(addressTitleLabel, gbcAddress);
        gbcAddress.gridy++;

        JLabel presentAddressLabel = new JLabel("Present Address:");
        addressPanel.add(presentAddressLabel, gbcAddress);
        gbcAddress.gridx = 1;
        presentAddressArea = new JTextArea(3, 20);
        JScrollPane presentAddressScrollPane = new JScrollPane(presentAddressArea);
        addressPanel.add(presentAddressScrollPane, gbcAddress);
        gbcAddress.gridy++;
        gbcAddress.gridx = 0;
        JButton copyButton = new JButton("Copy");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                permanentAddressArea.setText(presentAddressArea.getText());
            }
        });
        addressPanel.add(copyButton, gbcAddress);
        gbcAddress.gridx = 1;
        gbcAddress.gridy++;
        gbcAddress.anchor = GridBagConstraints.WEST;
        JLabel permanentAddressLabel = new JLabel("Permanent Address:");
        addressPanel.add(permanentAddressLabel, gbcAddress);
        gbcAddress.gridy++;
        permanentAddressArea = new JTextArea(3, 20);
        JScrollPane permanentAddressScrollPane = new JScrollPane(permanentAddressArea);
        addressPanel.add(permanentAddressScrollPane, gbcAddress);
        gbcAddress.gridy++;
        gbcAddress.anchor = GridBagConstraints.CENTER;
        JButton submitButton2 = new JButton("Submit");
        submitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a confirmation dialog
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    cardLayout.show(cardPanel, "collegeDetailsPanel");
                    progressBar.setValue(75); // Update progress bar value
                }
            }
        });
        addressPanel.add(submitButton2, gbcAddress);

        collegeDetailsPanel = new JPanel();
        collegeDetailsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcCollegeDetails = new GridBagConstraints();
        gbcCollegeDetails.gridx = 0;
        gbcCollegeDetails.gridy = 0;
        gbcCollegeDetails.insets = new Insets(5, 5, 5, 5);
        gbcCollegeDetails.anchor = GridBagConstraints.WEST;

        JLabel collegeDetailsTitleLabel = new JLabel("Previous College Details");
        collegeDetailsTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        collegeDetailsPanel.add(collegeDetailsTitleLabel, gbcCollegeDetails);
        gbcCollegeDetails.gridy++;

        JLabel collegeNameLabel = new JLabel("College Name:");
        collegeDetailsPanel.add(collegeNameLabel, gbcCollegeDetails);
        gbcCollegeDetails.gridx++;
        collegeNameField = new JTextField(20);
        collegeDetailsPanel.add(collegeNameField, gbcCollegeDetails);
        gbcCollegeDetails.gridx = 0;
        gbcCollegeDetails.gridy++;

        JLabel graduationDateLabel = new JLabel("Graduation Date:");
        collegeDetailsPanel.add(graduationDateLabel, gbcCollegeDetails);
        gbcCollegeDetails.gridx++;
        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            graduationDateField = new JFormattedTextField(dateFormatter);
        } catch (Exception ex) {
            graduationDateField = new JFormattedTextField();
        }
        collegeDetailsPanel.add(graduationDateField, gbcCollegeDetails);
        gbcCollegeDetails.gridx = 0;
        gbcCollegeDetails.gridy++;

        JLabel schoolAddressLabel = new JLabel("School Address:");
        collegeDetailsPanel.add(schoolAddressLabel, gbcCollegeDetails);
        gbcCollegeDetails.gridx++;
        schoolAddressArea = new JTextArea(3, 20);
        JScrollPane schoolAddressScrollPane = new JScrollPane(schoolAddressArea);
        collegeDetailsPanel.add(schoolAddressScrollPane, gbcCollegeDetails);
        gbcCollegeDetails.gridy++;

        // File Upload Label
        JLabel uploadLabel = new JLabel("No file uploaded");
        collegeDetailsPanel.add(uploadLabel, gbcCollegeDetails);

        // File Upload Button
        JButton uploadButton = new JButton("Upload File");
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    uploadLabel.setText(selectedFile.getName() + " uploaded successfully");
                }
            }
        });
        gbcCollegeDetails.gridx++;
        collegeDetailsPanel.add(uploadButton, gbcCollegeDetails);

        gbcCollegeDetails.gridx = 0;
        gbcCollegeDetails.gridy++;
        gbcCollegeDetails.gridwidth = 2;
        gbcCollegeDetails.anchor = GridBagConstraints.CENTER;
        JButton submitButton3 = new JButton("Submit");
        submitButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a confirmation dialog
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    cardLayout.show(cardPanel, "referralPanel");
                    progressBar.setValue(100); // Update progress bar value
                }
            }
        });
        collegeDetailsPanel.add(submitButton3, gbcCollegeDetails);
// Fee Panel
        JPanel feePanel = new JPanel();
        feePanel.setLayout(new BorderLayout());
        JLabel feeLabel = new JLabel("Fee Payment Options:");
        feePanel.add(feeLabel, BorderLayout.NORTH);

// Payment options
        JPanel paymentOptionsPanel = new JPanel(new GridLayout(3, 1));
        JRadioButton creditCardRadio = new JRadioButton("Credit Card");
        JRadioButton debitCardRadio = new JRadioButton("Debit Card");
        JRadioButton cashRadio = new JRadioButton("Cash");

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(creditCardRadio);
        paymentGroup.add(debitCardRadio);
        paymentGroup.add(cashRadio);

        paymentOptionsPanel.add(creditCardRadio);
        paymentOptionsPanel.add(debitCardRadio);
        paymentOptionsPanel.add(cashRadio);

        feePanel.add(paymentOptionsPanel, BorderLayout.CENTER);

        JButton printReceiptButton = new JButton("Print Receipt");
        printReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get student's name and branch name from admission form panel
                Component[] components = admissionFormPanel.getComponents();
                String studentName = "";
                String branchName = "";
                for (Component component : components) {
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        String fieldName = textField.getName();
                        if (fieldName != null) {
                            if (fieldName.equals("name")) {
                                studentName = textField.getText();
                            } else if (fieldName.equals("branch")) {
                                branchName = textField.getText();
                            }
                        }
                    }
                }

                // Get selected payment method
                String paymentMethod = "";
                if (creditCardRadio.isSelected()) {
                    paymentMethod = "Credit Card";
                } else if (debitCardRadio.isSelected()) {
                    paymentMethod = "Debit Card";
                } else if (cashRadio.isSelected()) {
                    paymentMethod = "Cash";
                }

                // Print receipt
                String receipt = "Receipt:\n";
                receipt += "Student Name: " + studentName + "\n";
                receipt += "Branch Name: " + branchName + "\n";
                receipt += "Payment Method: " + paymentMethod;

                JOptionPane.showMessageDialog(null, receipt, "Receipt", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        feePanel.add(printReceiptButton, BorderLayout.SOUTH);
        cardPanel.add(loginPanel, "loginPanel");
        cardPanel.add(signupPanel, "signupPanel");
        cardPanel.add(admissionFormPanel, "admissionFormPanel");
        cardPanel.add(addressPanel, "addressPanel");
        cardPanel.add(collegeDetailsPanel, "collegeDetailsPanel");
        cardPanel.add(feePanel, "feePanel");

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        add(titlePanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);

        cardLayout.show(cardPanel, "loginPanel");
    }

    private void writeAccountToFile(String username, String password) {
        try {
            FileWriter writer = new FileWriter("accounts.txt", true);
            writer.write(username + ":" + password + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StudentAdmissionSystem system = new StudentAdmissionSystem();
                system.setVisible(true);
            }
        });
    }
}