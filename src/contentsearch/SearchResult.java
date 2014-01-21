package contentsearch;

import java.io.File;

/**
 * A simple search result with public values file, line, position
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
