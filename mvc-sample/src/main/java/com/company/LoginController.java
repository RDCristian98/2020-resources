package com.company;


public class LoginController {

    private final ILoginView loginView;

    LoginController(ILoginView loginView/* , IAccountProvider accountProvider */) {

        this.loginView = loginView;
    }

    public void login() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        /*
        Possible alternative:

        Account account = accountProvider.getAccount(username, password);
        if (account == null)
            viewProvider.showErrorMessage("Invalid username/password");
        else {
            viewProvider.showView(account);
        }
        */
        if (username.equals("admin") && password.equals("admin"))
            loginView.showAdminView();
        else if (username.equals("user") && password.equals("user"))
            loginView.showRegularView();
        else
            loginView.showErrorMessage("Invalid username/password");
    }
}
