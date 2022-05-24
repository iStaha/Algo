package collections;
import java.util.*;
// Implementing iterable interface

class CodeSpeedy<T> implements Iterable<T> {
 
    private List<T> strList;
 
    public CodeSpeedy(T [] temp) {
 
        strList = Arrays.asList(temp);
        
    }
    
    //Overriding iterator()  
    @Override
    public Iterator<T> iterator() {
 
        return strList.iterator();
    }
}

//e test:   [1, 3, 6, 4, 1, 2]
//OK

//E//xample test:   [1, 2, 3]
//OK

//Example test:   [-1, -3]
public class Main {
 
    public static void main(String [] args) {
 
        String [] str = {"Welcome ", "To ", "CodeSpeedy. "};
        
        // Object Declaration   
        CodeSpeedy<String> obj = new CodeSpeedy<>(str);
 
        //For-each loop
        for (String i : obj) {
 
            System.out.print(i);
        }
    }
}