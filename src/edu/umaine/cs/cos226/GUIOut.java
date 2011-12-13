package edu.umaine.cs.cos226;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class GUIOut {
    
    javax.swing.JTextArea out;
    PrintStream outFile;
    boolean file;
    
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
    
    public void println() {
        this.out.append("\n");
        if (this.file)
            this.outFile.println();
    }

    public void print(String in) {
        this.out.append(in);
        if (this.file)
            this.outFile.print(in);
    }
    public void println(String in) {
        this.out.append(in + "\n");
        if (this.file)
            this.outFile.println(in);
    }

    public void print(Number in) {
        this.out.append(in.toString());
        if (this.file)
            this.outFile.print(in);
    }
    public void println(Number in) {
        this.out.append(in.toString() + "\n");
        if (this.file)
            this.outFile.println(in);
    }
}
