package org.example;
import org.example.FileReturn;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Class for searching text in files
 */
public class Search<E> {
    private String searchString;
    private String sourceDirectory = "C:\\";
    private boolean subDirecotry = true;
    private List<String> flag = Arrays.asList("TXT","HTML","XML");

    /**
     * Constructor for searching
     * @param searchString the string to be found
     * @param sourceDirectory Start directory
     * @param subDirecotry Boolean option to search in subDirectories
     * @param flag types of file with whom function will open
     */
    Search(String searchString, String sourceDirectory,boolean subDirecotry, List<String> flag){
        this.searchString = searchString;
        this.sourceDirectory = sourceDirectory;
        this.subDirecotry = subDirecotry;
        this.flag = flag;
    }
    /**
     * Constructor for searching
     * @param searchString the string to be found
     * @param sourceDirectory Start directory
     */
    Search(String searchString,String sourceDirectory){
        this.searchString = searchString;
        this.sourceDirectory = sourceDirectory;
    }
    /**
     * Constructor for searching
     * @param searchString the string to be found
     */
    Search(String searchString){
        this.searchString = searchString;
    }


    public void setFlag(List<String> flag){
        this.flag = flag;
    }
    public void setSearchString(String searchString){this.searchString = searchString;}
    public void setSourceDirectory(String sourceDirectory){this.sourceDirectory = sourceDirectory;}
    public void setSubDirecotry (boolean subDirecotry){this.subDirecotry = subDirecotry;}

    /**
     * Stare searching in files
     * @return list of @FileReturns, where @searchString was found
     */
    public List<FileReturn> search(){
        List<FileReturn> foundedFiles = new ArrayList<>();
        ArrayList<File> files = new ArrayList<>();
        files.add(new File(sourceDirectory));
        while(files.size() > 0) {
            File[] file = files.get(0).listFiles();
            files.remove(0);
            for (File f: file) {
                if (f.isDirectory()){
                    files.add(f);
                } else{
                    if (f.canRead() && flag.contains(getExtension(f).toUpperCase())) {
                        FileReturn tempFile = scaner(f);
                        if (!tempFile.getFoundedStrings().isEmpty()) {
                            foundedFiles.add(tempFile);
                        }
                    }
                }
            }
        }
        return foundedFiles;
    }
    private String getExtension(File file){
        String extension = "";
        String fileName = file.getName();
        int i = fileName.lastIndexOf('.');
        int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

        if (i > p) {
            extension = fileName.substring(i+1);
        }
        return extension;

    }
    private FileReturn scaner(File fileDirectory){
        try {
            FileReturn file = new FileReturn(fileDirectory.getName(),fileDirectory.getAbsolutePath());
            Scanner scanner = new Scanner(fileDirectory);
            Integer counter = 0;
            while(scanner.hasNextLine()){
                counter++;
                String temp = scanner.nextLine();
                if(temp.contains(searchString)){
                    file.addFoundedString(counter,temp);
                }
            }
            scanner.close();
            return file;
        } catch (FileNotFoundException e){
            return new FileReturn(fileDirectory);
            /*
            Как ты вообще сюда забрался?
             */
        }

    }

}
