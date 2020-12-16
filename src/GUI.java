import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class GUI implements ItemListener {

    private static JButton administratorLoginButton;
    private static JButton userLoginButton;
    private static JLabel welcomeLabel;
    private static JLabel userLabel;
    private static JLabel passwordLabel;

    private JTextField userTextRegister;
    private JPasswordField passwordTextRegister;
    private JTextField userTextLogin;
    private JPasswordField passwordTextLogin;
    private JTextField userTextAdmin;
    private JPasswordField passwordTextAdmin;

    private static JButton loginButtonUser;
    private static JButton loginButtonRegister;
    private static JButton loginButtonAdmin;

    private static JLabel registerLabel;
    private static JButton registerButton;
    private static JButton logoutButton;
    private static JButton userPortalButton;
    private JButton openCheckingAccountButton;
    private JButton openSavingsAccountButton;
    private JButton closeCheckingAccountButton;
    private JButton closeSavingsAccountButton;
    private static JButton adminPortalButton;
    private JTextArea transactionsArea;

    private JTextField checkingFieldDeposit;
    private JTextField savingsFieldDeposit;
    private JButton checkingButtonDeposit;
    private JButton savingsButtonDeposit;

    private JTextField checkingFieldWithdraw;
    private JTextField savingsFieldWithdraw;
    private JButton checkingButtonWithdraw;
    private JButton savingsButtonWithdraw;

    private JLabel checkingLabelBalances = new JLabel();
    private JLabel checkingLabelDeposit = new JLabel();
    private JLabel checkingLabelWithdraw = new JLabel();

    private JLabel savingsLabelBalances = new JLabel();
    private JLabel savingsLabelDeposit = new JLabel();
    private JLabel savingsLabelWithdraw = new JLabel();

    private JButton savingsTransactionsButton;
    private JButton checkingTransactionsButton;

    User currentUser;
    Customer currentCustomer = (Customer) currentUser;
    CheckingAccount currentChecking = null;
    SavingsAccount currentSavings = null;

    JFrame frame;
    JPanel pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8, pane9, pane10, pane11, pane12, pane13, cardPane;
    CardLayout card;

    JPanel cards; //a panel that uses CardLayout

    public GUI() {
        frame = new JFrame("CardLayout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        pane1 = new JPanel();
        pane2 = new JPanel();
        pane3 = new JPanel();
        pane4 = new JPanel();
        pane5 = new JPanel();
        pane6 = new JPanel();
        pane7 = new JPanel();
        pane8 = new JPanel();
        pane9 = new JPanel();
        pane10 = new JPanel();
        pane11 = new JPanel();
        pane12 = new JPanel(); // admin customers
        pane13 = new JPanel(); // admin reports
        cardPane = new JPanel();

        createUserLoginComponent(pane1);
        createAdminLoginComponent(pane2);
        createRegisterComponent(pane3);
        createUserPortalComponent(pane4);
        createAdminPortalComponent(pane5);
        createOpenAccountComponent(pane6);
        createCloseAccountComponent(pane7);
        createBalancesComponent(pane8);
        createDepositMoneyComponent(pane9);
        createWithdrawMoneyComponent(pane10);
        createRequestLoanComponent(pane11);
        createCustomersComponent(pane12);
        createReportsComponent(pane13);

        card = new CardLayout();

        cardPane.setLayout(card);
        cardPane.add(pane1, "User Login");
        cardPane.add(pane2, "Administrator Login");
        cardPane.add(pane3, "Register");
        cardPane.add(pane4, "User Portal");
        cardPane.add(pane5, "Admin Portal");
        cardPane.add(pane6, "Open Bank Account");
        cardPane.add(pane7, "Close Bank Account");
        cardPane.add(pane8, "View Balances");
        cardPane.add(pane9, "Deposit Money");
        cardPane.add(pane10, "Withdraw Money");
        cardPane.add(pane11, "Request Loan");
        cardPane.add(pane12, "Customers");
        cardPane.add(pane13, "Reports");

        frame.add(cardPane);
        // Display the window.
        frame.setTitle("Fancy Bank ATM #611");
        // frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /* Login Components */

    public void createUserLoginComponent(JPanel panel) {
        administratorLoginButton = new JButton("Administrator Login");
        administratorLoginButton.setBounds(30, 30, 160, 25);
        adminLoginListener al = new adminLoginListener();
        administratorLoginButton.addActionListener(al);
        panel.add(administratorLoginButton);

        welcomeLabel = new JLabel("Welcome to your User Portal", SwingConstants.CENTER);
        welcomeLabel.setBounds(150, 95, 200, 25);
        Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        welcomeLabel.setBorder(loweredetched);
        panel.add(welcomeLabel);

        userLabel = new JLabel("Username");
        userLabel.setBounds(110, 140, 80, 25);
        panel.add(userLabel);

        userTextLogin = new JTextField();
        userTextLogin.setBounds(200, 140, 165, 25);
        panel.add(userTextLogin);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(110, 180, 80, 25);
        panel.add(passwordLabel);

        passwordTextLogin = new JPasswordField();
        passwordTextLogin.setBounds(200, 180, 165, 25);
        panel.add(passwordTextLogin);

        loginButtonUser = new JButton("User Login");
        loginButtonUser.setBounds(190, 225, 100, 25);
        userPortalListener upl = new userPortalListener();
        loginButtonUser.addActionListener(upl);
        panel.add(loginButtonUser);

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

        welcomeLabel = new JLabel("Administrator Login", SwingConstants.CENTER);
        welcomeLabel.setBounds(150, 95, 200, 25);

        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        welcomeLabel.setBorder(raisedetched);
        panel.add(welcomeLabel);

        userLabel = new JLabel("Username");
        userLabel.setBounds(110, 140, 80, 25);
        panel.add(userLabel);

        userTextAdmin = new JTextField(20);
        userTextAdmin.setBounds(200, 140, 165, 25);
        panel.add(userTextAdmin);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(110, 180, 80, 25);
        panel.add(passwordLabel);

        passwordTextAdmin = new JPasswordField();
        passwordTextAdmin.setBounds(200, 180, 165, 25);
        panel.add(passwordTextAdmin);

        loginButtonAdmin = new JButton("Administrator Login");
        loginButtonAdmin.setBounds(170, 225, 150, 25);
        adminPortalListener apl = new adminPortalListener();
        loginButtonAdmin.addActionListener(apl);
        panel.add(loginButtonAdmin);

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

        userTextRegister = new JTextField(20);
        userTextRegister.setBounds(200, 140, 165, 25);
        panel.add(userTextRegister);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(110, 180, 80, 25);
        panel.add(passwordLabel);

        passwordTextRegister = new JPasswordField();
        passwordTextRegister.setBounds(200, 180, 165, 25);
        panel.add(passwordTextRegister);

        loginButtonRegister = new JButton("Register");
        loginButtonRegister.setBounds(190, 225, 100, 25);
        userPortalListener upl = new userPortalListener();
        loginButtonRegister.addActionListener(upl);
        panel.add(loginButtonRegister);

        panel.setLayout(null);
    }

    /* Portal Components */

    public void createUserPortalComponent(JPanel panel) {
        welcomeLabel = new JLabel("User Portal");
        welcomeLabel.setBounds(220, 95, 200, 25);
        panel.add(welcomeLabel);

        JButton button1 = new JButton("Open Bank Account");
        button1.setBounds(70, 150, 180, 25);
        openBankAccountListener obal = new openBankAccountListener();
        button1.addActionListener(obal);
        panel.add(button1);

        JButton button2 = new JButton("Close Bank Account");
        button2.setBounds(70, 180, 180, 25);
        closeBankAccountListener cbal = new closeBankAccountListener();
        button2.addActionListener(cbal);
        panel.add(button2);

        String s = "View Transactions and Balances";
        String html = "<html><body style='width: %1spx; text-align: center'>%1s";
        JButton button3 = new JButton(String.format(html, 100, s));
        button3.setBounds(75, 210, 170, 40);
        viewBalancesListener vbl = new viewBalancesListener();
        button3.addActionListener(vbl);
        panel.add(button3);

        JButton button4 = new JButton("Deposit Money");
        button4.setBounds(260, 150, 180, 25);
        depositMoneyListener dml = new depositMoneyListener();
        button4.addActionListener(dml);
        panel.add(button4);

        JButton button5 = new JButton("Withdraw Money");
        button5.setBounds(260, 180, 180, 25);
        withdrawMoneyListener wml = new withdrawMoneyListener();
        button5.addActionListener(wml);
        panel.add(button5);

        JButton button6 = new JButton("Request Loan");
        button6.setBounds(260, 210, 180, 25);
        requestLoanListener rll = new requestLoanListener();
        button6.addActionListener(rll);
        panel.add(button6);

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
        customersListener cl = new customersListener();
        button1.addActionListener(cl);
        panel.add(button1);

        JButton button4 = new JButton("Reports");
        button4.setBounds(260, 150, 180, 25);
        reportsListener rl = new reportsListener();
        button4.addActionListener(rl);
        panel.add(button4);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(30, 320, 90, 25);
        adminLoginListener al = new adminLoginListener();
        logoutButton.addActionListener(al);
        panel.add(logoutButton);

        panel.setLayout(null);
    }

    /* User Components */

    public void createOpenAccountComponent(JPanel panel) {
        userPortalButton = new JButton("Back");
        userPortalButton.setBounds(30, 30, 160, 25);
        userPortalListener upl = new userPortalListener();
        userPortalButton.addActionListener(upl);
        panel.add(userPortalButton);

        welcomeLabel = new JLabel("Open a Bank Account", SwingConstants.CENTER);
        welcomeLabel.setBounds(150, 95, 200, 25);
        panel.add(welcomeLabel);

        openCheckingAccountButton = new JButton("Checking Account");
        openCheckingAccountButton.setBounds(150, 140, 200, 25);
        openCheckingListener ocl = new openCheckingListener();
        openCheckingAccountButton.addActionListener(ocl);
        if (currentChecking != null) {
            openCheckingAccountButton.setEnabled(false);
        }
        panel.add(openCheckingAccountButton);

        openSavingsAccountButton = new JButton("Savings Account");
        openSavingsAccountButton.setBounds(150, 200, 200, 25);
        openSavingsListener osl = new openSavingsListener();
        openSavingsAccountButton.addActionListener(osl);
        panel.add(openSavingsAccountButton);

        panel.setLayout(null);
    }

    public void createCloseAccountComponent(JPanel panel) {
        userPortalButton = new JButton("Back");
        userPortalButton.setBounds(30, 30, 160, 25);
        userPortalListener upl = new userPortalListener();
        userPortalButton.addActionListener(upl);
        panel.add(userPortalButton);

        welcomeLabel = new JLabel("Close a Bank Account", SwingConstants.CENTER);
        welcomeLabel.setBounds(150, 95, 200, 25);
        panel.add(welcomeLabel);

        closeCheckingAccountButton = new JButton("Checking Account");
        closeCheckingAccountButton.setBounds(150, 140, 200, 25);
        closeCheckingListener ccl = new closeCheckingListener();
        closeCheckingAccountButton.addActionListener(ccl);
        closeCheckingAccountButton.setEnabled(false);
        panel.add(closeCheckingAccountButton);

        closeSavingsAccountButton = new JButton("Savings Account");
        closeSavingsAccountButton.setBounds(150, 200, 200, 25);
        closeSavingsListener csl = new closeSavingsListener();
        closeSavingsAccountButton.addActionListener(csl);
        closeSavingsAccountButton.setEnabled(false);
        panel.add(closeSavingsAccountButton);

        panel.setLayout(null);
    }

    public void createBalancesComponent(JPanel panel) {
        userPortalButton = new JButton("Back");
        userPortalButton.setBounds(30, 30, 160, 25);
        userPortalListener upl = new userPortalListener();
        userPortalButton.addActionListener(upl);
        panel.add(userPortalButton);

        welcomeLabel = new JLabel("View transactions and balances", SwingConstants.CENTER);
        welcomeLabel.setBounds(150, 95, 200, 25);
        panel.add(welcomeLabel);

        if (currentChecking == null) {
            checkingLabelBalances.setText("Checking: N/A");
        } else {
            checkingLabelBalances.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
        }
        checkingLabelBalances.setBounds(100, 120, 200, 25);
        panel.add(checkingLabelBalances);

        if (currentSavings == null) {
            savingsLabelBalances.setText("Savings: N/A");
        } else {
            savingsLabelBalances.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
        }
        savingsLabelBalances = new JLabel("Savings: N/A");
        savingsLabelBalances.setBounds(310, 120, 200, 25);
        panel.add(savingsLabelBalances);

        checkingTransactionsButton = new JButton("Checking");
        checkingTransactionsButton.setBounds(100, 145, 80, 25);
        checkingTransactionsListener ctl = new checkingTransactionsListener();
        checkingTransactionsButton.addActionListener(ctl);
        panel.add(checkingTransactionsButton);

        savingsTransactionsButton = new JButton("Savings");
        savingsTransactionsButton.setBounds(300, 145, 80, 25);
        savingsTransactionsListener stl = new savingsTransactionsListener();
        savingsTransactionsButton.addActionListener(stl);
        panel.add(savingsTransactionsButton);

        transactionsArea = new JTextArea();
//        transactionsArea.setEditable(false);
        transactionsArea.setBounds(50, 180, 400, 150);
        panel.add(transactionsArea);


        panel.setLayout(null);
    }

    public void createDepositMoneyComponent(JPanel panel) {
        userPortalButton = new JButton("Back");
        userPortalButton.setBounds(30, 30, 160, 25);
        userPortalListener upl = new userPortalListener();
        userPortalButton.addActionListener(upl);
        panel.add(userPortalButton);

        welcomeLabel = new JLabel("Deposit money", SwingConstants.CENTER);
        welcomeLabel.setBounds(150, 95, 200, 25);
        panel.add(welcomeLabel);

        if (currentChecking == null) {
            checkingLabelDeposit.setText("Checking: N/A");
        } else {
            checkingLabelDeposit.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
        }
        checkingLabelDeposit.setBounds(100, 120, 200, 25);
        panel.add(checkingLabelDeposit);

        if (currentSavings == null) {
            savingsLabelDeposit.setText("Savings: N/A");
        } else {
            savingsLabelDeposit.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
        }
        savingsLabelDeposit.setBounds(310, 120, 200, 25);
        panel.add(savingsLabelDeposit);

        checkingFieldDeposit = new JTextField(5);
        checkingFieldDeposit.setBounds(80, 145, 75, 25);
        if (currentChecking == null) {
            checkingFieldDeposit.setEnabled(false);
        } else {
            checkingFieldDeposit.setEnabled(true);
        }
        panel.add(checkingFieldDeposit);

        checkingButtonDeposit = new JButton("Submit");
        checkingButtonDeposit.setBounds(150, 145, 80, 25);
        if (currentChecking == null) {
            checkingButtonDeposit.setEnabled(false);
        } else {
            checkingButtonDeposit.setEnabled(true);
        }
        checkingDepositListener cdl = new checkingDepositListener();
        checkingButtonDeposit.addActionListener(cdl);
        panel.add(checkingButtonDeposit);

        savingsFieldDeposit = new JTextField(5);
        savingsFieldDeposit.setBounds(280, 145, 75, 25);
        if (currentSavings == null) {
            savingsFieldDeposit.setEnabled(false);
        } else {
            savingsFieldDeposit.setEnabled(true);
        }
        panel.add(savingsFieldDeposit);

        savingsButtonDeposit = new JButton("Submit");
        savingsButtonDeposit.setBounds(350, 145, 80, 25);
        if (currentSavings == null) {
            savingsButtonDeposit.setEnabled(false);
        } else {
            savingsButtonDeposit.setEnabled(true);
        }
        savingsDepositListener sdl = new savingsDepositListener();
        savingsButtonDeposit.addActionListener(sdl);
        panel.add(savingsButtonDeposit);

        panel.setLayout(null);
    }

    public void createWithdrawMoneyComponent(JPanel panel) {
        userPortalButton = new JButton("Back");
        userPortalButton.setBounds(30, 30, 160, 25);
        userPortalListener upl = new userPortalListener();
        userPortalButton.addActionListener(upl);
        panel.add(userPortalButton);

        welcomeLabel = new JLabel("Withdraw money", SwingConstants.CENTER);
        welcomeLabel.setBounds(150, 95, 200, 25);
        panel.add(welcomeLabel);

        if (currentChecking == null) {
            checkingLabelWithdraw.setText("Checking: N/A");
        } else {
            checkingLabelWithdraw.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
        }
        checkingLabelWithdraw.setBounds(100, 120, 200, 25);
        panel.add(checkingLabelWithdraw);

        if (currentSavings == null) {
            savingsLabelWithdraw.setText("Savings: N/A");
        } else {
            savingsLabelWithdraw.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
        }
        savingsLabelWithdraw.setBounds(310, 120, 200, 25);
        panel.add(savingsLabelWithdraw);

        checkingFieldWithdraw = new JTextField(5);
        checkingFieldWithdraw.setBounds(80, 145, 75, 25);
        if (currentChecking == null) {
            checkingFieldWithdraw.setEnabled(false);
        } else {
            checkingFieldWithdraw.setEnabled(true);
        }
        panel.add(checkingFieldWithdraw);

        checkingButtonWithdraw = new JButton("Submit");
        checkingButtonWithdraw.setBounds(150, 145, 80, 25);
        if (currentChecking == null) {
            checkingButtonWithdraw.setEnabled(false);
        } else {
            checkingButtonWithdraw.setEnabled(true);
        }
        checkingWithdrawListener cwl = new checkingWithdrawListener();
        checkingButtonWithdraw.addActionListener(cwl);
        panel.add(checkingButtonWithdraw);

        savingsFieldWithdraw = new JTextField(5);
        savingsFieldWithdraw.setBounds(280, 145, 75, 25);
        if (currentSavings == null) {
            savingsFieldWithdraw.setEnabled(false);
        } else {
            savingsFieldWithdraw.setEnabled(true);
        }
        panel.add(savingsFieldWithdraw);

        savingsButtonWithdraw = new JButton("Submit");
        savingsButtonWithdraw.setBounds(350, 145, 80, 25);
        if (currentSavings == null) {
            savingsButtonWithdraw.setEnabled(false);
        } else {
            savingsButtonWithdraw.setEnabled(true);
        }
        savingsWithdrawListener swl = new savingsWithdrawListener();
        savingsButtonWithdraw.addActionListener(swl);
        panel.add(savingsButtonWithdraw);

        panel.setLayout(null);
    }

    public void createRequestLoanComponent(JPanel panel) {
        userPortalButton = new JButton("Back");
        userPortalButton.setBounds(30, 30, 160, 25);
        userPortalListener upl = new userPortalListener();
        userPortalButton.addActionListener(upl);
        panel.add(userPortalButton);

        welcomeLabel = new JLabel("Request loan", SwingConstants.CENTER);
        welcomeLabel.setBounds(150, 95, 200, 25);
        panel.add(welcomeLabel);

        JTextField requestLoanField = new JTextField(5);
        requestLoanField.setBounds(180, 145, 75, 25);
        panel.add(requestLoanField);

        JButton requestLoanButton = new JButton("Submit");
        requestLoanButton.setBounds(250, 145, 80, 25);
        panel.add(requestLoanButton);

        panel.setLayout(null);
    }

    /* Admin Components */

    public void createCustomersComponent(JPanel panel) {
        adminPortalButton = new JButton("Back");
        adminPortalButton.setBounds(30, 30, 160, 25);
        adminPortalListener apl = new adminPortalListener();
        adminPortalButton.addActionListener(apl);
        panel.add(adminPortalButton);

        welcomeLabel = new JLabel("Check customers", SwingConstants.CENTER);
        welcomeLabel.setBounds(145, 95, 200, 25);
        panel.add(welcomeLabel);

        JButton allCustomers = new JButton("All Customers");
        allCustomers.setBounds(75, 145, 150, 25);
        panel.add(allCustomers);

        JButton overdueCustomers = new JButton("Overdue Customers");
        overdueCustomers.setBounds(225, 145, 200, 25);
        overdueCustomers.setEnabled(false);
        panel.add(overdueCustomers);

        JTextArea customersArea = new JTextArea();
//        reportArea.setEditable(false);
        customersArea.setBounds(50, 180, 400, 150);
        panel.add(customersArea);

        panel.setLayout(null);
    }

    public void createReportsComponent(JPanel panel) {
        adminPortalButton = new JButton("Back");
        adminPortalButton.setBounds(30, 30, 160, 25);
        adminPortalListener apl = new adminPortalListener();
        adminPortalButton.addActionListener(apl);
        panel.add(adminPortalButton);

        welcomeLabel = new JLabel("Retrieve reports", SwingConstants.CENTER);
        welcomeLabel.setBounds(145, 95, 200, 25);
        panel.add(welcomeLabel);

        JButton completeReport = new JButton("Complete Report");
        completeReport.setBounds(75, 145, 150, 25);
        panel.add(completeReport);

        JButton changesReport = new JButton("Changes Since Last Report");
        changesReport.setBounds(225, 145, 200, 25);
        changesReport.setEnabled(false);
        panel.add(changesReport);

        JTextArea reportArea = new JTextArea();
//        reportArea.setEditable(false);
        reportArea.setBounds(50, 180, 400, 150);
        panel.add(reportArea);

        panel.setLayout(null);
    }

    public static void main(String args[]) {
        /* Use an appropriate Look and Feel */
        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        // Create GUI
        GUI test = new GUI();
    }

    /* Login Button Listeners */

    class userPortalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Navigating to user portal.");
            boolean loginSuccess = false;
            if (e.getSource() == loginButtonUser) {
                String username = userTextLogin.getText();
                System.out.println("Welcome " + username);
                String passText = new String(passwordTextLogin.getPassword());
                System.out.println("Hello " + passText);
                if (Bank.getBank().login(username, passText) != null) {
                    currentCustomer = Bank.getBank().login(username, passText);
                    card.show(cardPane, "User Portal");
                }
            } else if (e.getSource() == loginButtonRegister) {
                String username = userTextRegister.getText();
                System.out.println("Welcome " + username);
                String passText = new String(passwordTextRegister.getPassword());
                System.out.println("Hello " + passText);
                currentCustomer = (Customer) Bank.getBank().registerNewCustomer(username, passText);
                card.show(cardPane, "User Portal");
            } else {
                card.show(cardPane, "User Portal");
            }
        }
    }

    class registerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Register button clicked.");
            card.show(cardPane, "Register");
        }
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

    /* User Portal Listeners */

    // Open Bank Account

    class openBankAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Opening a bank account screen.");
            card.show(cardPane, "Open Bank Account");
        }
    }

    class openCheckingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Open checking account.");
            Bank.getBank().openCheckingAccount(currentCustomer, 0, Currency.UIV);
            ArrayList<Account> accounts = currentCustomer.getAccounts();
            for (Account account:accounts) {
                if (account instanceof CheckingAccount) {
                    currentChecking = (CheckingAccount) account;
                }
            }
            System.out.println("opened account " + currentChecking.getAccountInfo());
            if (e.getSource() == openCheckingAccountButton) {
                openCheckingAccountButton.setEnabled(false);
                closeCheckingAccountButton.setEnabled(true);
                checkingFieldDeposit.setEnabled(true);
                checkingButtonDeposit.setEnabled(true);
                checkingFieldWithdraw.setEnabled(true);
                checkingButtonWithdraw.setEnabled(true);
                checkingLabelBalances.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
                checkingLabelDeposit.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
                checkingLabelWithdraw.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
            }
        }
    }

    class openSavingsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Open savings account.");
            Bank.getBank().openSavingsAccount(currentCustomer, 0, Currency.UIV, SavingsAccount.DEFAULT_INTEREST_RATE, 1000000);
            ArrayList<Account> accounts = currentCustomer.getAccounts();
            for (Account account:accounts) {
                if (account instanceof SavingsAccount) {
                    currentSavings = (SavingsAccount) account;
                }
            }
            System.out.println("opened account " + currentSavings.getAccountInfo());
            if (e.getSource() == openSavingsAccountButton) {
                openSavingsAccountButton.setEnabled(false);
                closeSavingsAccountButton.setEnabled(true);
                savingsFieldDeposit.setEnabled(true);
                savingsButtonDeposit.setEnabled(true);
                savingsFieldWithdraw.setEnabled(true);
                savingsButtonWithdraw.setEnabled(true);
                savingsLabelBalances.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
                savingsLabelDeposit.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
                savingsLabelWithdraw.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
            }
        }
    }

    // Close Bank Account

    class closeBankAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Closing a bank account screen.");
            card.show(cardPane, "Close Bank Account");
        }
    }

    class closeCheckingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Close checking account.");
            System.out.println("closed account " + currentChecking.getAccountInfo());
            Bank.getBank().deleteAccount(currentChecking.getAccountNumber());
            System.out.println(currentCustomer.getAccounts().size());
            if (e.getSource() == closeCheckingAccountButton) {
                closeCheckingAccountButton.setEnabled(false);
                openCheckingAccountButton.setEnabled(true);
                checkingFieldDeposit.setEnabled(false);
                checkingButtonDeposit.setEnabled(false);
                checkingFieldWithdraw.setEnabled(false);
                checkingButtonWithdraw.setEnabled(false);
                checkingLabelBalances.setText("Checking: N/A");
                checkingLabelDeposit.setText("Checking: N/A");
                checkingLabelWithdraw.setText("Checking: N/A");
            }
        }
    }

    class closeSavingsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Close savings account.");
            System.out.println("closed account " + currentSavings.getAccountInfo());
            Bank.getBank().deleteAccount(currentSavings.getAccountNumber());
            System.out.println(currentCustomer.getAccounts().size());
            if (e.getSource() == closeSavingsAccountButton) {
                closeSavingsAccountButton.setEnabled(false);
                openSavingsAccountButton.setEnabled(true);
                savingsFieldDeposit.setEnabled(false);
                savingsButtonDeposit.setEnabled(false);
                savingsFieldWithdraw.setEnabled(false);
                savingsButtonWithdraw.setEnabled(false);
                savingsLabelBalances.setText("Savings: N/A");
                savingsLabelDeposit.setText("Savings: N/A");
                savingsLabelWithdraw.setText("Savings: N/A");
            }
        }
    }

    // View Balances

    class viewBalancesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> View balances screen.");
            card.show(cardPane, "View Balances");
        }
    }

    class checkingTransactionsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Showing checking transactions.");
            String res = "";
            for (Transaction transaction:currentChecking.getTransactions()) {
                System.out.println(transaction);
                res += transaction;
            }
            System.out.println("Kore wa: " + res);
            transactionsArea.setText(res);
            System.out.println("This is: " + transactionsArea.getText());
        }
    }

    class savingsTransactionsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Showing savings transactions.");
            String res = "";
            for (Transaction transaction:currentSavings.getTransactions()) {
                res += transaction;
            }
            transactionsArea.setText(res);
        }
    }

    // Deposit Money

    class depositMoneyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Deposit money screen.");
            ArrayList<Account> accounts = currentCustomer.getAccounts();
