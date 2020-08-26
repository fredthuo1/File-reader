import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter File name to encrypt: ");
        String file = scanner.nextLine();
        System.out.println("Enter File destination name: ");
        String outFile = scanner.nextLine();
        System.out.println("Enter byte in the range of -128 to 127: ");
        int bite = scanner.nextInt();
        if (bite < -128 || bite > 127) {
            System.out.println("Invalid input! Enter value between -128 and 127! Try again: ");
            bite = scanner.nextByte();
        }
        encrypt(file, outFile, bite).close();
        System.out.println("Done now you can open the encrypted file!");

    }

    public static FileOutputStream encrypt(String file, String destination, int code) throws IOException {
        FileInputStream in = null;
        try {

            in = new FileInputStream(file);
        } catch ( FileNotFoundException ex ) {
            System.out.println("File " + file + " was not found.");
        }
        FileOutputStream out = new FileOutputStream(destination);

        int c;

        while ((c = in.read()) != -1) {
            out.write((byte) c + code);
        }

        return out;
    }
}
