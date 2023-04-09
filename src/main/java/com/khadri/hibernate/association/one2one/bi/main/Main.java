package com.khadri.hibernate.association.one2one.bi.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.association.one2one.bi.entity.Address;
import com.khadri.hibernate.association.one2one.bi.entity.Student;
import com.khadri.hibernate.util.StandardServiceRegistryUtil;

public class Main {

	public static void main(String[] args) {

		Class<?> classObj1 = Student.class;
		Class<?> classObj2 = Address.class;

		Session session = StandardServiceRegistryUtil.createSession(classObj1, classObj2);

		Transaction txn = session.beginTransaction();

		Address address = new Address();
		address.setDoorNo("1/2");
		address.setStreet("ABC Street");
		address.setCity("Kadiri");
		address.setState("AP");

		Student student = new Student();
		student.setName("Jeelan");
		student.setAddress(address);

		address.setStudent(student);

		session.save(address);

		txn.commit();

	}
}
