import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskPriorityManager {
    // Task class to hold task details and priority
    static class Task implements Comparable<Task> {
        String name;
        int priority; // Lower value = higher priority

        Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return "Task: " + name + ", Priority: " + priority;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(); // Min-Heap for tasks
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Task Priority Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Highest Priority Task");
            System.out.println("3. Complete Task");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter priority (lower number = higher priority): ");
                    int priority = scanner.nextInt();
                    taskQueue.offer(new Task(name, priority));
                    System.out.println("Task added.");
                    break;

                case 2:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("Highest Priority Task: " + taskQueue.peek());
                    }
                    break;

                case 3:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks to complete.");
                    } else {
                        System.out.println("Completed Task: " + taskQueue.poll());
                    }
                    break;

                case 4:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("--- All Tasks ---");
                        for (Task task : taskQueue) {
                            System.out.println(task);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
