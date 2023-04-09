package com.khadri.hibernate.association.one2one.uni.main;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.association.one2one.uni.entity.AdhaarGenerator;
import com.khadri.hibernate.association.one2one.uni.entity.Husband;
import com.khadri.hibernate.association.one2one.uni.entity.Wife;
import com.khadri.hibernate.exception.KhadriException;
import com.khadri.hibernate.util.StandardServiceRegistryUtil;

public class Main {

	public static void main(String[] args) {

		Class<?> classObj1 = Husband.class;
		Class<?> classObj2 = Wife.class;

		Session session = StandardServiceRegistryUtil.createSession(classObj1, classObj2);

		Transaction txn = session.beginTransaction();

		Wife wife = new Wife();
		wife.setId(AdhaarGenerator.generateAdhaar());
		wife.setName("Ramya");
		session.save(wife);

		Husband husband = new Husband();
		husband.setId(AdhaarGenerator.generateAdhaar());
		husband.setName("Vikram");
		husband.setWife(wife);
		session.save(husband);

		txn.commit();
		Husband husband2 = session.byId(Husband.class).getReference(husband.getId());

		Optional.ofNullable(husband2).ifPresentOrElse((adhaar) -> {

			System.out.println("----- HUSBAND DETAILS ---->");
			System.out.println("HUSBAND ADHAAR NUMBER : " + husband2.getId());
			System.out.println("HUSBAND NAME : " + husband2.getName());
			System.out.println("<----- HUSBAND DETAILS ----");

			System.out.println("----- WIFE DETAILS ---->");
			System.out.println("WIFE ADHAAR NUMBER : " + husband2.getWife().getId());
			System.out.println("WIFE NAME : " + husband2.getWife().getName());
			System.out.println("<----- WIFE DETAILS ----");

		}, () -> {
			throw new KhadriException("No Record Found");
		});

	}
}
