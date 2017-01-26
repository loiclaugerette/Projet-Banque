package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ParseException;

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

public class ServiceClientTest {
    private static ClassPathXmlApplicationContext context;
    private static IServiceClient serviceClient;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("app.xml");
        serviceClient = (IServiceClient) context.getBean("ServiceClientImpl");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        context.close();
    }

    //===========================
    //  Les tests
    //===========================
    
    @Test
    @Ignore
    public void testAdd() throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        Client client1 = null;
		try {
			client1 = new Client(123l, "ferhaten", "sonia", sf.parse("26-10-2016"), "paris");
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
        serviceClient.add(client1);
        assertNotNull(client1.getIdClient());
    }

    @Test
    @Ignore
    public void testGetOne() {
        Client c = serviceClient.getOne(1L);
        assertNotNull(c);
    }

    @Test
    @Ignore
    public void testGetAll() {
        List<Client> clients = new ArrayList<Client>();
		try {
			clients = serviceClient.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
        assertNotNull(clients);
    }

    @Test
    @Ignore
    public void testUpdate() {
        Client c = serviceClient.getOne(2L);
        c.setAdresse("newAdresse");
        serviceClient.update(c);
        assertThat("newAdresse", IsEqual.equalTo(serviceClient.getOne(2L).getAdresse()));;
    }

    @Test
    @Ignore
    public void testDelete() {
		try {
			List<Client> clients = serviceClient.getAll();
	        int c1= clients.size();
	        serviceClient.delete(1L);
	        int c2 = clients.size();
	        assert(c1-c2==1);
		} catch (NullListException e) {
			e.printStackTrace();
		}
        
    }

    @Test
    @Ignore
    public void testGetClientByMc() {
    	
        List<Client> clients = serviceClient.getClientByMc("f");
        for(int i =0; i<clients.size(); i++){
        	System.out.println(clients.get(i));
            if(clients.get(i).getNom().contains("f")){
                assert(true);
            }
        }
    }

    @Test
    @Ignore
    public void testGetCompteByClient() {
		Client client = new Client(123L, "qdklqjdjs", "qsiduaozeu", new Date(), "oiua");
		serviceClient.add(client);
		Compte compte = new CompteCourant(0L, 156.0, new Date(), 0.0);
		IServiceCompte serviceCompte = (IServiceCompte)context.getBean("ServiceCompteImpl");
		serviceCompte.add(compte);
		serviceCompte.addCompteToClient(compte.getIdCompte(), client.getIdClient());
		assertNotNull(serviceClient.getOne(client.getIdClient()).getComptes().size());
    }
    
    @Test
    @Ignore
    public void testAddClientToBanque() {
		Banque banque = new Banque("nom", "adresse", 12345);
		IServiceBanque serviceBanque = (IServiceBanque)context.getBean("ServiceBanqueImpl");
		serviceBanque.add(banque);
		Client client = new Client(0L, "nom", "prenom", new Date(), "adresse");
		serviceClient.add(client);
		try {
			serviceClient.addClientToBanque(client.getIdClient(), banque.getIdBanque());
		} catch (AlreadyLinkedException e) {
			e.printStackTrace();
		}
		assertNotNull(serviceBanque.getOne(banque.getIdBanque()).getClients().size());
    }

}