package org.example;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for output founded files.
 */
public class FileReturn {
    private String fileName;
    private String directory;
    private HashMap<Integer,String> foundedStrings;

    /**
     * Constructor for FileReturn
     * @param fileName name output file
     * @param directory of file where does it locate
     */
    FileReturn(String fileName,String directory){
        this.directory = directory;
        this.fileName = fileName;
        this.foundedStrings = new HashMap<>();
    }
    FileReturn(File file){
        this.directory = file.getAbsolutePath();
        this.fileName = file.getName();
        this.foundedStrings = new HashMap<>();
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public void setDirectory(String directory){
        this.directory = directory;
    }
    public void setFoundedStrings(HashMap<Integer,String> foundedStrings){
        this.foundedStrings = foundedStrings;
    }

    /**
     * Add string for finded
     * @param i
     * @param s
     */
    public void addFoundedString(Integer i,String s){
        foundedStrings.put(i,s);
    }
    public String getFileName(){return fileName;}
    public String getDirectory(){return directory;}
    public HashMap<Integer,String> getFoundedStrings(){return foundedStrings;}
    public void print(){
        System.out.printf("File Name: %s \n",fileName);
        System.out.printf("Directory: %s \n",directory);
        System.out.println("Numbers of string {");
        for(Map.Entry<Integer,String> obj : foundedStrings.entrySet()){{
            System.out.println(obj.getKey() + " : " + obj.getValue());
            }
        }
        System.out.println("}");
    }
}
