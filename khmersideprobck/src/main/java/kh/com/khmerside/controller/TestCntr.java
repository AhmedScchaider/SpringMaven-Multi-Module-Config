package kh.com.khmerside.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestCntr {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/test")
	public ResponseEntity<Map<String, Object>> test() {
		Map<String, Object> responseMap = new HashMap<String, Object>();

		logger.info("This is test controller...");
		responseMap.put("RSLT_CD", "000");
		responseMap.put("RSLT_MSG", "SUCCESS!");
		return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
	}
}
