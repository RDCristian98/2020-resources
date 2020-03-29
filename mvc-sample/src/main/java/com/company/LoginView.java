package com.company;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame implements ILoginView {

    private final JTextField usernameTextField;
    private final JTextField passwordTextField;

    public LoginView() {
        setMinimumSize(new Dimension(200, 200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("Login view");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        usernameTextField = new JTextField();
        add(usernameTextField);

        passwordTextField = new JTextField();
        add(passwordTextField);

        JButton loginButton = new JButton();
        loginButton.setText("Login");
        add(loginButton);

        LoginController loginController = new LoginController(this);
        loginButton.addActionListener(e -> loginController.login());
    }

    @Override
    public void showAdminView() {
        new AdminView().setVisible(true);
    }

    @Override
    public void showRegularView() {
        new RegularView().setVisible(true);
    }

    @Override
    public String getUsername() {
        return usernameTextField.getText();
    }

    @Override
    public String getPassword() {
        return passwordTextField.getText();
    }

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }


}
