package API.Infra.Properties;

public class AuthID {
    public static String token;

    public static String initializeToken() {
        try {
            token = PostAuth.GetAuthKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return token;
    }
}
