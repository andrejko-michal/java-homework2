package com.streams;

import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMethod {
    public static void main(String[] args) {

        //task 1
        System.out.println("------Task 1 --------");
        int sum = Stream.iterate(1, A -> A + 1)
                .limit(10000)
                .filter(A -> (A % 3 == 0) && (A % 5 == 0) && (A % 7 != 0))
                .mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        System.out.println("------Task 2 --------");
        Stream.iterate(1, A -> A + 1)
                .filter(A -> (A % 2 == 0) && (A % 8 != 0))
                .limit(100)
                .forEach(A -> System.out.println(A));

        //task 3.1
        System.out.println("------Task 3.1 --------");
        Stream<Book> list = Stream.of(new Book("Basics of Gravity", 58), new Book("Orlovi Rano Lete", 158),
                new Book("Zart", 20), new Book("Love in the time of Cholera", 1000),
                new Book("Love", 101), new Book("Basics of GLove", 98));
        list.filter(b -> b.getPrice() < 100)
                .map(b -> b.getName())
                .sorted()
                .forEach(name -> System.out.println(name));


        //task 3.2
        System.out.println("------Task 3.2 --------");
        Stream<Book> list1 = Stream.of(new Book("Basics of Gravity", 58), new Book("Orlovi Rano Lete", 158),
                new Book("Zart", 20), new Book("Love in the time of Cholera", 1000),
                new Book("Love", 101), new Book("Basics of GLove", 98));
        long count = list1.map(b -> b.getName())
                .filter(n -> n.length() < 5)
                .count();
        System.out.println(count);

        //task 3.3
        System.out.println("------Task 3.3 --------");
        Stream<Book> list2 = Stream.of(new Book("Basics of Gravity", 15), new Book("Orlovi Rano Lete", 13),
                new Book("Zart", 45), new Book("Love in the time of Cholera", 18),
                new Book("Love", 89), new Book("Basics of GLove", 70),
                new Book("Love", 76), new Book("Basics of GLove", 56));
        Double avaragePrice =  list2.map(book -> book.getPrice())
                .collect(Collectors.averagingInt(a -> a));
        System.out.println(avaragePrice);

        //task 3.4
        System.out.println("------Task 3.4 --------");
        Stream<Book> list3 = Stream.of(new Book("Basics of Gravity", 58), new Book("Orlovi Rano Lete", 90),
                new Book("Love", 1010), new Book("Basics of GLove", 98));
        boolean isCheaperThan500 = list3.map(a -> a.getPrice())
                .allMatch(a -> a < 500);
        System.out.println(isCheaperThan500);
    }
}
