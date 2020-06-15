import java.util.ArrayList;

public class Library {
    public static void main(String... args){
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("James", "The color0"));
        books.add(new Book("J2ames", "rThe color1"));
        books.add(new Book("J3ames", "rThe color2"));
        books.add(new Book("J4ames", "The color3"));
        books.add(new Book("J5ames", "The color4"));
        books.add(new Book("J6ames", "The color5"));
        books.add(new Book("J7ames", "The color6"));
        books.add(new Book("J8ames", "The color7"));
        books.add(new Book("J2ames", "The color8"));

        books.stream().filter(book -> {
           return book.getAuthor().startsWith("J");
        }).filter(book -> {
            return book.getTitle().startsWith("rTh");
        }).forEach(System.out::println);


        books.parallelStream().filter(book -> {
            return book.getAuthor().startsWith("J2");
        }).filter(book -> {
            return book.getTitle().startsWith("Th");
        }).forEach(System.out::println);
    }
}
