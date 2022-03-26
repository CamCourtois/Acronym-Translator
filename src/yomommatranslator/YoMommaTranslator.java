
package yomommatranslator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * TA: Maggie Stewart
 * @author Cameron Courtois
 * Submission Time: 
 */
public class YoMommaTranslator {

    public static void main(String[] args) throws FileNotFoundException 
    {
        HashMap<String, String> acronymPhrase = new HashMap<>();
        
        File inputFile = new File("acronyms.txt");
        Scanner in = new Scanner(inputFile);
        
        
        //reads imported text file and splits each line in half, moving one
        //half to the Key set and the other half to a value
        while(in.hasNextLine())
        {
            String line = in.nextLine();
            String[] splitted = line.split("\\t");
            
            acronymPhrase.put(splitted[0].toLowerCase(), splitted[1].toLowerCase());
        }
        
        System.out.print("Enter a sentence: ");
        
        Scanner userIn = new Scanner(System.in).useDelimiter("\\n");
        String userInput = userIn.next();
        
        String[] split = userInput.split("\\s+");
        
        String translation = "";
        
        //iterates through the array of splitted user inputs and translates them
        for(int i = 0; i < split.length; i++)
        {
            if(acronymPhrase.containsKey(split[i].toLowerCase()))
                translation += acronymPhrase.get(split[i].toLowerCase())+ " ";
            else
                translation += split[i] + " ";

        }
        
        System.out.println(translation);
        
    }
    
}
