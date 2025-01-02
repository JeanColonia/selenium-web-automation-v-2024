package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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


    @Test
    public void streamMap(){

        List<String> names = new ArrayList<>();
        names.add("Jose");
        names.add("Adam");
        names.add("Margareth");
        names.add("Louis");
        names.add("Andrade");

       Stream<String> names1 =  names.stream().filter(s-> s.startsWith("A")).map(s->s.toUpperCase());

       Stream<String> newStream = Stream.concat(names.stream(), names1);

       boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("adam"));

        Assert.assertTrue(flag);


        List<Integer> numbers = Arrays.asList(16,4,2,1,6,7,9,4,2,1);

        List<Integer> results = numbers.stream().sorted().distinct().collect(Collectors.toList());

        System.out.println(results.get(2));
    }
}
