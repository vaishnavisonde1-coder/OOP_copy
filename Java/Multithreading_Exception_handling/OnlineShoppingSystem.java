package Multithreading_Exception_handling;
class OrderConfirmation implements Runnable {
    private String orderId;

    public OrderConfirmation(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("📦 [Order Confirmation] Starting confirmation for Order ID: " + orderId);
        try {
            // Simulating database update and stock verification delay
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("✅ [Order Confirmation] Order " + orderId + " has been officially confirmed!");
    }
}

class InvoiceGeneration implements Runnable {
    private String orderId;

    public InvoiceGeneration(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("🧾 [Invoice Generation] Creating invoice for Order ID: " + orderId);
        try {
            // Simulating PDF generation and email sending delay
            Thread.sleep(1200); 
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("📧 [Invoice Generation] Invoice sent successfully for Order ID: " + orderId);
    }
}

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        String customerOrderId = "ORD-2026-9876";

        System.out.println("🛒 Customer placed an order. Processing tasks concurrently...\n");

        // Creating the tasks
        Thread confirmationThread = new Thread(new OrderConfirmation(customerOrderId));
        Thread invoiceThread = new Thread(new InvoiceGeneration(customerOrderId));

        // Starting both threads simultaneously
        confirmationThread.start();
        invoiceThread.start();

        try {
            // Main thread waits for both tasks to complete before wrapping up
            confirmationThread.join();
            invoiceThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n🎉 Success! All post-purchase processes completed for " + customerOrderId);
    }
}
