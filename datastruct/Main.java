package datastruct;

import java.util.*;
import static java.lang.System.exit;

public class Main {
    public static void selector() {
        Scanner scan = new Scanner(System.in);
        String[] options = {
                "[A] Circular Array",
                "[B] Stack",
                "[C] Linked List",
                "[D] Hash Map",
                "[E] Exit"
        };

        while (true) {
            printSelection(options);
            char selected = scan.next().charAt(0);
            switch (selected) {
                case 'a', 'A' -> {
                    System.out.println("\nCircular Array");
                    CircularArray ca = new CircularArray();
                    ca.process();
                }
                case 'b', 'B' -> {
                    System.out.println("\nStack");
                    CStack s = new CStack();
                    s.process();
                }
                case 'c', 'C' -> {
                    System.out.println("\nLinked List");
                    CLinkedList ll = new CLinkedList();
                    ll.process();
                }
                case 'd', 'D' -> {
                    System.out.println("\nHash Map");
                    CHashMap hm = new CHashMap();
                    hm.process();
                }
                case 'e', 'E' -> {
                    System.out.println("Thank you for using our program.");
                    exit(0);
                }
                default -> {
                    System.out.println("Invalid input '" + selected + "'.");
                    selector();
                }
            }
            
            scan.close();
        }
    }

    public static void printSelection(String[] options) {
        System.out.print("""
                ========================================
                Data Structures Implementations
                """);
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option: ");
    }

    public static void main(String[] args) {
        selector();
    }
}

class CircularArray {
    private int front, rear;

    // initializing Circular Array
    CircularArray() {
        front = -1;
        rear = -1;
    }

    // display Array <display>
    public void display(int[] arr, int size) {
        if (front == -1 && rear == -1)
            System.out.println("Array is currently isEmpty.");
        else {
            System.out.println("Array contents <display>: ");

            for (int i = front; i != rear; i = (i + 1) % size)
                System.out.print(arr[i] + " ");
            System.out.print(arr[rear] + "");
            System.out.println("\nFront element is: " + front);
            System.out.println("Rear element is " + rear + "\n");
        }
    }

    // Enqueue element to Array <enqueue>
    public void enqueue(int[] arr, int size, int i) {
        if (isFull(arr.length))
            System.out.println("Enqueue has failed. Array currently full.\n");
        else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            arr[rear] = i;
        }
    }

    // Dequeue element from Array <dequeue>
    public int dequeue(int[] arr, int size) {
        int dequeued = arr[front];
        if (isEmpty()) {
            System.out.println("Dequeue has failed. Array is currently empty.\n");
            return -1;
        }
        else {
            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else
                front = (front + 1) % size;
            return dequeued;
        }
    }

    //returns if array isFull
    public boolean isFull(int size) {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    // returns if array isEmpty
    public boolean isEmpty() {
        return (front == -1);
    }

    // Clear Array <clear>
    public void clear(int[] arr, int size) {
        for (int i = front; i != rear; i = (i + 1) % size)
            arr[i] = 0;
        arr[rear] = 0;
        front = -1;
        rear = -1;
    }

    public int input(boolean mode) {
        Scanner scan = new Scanner(System.in);
        int temp = 10;

        try {
            if (mode) {
                while (true) {
                    System.out.print("Input Enqueue Limit [10-20]: ");
                    temp = scan.nextInt();

                    if (temp >= 10 && temp <= 20) {
                        break;
                    } else {
                        System.out.print("========================================\n");
                        System.out.println("Input Number must be BETWEEN OR EQUAL TO 10 AND 20");
                        System.out.print("========================================\n");
                    }
                }
            }
            else {
                while (true) {
                    System.out.print("Input Number to Enqueue [0-99]: ");
                    temp = scan.nextInt();

                    if (temp >= 0 && temp <= 99) {
                        break;
                    } else {
                        System.out.print("========================================\n");
                        System.out.println("Input Number must be BETWEEN OR EQUAL TO 0 AND 99");
                        System.out.print("========================================\n");
                    }
                }
            }
        } catch (Exception ex) {
            System.out.print("========================================\n");
            System.out.println("Invalid Input");
            System.out.print("========================================\n");
            input(mode);
        }

        scan.close();
        return temp;
    }

    public void printMenu(String[] options) {
        System.out.println("========================================");
        System.out.println("Circular Array");
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option: ");
    }

    public void choice(int[] arr, int size) {
        boolean b = true;
        Scanner scan = new Scanner(System.in);
        String[] options = {
                "[A] Enqueue",
                "[B] Dequeue",
                "[C] Clear Circular Array",
                "[D] Display Circular Array",
                "[E] Exit"
        };

        while (b) {
            printMenu(options);
            try {
                switch (scan.next().charAt(0)) {
                    case 'a', 'A' -> {
                        int number = input(false);
                        System.out.println("Attempting to enqueue <enqueue> >>");
                        System.out.println("Enqueued item <enqueue>: " + number);
                        enqueue(arr, size, number);
                    }
                    case 'b', 'B' -> {
                        System.out.println("Attempting to dequeue <dequeue>:");
                        System.out.println("Dequeued item <dequeue>: " + dequeue(arr, size));
                    }
                    case 'c', 'C' -> {
                        System.out.println("Cleared Array <clear> >>");
                        clear(arr, size);
                    }
                    case 'd', 'D' -> display(arr, size);
                    case 'e', 'E' -> {
                        System.out.println("Thank you for using our Circular Array.\n");
                        b = false;
                    }
                    default -> throw new Exception();
                }
            }
            catch (Exception ex){
                System.out.print("========================================\n");
                System.out.println("Invalid Input: Character input must range from A to D");
                System.out.print("========================================\n\n");
                choice(arr, size);
            }
        }

        scan.close();
    }

    public void process() {
        // input array size and number to enqueue
        int size = input(true);
        int[] arr = new int[size];

        // populates the circular array through enqueuing
        System.out.println("Enqueuing the array <enqueue> >>");	// Enqueue elements
        for (int i = 0; i < size; i++) {
            System.out.println("Enqueueing <enqueue>: " + i);
            enqueue(arr, size, i);
        }
        display(arr, size);

        // asks the user for option, program ends if user inputs 'd' or 'D'
        choice(arr, size);
    }
}

