
import scala.io.StdIn.readLine
import scala.collection.mutable

object library{

	case class Book(title: String, author: String, isbn: String)
	
	val books: mutable.Set[Book] = mutable.Set(
		Book("Harry Potter", "J.K.R", "10234"),
		Book("Lord of the Rings", "J.K.T", "10352")
		);

	def displayBooks() = {
	
		var i = 0;
	
		for(b <- books){
			
			println(s"\n${i+1}.Title:${b.title}  Author:${b.author}  ISBN:${b.isbn}");
			i = i + 1;
		}
		println("\n");
	}
	
	def addBook(): Unit = {
		
		var name = readLine("Enter the name of book : ");
		var author = readLine("Enter the author of book : ");
		var isbn = readLine("Enter the ISBN of book : ");
		
		var newBook = Book(name,author,isbn);
		
		if(books.filter(_.isbn == newBook.isbn).isEmpty) {
			
			books += newBook;
			println("\nBook added");
		}else{
			println("\nBook is exist");
		}
	}
	
	def removeBook(): Unit = {
		
		var isbn = readLine("Enter ISBN to remove : ");
		
		books.find(_.isbn == isbn) match {
			case Some(book) => books -=book
			case None => println(s"No book found with ISBN ${isbn}\n");
				}
	}
	
	def checkBook(): Unit = {
		
		var isbn = readLine("\nEnter ISBN to check : ");
		
		if(books.exists(_.isbn == isbn)){
			println(s"\nThe book with ISBN ${isbn} is in the library");
		}
		else{
			println(s"\nThe book eith ISBN ${isbn} is not in the library");
		}
	}
	
	def searchBook(): Unit = {
	
		var title = readLine("\nEnter Title to Search : ");
		
		books.find(_.title.equalsIgnoreCase(title)) match {
			
			case Some(book) =>
				println(s"Book found: ${book.title} by ${book.author}, ISBN: ${book.isbn}");
				
			case None => println(s"No book found with title ${title}");
		}
		
	};
	
	def displayBooksByAuthor():Unit = {
		
		var author = readLine("\nEnter Title author : ");
		
		var booksByAuthor = books.filter(_.author.equalsIgnoreCase(author))
		if(booksByAuthor.nonEmpty){
			println(s"Books by ${author}:");
			booksByAuthor.foreach(book => println(s"${book.title}, ISBN: ${book.isbn}"));
		}else{
		println(s"No books found by author ${author}");
		}
	}
	
	def main(args: Array[String]): Unit = {
	
		var choice = "1";
		
		while(choice != "0")
		{
		
		choice = readLine("\n 1 for display,  \n2 for add book, \n3 for remove	book, \n4 for check a book is exist, \n5 for search book, \n6 for display book by author, \nEnter your choice :");
		
		  choice match {	
		   
		   case "1" => displayBooks();
			
		   case "2" => {
		   	      addBook();
			      displayBooks();
			      }
			
		  case "3" =>{
		  	     removeBook();
			     displayBooks();
			    }
			
		  case "4" => checkBook();
			
		  case "5" => searchBook();
			
		  case "6" => displayBooksByAuthor();

		}
	      }
	}
}
