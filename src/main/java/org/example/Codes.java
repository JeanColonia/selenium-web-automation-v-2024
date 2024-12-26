package org.example;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Codes {


    public void prueba(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Jean");
        names.add("Marie");
        names.add("Louis");
        names.add("Josue");

        int count=0;
        for (int i = 0; i < names.size(); i++) {

            if(names.get(i).startsWith("J")){

                count++;
            }
        }

        System.out.println("COUNT "+count);


    }


    @Test
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Jean");
        names.add("Marie");
        names.add("Louis");
        names.add("Josue");

        String startsLetter = "J";

        Long count_ = names.stream().filter(s-> s.startsWith(startsLetter)).count();

        Optional<String> firstResult = names.stream().filter(s->s.startsWith(startsLetter)).limit(1).findFirst();

        String valor = firstResult.orElse("Valor no encontrado....");
        System.out.println(count_);
        System.out.println(valor);
    }
}
