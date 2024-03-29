package notepad;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

// javac Notepad.java && java Notepad.java

public class Notepad extends JPanel implements ActionListener {
    final JFrame f, frameSearch;
    final JTextArea ta;
    final JPanel p1, p2;
    final JButton load, save, clear, close, sort, search, replace, countWord, countSent, frequency;
    final String path = "noname.txt"; // "src/notepad/noname.txt";

    public Notepad() {
        f = new JFrame("A Notepad");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSearch = new JFrame();
        Path file = Paths.get(path);

        p1 = new JPanel();
        p2 = new JPanel();

        ta = new JTextArea(50, 50);

        load = new JButton("Load " + file.getFileName());
        save = new JButton("Save " + file.getFileName());
        clear = new JButton("Clear");
        close = new JButton("Close");
        sort = new JButton("Sort");
        search = new JButton("Search");
        replace = new JButton("Search and Replace");
        countWord = new JButton("Count# of Words");
        countSent = new JButton("Count# of Sentences");
        frequency = new JButton("Frequency# of Words");

        p1.setLayout(new GridLayout(2,5));
        p1.add(load);
        p1.add(save);
        p1.add(clear);
        p1.add(close);
        p1.add(sort);
        p1.add(search);
        p1.add(replace);
        p1.add(countWord);
        p1.add(countSent);
        p1.add(frequency);
    }
    public void launchFrame() {
        f.add(ta, BorderLayout.CENTER);
        f.add(p1, BorderLayout.SOUTH);

        f.setSize(800, 400);
        f.setLocation(400, 200);
        f.setVisible(true);

        load.addActionListener(this);
        save.addActionListener(this);
        clear.addActionListener(this);
        close.addActionListener(this);
        sort.addActionListener(this);
        search.addActionListener(this);
        replace.addActionListener(this);
        countWord.addActionListener(this);
        countSent.addActionListener(this);
        frequency.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == load) {
            try {
                FileInputStream input = new FileInputStream(path);
                StringBuilder sb = new StringBuilder();
                int i;
                while ((i = input.read()) != -1) {
                    sb.append((char) i);
                }
                ta.setText(sb.toString());
                input.close();
            } catch (FileNotFoundException fe) {
                // System.out.println(System.getProperty("user.dir"));
                System.out.println("File Not Found " + fe);
            } catch (IOException ioe) {
                System.out.println("IOException");
            } finally {
                    System.out.println("Loaded File");
            }
        }

        if (source == save) {
            if ((ta.getText() != null) && (ta.getText().length() > 0)) {
                try {
                    FileWriter fw = new FileWriter(path);
                    fw.write(ta.getText());
                    fw.close();
                } catch (FileNotFoundException fnfe) {
                    System.out.println("File Not Found");
                } catch (IOException ioe) {
                    System.out.println("IOException");
                } finally {
                    System.out.println("Saved File");
                }
            }
        }

        if (source == clear && ta.getText() != null) {
            ta.setText("");
        }

        if (source == close) {
            System.exit(0);
        }

        if (source == sort) {
            String line5 = ta.getText();

            if ((line5 != null) && (line5.length() > 0)) {
                String[] arr = line5.split("\n");
                Arrays.sort(arr);
                StringBuilder sb2 = new StringBuilder();

                for (String s : arr) {
                    sb2.append(s).append("\n");
                }
                ta.setText(sb2.toString());
            }
        }

        if (source == search) {
            String pattern = JOptionPane.showInputDialog(frameSearch, "Enter the word: ");

            if ((pattern != null) && (pattern.length() > 0)) {
                try {
                    Document doc = ta.getDocument();
                    Highlighter high = ta.getHighlighter();
                    String text = doc.getText(0, doc.getLength());
                    int pos = 0;

                    while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0) {
                        high.addHighlight(pos, pos + pattern.length(), DefaultHighlighter.DefaultPainter);
                        pos += pattern.length();
                    }
                } catch (NullPointerException | BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        if (source == replace) {
            String input2 = JOptionPane.showInputDialog(frameSearch, "Enter the word: ");

            if ((input2 != null) && (input2.length() > 0)) {
                String input3 = JOptionPane.showInputDialog(frameSearch, "Replace the word into: ");

                if ((input3 != null) && (input3.length() > 0)) {
                    String line5 = ta.getText();
                    String[] arr3 = line5.split("\\W+");
                    // System.out.println(Arrays.toString(arr3));

                    for (String s : arr3) {
                        if (input2.equalsIgnoreCase(s)) {
                            ta.setText(line5.replace(input2, input3));
                        }
                    }
                }
            }
        }

        if (source == countWord) {
            String line6 = ta.getText();
            if ((line6 != null) && (line6.length() > 0)) {
                line6 = line6.replaceAll("[\n\t]", "");
                String[] arr4 = line6.split("\\W+");
                JOptionPane.showMessageDialog(null, "The number of words is " + arr4.length + ".");
            }
        }

        if (source == countSent) {
            String line6 = ta.getText();
            if ((line6 != null) && (line6.length() > 0)) {
                line6 = line6.replaceAll("[\n\t]", "");
                String[] arr5 = line6.split("[!?.]+");
                JOptionPane.showMessageDialog(null, "The number of sentences is " + arr5.length + ".");
            }
        }

        if (source == frequency) {
            String pattern = JOptionPane.showInputDialog(frameSearch, "Enter the word: ");

            if ((pattern != null) && (pattern.length() > 0)) {
                String line6 = ta.getText();
                String[] arr4 = line6.split("\\W+");
                // System.out.println(Arrays.toString(arr4));
                int counter = 0;

                for (String s: arr4) {
                    if (pattern.equalsIgnoreCase(s)) {
                        counter++;
                    }
                }
                JOptionPane.showMessageDialog(null, "The frequency of the word is " + counter + ".");
            }
        }
    }

    public static void main(String[] args) {
        Notepad m = new Notepad();
        m.launchFrame();
    }
}