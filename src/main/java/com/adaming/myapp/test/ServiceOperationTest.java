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

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.CompteCourant;
import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.entities.Retrait;
import com.adaming.myapp.entities.Versement;
import com.adaming.myapp.entities.Virement;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.servicecompte.IServiceCompte;
import com.adaming.myapp.serviceoperation.IServiceOperation;

public class ServiceOperationTest {
	
	private static ClassPathXmlApplicationContext context;
	private static IServiceOperation serviceOperation;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceOperation = (IServiceOperation)context.getBean("ServiceOperationImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	@Ignore
	public void testAdd() {
		Operation operation = new Versement(new Date(), 10.0);
		serviceOperation.add(operation);
		assertNotNull(operation.getIdOperation());
	}

	@Test
	@Ignore
	public void testGetOne() {
		List<Operation> operations = new ArrayList<Operation>();
		try {
			operations = serviceOperation.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		Operation operation = serviceOperation.getOne(operations.get(0).getIdOperation());
		assertNotNull(operation);
	}

	@Test
	@Ignore
	public void testGetAll() {
		List<Operation> operations = new ArrayList<Operation>();;
		try {
			operations = serviceOperation.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		assertNotNull(operations.size());
	}

	@Test
	@Ignore
	public void testUpdate() {
		Operation operation = new Operation();
		try {
			operation = serviceOperation.getAll().get(0);
		} catch (NullListException e) {
			e.printStackTrace();
		}
		double newMontant = 20.0;
		operation.setMontantOperation(newMontant);
		serviceOperation.update(operation);
		assertThat(newMontant, IsEqual.equalTo(serviceOperation.getOne(operation.getIdOperation()).getMontantOperation()));
	}

	@Test
	@Ignore
	public void testDelete() {
		List<Operation> operations = new ArrayList<Operation>();
		try {
			operations = serviceOperation.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		serviceOperation.delete(operations.get(0).getIdOperation());
		List<Operation> operations2 = new ArrayList<Operation>();
		try {
			operations2 = serviceOperation.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		assertTrue((operations.size() - 1) == operations2.size());
	}

	@Test
	@Ignore
	public void testDoVersement() {
		IServiceCompte serviceCompte = (IServiceCompte)context.getBean("ServiceCompteImpl");
		Versement versement = new Versement(new Date(), 10.0);
		double solde;
		try {
			solde = serviceCompte.getAll().get(0).getSolde();
			serviceOperation.doVersement(versement, serviceCompte.getAll().get(0).getIdCompte());
			assertThat((solde + versement.getMontantOperation()), IsEqual.equalTo(serviceCompte.getAll().get(0).getSolde()));
		} catch (NullListException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testDoRetrait() {
		IServiceCompte serviceCompte = (IServiceCompte)context.getBean("ServiceCompteImpl");
		Retrait retrait = new Retrait(new Date(), 10.0);
		double solde;
		try {
			solde = serviceCompte.getAll().get(0).getSolde();
			serviceOperation.doRetrait(retrait, serviceCompte.getAll().get(0).getIdCompte());
			assertThat((solde - retrait.getMontantOperation()), IsEqual.equalTo(serviceCompte.getAll().get(0).getSolde()));
		} catch (NullListException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testDoVirement() {
		IServiceCompte serviceCompte = (IServiceCompte)context.getBean("ServiceCompteImpl");
		Virement virement = new Virement(new Date(), 10.0);
		double solde;
		try {
			solde = serviceCompte.getAll().get(0).getSolde();
			serviceOperation.doVirement(virement, serviceCompte.getAll().get(0).getIdCompte(), serviceCompte.getAll().get(0).getIdCompte());
			assertThat(solde, IsEqual.equalTo(serviceCompte.getAll().get(0).getSolde()));
		} catch (NullListException e) {
			e.printStackTrace();
		}
	}

}
