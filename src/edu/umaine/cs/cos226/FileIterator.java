package edu.umaine.cs.cos226;

import java.io.File;

/**
 * Walks through a file system and searches its contents
 * @author Alex
 */
public class FileIterator {
    
    private int fileCount;
    private int numFinds;
    private ContentSearch cs;
    private GUIOut out;
    
    /**
     * Creates a new FileIterator
     * @param out GUIOut class to pass output to
     */
    public FileIterator(GUIOut out) {
        this.fileCount = 0;
        this.numFinds = 0;
        this.cs = new ContentSearch(out);
        this.out = out;
    }
    
    /**
     * Iterate a directory based on input
     * @param dir The directory to search in
     * @param incSub Include sub-folders
     * @param filter Filename filters to use, separated by ',' (supports wildcards '*')
     * @param target String to search file contents for
     * @param mCase Match case on contents search
     */
    public void IterateDirectory(String dir, boolean incSub, String filter, String target, boolean mCase) {
        this.IterateDirectory(new File(dir), incSub, filter, target, mCase);
        this.out.println("Enumerated " + this.fileCount + " files.");
        this.out.println("Found " + this.numFinds + " matches.");
        this.out.println("----------------");
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
}