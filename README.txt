A simple file content searcher. Walks through files in a specified directory, looking for matching strings within the raw data.
Usage: javaw -jar ContentSearch.jar <folder> <-s> <-m> <-o file>

Optional Parameters:
 folder     Search Folder
 -s         Include Subdirectories
 -m         Match Case
 -o file    Output File

src/
    ContentSearch.java    File content searcher
    ContentSearchGUI.java Main program (calls FileIterator)
    CSFilenameFilter.java Filename Filtering
    FileIterator.java     File directory walker (calls filename filtering and content searching)
    GUIOut.java           Pseudo output steam for GUI console / file output