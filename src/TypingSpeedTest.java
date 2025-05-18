import java.util.Scanner;
import java.util.Random;

public class TypingSpeedTest {
    public static void main(String[] args) {
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "Typing practice improves speed and accuracy.",
                "Java programming is fun and educational.",
                "Practice makes perfect in coding and typing.",
                "Consistency is the key to mastering skills."
        };
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String testSentence = sentences[random.nextInt(sentences.length)];
        System.out.println("Type the following sentence:");
        System.out.println("\n" + testSentence);
        System.out.println("\nPress Enter when you are ready ...");
        scanner.nextLine();


        long startTime = System.currentTimeMillis();

        System.out.println("Start Typing:");
        String userInput = scanner.nextLine();

        long endTime = System.currentTimeMillis();

        long timeTakenMillis = endTime - startTime;
        double timeTakenSeconds = timeTakenMillis / 1000.0;

        int wordCount = testSentence.split("\\s+").length;
        double wpm = (wordCount / timeTakenSeconds) * 60;

        int correctChars = 0;
        int minLength = Math.min(testSentence.length(), userInput.length());


        for(int i = 0; i <minLength; i++){
            if(testSentence.charAt(i)== userInput.charAt(i)){
                correctChars++;
            }
        }

        double accuracy = ((double) correctChars / testSentence.length())* 100;


        System.out.printf("\nTime Taken: %.2f seconds\n",timeTakenSeconds);
        System.out.printf("Your Typing Speed: %.2f WPM\n",wpm);
        System.out.printf("Accuracy: %.2f%%\n",accuracy);

        scanner.close();

    }
}