package com.example.vector.api.security.util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {
//	 private static PasswordEncoder delegateEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	public static void main(String[] args) {
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//		System.out.println(delegateEncoder.encode("m0b1l30"));
		System.out.println(encoder.encode("m0b1l30"));
		System.out.println("");

//		System.out.println(delegateEncoder.encode("@ngul@r0"));
		System.out.println(encoder.encode("@ngul@r0"));
		System.out.println("");

//		System.out.println(delegateEncoder.encode("admin"));
		System.out.println(encoder.encode("admin"));
		System.out.println("");

//		System.out.println(delegateEncoder.encode("iranildo"));
		System.out.println(encoder.encode("iranildo"));

	}
}

