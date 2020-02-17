import java.io.*;
import java.util.*;

public class Main {
    static Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();
    
    public static void readFile() {
         String fileName = "data.txt";
         try {
            Scanner scanner = new Scanner(new File(fileName));
            
            String currWeb = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(": ");
                if(words[0].equals("use_web")) {
                    currWeb = words[1];
                }
                else if(words[0].equals("disallow")) {
                    if(words[1].equals("*")) {
                        addRules(currWeb, "ALL");
                    }
                    else {
                        addRules(currWeb, words[1]);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
    
    public static void addRules(String use_web, String disallow) {
        if(table.containsKey(use_web)) {
            ArrayList<String> currRules = table.get(use_web);
            if(disallow.equals("ALL")) {
                currRules = new ArrayList<>();
                currRules.add("ALL");
                table.put(use_web, currRules);
            }
            else if(!currRules.contains("ALL")) {
                currRules.add(disallow);
            }
        }
        else {
            ArrayList<String> list = new ArrayList<>();
            list.add(disallow);
            table.put(use_web, list);
        }
    }
    
    public static void readRules() {
        StringBuilder currRule = new StringBuilder();
        for(String use_web : table.keySet()) {
            currRule.append(use_web).append(" disallows");
            ArrayList<String> list = table.get(use_web);
            String delim = " ";
            for(String disallow : list) {
                currRule.append(delim).append(disallow);
                delim = ", ";
            }
            currRule.append(".");
            System.out.println(currRule.toString());
            currRule = new StringBuilder();
        }
    }
    
    public static void main(String[] args) {
        readFile();
        readRules();
    }
}