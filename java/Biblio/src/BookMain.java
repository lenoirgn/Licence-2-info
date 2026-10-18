public class BookMain{
    public static void main(String[] args) {
        Book b1 = new Book("Le Petit Prince", "Saint-Exupéry",BookCategory.ROMAN);
        Book b2 = b1;
        Book b3 = new Book("Le Petit Prince", "Saint-Exupéry",BookCategory.ROMAN);
        System.out.println(Book.getnombreLivres());

    }
}