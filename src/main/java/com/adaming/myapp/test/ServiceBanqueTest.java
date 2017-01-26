package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.CompteCourant;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exception.AlreadyLinkedException;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.servicebanque.IServiceBanque;
import com.adaming.myapp.serviceclient.IServiceClient;
import com.adaming.myapp.servicecompte.IServiceCompte;
import com.adaming.myapp.serviceemployee.IServiceEmploye;

public class ServiceBanqueTest {

    private static ClassPathXmlApplicationContext context;
    private static IServiceBanque serviceBanque;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("app.xml");
        serviceBanque = (IServiceBanque) context.getBean("ServiceBanqueImpl");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        context.close();
    }
    
    //=====================
    // les tests
    //=====================
    
    @Test
    @Ignore
    public void testAdd() {
        Banque banque1= new Banque("Bnp", "paris", 75001 );
        serviceBanque.add(banque1);
        assertNotNull(banque1.getIdBanque());
    }

    @Test
    @Ignore
    public void testGetOne() {
        Banque b = serviceBanque.getOne(1L);
        assertNotNull(b);
        
    }

    @Test
    @Ignore
    public void testGetAll() {
        List<Banque> banques = new ArrayList<Banque>();
		try {
			banques = serviceBanque.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
        assertNotNull(banques);
        
        
    }

    @Test
    @Ignore
    public void testUpdate() {
        Banque b = serviceBanque.getOne(2L);
        b.setAdresse("newAdresse");
        serviceBanque.update(b);
        assertThat("newAdresse", IsEqual.equalTo(serviceBanque.getOne(b.getIdBanque()).getAdresse()));;
    }

    @Test
    @Ignore
    public void testDelete() {
		try {
			List<Banque> banques = serviceBanque.getAll();
	        int s1= banques.size();
	        serviceBanque.delete(3L);
	        int s2 = serviceBanque.getAll().size();
	        assertTrue((s1-s2)==1);
		} catch (NullListException e) {
			e.printStackTrace();
		}
    }

    @Test
    @Ignore
    public void testGetEmployeByBanque() {
		Banque banque = new Banque("nom", "adresse", 12345);
		serviceBanque.add(banque);
		Employe employe = new Employe(123L, "nom");
		IServiceEmploye serviceEmploye = (IServiceEmploye)context.getBean("ServiceEmployeImpl");
		serviceEmploye.add(employe);
		serviceEmploye.addEmployeToBanque(employe.getIdEmploye(), banque.getIdBanque());
		assertNotNull(serviceBanque.getOne(banque.getIdBanque()).getEmployes().size());
    }

    @Test
    @Ignore
    public void testGetClientByBanque() {
		Banque banque = new Banque("nom", "adresse", 12345);
		serviceBanque.add(banque);
		Client client = new Client(0L, "nom", "prenom", new Date(), "adresse");
		IServiceClient serviceClient = (IServiceClient)context.getBean("ServiceClientImpl");
		serviceClient.add(client);
		try {
			serviceClient.addClientToBanque(client.getIdClient(), banque.getIdBanque());
		} catch (AlreadyLinkedException e) {
			e.printStackTrace();
		}
		assertNotNull(serviceBanque.getOne(banque.getIdBanque()).getClients().size());
    }

    @Test
    @Ignore
    public void testGetCompteByBanque() {
    	IServiceCompte serviceCompte = (IServiceCompte)context.getBean("ServiceCompteImpl");
    	serviceCompte.add(new CompteCourant());
    	
		try {
	        List<Compte> comptes = serviceBanque.getCompteByBanque(4L);
	        assertNotNull(comptes);
		} catch (NullListException e) {
			e.printStackTrace();
		}
    }

}
