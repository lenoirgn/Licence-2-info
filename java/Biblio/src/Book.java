public class Book{
    public Book(String name,String auteur, BookCategory cat){
        this.name=name;
        this.auteur=auteur;
        this.avaible=true;
        this.cat=cat;
        nombreLivres++;
    }
    private String name;
    private String auteur;
    private boolean  avaible;
    private BookCategory cat;
    private static int nombreLivres = 0;

    public static int  getnombreLivres(){
        return nombreLivres;
    }
    public boolean equals(Object o){
        if (!(o instanceof Book)){
            return false;
        }
        Book other=(Book) o;
        return this.name.equals(other.name) && this.auteur.equals(other.auteur);
    }
    public String getname(){
        return this.name;
    }
    public String getauteur(){
        return this.auteur;
    }

    public boolean isBorrowed(){
        return this.avaible;
    }

    public void  borrow()throws BookUnavailableException{
        if (this.isBorrowed()){
            this.avaible=false;

        }else{
          throw new BookUnavailableException("Livre deja emprunter");  
        }

    }
    public void returnBook() throws BookNotBorrowedException{
        if (!this.isBorrowed()){
            this.avaible=true;

        }else{
          throw new BookNotBorrowedException("Livre non emprunter");  
        }
    }



}