class CStack {
    // Create stack <new>
    CStack() {
    }

    // Display stack <display>
    public void display(Stack<Integer> stack) {
        System.out.println("Display stack <display>:\n" + stack);
    }

    // Push items to stack <push>
    public void push(Stack<Integer> stack, int size, int i) {
        if (isFull(stack, size))
            System.out.println("Push failed since stack is full.");
        else
            stack.push(i);
    }

    // Peek into stack <peek>
    public int peek(Stack<Integer> stack) {
        if (isEmpty(stack)) {
            System.out.println("Peek failed since stack is empty.");
            return -1;
        }
        return stack.peek();
    }

    // Pop items from stack <pop>
    public int pop(Stack<Integer> stack) {
        if (isEmpty(stack)) {
            System.out.println("\nPop failed since stack is empty.");
            return -1;
        }
        else
            return stack.pop();
    }

    // isFull
    public boolean isFull(Stack<Integer> stack, int size) {
        return stack.size() == size;
    }


    // isEmpty
    public boolean isEmpty(Stack<Integer> stack) {
        return stack.isEmpty();
    }

    // Clear stack <clear>
    public void clear(Stack<Integer> stack) {
        while (!isEmpty(stack))
            stack.pop();
    }

    public int input(boolean mode) {
        Scanner scan = new Scanner(System.in);
        int temp = 10;

        try {
            if (mode) {
                while (true) {
                    System.out.print("Input Stack Size [10-20]: ");
                    temp = scan.nextInt();

                    if (temp >= 10 && temp <= 20) {
                        break;
                    } else {
                        System.out.print("========================================\n");
                        System.out.println("Input Number must be BETWEEN OR EQUAL TO 10 AND 20");
                        System.out.print("========================================\n");
                    }
                }
            }
            else {
                while (true) {
                    System.out.print("Input Number to Push [0-99]: ");
                    temp = scan.nextInt();

                    if (temp >= 0 && temp <= 99) {
                        break;
                    } else {
                        System.out.print("========================================\n");
                        System.out.println("Input Number must be BETWEEN OR EQUAL TO 0 AND 99");
                        System.out.print("========================================\n");
                    }
                }
            }
        } catch (Exception ex) {
            System.out.print("========================================\n");
            System.out.println("Invalid Input");
            System.out.print("========================================\n");
            input(mode);
        }

        scan.close();
        return temp;
    }

