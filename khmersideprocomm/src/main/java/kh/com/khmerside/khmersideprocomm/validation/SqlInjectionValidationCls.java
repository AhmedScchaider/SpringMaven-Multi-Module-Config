package kh.com.khmerside.khmersideprocomm.validation;

public class SqlInjectionValidationCls {
public static final boolean checkSqlInjectionValidation(String pStrSqlParam){
		
		/* prevent basic sql injection with special character <, >, !, =, &, |, union, UNION */
		if(!pStrSqlParam.matches("(.*)<(.*)")) return false;
		if(!pStrSqlParam.matches("(.*)>(.*)")) return false;
		if(!pStrSqlParam.matches("(.*)!(.*)")) return false;
		if(!pStrSqlParam.matches("(.*)=(.*)")) return false;
		if(!pStrSqlParam.matches("(.*)&(.*)")) return false;
		if(!pStrSqlParam.matches("(.*)|(.*)")) return false;
		if(!pStrSqlParam.matches("(.*)union(.*)")) return false;
		if(!pStrSqlParam.matches("(.*)UNION(.*)")) return false;
		
		return true;
	}
}
