package test.jersey.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import test.jersey.pojo.MyResponse;


@Path("/hello")
public class HelloResponse { 
	
	/**
	 * openAPI GET 请求处理测试
	 * @param format 1-xml ; 2-json
	 */
	@GET
	@HeaderParam("Accept:application/json")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response sayHello(@DefaultValue("0") @QueryParam("id") String id,@DefaultValue("NaN")@QueryParam("name") String name,@QueryParam("format") String format,@HeaderParam("accept") String accept){
		ResponseBuilder builder = null;
		
		builder = Response.ok();//取得 ResponseBuilder对象
//		builder = Response.status(503);
		
		if(format != null && "2".equals(format)){//根据请求参数设置返回数据格式
			builder.header("Content-Type", MediaType.APPLICATION_JSON_TYPE);
		}else{
			builder.header("Content-Type", MediaType.APPLICATION_XML_TYPE);
		}
		builder.entity(new MyResponse(id,name,12));//注入被渲染对象(即返回对象)
		return builder.build();
	}
	
	/**
	 * openAPI POST 请求处理测试
	 */
	@POST
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public MyResponse sayHello( @DefaultValue("0") @FormParam("id") String id,@DefaultValue("NaN")@FormParam("name") String name,@QueryParam("age") int age){
		return new MyResponse(id,name,age);
	}
	
	/**
	 * RESTful GET 请求处理测试
	 */
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/sayhello/{id}/{name}")
	public Object sayHelloRest(@DefaultValue("1") @PathParam("id") String id,@DefaultValue("1NaN") @PathParam("name") String name){
		return new MyResponse(id,name,0);
	}
}
