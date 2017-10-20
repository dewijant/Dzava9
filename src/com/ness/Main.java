package com.ness;


import java.awt.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;


public class Main {

    public static void main(String[] args) {


        Logger logger = Logger.getLogger("MY LOGGER");
        logger.info("message");

        Locale locale = new Locale("fr", "FR");
        Locale localeDefault = Locale.getDefault();

        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);

        logger.info(messages.getString("pozdrav"));

        logger.setResourceBundle(messages);
        logger.warning("pozdrav");
        logger.warning("pozdrav z fronty");


        Point pointZero = new Point();
        pointZero.setLocation(0,0);
        //pointZero = null;
        Optional<Point> point = Optional.ofNullable(pointZero);


        point.ifPresent(new Consumer<Point>() {
            Logger logger = Logger.getLogger("MY LOGGER");
            @Override
            public void accept(Point o) {
                o.setLocation(55,66);
            }
        });

        //point.ifPresent(System.out::println);
        Optional<Point> filteredPoint = point.filter(coordX -> 55 == coordX.getX());//.ifPresent(() -> System.out.println("D"));
        point.filter(coordX -> 55 == coordX.getX());//.ifPresent(() -> System.out.println("S"));


        Point point1 = point.orElse(new Point());

        logger.info("point1 : "+point1.toString());


        Stream<Integer> stream = Stream.iterate(0, i -> i < 10, i -> i + 1);
        point.ifPresent(System.out::println);

        stream.filter((prvek)-> prvek > 5 && prvek < 8).forEach(System.out::print);

        Runnable r2 = () -> {System.out.println("\r\nRADEK: "); System.out.println("Howdy, world!"); return;};
        r2.run();

        Comparator<String> c =
                (lhs, rhs) -> lhs.compareTo(rhs);
        int result = c.compare("ZHello", "World");


        Comparator<String> c2 =
                (String lhs, String rhs) ->  // neni treba uvadet typ
                {
                    System.out.println("I am comparing " + lhs + " to " + rhs);
                    return lhs.compareTo(rhs);
                };
        result = c2.compare("Hello", "World");

        System.out.println(result);


        Object o = (Runnable) () -> System.out.println("EXPLICIT CASTING");
        ((Runnable)o).run();
        // now we're all good

        // Vlakno ma pristup k promenne mimo jeho tridu
        StringBuilder message = new StringBuilder();
        Runnable r = () -> System.out.println(message);
        message.append("Kecy, ");
        r.run();
        message.append("Prdy!");
        r.run();


        /*if(optional.isPresent()) {
            logger.info(point.toString());
        }*/
        Person[] people = new Person[] {
                new Person("Ted", "Neward", 41),
                new Person("Charlotte", "Neward", 41),
                new Person("Michael", "Neward", 19),
                new Person("Matthew", "Neward", 13)
        };

        Arrays.sort(people, Person.compareFirstName);

        for (Person p : people)
            System.out.println(p.getFirstName());

        Arrays.sort(people, Person::compareFirstNames);

        logger.info(" -- GIT WORK BRANCH -- ");

        Arrays.sort(people, comparing(Person::getAge));

        for (Person p : people)
            System.out.println(p.getFirstName());



    }


}
