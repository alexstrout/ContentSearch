package contentsearch;

import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Walks through a file searching for a desired string of characters
 * Outputs any result to standard output
 * @author Alex
 */
public class ContentSearch {

    private int BUFFER_LENGTH = 256;
    private List searchResults;
    private GUIOut out;

    /**
     * Creates a new ContentSearch
     * @param out GUIOut class to pass output to
     * @param searchResults SearchResults list
     */
    public ContentSearch(GUIOut out, List searchResults) {
        this.searchResults = searchResults;
        this.out = out;
    }

    /**
     * Searches a file for a target
     * @param file File to enumerate
     * @param target String to search for
     * @param mCase Match case for searching
     * @return number of matches found
     */
    public int searchFile(File file, String target, boolean mCase) {
        if (file.length() == 0)
            return 0;
        char[] cBuf = new char[this.BUFFER_LENGTH];
        int line = 1;
        int pos = 1;
        int cFound = 0;
        int numFinds = 0;
        int tLength = target.length();
        try {
            FileReader fin = new FileReader(file);
            while (fin.ready()) {
                int cBufRead = fin.read(cBuf);
                for (int i=0; i<cBufRead; i++) {
                    if (cFound == tLength) {
                        this.searchResults.add(new SearchResult(file, line, pos));
                        pos += cFound;
                        cFound = 0;
                        numFinds++;
                        continue;
                    }
                    char tChar = target.charAt(cFound);
                    if (cBuf[i] == tChar || (!mCase && Character.toLowerCase(cBuf[i]) == tChar)) {
                        cFound++;
                        continue;
                    }
                    if (cBuf[i] == '\n') {
                        cFound = 0;
                        line++;
                        pos = 1;
                        continue;
                    }
                    cFound = 0;
                    pos++;
                }
            }
        }
        catch (java.io.FileNotFoundException ex) {
                    this.out.println(ex + " (" + file + ")");
        }
        catch (java.io.IOException ex) {
                    this.out.println(ex + " (" + file + ")");
        }
        return numFinds;
    }
}