    public void printMenu(String[] options) {
        System.out.println("========================================");
        System.out.println("Stack");
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option: ");
    }

    public void choice(Stack<Integer> stack, int size) {
        boolean b = true;
        Scanner scan = new Scanner(System.in);
        String[] options = {
                "[A] Push",
                "[B] Pop",
                "[C] Clear Stack",
                "[D] Display Stack",
                "[E] Peek",
                "[F] Exit"
        };

        while (b) {
            printMenu(options);
            try {
                switch (scan.next().charAt(0)) {
                    case 'a', 'A' -> {
                        int number = input(false);
                        System.out.println("Attempting to push <push> >>");
                        System.out.println("Pushed item <push>: " + number);
                        push(stack, size, number);
                    }
                    case 'b', 'B' -> {
                        System.out.println("Attempting to pop <pop> >>");
                        System.out.println("Popped item <pop>: " + pop(stack));
                    }
                    case 'c', 'C' -> {
                        System.out.println("Clear command <clear> >>");
                        clear(stack);
                        System.out.println("Cleared stack <clear>");

                    }
                    case 'd', 'D' -> {
                        System.out.println("Display stack <display> >>");
                        display(stack);
                    }
                    case 'e', 'E' -> {
                        System.out.println("Peek command <peek> >>");
                        System.out.println("Peeked item <peek>: " + peek(stack));
                    }
                    case 'f', 'F' -> {
                        System.out.println("Thank you for using our Stack.\n");
                        b = false;
                    }
                    default -> throw new Exception();
                }
            }
            catch (Exception ex){
                System.out.print("========================================\n");
                System.out.println("Invalid Input: Character input must range from A to D");
                System.out.print("========================================\n\n");
                choice(stack, size);
            }
        }

        scan.close();
    }

    public void process() {
        // create stack
        Stack<Integer> stack = new Stack<>();

        // input stack size
        int size = input(true);

        // Populate stack
        System.out.println("\nValues pushed <push> >>");
        for (int i = 0; i < size; i++) {
            System.out.println("Pushed <push>: " + i);
            push(stack, size, i);
        }
        display(stack);

        // asks the user for option, program ends if user inputs 'd' or 'D'
        choice(stack, size);
    }
}

class CLinkedList {
    CLinkedList() {
    }

    public void display(LinkedList<Integer> list) {
        System.out.println("Displaying Linked List:\n" + list);
    }

    public int input() {
        Scanner scan = new Scanner(System.in);
        int temp = 10;

        try {
            while (true) {
                System.out.print("Input Number to Add [0-99]: ");
                temp = scan.nextInt();

                if (temp >= 0 && temp <= 99) {
                    break;
                } else {
                    System.out.print("========================================\n");
                    System.out.println("Input Number must be BETWEEN OR EQUAL TO 0 AND 99");
                    System.out.print("========================================\n");
                }
            }
        } catch (Exception ex) {
            System.out.print("========================================\n");
            System.out.println("Invalid Input");
            System.out.print("========================================\n");
            input();
        }

        scan.close();
        return temp;
    }

    public void printMenu(String[] options) {
        System.out.println("========================================");
        System.out.println("Stack");
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option: ");
    }

