package fr.adaming.test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.model.Agence;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})

public class classDaoTestPrep {
//	@Autowired
//	IAgenceDao agenceDao;
//
//	@Test
//	public void getAgenceByNumeroTest() {
//
//		Agence agenceTheorique = new Agence();
//		agenceTheorique.setNumero(2);
//		Agence agence = agenceDao.getAgenceByNumero(2);
//		assertEquals(agenceTheorique.getNumero(), agence.getNumero());
//	}
//
//	@Test
//	public void getAllAgencesTest() {
//		int theoricSize = 1;
//		List<Agence> liste = agenceDao.getAllAgences();
//		assertEquals(theoricSize, liste.size());
//	}
//
//	@Test
//	public void addAgenceTest() {
//		int theoricSize = agenceDao.getAllAgences().size();
//		Date date = new Date(2011, 11, 11);
//		Agence agence = new Agence(date);
//		// agence.setNumero(5);
//		agenceDao.ajouterAgence(agence);
//		List<Agence> liste2 = agenceDao.getAllAgences();
//		assertEquals(theoricSize + 1, liste2.size());
//	}
//
//	@Test
//	public void modifierAgenceTest() {
//		int theoricSize = agenceDao.getAllAgences().size();
//		Agence agenceTheorique = agenceDao.getAgenceByNumero(1);
//		agenceDao.ajouterAgence(agenceTheorique);
//		Date date3 = new Date(0102 / 02 / 02);
//		agenceTheorique.setDateCreation(date3);
//		agenceDao.modifierAgence(agenceTheorique);
//		Agence agence = agenceDao.getAgenceByNumero(1);
//		assertEquals(agenceTheorique.getDateCreation(),
//				agence.getDateCreation());
//	}
//
//	@Test
//	public void supprAgenceTest() {
//		int theoricSize = agenceDao.getAllAgences().size();
//		Agence agence = agenceDao.getAgenceByNumero(2);
//		agenceDao.supprimerAgence(agence);
//		List<Agence> liste2 = agenceDao.getAllAgences();
//		assertEquals(theoricSize - 1, liste2.size());
//	}

}
