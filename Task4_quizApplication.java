import java.util.*;
public class Task4_quizApplication {
    static class Question {
        String question;
        String[] options;
        int correctIndex;
        public Question(String question, String[] options, int correctIndex) {
            this.question = question;
            this.options = options;
            this.correctIndex = correctIndex;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question[] questions = new Question[]{
            new Question("What is the capital of India?", new String[]{"Mumbai", "New Delhi", "Kolkata", "Chennai"}, 1),
            new Question("Which Indian festival is known as the Festival of Lights?", new String[]{"Holi", "Diwali", "Eid", "Christmas"}, 1),
            new Question("In which year did India become independent?", new String[]{"1942", "1945", "1947", "1950"}, 2),
            new Question("Who wrote the Indian national anthem?", new String[]{"Rabindranath Tagore", "Bankim Chandra Chatterjee", "Subhash Chandra Bose", "Sarojini Naidu"}, 1),
            new Question("Which city is known as the 'Pink City'?", new String[]{"Jaipur", "Jodhpur", "Udaipur", "Bikaner"}, 0)
        };
        int score = 0;
        int timeLimit = 10; // seconds
        List<String> summary = new ArrayList<>();
        System.out.println("🎯 Welcome to the India Quiz!");
        System.out.println("⏰ You have " + timeLimit + " seconds to answer each question.\n");
        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            System.out.println("Q" + (i + 1) + ": " + q.question);
            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("\n Time's up! Moving to next question...\n");
                    System.exit(0); 
                }
            };
            timer.schedule(task, timeLimit * 1000L);
            System.out.print("Your answer (1-4): ");
            int answer;
            try {
                answer = sc.nextInt();
            } catch (Exception e) {
                answer = -1; 
                sc.next();
            }
            timer.cancel();
            if (answer - 1 == q.correctIndex) {
                score++;
                summary.add("Q" + (i + 1) + ": Correct");
            } else {
                summary.add("Q" + (i + 1) + ":Incorrect (Correct: " + q.options[q.correctIndex] + ")");
            }
            System.out.println();
        }
        System.out.println("Quiz Complete!");
        System.out.println("Your Score: " + score + " out of " + questions.length);
        System.out.println("\n Summary:");
        for (String s : summary) {
            System.out.println(s);
        }
        sc.close();
    }
}