    public void choice(LinkedList<Integer> list) {
        boolean b = true;
        Scanner scan = new Scanner(System.in);
        String[] options = {
                "[A] Add to First",
                "[B] Add to Last",
                "[C] Remove First",
                "[D] Remove Last",
                "[E] Peek First",
                "[F] Peek Last",
                "[G] Display Linked List",
                "[H] Exit"
        };

        while (b) {
            printMenu(options);
            try {
                switch (scan.next().charAt(0)) {
                    case 'a', 'A' -> {
                        int number = input();
                        System.out.println("Attempting to add >>");
                        System.out.println("Added item to first: " + number);
                        list.addFirst(number);
                    }
                    case 'b', 'B' -> {
                        int number = input();
                        System.out.println("Attempting to add >>");
                        System.out.println("Added item to last: " + number);
                        list.addLast(number);
                    }
                    case 'c', 'C' -> {
                        System.out.println("Attempting to remove from first >>");
                        System.out.println("Removed item from first: " + list.removeFirst());
                    }
                    case 'd', 'D' -> {
                        System.out.println("Attempting to remove from last >>");
                        System.out.println("Removed item from last: " + list.removeLast());
                    }
                    case 'e', 'E' -> {
                        System.out.println("Peek first >>");
                        System.out.println("Peeked item: " + list.getFirst());
                    }
                    case 'f', 'F' -> {
                        System.out.println("Peek last >>");
                        System.out.println("Peeked item: " + list.getLast());
                    }
                    case 'g', 'G' -> display(list);
                    case 'h', 'H' -> {
                        System.out.println("Thank you for using our Linked List.\n");
                        b = false;
                    }
                    default -> throw new Exception();
                }
            }
            catch (Exception ex){
                System.out.print("========================================\n");
                System.out.println("Invalid Input: Character input must range from A to H");
                System.out.print("========================================\n\n");
                choice(list);
            }
        }

        scan.close();
    }

    public void process() {
        // create stack
        LinkedList<Integer> list = new LinkedList<>();

        // Populate stack
        System.out.println("\nValues added to last >>");
        for (int i = 0; i < 10; i++) {
            System.out.println("Added: " + i);
            list.addLast(i);
        }
        display(list);

        // asks the user for option, program ends if user inputs 'h' or 'H'
        choice(list);
    }
}

class CHashMap {
    CHashMap() {

    }

    public void display(HashMap<java.util.UUID, String> hm) {
        System.out.println("Displaying Hash Map");
        for (java.util.UUID key : hm.keySet())
            System.out.println(key + ": " + hm.get(key));
    }

    public String input() {
        Scanner scan = new Scanner(System.in);
        String temp = "";

        try {
            System.out.print("Input: ");
            temp = scan.nextLine();
        } catch (Exception ex) {
            System.out.print("========================================\n");
            System.out.println("Invalid Input");
            System.out.print("========================================\n");
            input();
        }

        scan.close();
        return temp;
    }

    public void printMenu(String[] options) {
        System.out.println("========================================");
        System.out.println("Hash Map");
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option: ");
    }

    public void choice(HashMap<java.util.UUID, String> hm) {
        boolean b = true;
        Scanner scan = new Scanner(System.in);
        String[] options = {
                "[A] Add Item",
                "[B] Remove Item",
                "[C] Access Item",
                "[D] Display Hash Map",
                "[E] Exit"
        };

        while (b) {
            printMenu(options);
            try {
                switch (scan.next().charAt(0)) {
                    case 'a', 'A' -> {
                        String item = input();
                        java.util.UUID key = java.util.UUID.randomUUID();
                        hm.put(key, item);
                        System.out.println("Added item with key <" + key + ">: " + item);
                    }
                    case 'b', 'B' -> {
                        java.util.UUID key = UUID.fromString(input());
                        hm.remove(key);
                        System.out.println("Removed item with key <" + key + ">.");
                    }
                    case 'c', 'C' -> {
                        java.util.UUID key = UUID.fromString(input());
                        String item = hm.get(key);
                        System.out.println("Item with key <" + key + ">: " + item);
                    }
                    case 'd', 'D' -> display(hm);
                    case 'e', 'E' -> {
                        System.out.println("Thank you for using our Hash Map.\n");
                        b = false;
                    }
                    default -> throw new Exception();
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.print("Key Not Found. Try again.\n");
            }
            catch (Exception ex){
                System.out.print("========================================\n");
                System.out.println("Invalid Input: Character input must range from A to E");
                System.out.print("========================================\n\n");
                choice(hm);
            }
        }

        scan.close();
    }

    public void process() {
        // create Hash Map
        HashMap<java.util.UUID, String> hm = new HashMap<>();
        String[] arr = {"One", "Two", "Three", "Four", "Five"};

        // populate Hash Map
        System.out.println("\nValues added to HashMap");
        for (int i = 0; i < 5; i++) {
            System.out.println("Added: " + arr[i]);
            hm.put(java.util.UUID.randomUUID(), arr[i]);
        }
        display(hm);

        // asks the user for option, program ends if user inputs 'e' or 'E'
        choice(hm);
    }
}