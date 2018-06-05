package kh.com.khmerside.service;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import kh.com.khmerside.khmersideprocomm.crypto.assyncronous.KhmerSideRsaCipher;
import kh.com.khmerside.khmersideprocomm.crypto.syncronous.KhmerSideAesCls;

@Service
public class SecurityService {

	public SecurityService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*DTO BEAN*/
	@Bean
	public KhmerSideRsaCipher khmerSideRsaCipher() throws IOException {
		return new KhmerSideRsaCipher(new ClassPathResource("private.key").getFile());
	}
	
	@Bean
	public KhmerSideAesCls khmerSideAesCls() {
		return new KhmerSideAesCls("KEY@2017");
	}
}
