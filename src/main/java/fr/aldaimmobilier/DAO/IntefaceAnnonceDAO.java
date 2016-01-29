package fr.aldaimmobilier.DAO;

import java.util.List;

import fr.aldaimmobilier.EntityTable.Annonce;
import fr.aldaimmobilier.EntityTable.User;

public interface IntefaceAnnonceDAO {
    public Annonce insertAnnonce(Annonce annonce);
    public List<Annonce> getAnnonces();    
    public void updateAnnonces();


}
