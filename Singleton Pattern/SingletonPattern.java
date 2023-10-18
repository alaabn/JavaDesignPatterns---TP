import java.util.HashMap;
import java.util.Map;

final class ConfigSingleton {
    private static ConfigSingleton INSTANCE;
    private Map<String, String> props;

    private ConfigSingleton() {
        this.props = new HashMap<>();
    }

    public static ConfigSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConfigSingleton();
        }

        return INSTANCE;
    }

    public String getProp(String key) {
        return props.get(key);
    }

    public void setProp(String key, String value) {
        props.put(key, value);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        ConfigSingleton config1 = ConfigSingleton.getInstance();
        config1.setProp("port", "3000");
        String port = config1.getProp("port");
        config1.setProp("url", "api.polytec.tn");
        System.out.println("depuisfichier 1  " + port);

        ConfigSingleton config2 = ConfigSingleton.getInstance();
        String url = config2.getProp("url");
        System.out.println("depuisfichier 2  " + url);

    }
}