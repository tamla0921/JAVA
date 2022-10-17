package edu.java.contact.ver02;

//import edu.java.contact.ver02.Contact;

public interface ContactDao {
	Contact[] read();
	
	Contact read(int index) ;
	
	int create(Contact c) ;
	
	int update(int index, String Name, String Phone, String Email) ;

}
