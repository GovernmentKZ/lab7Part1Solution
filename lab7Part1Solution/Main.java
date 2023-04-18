package lab7Part1Solution;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Library library = new Library();
		//create an instance of library class
		
		int choice = -1;
		System.out.println("Welcome to the IITU Library");
		while (choice != 0) {
			System.out.println("1. Add book");
			System.out.println("2. Add user");
			System.out.println("3. Give book to student");
			System.out.println("4. Return book from student");
			System.out.println("5. Print books information");
			System.out.println("6. Print students information");
			System.out.println("7. Print student's books");
			System.out.println("8. Check user");
			System.out.println("0. Exit");
			
			choice = sc.nextInt();

			switch (choice) {
				case 1:
				//here you have to add an opportunity to create an instance of a book class
				//and then you have to call corresponding method from library class in order to add created book
					System.out.print("Enter a book's title: ");
					sc.nextLine();
					String title = sc.nextLine();

					System.out.print("Enter a book's author: ");
					String author = sc.nextLine();

					System.out.print("Enter a book's isbn: ");
					String isbn = sc.nextLine();

					System.out.print("Enter a book's year: ");
					int year = sc.nextInt();

					System.out.print("Enter a book's quantity: ");
					int quantity = sc.nextInt();

					if(quantity <= 0){
						System.out.println("Give for the quantity more than 0. Enter the new quantity:");
						quantity = sc.nextInt();
					}
					Book book = new Book(title, author, isbn, year, quantity);
					library.addBook(book);
					break;
				case 2:
				// same as for case 1, but for "student" object
					System.out.print("Enter student's id: ");
					int id = sc.nextInt();
					int x = id;
					int test = x / 10000;
					if (test == 2)
					{
						System.out.print("Enter student's name: ");
						sc.nextLine();
						String name = sc.nextLine();

						System.out.print("Enter student's surname: ");
						String surname = sc.nextLine();

						System.out.print("Enter student's group: ");
						String group = sc.nextLine();

						User user = new Student(id, name, surname, group);
						library.addUser(user);
						break;
					}
					else if (test > 0 && test < 2) {

						System.out.print("Enter user's name: ");
						sc.nextLine();
						String name = sc.nextLine();

						System.out.print("Enter user's surname: ");
						String surname = sc.nextLine();

						System.out.print("Enter user's group: ");
						String group = sc.nextLine();

						User user = new Pupil(id, name, surname, group);
						library.addUser(user);
						break;
					}
					else {
						System.out.println("You Put Wrong ID. Id Student start with 2. Id Pupil start with 1.");
						break;
					}
				case 3:
				//here you have to call corresponding method for adding a certain book for a certain student
					System.out.print("This book for children?(y/n): ");
					sc.nextLine();
					String answer = sc.nextLine();

					System.out.print("Enter student's id: ");
					int studentId = sc.nextInt();
					int t = studentId / 10000;
					System.out.print("Enter book's title: ");
					sc.nextLine();
					String bookTitle = sc.nextLine();
					if(answer.equals("n") && t == 1) {
						System.out.println("pupil cant take this book");
						break;
					}
					else {
						library.addBookToUser(studentId, bookTitle);
						System.out.println("You take book");
						break;
					}
				case 4:
				//here you have to call corresponding method for returning a certain book from a certain student
					System.out.print("Enter student id: ");
					int studentId2 = sc.nextInt();

					System.out.print("Enter book title: ");
					sc.nextLine();
					String bookTitles = sc.nextLine();

					library.returnBookFromStudent(studentId2, bookTitles);
					break;
				case 5:
				//here you have to call method in order to print info about all books in library
					library.printBooksInformation();
					break;
				case 6:
				//here you have to call method in order to print info about all students registered in library
					library.printStudentsInformation();
					break;
				case 7:
				//here you have to call method in order to print info about books holded by a certain student
					System.out.print("Enter student id: ");
					int studentId3 = sc.nextInt();

					library.printUsersBooks(studentId3);
					break;
				case 8:
					System.out.print("Enter user's id: ");
					int Id = sc.nextInt();
					int y = Id;
					int testid = y / 10000;
						library.check(testid);
					break;
				case 0:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}
}
