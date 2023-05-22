package View;

import Controller.AdminController;
import Model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

    //Elements of Admin Class
    private JButton View_Books_Button;
    private JButton View_Users_Button;
    private JButton View_IssuedBooks_Button;
    private JButton Issue_Book_Button;
    private JButton Add_User_Button;
    private JButton Add_Book_Button;
    private JButton Return_Book_Button;
    private JButton Create_Reset_Button;
    private AdminController adminController;
    public Admin() 
    {
        setTitle("Library Management System");
        setSize(430,700 );
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        View_Books_Button = new JButton("View Books");
        View_Books_Button.addActionListener(this);
        add(View_Books_Button);

        View_Users_Button = new JButton("View Users");
        View_Users_Button.addActionListener(this);
        add(View_Users_Button);

        View_IssuedBooks_Button = new JButton("View Issued Books");
        View_IssuedBooks_Button.addActionListener(this);
        add(View_IssuedBooks_Button);

        Issue_Book_Button = new JButton("Issue Book");
        Issue_Book_Button.addActionListener(this);
        add(Issue_Book_Button);

        Add_User_Button = new JButton("Add User");
        Add_User_Button.addActionListener(this);
        add(Add_User_Button);

        Add_Book_Button = new JButton("Add Book");
        Add_Book_Button.addActionListener(this);
        add(Add_Book_Button);

        // Return Book Components
        Return_Book_Button = new JButton("Return Book");
        Return_Book_Button.addActionListener(this);
        add(Return_Book_Button);

        Create_Reset_Button = new JButton("Create/Reset");
        Create_Reset_Button.addActionListener(this);
        add(Create_Reset_Button);

        
    }
    public void setController(AdminController adminController) {
        this.adminController = adminController;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == View_Books_Button) 
        {

           JOptionPane.showMessageDialog(this, "View Books");
            new ViewBook().setVisible(true);
        } 
        else if (e.getSource() == View_Users_Button)
        {
    
            JOptionPane.showMessageDialog(this, "View Users");
            new UsersList().setVisible(true);
        }
        else if (e.getSource() == View_IssuedBooks_Button)  
        {
            JOptionPane.showMessageDialog(this, "View Issued Books");
            new IssueBook().setVisible(true);
        }
        else if (e.getSource() == Issue_Book_Button)
        {
            JOptionPane.showMessageDialog(this, "Issue Book");
        } 
        else if (e.getSource() == Add_User_Button)
        {
            JOptionPane.showMessageDialog(this, "Add User");
        }
        else if (e.getSource() == Add_Book_Button)
        { String bookName = JOptionPane.showInputDialog(this, "Enter Book Name");
            String genre = JOptionPane.showInputDialog(this, "Enter Genre");
            String priceStr = JOptionPane.showInputDialog(this, "Enter Price");
            double price = Double.parseDouble(priceStr);

            Book book = new Book(bookName, genre, price);
            adminController.addBook(book);} 
        else if (e.getSource() == Return_Book_Button) 
        {
            JOptionPane.showMessageDialog(this, "Return Book");
        } 
        else if (e.getSource() == Create_Reset_Button)
        {
            JOptionPane.showMessageDialog(this, " Database Create/Reset");
          
        }
    }
}
