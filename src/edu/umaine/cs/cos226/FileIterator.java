package edu.umaine.cs.cos226;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Walks through a file system and searches its contents
 * @author Alex
 */
public class FileIterator {

    private int fileCount;
    private int numFinds;
    private List<SearchResult> searchResults;
    private ContentSearch cs;
    private GUIOut out;

    /**
     * Creates a new FileIterator
     * @param out GUIOut class to pass output to
     */
    public FileIterator(GUIOut out) {
        this.fileCount = 0;
        this.numFinds = 0;
        this.searchResults = new LinkedList<SearchResult>();
        this.cs = new ContentSearch(out,this.searchResults);
        this.out = out;
    }

    /**
     * Iterate a directory based on input
     * @param dir The directory to search in
     * @param incSub Include sub-folders
     * @param filter Filename filters to use, separated by ',' (supports wildcards '*')
     * @param target String to search file contents for
     * @param mCase Match case on contents search
     * @return List of SearchResults
     */
    public List IterateDirectory(String dir, boolean incSub, String filter, String target, boolean mCase) {
        this.IterateDirectory(new File(dir), incSub, filter, target, mCase);
        return this.searchResults;
    }
    private void IterateDirectory(File dir, boolean incSub, String filter, String target, boolean mCase) {
        CSFilenameFilter fileFilter = new CSFilenameFilter(filter);
        File[] children = dir.listFiles(fileFilter);
        if (children == null)
            return; //must not've been a folder
        for (int i=0; i<children.length; i++) {
            File file = children[i];
            if (file.isDirectory() && incSub) {
                try {
                    if (file.getAbsolutePath().equals(file.getCanonicalPath())) {
                        IterateDirectory(file, true, filter, target, mCase);
                    }
                }
                catch (java.io.IOException ex) {
                    this.out.println(ex + " (" + file + ")");
                }
            }
            else if (file.isFile()) {
                this.fileCount++;
                numFinds += cs.searchFile(file, target, mCase);
            }
        }
    }
    
    /**
     * Return number of files enumerated
     * @return Number of files enumerated
     */
    public int getFileCount() {
        return this.fileCount;
    }
    /**
     * Return number of finds
     * @return Number of finds
     */
    public int getNumFinds() {
        return this.numFinds;
    }
}