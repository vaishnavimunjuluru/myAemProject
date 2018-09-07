package com.community.aem.core; 
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.api.servlets.HttpConstants;
@Component(service = KeyService.class, property = { Constants.SERVICE_DESCRIPTION + "=Simple key service",
"sling.servlet.methods=" + HttpConstants.METHOD_GET
})
public class KeyServiceImpl implements KeyService
{
private int key = 0 ;
public void setKey(int val)
{
	this.key = val ; 
}
public String getKey()
{
String strI = Integer.toString(this.key);
return strI; 
}
}