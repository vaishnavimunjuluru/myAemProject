package com.community.aem.core.servlets;

import java.io.IOException;
import java.rmi.ServerException;
import javax.servlet.Servlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import com.google.gson.Gson;
@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
"sling.servlet.resourceTypes=" + "sling/servlet/default", "sling.servlet.selectors=" + "demo",
"sling.servlet.methods=" + HttpConstants.METHOD_GET,"sling.servlet.extensions=" + "json"
})
public class ServletJson extends org.apache.sling.api.servlets.SlingAllMethodsServlet 
{
protected final Logger log = LoggerFactory.getLogger(ServletJson.class);
//@Reference MyService keys;
public int id;
private String name;
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
throws ServerException, IOException
{
/*USING GSON OBJECT
@SerializedName
int id;
@SerializedName
String name;
 response.setContentType("text/html");
SimpleServlet servlet = new SimpleServlet();
servlet.setId(123);
int id=servlet.getId();
servlet.setName("abc");         
Gson gsonObj = new Gson();
String jsonStr = gsonObj.toJson(servlet);
response.getWriter().write(jsonStr);*/
response.setContentType("text/html");
JSONObject jsonData = new JSONObject();
try {
jsonData.put("name", "abc");
jsonData.put("addr", "xyz");
jsonData.put("id", 23);
} 
catch (JSONException e)
{
e.printStackTrace();
}
response.getWriter().write(jsonData.toString());
/*keys.setKey(23);
String data=keys.getKey();
response.getWriter().write(data);
*/
}
}
