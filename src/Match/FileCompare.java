package Match;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCompare {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Two names of compared files must be in the command line!");
            return;
        }
        try (
                FileInputStream f1 = new FileInputStream(args[0]);
                FileInputStream f2 = new FileInputStream(args[1])
        ) {
            int n = f1.available();
            boolean eq = n == f2.available();
            if (eq) {
                for (int i = 0; i < n; i++) {
                    if (f1.read() != f2.read()) {
                        eq = false;
                        break;
                    }
                }
            }
            System.out.println(eq ? "Files match" : "Files don't match");
        } catch (FileNotFoundException e) {
            System.out.println("File don't exist!");
        } catch (IOException e) {
            System.out.println("I/O error!");
        }

    }
}
