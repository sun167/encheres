package fr.eni.ecole.bll;


import java.util.List;

import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Enchere;
import fr.eni.ecole.bo.Utilisateur;
import fr.eni.ecole.dal.DAOFactory;
import fr.eni.ecole.dal.EnchereDAO;
import fr.eni.ecole.exception.BusinessException;
/**
 * Cette classe contient la logique métier avant l'appel aux méthodes de la couche DAL qui accèdent à la table encheres de la base de données
 */
public class BllEnchere {

	private static BllEnchere instance;
	private static EnchereDAO enchere;
	
	private BllEnchere() {
		enchere = DAOFactory.getEnchereDAO();
	}
	
	public static BllEnchere getBllEnchere() {
		if(instance == null) {
			instance = new BllEnchere();
		}
		return instance;
	}
	
	public void insert(Enchere item) throws BusinessException{
		enchere.insert(item);
	}
	
	public List<Enchere> selectByArticle(Article a) throws BusinessException{
		return enchere.selectByArticle(a);
	}
	
	public List<Enchere> selectByUser(Utilisateur util) throws BusinessException{
		return enchere.selectByUser(util);
	}
	public List<Enchere> selectAll() throws BusinessException{
        return enchere.selectAll();
    }
   
	public void delete(Enchere item) throws BusinessException {
		enchere.delete(item);
	}
    public void deleteByUser(Utilisateur user) throws BusinessException{
    	List<Enchere> encheresOfUserToDelete = selectByUser(user);
		for (Enchere ench : encheresOfUserToDelete) {
			delete(ench);
		}
    }
	
}
