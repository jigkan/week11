package testpractice;

import java.util.ArrayList;
import java.util.List;

public class Parentclass {

    public static void main(String[] args) {
        List<String> name= new ArrayList<>();
            name.add("jignesh");
            name.add("bhavesh");
            name.add("Gaurang");

            for(String a:name){
                if (a.equalsIgnoreCase("Jignesh"))
                    System.out.println("jignesh patel");
            }



            }



    }

