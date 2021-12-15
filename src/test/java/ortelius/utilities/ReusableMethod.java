package ortelius.utilities;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class ReusableMethod {

    public static String getEnvironmentValue(String key)
    {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(variables).getProperty(key);
    }

}
