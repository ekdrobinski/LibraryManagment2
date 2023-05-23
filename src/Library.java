import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public List<Book> findBooksByPublicationYear(int year) {
        Predicate<Book> filterByPublicationYear = book -> book.getPublicationYear() == year;
        return filterBooks(filterByPublicationYear);
    }

    public List<Book> findBooksByAuthor(String author) {
        Predicate<Book> filterByAuthor = book -> book.getAuthor().equalsIgnoreCase(author);
        return filterBooks(filterByAuthor);
    }

    public Book findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null);
    }

    public List<Book> findBooksByPageCount(int pageCount) {
        Predicate<Book> filterByPageCount = book -> book.getPages() > pageCount;
        return filterBooks(filterByPageCount);
    }

    public void printAllBookTitlesSorted() {
        books.stream()
                .map(Book::getTitle)
                .sorted()
                .forEach(System.out::println);
    }

    public List<Book> findBooksByCategory(String category) {
        Predicate<Book> filterByCategory = book -> book.getCategory().equalsIgnoreCase(category);
        return filterBooks(filterByCategory);
    }

    public void loanBook(Book book, User user) {
        if (!book.isOnLoan()) {
            book.setOnLoan(true);
            user.addBook(book);
        }
    }

    public void returnBook(Book book, User user) {
        if (book.isOnLoan() && user.hasBook(book)) {
            book.setOnLoan(false);
            user.removeBook(book);
        }
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    private List<Book> filterBooks(Predicate<Book> predicate) {
        return books.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
