package contentsearch;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Handles filtering filenames, with or without wildcard char '*'
 * @author Alex
 */
public class CSFilenameFilter implements FilenameFilter {

    private String filter;
    private String name;

    /**
     * Creates a CSFilenameFilter
     * @param filter File filters to use
     */
    public CSFilenameFilter(String filter) {
        this.filter = filter.toLowerCase().trim();
    }

    @Override
    public boolean accept(File dir, String name) {
        //Quick shortcut for directories and common "all" wildcards
        if (new File(dir, name).isDirectory() || this.filter.equals("*") || this.filter.equals("*.*"))
            return true;

        this.name = name.toLowerCase();
        if (this.filter.contains(",")) { //Multiple filters?
            String[] subFilters = this.filter.split("\\,", -1);
            for (int i=0; i<subFilters.length; i++)
                if (this.shouldAccept(subFilters[i]))
                    return true;
            return false;
        }
        return this.shouldAccept(this.filter);
    }

    private boolean shouldAccept(String filter) {
        if (this.name.equals(filter))
            return true; //No wildcards, skip rest
        boolean wildEnd = filter.endsWith("*"); //fix for terms ending with *

        String[] filSub = filter.split("\\*"); //Split using wildcard
        //Check for explicit start/ends on filter (eg. a.ini instead of *a.ini)
        if (!this.name.startsWith(filSub[0]))
            return false;
        if (!wildEnd && !this.name.endsWith(filSub[filSub.length-1]))
            return false;

        //Start/end checked, so chop them off...
        String nameSub = this.name.substring(filSub[0].length());
        nameSub = nameSub.substring(0, nameSub.length()-filSub[filSub.length-1].length());

        //... and start checking middle wildcards in order of appearance
        int prevIndex = -1;
        int curIndex;
        for (int i=1; i<filSub.length-1 || (wildEnd && i<filSub.length); i++) {
            curIndex = nameSub.indexOf(filSub[i]);
            if (curIndex < prevIndex || !nameSub.contains(filSub[i])) {
                return false; //do not allow wildcards to be found out-of-order
            }
            prevIndex = curIndex;
            nameSub = nameSub.substring(filSub[i].length());
        }
        return true;
    }
}
