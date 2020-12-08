import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class GUI implements ActionListener, ItemListener {

    private static JButton administratorLoginButton;
    private static JButton userLoginButton;
    private static JLabel welcomeLabel;
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JLabel registerLabel;
    private static JButton registerButton;
    private static JButton logoutButton;

    JFrame frame;
    JPanel pane1, pane2, pane3, pane4, pane5, cardPane;
    CardLayout card;

    JPanel cards; //a panel that uses CardLayout
    final static String userPanel = "User Login";
    final static String adminPanel = "Administrator Login";

    public GUI() {
        frame = new JFrame("CardLayout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        pane1 = new JPanel();
        pane2 = new JPanel();
        pane3 = new JPanel();
        pane4 = new JPanel();
        pane5 = new JPanel();
        cardPane = new JPanel();

//        pane1.setBackground(Color.BLACK);
//        pane2.setBackground(Color.BLUE);
//        pane3.setBackground(Color.GREEN);

//        JButton button1 = new JButton("Click me to change panel");
//        button1.setBounds(10,10,280,10);
//        button1.addActionListener(this);
//        pane1.add(button1);

        createUserLoginComponent(pane1);


//        JButton button2 = new JButton("Click me to change panel");
//        button2.addActionListener(this);
//        pane2.add(button2);

        createAdminLoginComponent(pane2);

//        JButton button3 = new JButton("Click me to change panel");
//        button3.addActionListener(this);
//        pane3.add(button3);

        createRegisterComponent(pane3);

        createUserPortalComponent(pane4);

        createAdminPortalComponent(pane5);

        card = new CardLayout();

        cardPane.setLayout(card);
        cardPane.add(pane1, "User Login");
        cardPane.add(pane2, "Administrator Login");
        cardPane.add(pane3, "Register");
        cardPane.add(pane4, "User Portal");
        cardPane.add(pane5, "Admin Portal");

        frame.add(cardPane);
        //Display the window.
        frame.setTitle("Fancy Bank ATM #611");
//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

//    public void addComponentToPane(Container pane) {
//        //Put the JComboBox in a JPanel to get a nicer look.
//        JPanel comboBoxPane = new JPanel(); //use FlowLayout
//        String comboBoxItems[] = { userPanel, adminPanel };
//        JComboBox cb = new JComboBox(comboBoxItems);
//        cb.setEditable(false);
//        cb.addItemListener(this);
//        comboBoxPane.add(cb);
//
//        //Create the "cards".
//        JPanel card1 = new JPanel();
//        createUserLoginComponent(card1);
//
//        JPanel card2 = new JPanel();
//        createAdminLoginComponent(card2);
//
//        //Create the panel that contains the "cards".
//        cards = new JPanel(new CardLayout());
//        cards.add(card1, userPanel);
//        cards.add(card2, adminPanel);
//
////        pane.add(comboBoxPane, BorderLayout.WEST);
//        pane.add(card1, BorderLayout.CENTER);
//    }

    public void createUserLoginComponent(JPanel panel) {
        administratorLoginButton = new JButton("Administrator Login");
        administratorLoginButton.setBounds(30, 30, 160, 25);
        adminLoginListener al = new adminLoginListener();
        administratorLoginButton.addActionListener(al);
        panel.add(administratorLoginButton);

        welcomeLabel = new JLabel("Welcome to your User Portal");
        welcomeLabel.setBounds(160, 95, 200, 25);
        panel.add(welcomeLabel);

        userLabel = new JLabel("Username");
        userLabel.setBounds(110, 140, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(200, 140, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(110, 180, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(200, 180, 165, 25);
        panel.add(passwordText);

        loginButton = new JButton("User Login");
        loginButton.setBounds(190, 225, 100, 25);
        userPortalListener upl = new userPortalListener();
        loginButton.addActionListener(upl);
        panel.add(loginButton);

        registerLabel = new JLabel("Need an account?");
        registerLabel.setBounds(140, 300, 120, 25);
        panel.add(registerLabel);

        registerButton = new JButton("Register");
        registerButton.setBounds(260, 300, 90, 25);
        registerListener rl = new registerListener();
        registerButton.addActionListener(rl);
        panel.add(registerButton);

        panel.setLayout(null);
    }

    public void createAdminLoginComponent(JPanel panel) {
        userLoginButton = new JButton("User Login");
        userLoginButton.setBounds(30, 30, 160, 25);
        userLoginListener ul = new userLoginListener();
        userLoginButton.addActionListener(ul);
        panel.add(userLoginButton);

        welcomeLabel = new JLabel("Administrator Login");
        welcomeLabel.setBounds(180, 95, 200, 25);
        panel.add(welcomeLabel);

        userLabel = new JLabel("Username");
        userLabel.setBounds(110, 140, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(200, 140, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(110, 180, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(200, 180, 165, 25);
        panel.add(passwordText);

        loginButton = new JButton("Administrator Login");
        loginButton.setBounds(170, 225, 150, 25);
        adminPortalListener apl = new adminPortalListener();
        loginButton.addActionListener(apl);
        panel.add(loginButton);

        panel.setLayout(null);
    }

    public void createRegisterComponent(JPanel panel) {
        userLoginButton = new JButton("Back to Login");
        userLoginButton.setBounds(30, 30, 160, 25);
        userLoginListener ul = new userLoginListener();
        userLoginButton.addActionListener(ul);
        panel.add(userLoginButton);

        welcomeLabel = new JLabel("Create an Account");
        welcomeLabel.setBounds(180, 95, 200, 25);
        panel.add(welcomeLabel);

        userLabel = new JLabel("Username");
        userLabel.setBounds(110, 140, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(200, 140, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(110, 180, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(200, 180, 165, 25);
        panel.add(passwordText);

        loginButton = new JButton("Register");
        loginButton.setBounds(190, 225, 100, 25);
        userPortalListener upl = new userPortalListener();
        loginButton.addActionListener(upl);
        panel.add(loginButton);

        panel.setLayout(null);
    }

    public void createUserPortalComponent(JPanel panel) {
//        administratorLoginButton = new JButton("Administrator Login");
//        administratorLoginButton.setBounds(30, 30, 160, 25);
//        adminLoginListener al = new adminLoginListener();
//        administratorLoginButton.addActionListener(al);
//        panel.add(administratorLoginButton);

        welcomeLabel = new JLabel("User Portal");
        welcomeLabel.setBounds(220, 95, 200, 25);
        panel.add(welcomeLabel);

//        userLabel = new JLabel("Username");
//        userLabel.setBounds(110, 140, 80, 25);
//        panel.add(userLabel);

        JButton button1 = new JButton("Open Bank Account");
        button1.setBounds(70, 150, 180, 25);
        panel.add(button1);

        JButton button2 = new JButton("Close Bank Account");
        button2.setBounds(70, 180, 180, 25);
        panel.add(button2);

        String s = "View Transactions and Balances";
        String html = "<html><body style='width: %1spx; text-align: center'>%1s";
        JButton button3 = new JButton(String.format(html, 100, s));
        button3.setBounds(75, 210, 170, 40);
        panel.add(button3);

        JButton button4 = new JButton("Deposit Money");
        button4.setBounds(260, 150, 180, 25);
        panel.add(button4);

        JButton button5 = new JButton("Withdraw Money");
        button5.setBounds(260, 180, 180, 25);
        panel.add(button5);

        JButton button6 = new JButton("Request Loan");
        button6.setBounds(260, 210, 180, 25);
        panel.add(button6);

//        userText = new JTextField(20);
//        userText.setBounds(200, 140, 165, 25);
//        panel.add(userText);
//
//        passwordLabel = new JLabel("Password");
//        passwordLabel.setBounds(110, 180, 80, 25);
//        panel.add(passwordLabel);
//
//        passwordText = new JPasswordField();
//        passwordText.setBounds(200, 180, 165, 25);
//        panel.add(passwordText);
//
//        loginButton = new JButton("User Login");
//        loginButton.setBounds(190, 225, 100, 25);
//        loginButton.addActionListener(new LoginGUI());
//        panel.add(loginButton);
//
//        registerLabel = new JLabel("Need an account?");
//        registerLabel.setBounds(140, 300, 120, 25);
//        panel.add(registerLabel);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(30, 320, 90, 25);
        userLoginListener ul = new userLoginListener();
        logoutButton.addActionListener(ul);
        panel.add(logoutButton);

        panel.setLayout(null);
    }

    public void createAdminPortalComponent(JPanel panel) {
        welcomeLabel = new JLabel("Administrator Portal");
        welcomeLabel.setBounds(180, 95, 200, 25);
        panel.add(welcomeLabel);

        JButton button1 = new JButton("Customers");
        button1.setBounds(70, 150, 180, 25);
        panel.add(button1);

        JButton button4 = new JButton("Reports");
        button4.setBounds(260, 150, 180, 25);
        panel.add(button4);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(30, 320, 90, 25);
        adminLoginListener al = new adminLoginListener();
        logoutButton.addActionListener(al);
        panel.add(logoutButton);

        panel.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        card.next(cardPane);
    }
//    public static void main(String args[]) {
//        /* Use an appropriate Look and Feel */
//        try {
////            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
////            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//        } catch (InstantiationException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        /* Turn off metal's use of bold fonts */
//        UIManager.put("swing.boldMetal", Boolean.FALSE);
//
//        // Create GUI
//        HubTest test = new HubTest();
//    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    class adminLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Administrator login.");
            card.show(cardPane, "Administrator Login");
        }
    }

    class userLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> User login.");
            card.show(cardPane, "User Login");
        }
    }

    class registerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Register button clicked.");
            card.show(cardPane, "Register");
        }
    }

    class userPortalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Navigating to user portal.");
            card.show(cardPane, "User Portal");
        }
    }

    class adminPortalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Navigating to admin portal.");
            card.show(cardPane, "Admin Portal");
        }
    }
}