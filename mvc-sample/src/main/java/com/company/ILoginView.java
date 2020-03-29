package com.company;

interface ILoginDataProvider {

    String getUsername();

    String getPassword();

}

interface IViewProvider {

    void showAdminView();

    void showRegularView();

    void showErrorMessage(String message);
}

public interface ILoginView extends ILoginDataProvider, IViewProvider {
}
