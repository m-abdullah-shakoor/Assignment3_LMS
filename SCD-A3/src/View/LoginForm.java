package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DAO.UsersListDao;
public class LoginForm extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserListDao userDAO;

    public LoginForm() {
        // Instantiate the UserDAO class
        userDAO = new UsersListDao();
        //Properties of Form
        setTitle("Login Form");
        setLayout(new FlowLayout());
        setSize(712,430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        //Username Components
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel);
        Username_Field = new JTextField(20);
        add(Username_Field);
        
         //Password Components
        JLabel PasswordLabel = new JLabel("Password:");
        add(PasswordLabel);
        Pass_Field = new JPasswordField(20);
        add(Pass_Field);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBackground(Color.BLUE);
        add(loginButton);

    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        // Perform authentication using the UserDAO
        boolean authenticated = userDAO.authenticate(username, password);

        if (authenticated) {
            // User is authenticated, perform further actions or navigate to another view
            // For example, open a new window or show a success message
        } else {
            // Authentication failed, display an error message
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }

        // Clear the input fields
        usernameField.setText("");
        passwordField.setText("");
    }

   
}


