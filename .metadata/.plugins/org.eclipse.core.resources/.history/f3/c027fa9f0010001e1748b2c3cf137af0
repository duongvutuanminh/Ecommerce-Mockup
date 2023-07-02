package com.ecomvn.common.entity.idGenerator;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public class UserIDGenerator implements IdentifierGenerator {
	
	public static final String INITIAL_PARAM = "";
	private String initialParam;
	
	public static final String INCREMENT_PARAM = "";
	private String incrementParam;
	
	public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
    public static final String VALUE_PREFIX_DEFAULT = "";
    private String valuePrefix;
	
    public static final String NUMBER_FORMAT_DEFAULT = "%05d";
    private String numberFormat = NUMBER_FORMAT_DEFAULT;
    
	@Override
    public Serializable generate(SharedSessionContractImplementor session,
            Object object) throws HibernateException {
		User user = (User) object;
		
        return valuePrefix + "#" + String.format(numberFormat, generateUniqueIdentifier());
    }
	
	private String generateUniqueIdentifier() {
		return 
	}
	
	public void setPrefixValues(String valuePrefix, String initialParam, String incrementParam) {
		this.valuePrefix = valuePrefix;
		this.initialParam = initialParam;
		this.incrementParam = incrementParam;
	}
}  
