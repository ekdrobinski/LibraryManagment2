import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

class User {
    private String name;
    private int libraryCardNumber;
    private List<Book> booksOnLoan;
    private LocalDate returnDate;

    public User(String name, int libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.booksOnLoan = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getBooksOnLoan() {
        return booksOnLoan;
    }

    public void addBook(Book book) {
        booksOnLoan.add(book);
        returnDate = LocalDate.now().plusWeeks(2);
    }

    public void removeBook(Book book) {
        booksOnLoan.remove(book);
    }

    public boolean hasBook(Book book) {
        return booksOnLoan.contains(book);
    }

    public boolean hasLateFee() {
        return LocalDate.now().isAfter(returnDate);
    }

    public double calculateLateFees() {
        if (hasLateFee()) {
            long weeksOverdue = LocalDate.now().until(returnDate).getDays() / 7;
            return weeksOverdue * 2.0;
        }
        return 0.0;
    }
}