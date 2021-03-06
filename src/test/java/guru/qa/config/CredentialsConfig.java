package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:guru.qa.config/credentials.properties"})
public interface CredentialsConfig extends Config {
        String remoteuUrl();
        String login();
        String password();
}