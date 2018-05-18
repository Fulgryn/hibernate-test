package fr.grey.test;

import fr.grey.dao.BookDAO;
import fr.grey.dao.ClientDAO;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;


public class Main {
    static Logger log = (Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    public static void main(String[] args) {
        log.setLevel(Level.WARN);
        Book book1 = new Book("Le Mythe de Cthulhu", "H.P. LOVECRAFT");
        BookDAO.createBook(book1);
        Book book2 = new Book("Dagon", "H.P. LOVECRAFT");
        BookDAO.createBook(book2);
        Client client1 = new Client("Schmorgl","Michel", Gender.M);
        ClientDAO.createClient(client1);
        Client client2 = new Client("Zmurg","Paulette", Gender.F);
        ClientDAO.createClient(client2);
        client1.addPurcharsedBook(book1);
        client1.addPurcharsedBook(book2);
        ClientDAO.updateClient(client1);
        client2.addPurcharsedBook(book2);
        ClientDAO.updateClient(client2);

        System.out.println(BookDAO.getPurchasedBy(book2).toString());

        client1.displayPurchasedBooks();

    }
}
