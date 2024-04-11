import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String nunmberfileName = "number_of_file.txt";
    public static final String make_paper_file = "make_paper_file.txt";

    public static void main(String[] args) {
        System.out.println("You want make question paper press 1");
        System.out.println("You want see question paper press 2");
        System.out.println("You want Add question paper press 3");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1 -> create_paper();
            case 2 -> view_paper();
            case 3 -> add_question();

            default -> System.out.println("Invalid entry");
        }
    }

    private static void delete_paper() {
        int file_number = 0;
        try (Scanner scanner = new Scanner(new File(nunmberfileName))) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                file_number = number;
                System.out.println("Read number: " + number);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        if (file_number == 0) {
            System.out.println("Question Paper is Not Fund");
        }
        for (int i = 1; i <= file_number; i++) {
            System.out.println("Question Paper" + i);
        }
        Scanner scanner = new Scanner(System.in);
        File fileToDelete = new File("Question_paper" + scanner.nextInt() + ".txt");
        // Check if the file exists before attempting to delete it
        if (fileToDelete.exists()) {
            // Attempt to delete the file
            if (fileToDelete.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    private static void add_question() {
        System.out.println("Enter Number of question");
        Scanner scanner = new Scanner(System.in);
        int number_of_question = scanner.nextInt();
        number_of_question++;
        ArrayList<String> list_question = new ArrayList();
        for (int i = 1; i <= number_of_question; i++) {
            list_question.add(scanner.nextLine());
        }
        for (String a : list_question) {
            System.out.println(a);
        }
        sava_list(list_question, number_of_question);
    }

    private static void sava_list(ArrayList<String> list_question, int number_of_question) {
        int file_number = 0;
        try (Scanner scanner = new Scanner(new File(nunmberfileName))) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                file_number = number;
                System.out.println("Read number: " + number);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        if (file_number == 0) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(nunmberfileName))) {
                // Write data to the file
                writer.println(1);
                System.out.println("Data has been written to the file.");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
        file_number++;
        String fileName = "Question_paper" + file_number + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write data to the file
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))) {
                // Write data to the file
                printWriter.println(number_of_question);
                System.out.println("Data has been written to the file.");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
            for (int i = 0; i < number_of_question; i++) {
                writer.write(list_question.get(i) + "\n");
            }
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(nunmberfileName))) {
                // Write data to the file
                printWriter.println(file_number);
                System.out.println("Data has been written to the file.");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void view_paper() {
        int file_number = 0;
        try (Scanner scanner = new Scanner(new File(nunmberfileName))) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                file_number = number;
                System.out.println("Read number: " + number);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Paper not found: " + e.getMessage());
        }
        if (file_number == 0) {
            System.out.println("Question Paper is Not Fund");
        }
        for (int i = 1; i <= file_number; i++) {
            System.out.println("Question Paper" + i);
        }
        Scanner scanner = new Scanner(System.in);
        diselay_file(scanner.nextInt());
    }

    private static void diselay_file(int file_number) {
        String fileName = "Question_paper" + file_number + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int a = 0;
            while ((line = reader.readLine()) != null) {
                if (a >= 1) {
                    System.out.println("Q." + a + " " + line);
                    a++;
                } else {
                    System.out.println(line);
                    a++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void create_paper() {
        int file_number = 0;
        try (Scanner scanner = new Scanner(new File(nunmberfileName))) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                file_number = number;
                System.out.println("Read number: " + number);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Paper not found: " + e.getMessage());
        }
        System.out.println("Note: Max to Max You are Put Only " + file_number + " Question");
        System.out.println("Enter Number of Question");
        Scanner scanner = new Scanner(System.in);
        make_paper(scanner.nextInt());
    }

    private static void make_paper(int number_of_Question) {
        ArrayList<String> list_question = new ArrayList();
        int create_paper_number = 0;
        try (Scanner scanner = new Scanner(new File(make_paper_file))) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                create_paper_number = number;
                System.out.println("Read number: " + number);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        if (create_paper_number == 0) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(make_paper_file))) {
                // Write data to the file
                writer.println(1);
                System.out.println("Data has been written to the file.");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
        for (int i = 1; i <= number_of_Question; i++) {
            String fileName = "Question_paper" + i + ".txt";
            int desiredLine = number_genret(i, number_of_Question, create_paper_number); // Select the line number to read

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                int currentLine = 1;

                // Read lines until reaching the desired line
                while ((line = reader.readLine()) != null && currentLine < desiredLine) {
                    currentLine++;
                }
                // Print the desired line
                if (currentLine == desiredLine) {
                    list_question.add(line);
                    System.out.println("Line " + desiredLine + ": " + line);
                } else {
                    System.out.println("File doesn't have line " + desiredLine);
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }
        for (int i = 0; i < number_of_Question; i++) {
            System.out.println(i+"."+list_question.get(i));
        }
        save_ganretd_paper(list_question,create_paper_number,number_of_Question);
    }

    private static void save_ganretd_paper(ArrayList<String> list_question, int create_paper_number, int number_of_Question) {
        String fileName = "Generated_Question_paper" + create_paper_number + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write data to the file
            for (int i = 0; i < number_of_Question; i++) {
                writer.write(list_question.get(i) + "\n");
            }
            create_paper_number++;
            System.out.println(create_paper_number);
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(make_paper_file))) {
                // Write data to the file
                printWriter.println(create_paper_number);
                System.out.println("numbre has been written to the file.");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static int number_genret(int a, int b, int c) {
        int d = a * a * b * b * c * c;
        System.out.println(d + "d");
        int e = d / (a + b + c);
        int f = 0;
        System.out.println(e + "e");
        if (e != 0) {
            if (f == 0) {
                f = (int) (e % 10);
                System.out.println(f + "f");
            }
            if (f == 0) {
                e = e / 10;
                f = (int) (e % 10);
                System.out.println(f + "f");
            }
            return f;
        }
        float d1 = a * a * b * b * c * c;
        float e1 = d1 / (a + b + c);
        System.out.println(e1);
        int a1 = (int) (e1 * 10);
        System.out.println(a1);
        if (a1 == 0) {
            a1 = (int) e1 * 100;
            System.out.println(a1);
        }
        return a1;
    }
}
