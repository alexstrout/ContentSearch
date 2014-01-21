package contentsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * A pseudo output stream for GUI output, also handles output to file
 * @author Alex
 */
public class GUIOut {

    javax.swing.JTextArea out;
    PrintStream outFile;
    boolean file;

    /**
     * Construct a new GUIOut
     * @param out GUI Output Console
     * @param outFile File to output to (or "null" for no file output)
     */
    public GUIOut(javax.swing.JTextArea out, File outFile) {
        this.out = out;
        this.file = false;
        if (outFile != null) {
            try {
                this.outFile = new PrintStream(outFile);
                this.file = true;
            } catch (FileNotFoundException ex) {
                this.out.append(ex + " (" + outFile + ")\n");
                this.file = false;
            }
        }
    }

    /**
     * Print a blank line
     */
    public void println() {
        this.out.append("\n");
        if (this.file)
            this.outFile.println();
    }

    /**
     * Print string input
     * @param in String input
     */
    public void print(String in) {
        this.out.append(in);
        if (this.file)
            this.outFile.print(in);
    }
    /**
     * Print string input with \n
     * @param in String input
     */
    public void println(String in) {
        this.out.append(in + "\n");
        if (this.file)
            this.outFile.println(in);
    }

    /**
     * Print Number input
     * @param in Number input
     */
    public void print(Number in) {
        this.out.append(in.toString());
        if (this.file)
            this.outFile.print(in);
    }
    /**
     * Print Number input with \n
     * @param in Number input
     */
    public void println(Number in) {
        this.out.append(in.toString() + "\n");
        if (this.file)
            this.outFile.println(in);
    }
}
