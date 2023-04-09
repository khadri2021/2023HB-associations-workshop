package com.khadri.hibernate.association.one2one.uni.entity;


import java.util.Optional;
import java.util.Random;

public class AdhaarGenerator {

	public static String generateAdhaar() {

		String substring = Optional.ofNullable(new Random().nextLong()).map((num) -> {
			return num < 0 ? num * -1 : num;
		}).get().toString().substring(0, 12);

		StringBuffer stringBuffer = new StringBuffer(substring);

		stringBuffer.insert(4, "-");

		stringBuffer.insert(9, "-");

		return stringBuffer.toString();

	}
}
