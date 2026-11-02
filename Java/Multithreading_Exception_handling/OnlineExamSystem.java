package Multithreading_Exception_handling;
import java.util.Scanner;

class ExamTimer implements Runnable {
    private int durationInSeconds;
    private volatile boolean examFinished = false;

    public ExamTimer(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public void finishExam() {
        this.examFinished = true;
    }

    @Override
    public void run() {
        while (durationInSeconds > 0 && !examFinished) {
            if (durationInSeconds % 5 == 0 || durationInSeconds <= 3) {
                System.out.println("\nTime remaining: " + durationInSeconds + " seconds");
            }
            
            try {
                Thread.sleep(1000); // Wait for 1 second
            } catch (InterruptedException e) {
                System.out.println("Timer interrupted.");
                return;
            }
            durationInSeconds--;
        }

        if (!examFinished) {
            System.out.println("\nTime is UP! The exam is submitting automatically.");
            System.exit(0); // program terminated
        }
    }
}

public class OnlineExamSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examDuration = 15; // 15 seconds exam for simulation

        System.out.println("Welcome to the Online Exam! You have " + examDuration + " seconds.");
        System.out.println("Starting the exam now...\n");

        ExamTimer timerRunnable = new ExamTimer(examDuration);
        Thread timerThread = new Thread(timerRunnable);
        timerThread.start();

        String[] questions = {
            "1. What is your College's name? (Type your answer): ",
            "2. What is your roll number? (Type your answer): "
        };

        for (int i = 0; i < questions.length; i++) {
            System.out.print(questions[i]);
            String answer = scanner.nextLine();
            System.out.println("Saved response for Question " + (i + 1) + ": " + answer);
        }

        timerRunnable.finishExam();
        System.out.println("\nCongratulations! You submitted your exam successfully before the deadline.");
        scanner.close();
    }
}
