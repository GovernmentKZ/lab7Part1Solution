package lab7Part1Solution;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String surname;
    private String group;
    private ArrayList<Book> borrowedBooks;

    public User(int id, String name, String surname, String group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.borrowedBooks = new ArrayList<Book>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    //this the method which allows to count book quantity and to add books into an arraylist
    public boolean borrowBook(Book b) {
        boolean exist = false;
        for (int i = 0; i < borrowedBooks.size(); i++) {
            if(borrowedBooks.get(i).getTitle().equals(b.getTitle())){
                exist = true;
                break;
            }
        }

        if(exist == false){
            borrowedBooks.add(b);
            System.out.println("Book borrowed successfully.");
        }
        else{
            System.out.println("Sorry, this book has already been borrowed.");
        }
        return exist;
    }
    //this method allows to return CERTAIN book from student to library by removing selected book from arraylist
    public boolean returnBook(Book b) {

        boolean exist = false;
        for (int i = 0; i < borrowedBooks.size(); i++) {
            if(borrowedBooks.get(i).getTitle().equals(b.getTitle())){
                exist = true;
                break;
            }
        }


        if(exist == false){
            System.out.println("You have not borrowed any books.");
        }
        else{
            borrowedBooks.remove(b);
            System.out.println("Book returned successfully." );
        }
        return exist;
    }

    //this method allows to print borrowed books for a certain student
    public void printBooks() {
        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println(borrowedBooks.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        ", group='" + group + '\'' +
                        ", borrowedBooks=" + borrowedBooks.size();
    }
}
