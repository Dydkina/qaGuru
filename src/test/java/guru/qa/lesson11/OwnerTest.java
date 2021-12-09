package guru.qa.lesson11;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tag("properties")
public class OwnerTest {
     public CredentialsConfig credentials =
                ConfigFactory.create(CredentialsConfig.class);

        @Test
        void readCredentialsTest() {
            String url = credentials.url();
            String login = credentials.login();
            String password = credentials.password();

            System.out.println(url);
            System.out.println(login);
            System.out.println(password);

            String message = format("I go to %s and login as %s with password %s", url,  login, password);
            System.out.println(message);
        }
}