package ma.projet.teste;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class Teste {
  public static void main(String[] args) {
        ProduitService produitService = new ProduitService();
        // 1. Créer cinq produits
        produitService.create(new Produit("Produit1", "REF001", new Date(), 90.00, "Produit de test 1"));
        produitService.create(new Produit("Produit2", "REF002", new Date(), 120.00, "Produit de test 2"));
        produitService.create(new Produit("Produit3", "REF003", new Date(), 150.00, "Produit de test 3"));
        produitService.create(new Produit("Produit4", "REF004", new Date(), 50.00, "Produit de test 4"));
        produitService.create(new Produit("Produit5", "REF005", new Date(), 200.00, "Produit de test 5"));
        // 2. Afficher la liste des produits
        System.out.println("Liste des produits :");
        List<Produit> produits = produitService.findAll();
        for (Produit produit : produits) {
            System.out.println(produit);
        }
        // 3. Afficher les informations du produit dont id = 2
        Produit produit2 = produitService.findById(2);
        System.out.println("\nInformations du produit avec id = 2 :");
        if (produit2 != null) {
            System.out.println(produit2);
        } else {
            System.out.println("Produit non trouvé.");
        }
        // 4. Supprimer le produit dont id = 3
        Produit produit3 = produitService.findById(3);
        if (produit3 != null) {
            produitService.delete(produit3);
            System.out.println("\nProduit avec id = 3 supprimé.");
        } else {
            System.out.println("Produit non trouvé pour la suppression.");
        }
        // 5. Modifier les informations du produit dont id = 1
        Produit produit1 = produitService.findById(1);
        if (produit1 != null) {
            produit1.setPrix(95.00); // Modifier le prix
            produitService.update(produit1);
            System.out.println("\nProduit avec id = 1 modifié.");
        } else {
            System.out.println("Produit non trouvé pour la modification.");
        }
        // Afficher la liste mise à jour des produits
        System.out.println("\nListe mise à jour des produits :");
        produits = produitService.findAll();
        for (Produit produit : produits) {
            System.out.println(produit);
        }
        // 6. Afficher la liste des produits dont le prix est supérieur à 100 DH
        System.out.println("\nProduits dont le prix est supérieur à 100 DH :");
        for (Produit produit : produits) {
            if (produit.getPrix() > 100) {
                System.out.println(produit);
            }
        }
        // 7. Afficher la liste des produits commandés entre deux dates lues au clavier
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.print("\nEntrez la date de début (yyyy-MM-dd) : ");
            Date dateDebut = dateFormat.parse(scanner.nextLine());
            System.out.print("Entrez la date de fin (yyyy-MM-dd) : ");
            Date dateFin = dateFormat.parse(scanner.nextLine());

            System.out.println("\nProduits commandés entre " + dateDebut + " et " + dateFin + " :");
            for (Produit produit : produits) {
                if (!produit.getDateAchat().before(dateDebut) && !produit.getDateAchat().after(dateFin)) {
                    System.out.println(produit);
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture des dates : " + e.getMessage());
        }

        scanner.close();
    }
}
   

