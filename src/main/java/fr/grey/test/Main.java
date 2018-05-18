package fr.grey.test;

import fr.grey.dao.BookDAO;
import fr.grey.dao.ClientDAO;


public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Le Myhte de Cthulhu", "H.P. LOVECRAFT");
        BookDAO.createBook(book1);
        Book book2 = new Book("Dagon", "H.P. LOVECRAFT");
        BookDAO.createBook(book2);
        Client client1 = new Client("Schmorgl","Michel", Gender.M);
        ClientDAO.createClient(client1);
        Client client2 = new Client("Zmurg","Paulette", Gender.F);
        ClientDAO.createClient(client2);
        client1.addPurcharsedBook(book1);
        ClientDAO.updateClient(client1);
    }
}
