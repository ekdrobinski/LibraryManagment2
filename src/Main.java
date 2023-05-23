import java.util.List;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        User user1 = new User("Name1", 12344);
        User user2 = new User("Name2", 12345);
        User user3 = new User("Name3", 12346);
        Book book1 = new Book("abook1", "author1", 2000, 100, "Early Childhood");
        Book book2 = new Book("book2", "author2", 2007, 400, "Nonfiction");
        Book book3 = new Book("dbook3", "author1", 2009, 700, "Young Adult");
        Book book4 = new Book("cbook4", "author3", 2015, 970, "Fiction");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        System.out.println("name:  " + user1.getName() + ", library card number:  " + user1.getLibraryCardNumber());
        System.out.println("name:  " + user2.getName() + ", library card number:  " + user2.getLibraryCardNumber());
        System.out.println("name:  " + user3.getName() + ", library card number:  " + user3.getLibraryCardNumber());

        System.out.println("books published in 2000:");
        List<Book> booksPublishedIn2000 = library.findBooksByPublicationYear(2000);
        booksPublishedIn2000.forEach(System.out::println);
        System.out.println();

        System.out.println("Books by Author1:");
        List<Book> booksByAuthor1 = library.findBooksByAuthor("author1");
        booksByAuthor1.forEach(System.out::println);
        System.out.println();

        System.out.println("book with the most pages:");
        Book bookWithMostPages = library.findBookWithMostPages();
        System.out.println(bookWithMostPages);
        System.out.println();

        System.out.println("books with more than 250 pages:");
        List<Book> booksWithMoreThan250Pages = library.findBooksByPageCount(250);
        booksWithMoreThan250Pages.forEach(System.out::println);
        System.out.println();

        System.out.println("book titles sorted alphabetically:");
        library.printAllBookTitlesSorted();
        System.out.println();

        System.out.println("Books in the Early Childhood category:");
        List<Book> booksInEarlyChildhoodCategory = library.findBooksByCategory("Early Childhood");
        booksInEarlyChildhoodCategory.forEach(System.out::println);
        System.out.println();

        library.registerUser(user1);
        library.registerUser(user2);

        library.loanBook(book1, user1);
        library.loanBook(book2, user1);
        library.loanBook(book3, user2);

        System.out.println("user1's books on loan:");
        List<Book> user1BooksOnLoan = user1.getBooksOnLoan();
        user1BooksOnLoan.forEach(System.out::println);
        System.out.println();

        System.out.println("user2's books on loan:");
        List<Book> user2BooksOnLoan = user2.getBooksOnLoan();
        user2BooksOnLoan.forEach(System.out::println);
        System.out.println();

        library.returnBook(book1, user1);

        System.out.println("user1's books on loan after returning a book:");
        user1BooksOnLoan = user1.getBooksOnLoan();
        user1BooksOnLoan.forEach(System.out::println);
        System.out.println();

        double lateFee = user1.calculateLateFees();
        if (lateFee > 0) {
            System.out.println("user1 late fees: $" + lateFee);
        } else {
            System.out.println("user1: no late fees");
        }
    }
}