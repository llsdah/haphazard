import org.example.PasswordGenerator;

public class CorrectPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatorPassword() {
        return "12341234";
    }
}
