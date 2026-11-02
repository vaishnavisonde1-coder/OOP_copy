package Multithreading_Exception_handling;
import java.util.Random;

class HeartRateMonitor implements Runnable {
    private Random random = new Random();

    @Override
    public void run() {
        try {
            while (true) {
                int heartRate = 65 + random.nextInt(35);
                System.out.println("❤️ [VITAL MONITOR] Heart Rate: " + heartRate + " BPM");
                
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Heart rate monitor deactivated.");
        }
    }
}

class TemperatureMonitor implements Runnable {
    private Random random = new Random();

    @Override
    public void run() {
        try {
            while (true) {
                double temperature = 36.5 + (random.nextDouble() * 1.5);
                System.out.printf("🌡️ [VITAL MONITOR] Body Temperature: %.1f °C\n", temperature);
                
                Thread.sleep(2500); 
            }
        } catch (InterruptedException e) {
            System.out.println("Temperature monitor deactivated.");
        }
    }
}

public class HospitalMonitoringSystem {
    public static void main(String[] args) {
        System.out.println("🏥 Initializing Patient ICU Monitoring System...");
        System.out.println("Press 'Ctrl + C' in your terminal anytime to stop monitoring.\n");

        Thread heartRateThread = new Thread(new HeartRateMonitor());
        Thread temperatureThread = new Thread(new TemperatureMonitor());

        heartRateThread.start();
        temperatureThread.start();
    }
}
