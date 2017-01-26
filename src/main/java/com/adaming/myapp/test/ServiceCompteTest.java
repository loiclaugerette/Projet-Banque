package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.CompteCourant;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.servicebanque.IServiceBanque;
import com.adaming.myapp.serviceclient.IServiceClient;
import com.adaming.myapp.servicecompte.IServiceCompte;
import com.adaming.myapp.serviceemployee.IServiceEmploye;

public class ServiceCompteTest {
	
	private static ClassPathXmlApplicationContext context;
	private static IServiceCompte serviceCompte;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceCompte =(IServiceCompte)context.getBean("ServiceCompteImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	@Ignore
	public void testAdd() {
		Compte c = new CompteCourant(12L, 158.2, new Date(), 0.0);		
		serviceCompte.add(c);
		assertNotNull(c.getIdCompte());
	}	
	
	
	@Test
	@Ignore
	public void testGetOne() {
		Compte c = serviceCompte.getOne(4L);
		assertNotNull(c.getIdCompte());
	}
	
	@Test
	@Ignore
	public void testGetAll() {
		List<Compte> comptes = new ArrayList<Compte>();
		try {
			comptes = serviceCompte.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		assertTrue(comptes != null);
		
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		Compte c1 = serviceCompte.getOne(4L);
		c1.setSolde(152.2);
		serviceCompte.update(c1);
		Compte c2 = serviceCompte.getOne(4L);
		Assert.assertThat(152.2, IsEqual.equalTo(c2.getSolde()));
	}
	
	@Test
	@Ignore
	public void testDelete() {
		try {
			List<Compte> comptes = serviceCompte.getAll();
			int size1 = comptes.size();
			serviceCompte.delete(7L);
			assertTrue(size1-serviceCompte.getAll().size()==1);
		} catch (NullListException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void testGetCompteByEmploye() {
		try {
			Employe employe = new Employe(456L, "nomda");
			IServiceEmploye serviceEmploye = (IServiceEmploye)context.getBean("ServiceEmployeImpl");
			serviceEmploye.add(employe);
			Compte compte = new CompteCourant(0L, 156.0, new Date(), 0.0);
			serviceCompte.add(compte);
			serviceCompte.addCompteToEmploye(compte.getIdCompte(), employe.getIdEmploye());
			assertNotNull(serviceCompte.getCompteByEmploye(employe.getIdEmploye()).size());
		} catch (NullListException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void testaddCompteToBanque() {
		Banque banque = new Banque("nom", "adresse", 12345);
		IServiceBanque serviceBanque = (IServiceBanque)context.getBean("ServiceBanqueImpl");
		serviceBanque.add(banque);
		Compte compte = new CompteCourant(0L, 156.0, new Date(), 0.0);
		serviceCompte.add(compte);
		serviceCompte.addCompteToBanque(compte.getIdCompte(), banque.getIdBanque());
		assertNotNull(serviceBanque.getOne(banque.getIdBanque()).getComptes().size());
	}

	@Test
	@Ignore
	public void testAddCompteToClient() {
		Client client = new Client(123L, "qdklqjdjs", "qsiduaozeu", new Date(), "oiua");
		IServiceClient serviceClient = (IServiceClient)context.getBean("ServiceClientImpl");
		serviceClient.add(client);
		Compte compte = new CompteCourant(0L, 156.0, new Date(), 0.0);
		serviceCompte.add(compte);
		serviceCompte.addCompteToClient(compte.getIdCompte(), client.getIdClient());
		assertNotNull(serviceClient.getOne(client.getIdClient()).getComptes().size());
	}

	@Test
	@Ignore
	public void testAddCompteToEmploye() {
		Employe employe = new Employe(456L, "nomda");
		IServiceEmploye serviceEmploye = (IServiceEmploye)context.getBean("ServiceEmployeImpl");
		serviceEmploye.add(employe);
		Compte compte = new CompteCourant(0L, 156.0, new Date(), 0.0);
		serviceCompte.add(compte);
		serviceCompte.addCompteToEmploye(compte.getIdCompte(), employe.getIdEmploye());
		assertNotNull(serviceCompte.getOne(compte.getIdCompte()).getEmploye());
	}

}
