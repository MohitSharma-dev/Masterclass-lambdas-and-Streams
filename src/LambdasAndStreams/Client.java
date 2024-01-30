package LambdasAndStreams;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
//        MathematicalOperation addition = new Addition();
//        Integer result = addition.operate(3 , 4);
        // this lambda expression suppose to act like your operate method
        MathematicalOperation addition = (x, y) -> { return x + y; };
        int z = addition.operate(3 , 5);
        MathematicalOperation subtraction = (x , y) -> x - y;
        int result = subtraction.operate(4 ,5);

        List<Integer> x = new ArrayList<>();
        x.add(10);
        x.add(4);
        x.add(2);
        x.add(30);
        x.add(6);
        x.add(50);
//        Comparator
        // Comparator and Comparable , Collections
        Collections.sort(x, (a , b) -> {
            if(a > b) return -1;
            else if (a < b) return 1;
            return 0;
        });
//        Comparable
        System.out.println(x);
//          Runnable
        // Runnable , Callable
        Stream<Integer> s = x.stream();
        s = s.limit(4);
        System.out.println(s);
        System.out.println(s.count());

        // you can't do this , stream is closed
        // Open a new stream to work on it again
//        System.out.println(s.limit(2).count());

        // takes first 4 values


        // Limit : Intermediate
        // Terminal : count()

        // even numbers
        List<Integer> s3 = x
                    .stream()
                    .sorted((a , b) -> {
                        if(a > b) return -1;
                        else if(a < b) return 1;
                        else return 0;
                    })
                    .filter((elem) -> { return elem % 2 == 0;})
                    .limit(3)
                    .collect(Collectors.toList());

        List<Integer> x1 = x.stream()
                .sorted()
                .filter((elem) -> {return elem % 5 == 0;})
                .limit(3)
                .collect(Collectors.toList());

        List<Integer> x2 = x.stream()
                .map((elem) -> { return elem * elem;})
                .sorted()
                .filter((elem) -> {
                    System.out.println(elem + " Filtering on first condition");
                    return elem % 2 == 0; }
                )
                .filter((elem) -> {
                    System.out.println(elem + " Filtering on second condition");
                    return elem % 3 == 0;
                })
                .collect(Collectors.toList());

        List<Integer> y = new ArrayList<>();
        for(Integer elem : x){
            if(elem % 2 == 0){
                y.add(elem);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(Integer elem : y){
            if(elem % 3 == 0){
                res.add(elem);
            }
        }
        // [1 , 2 ,3 ,4 ,5 , 6]
        x.stream()
                .filter((elem) -> {
                    System.out.println("Filter filter");
                    return elem % 2 == 0;
                })
                                .findAny();

        //findFirst gives you first element of result
        // sorted : intermediate
        // collect  : terminal
        System.out.println(x1);
        System.out.println(x2);




    }
}

// There is a list of integers
// sorted list
// divisible by 5
// out of the filtered elements , we only want first 3

// every element should be sqaured
// sorted
// filtered by even