//            for (Account account:accounts) {
//                if (account.Type == CHECKING)
//
//            }
//            Bank.getBank().depositMoney(currentUser)
            card.show(cardPane, "Deposit Money");
        }
    }

    class checkingDepositListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Depositing money: " + checkingFieldDeposit.getText());
//            ArrayList<Account> accounts = currentCustomer.getAccounts();
            double depositAmount = Double.parseDouble(checkingFieldDeposit.getText());
//            currentChecking.deposit(depositAmount, Currency.UIV);
            try {
                Bank.getBank().depositMoney(currentChecking, depositAmount, Currency.UIV);
            } catch (BankException bankException) {
                bankException.printStackTrace();
            }
            checkingLabelBalances.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
            checkingLabelDeposit.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
            checkingLabelWithdraw.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
//            card.show(cardPane, "Deposit Money");
        }
    }

    class savingsDepositListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Depositing money: " + savingsFieldDeposit.getText());
//            ArrayList<Account> accounts = currentCustomer.getAccounts();
            double depositAmount = Double.parseDouble(savingsFieldDeposit.getText());
//            currentChecking.deposit(depositAmount, Currency.UIV);
            try {
                Bank.getBank().depositMoney(currentSavings, depositAmount, Currency.UIV);
            } catch (BankException bankException) {
                bankException.printStackTrace();
            }
            savingsLabelBalances.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
            savingsLabelDeposit.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
            savingsLabelWithdraw.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
