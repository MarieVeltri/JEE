package be.veltri.servlet;
import java.io.Serializable;

public class Client implements Serializable {
	//Javabean : implémente Serializable car les objets peuvent circuler à travers le réseau, donc l'application doit être
	//capable de les transformer en texte pour les traiter, et de l'autre côté l'API doit pouvoir les remettre en objet.
	private static final long serialVersionUID = 1L; //numéro de série unique
    
    private String username;
    private String email;

    public Client() {} //ctor sans param ==> quand l'API reçoit le client sous forme de texte, elle doit recréer l'objet client
    //donc elle a besoin du ctor vide, puis des setters pour recréer correctement l'objet.

    public Client(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { //ne pas oublier d'ajouter des contrôles dans les setters
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}