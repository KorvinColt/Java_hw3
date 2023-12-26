import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int publishedYear;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }
}

class Library implements Iterable<Book> {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void sortByTitle() {
        Collections.sort(books);
    }

    public void sortByAuthor() {
        Collections.sort(books, (book1, book2) -> book1.getAuthor().compareTo(book2.getAuthor()));
    }

    public void sortByPublishedYear() {
        Collections.sort(books, (book1, book2) -> Integer.compare(book1.getPublishedYear(), book2.getPublishedYear()));
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}

class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("1984", "George Orwell", 1949);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.sortByTitle();
        System.out.println("Sorted by title:");
        for (Book book : library) {
            System.out.println(book);
        }

        library.sortByAuthor();
        System.out.println("\nSorted by author:");
        for (Book book : library) {
            System.out.println(book);
        }

        library.sortByPublishedYear();
        System.out.println("\nSorted by published year:");
        for (Book book : library) {
            System.out.println(book);
        }
    }
}