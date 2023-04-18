package lab7Part1Solution;

import java.util.ArrayList;

public class Library {

	public ArrayList<Book> bookList;
	public ArrayList<User> userList;

	public Library() {
		bookList = new ArrayList<Book>();
		userList = new ArrayList<User>();
	}
	//fill this class with all necessary fields
	//as well as do not forget to add constructor, which will allow to create an instance of that class later on
	//note: create an arraylist of books and students within the constructor (why?). 

	//this method allows to add book to library
	public void addBook(Book b) {
		if (bookList.contains(b)) {
			System.out.println("The book already exists. Please add a new book");
			return;
		}

		bookList.add(b);
		System.out.println(b.getTitle() + " was added!");
	}

	//this method allows to add students to library
	public void addUser(User u) {
		if (userList.contains(u)) {
			System.out.println("The student already exists");
			return;
		}
		userList.add(u);
		System.out.println("student with id " + u.getId() + " was added!");
	}

	//this method allows to increase amount of a certain book in a library after its return from a student
	public void increaseBookQuantity(Book b) {
		b.setQuantity(b.getQuantity() + 1);
	}

	//this method allows to decrease amount of a certain book in a library after its borrowing by a student
	public void decreaseBookQuantity(Book b) {
		b.setQuantity(b.getQuantity() - 1);
	}

	//this method allows to borrow a certain book by a certain student; as well as here we have to decrease amount of taken book
	public void addBookToUser(int id, String title) {
		Book b = null;
		User u = null;

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equals(title)) {
				b = bookList.get(i);
				break;
			}
		}
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId() == id) {
				u = userList.get(i);
				break;
			}
		}

		if (b == null) {
			System.out.println("There is no such book");
			return;
		}

		if (u == null) {
			System.out.println("There is no such student");
			return;
		}

		Book book2 = new Book(b.getTitle(), b.getAuthor(), b.getIsbn(), b.getYear(), 1);

		if(u.borrowBook(book2) == false){
			decreaseBookQuantity(b);
		}
	}

	//this method allows to return a certain book by a certain student; as well as here we have to increase amount of returned book
	public void returnBookFromStudent(int id, String title) {
		Book b = null;
		User u = null;

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equals(title)) {
				b = bookList.get(i);
				break;
			}
		}
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId() == id) {
				u = userList.get(i);
				break;
			}
		}

		if (b == null) {
			System.out.println("There is no such book");
			return;
		}

		if (u == null) {
			System.out.println("There is no such student");
			return;
		}

		if(u.returnBook(b)){
			increaseBookQuantity(b);
		}

	}

	//this method allows to print info about all books in library, including overall their amount and so on
	public void printBooksInformation() {

		for (Book book : this.bookList) {
			System.out.println(book);
		}
	}

	//this method allows to print info about all registered students in library, including overall their amount and so on
	public void printStudentsInformation() {
		for (User use : this.userList) {
			System.out.println(use);
		}
	}
	public void check(int id) {
		if (id == 2)
		{
			System.out.println("This student");
		}
		else if(id > 0 && id < 2)
		{
			System.out.println("This pupil");
		}
		else {
			System.out.println("It's no one!");
		}
		}

			//this method allows to show info about borrowed books for a certain student
	public void printUsersBooks(int id) {

		User u = null;

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId() == id) {
				u = userList.get(i);
				break;
			}
		}

		if (u == null) {
			System.out.println("There is no such student");
		}
		else{
			ArrayList<Book> borrowedBooks = u.getBorrowedBooks();
			if (borrowedBooks.size() > 0) {
				for (Book borrowedBook : borrowedBooks) {
					System.out.println(borrowedBook);
				}
			}
			else{
				System.out.println("No books were borrowed.");
			}

		}

	}
}
