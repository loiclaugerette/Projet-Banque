package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.servicebanque.IServiceBanque;
import com.adaming.myapp.serviceemployee.IServiceEmploye;

public class ServiceEmployeTest {
	
	private static ClassPathXmlApplicationContext context;
	private static IServiceEmploye serviceEmploye;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			context = new ClassPathXmlApplicationContext("app.xml");
			serviceEmploye =(IServiceEmploye)context.getBean("ServiceEmployeImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	@Ignore
	public void testAdd() {
		Employe e = new Employe(54L, "Jean");
		serviceEmploye.add(e);
		assertNotNull(e.getIdEmploye());
	}

	@Test
	@Ignore
	public void testGetOne() {
		Employe e = serviceEmploye.getOne(1L);
		assertNotNull(e.getIdEmploye());
	}

	@Test
	@Ignore
	public void testGetAll() {
		List<Employe> employes = new ArrayList<Employe>();
		try {
			employes = serviceEmploye.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		assertTrue(employes.size()>0);
	}

	@Test
	@Ignore
	public void testUpdate() {
		Employe e1 = serviceEmploye.getOne(1L);
		e1.setNom("nommodif");
		serviceEmploye.update(e1);
		Employe e2 = serviceEmploye.getOne(1L);
		Assert.assertThat("nommodif", IsEqual.equalTo(e2.getNom()));
	}

	@Test
	@Ignore
	public void testDelete() {
		try {
			List<Employe> employes = serviceEmploye.getAll();
			serviceEmploye.delete(1L);
			List<Employe> employes2 = serviceEmploye.getAll();
			assertTrue(employes.size()-1 == employes2.size());
		} catch (NullListException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddEmployeToBanque() {
		Banque banque = new Banque("nom", "adresse", 12345);
		IServiceBanque serviceBanque = (IServiceBanque)context.getBean("ServiceBanqueImpl");
		serviceBanque.add(banque);
		Employe employe = new Employe(123L, "nom");
		serviceEmploye.add(employe);
		serviceEmploye.addEmployeToBanque(employe.getIdEmploye(), banque.getIdBanque());
		assertNotNull(serviceBanque.getOne(banque.getIdBanque()).getEmployes().size());
	}
	
}
