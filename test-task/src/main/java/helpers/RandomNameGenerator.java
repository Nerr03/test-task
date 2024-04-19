package helpers;
import java.util.Random;

public class RandomNameGenerator {

  private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  private static final int NAME_LENGTH = 6; // Довжина випадкового імені

        public static String generateRandomName() {
            Random random = new Random();
            StringBuilder nameBuilder = new StringBuilder();

            for (int i = 0; i < NAME_LENGTH; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                char randomChar = CHARACTERS.charAt(randomIndex);
                nameBuilder.append(randomChar);
            }

            return nameBuilder.toString();
        }

}
