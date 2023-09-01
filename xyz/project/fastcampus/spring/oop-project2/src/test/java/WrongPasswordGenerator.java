import org.example.PasswordGenerator;

public class WrongPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatorPassword() {
        return "123";
    }
}
