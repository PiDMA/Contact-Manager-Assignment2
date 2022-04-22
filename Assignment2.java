/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author josia
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String myStr1 = "abc";
//        String myStr2 = "abc";
//        System.out.println(myStr1.compareToIgnoreCase(myStr2));
        // TODO code application logic here
        Dictionary d = new Dictionary();
        Path filePath = Paths.get("wordlist.txt");
        Charset charset = StandardCharsets.UTF_8;
        try {
            List<String> lines = Files.readAllLines(filePath, charset);
            for (String line : lines) {
                d.add(line, "Undefined Definition");
            }
        } catch (IOException ex) {
            System.out.format("I/O error: %s%n", ex);
        }
         System.out.println(d.balanceHeight(d.root));

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Command Options: ");
            System.out.println("1: Add New Word");
            System.out.println("2: Delete Word");
            System.out.println("3: Get Meaning");
            System.out.println("4: Dictionary List");
            System.out.println("5: Spell check a text file");
            System.out.println("6: EXIT");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the word you wish to add :");
                    String word = scan.next();
                    System.out.println("Enter the meaning of " + word + " :");
                    String meaning = scan.next();
                    d.add(word, meaning);
                    break;

                case 2:
                    System.out.println("Enter the word you wish to delete :");
                    String wordD = scan.next();
                    d.delete(wordD);
                    break;
                case 3:
                    break;
                case 4:
                    d.inOrderTraversal();
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Exiting.....");
                    System.exit(0);
            }

        }

    }

}
