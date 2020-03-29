package com.company;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginControllerTests {
    @Test
    public void givenAdminUsernameAndPassword_login_showAdminView() {
        ILoginView loginView = mock(ILoginView.class);
        when(loginView.getUsername()).thenReturn("admin");
        when(loginView.getPassword()).thenReturn("admin");

        LoginController controller = new LoginController(loginView);

        controller.login();

        verify(loginView).showAdminView();
    }

    @Test
    public void givenRegularUsernameAndPassword_login_showRegularView() {
        ILoginView loginView = mock(ILoginView.class);
        when(loginView.getUsername()).thenReturn("user");
        when(loginView.getPassword()).thenReturn("user");

        LoginController controller = new LoginController(loginView);

        controller.login();

        verify(loginView).showRegularView();
    }

    @Test
    public void givenInvalidUsernameAndPassword_login_showErrorMessage() {
        ILoginView loginView = mock(ILoginView.class);
        when(loginView.getUsername()).thenReturn("notanusername");
        when(loginView.getPassword()).thenReturn("nope");

        LoginController controller = new LoginController(loginView);

        controller.login();

        verify(loginView).showErrorMessage("Invalid username/password");
    }

    @Test
    public void givenInvalidUsernameAndPassword_login_showErrorMessage2() {
        TestLoginView loginView = new TestLoginView("notanusername", "nope");

        LoginController controller = new LoginController(loginView);

        controller.login();

        assertEquals(loginView.shownErrorMessage, "Invalid username/password");
    }

    class TestLoginView implements ILoginView
    {
        private final String username;
        private final String password;

        TestLoginView(String username, String password)
        {
            this.username = username;
            this.password = password;
        }
        @Override
        public void showAdminView() {

        }

        @Override
        public void showRegularView() {

        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public String getPassword() {
            return password;
        }

        public String shownErrorMessage;
        @Override
        public void showErrorMessage(String message) {
            shownErrorMessage = message;
        }
    }
}
