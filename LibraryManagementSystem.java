abstract class LibraryItem {

    protected String title;
    protected int itemId;
    protected boolean isIssued;

    // Constructor
    LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isIssued = false;
    }

    // Abstract method
    abstract int calculateFine(int daysLate);

    // Concrete method
    void displayInfo() {
        System.out.println(
                "Title : " + title +
                " | Item ID : " + itemId +
                " | Issued : " + isIssued
        );
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getItemId() {
        return itemId;
    }

    public boolean getIsIssued() {
        return isIssued;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }
}


// Interface
interface Issuable {

    void issueItem();

    void returnItem();
}


// Book class
class Book extends LibraryItem implements Issuable {

    Book(String title, int itemId) {
        super(title, itemId);
    }

    @Override
    int calculateFine(int daysLate) {
        return daysLate * 5;
    }

    @Override
    public void issueItem() {
        isIssued = true;
        System.out.println(title + " issued.");
    }

    @Override
    public void returnItem() {
        isIssued = false;
        System.out.println(title + " returned.");
    }

    @Override
    public String toString() {
        return "Item : " + title + " (Book)";
    }
}


// Magazine class
class Magazine extends LibraryItem implements Issuable {

    Magazine(String title, int itemId) {
        super(title, itemId);
    }

    @Override
    int calculateFine(int daysLate) {
        return daysLate * 2;
    }

    @Override
    public void issueItem() {
        isIssued = true;
        System.out.println(title + " issued.");
    }

    @Override
    public void returnItem() {
        isIssued = false;
        System.out.println(title + " returned.");
    }

    @Override
    public String toString() {
        return "Item : " + title + " (Magazine)";
    }
}


// Main class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Creating objects
        Book book1 =
                new Book("Java Programming", 101);

        Book book2 =
                new Book("Clean Code", 102);

        Magazine magazine1 =
                new Magazine("National Geographic", 201);

        Magazine magazine2 =
                new Magazine("Time Magazine", 202);


        // Issue items
        book1.issueItem();
        book2.issueItem();
        magazine1.issueItem();
        magazine2.issueItem();


        // Polymorphic array
        LibraryItem[] items = {
                book1,
                magazine1,
                book2,
                magazine2
        };


        // Late days
        int[] lateDays = {
                4, 4, 2, 2
        };


        System.out.println("\nFine Details:");

        // Runtime polymorphism
        for (int i = 0; i < items.length; i++) {

            int fine =
                    items[i].calculateFine(lateDays[i]);

            System.out.println(
                    items[i].toString() +
                    " | Fine for " +
                    lateDays[i] +
                    " days late : Rs." +
                    fine
            );
        }


        // Return items
        book1.returnItem();
        book2.returnItem();
        magazine1.returnItem();
        magazine2.returnItem();


        // Display information
        System.out.println("\nItem Information:");

        for (LibraryItem item : items) {
            item.displayInfo();
        }
    }
}