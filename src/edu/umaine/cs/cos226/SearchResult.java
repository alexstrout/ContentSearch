/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umaine.cs.cos226;

import java.io.File;

/**
 *
 * @author Alex
 */
class SearchResult {
    public File file;
    public int line,pos;

    public SearchResult(File file, int line, int pos) {
        this.file = file;
        this.line = line;
        this.pos = pos;
    }
    
    @Override
    public String toString() {
        return "\"" + file.getName() + "\" (" + line + ", " + pos + ")\t" + file;
    }
}
