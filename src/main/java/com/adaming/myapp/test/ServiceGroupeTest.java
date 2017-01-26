package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.serviceemployee.IServiceEmploye;
import com.adaming.myapp.servicegroupe.IServiceGroupe;

public class ServiceGroupeTest {
	
	private static ClassPathXmlApplicationContext context;
	private static IServiceGroupe serviceGroupe;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceGroupe = (IServiceGroupe)context.getBean("ServiceGroupeImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	@Ignore
	public void testAdd() {
		Groupe groupe = new Groupe(0L, "name");
		serviceGroupe.add(groupe);
		assertNotNull(groupe.getIdGroupe());
	}

	@Test
	@Ignore
	public void testGetOne() {
		List<Groupe> groupes = new ArrayList<Groupe>();
		try {
			groupes = serviceGroupe.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		Groupe groupe = serviceGroupe.getOne(groupes.get(0).getIdGroupe());
		assertNotNull(groupe);
	}

	@Test
	@Ignore
	public void testGetAll() {
		List<Groupe> groupes = new ArrayList<Groupe>();
		try {
			groupes = serviceGroupe.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		assertNotNull(groupes.size());
	}

	@Test
	@Ignore
	public void testUpdate() {
		Groupe groupe;
		try {
			groupe = serviceGroupe.getAll().get(0);
			String newName = "newName";
			groupe.setNom(newName);
			serviceGroupe.update(groupe);
			assertThat(newName, IsEqual.equalTo(serviceGroupe.getOne(groupe.getIdGroupe()).getNom()));
		} catch (NullListException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testDelete() {
		try {
			List<Groupe> groupes = serviceGroupe.getAll();
			serviceGroupe.delete(groupes.get(0).getIdGroupe());
			assertTrue((groupes.size() - 1) == serviceGroupe.getAll().size());			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testAddEmToGr() {
		Groupe groupe = new Groupe(0L, "name");
		serviceGroupe.add(groupe);
		IServiceEmploye serviceEmploye = (IServiceEmploye)context.getBean("ServiceEmployeImpl");
		Employe employe = new Employe(123L, "EmployeName");
		serviceEmploye.add(employe);
		serviceGroupe.addEmToGr(groupe.getIdGroupe(), employe.getIdEmploye());
		assertNotNull(groupe.getEmployes().size());
	}

	@Test
	@Ignore
	public void testGetEmployeByGroupe() {
		List<Employe> employes = new ArrayList<Employe>();
		try {
			employes = serviceGroupe.getEmployeByGroupe(serviceGroupe.getAll().get(0).getIdGroupe());
		} catch (NullListException e) {
			e.printStackTrace();
		}
		assertNotNull(employes.size());
	}

}