//            card.show(cardPane, "Deposit Money");
        }
    }

    // Withdraw Money

    class withdrawMoneyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Withdraw money screen.");
            card.show(cardPane, "Withdraw Money");
        }
    }

    class checkingWithdrawListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Withdrawing money: " + checkingFieldWithdraw.getText());
            double withdrawAmount = Double.parseDouble(checkingFieldWithdraw.getText());
            try {
                Bank.getBank().withdrawMoney(currentChecking, withdrawAmount, Currency.UIV);
            } catch (BankException bankException) {
                bankException.printStackTrace();
            }
            checkingLabelBalances.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
            checkingLabelDeposit.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
            checkingLabelWithdraw.setText("Checking: " + currentChecking.getBalance(Currency.UIV));
        }
    }

    class savingsWithdrawListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Withdrawing money: " + savingsFieldWithdraw.getText());
            double withdrawAmount = Double.parseDouble(savingsFieldWithdraw.getText());
            try {
                Bank.getBank().withdrawMoney(currentSavings, withdrawAmount, Currency.UIV);
            } catch (BankException bankException) {
                bankException.printStackTrace();
            }
            savingsLabelBalances.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
            savingsLabelDeposit.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
            savingsLabelWithdraw.setText("Savings: " + currentSavings.getBalance(Currency.UIV));
        }
    }

    // Request Loan

    class requestLoanListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Request loan screen.");
            card.show(cardPane, "Request Loan");
        }
    }

    /* Admin Portal Listeners */

    class adminPortalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Navigating to admin portal.");
            System.out.println("Welcome " + userTextAdmin.getText());
            String passText = new String(passwordTextAdmin.getPassword());
            System.out.println("Hello " + passText);
            card.show(cardPane, "Admin Portal");
        }
    }

    // Customers

    class customersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Check customers.");
            card.show(cardPane, "Customers");
        }
    }

    // Reports

    class reportsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("> Retrieve reports.");
            card.show(cardPane, "Reports");
        }
    }

    /* Override Methods */

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
}