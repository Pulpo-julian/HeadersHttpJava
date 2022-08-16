package com.julian.soporte.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class CabecerasHttpRequest
 */
public class CabecerasHttpRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CabecerasHttpRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		//devuelve el metodo que se uso en la peticion en este caso GET
		String metodoHttp = request.getMethod();
		
		String requestUri = request.getRequestURI();
		
		String requestUrl = request.getRequestURL().toString();
		
		String contextPath = request.getContextPath();
		
		String servletPath = request.getServletPath();
		
		//construir la url desde 0
		
		//se obtiene la ip servlet
		String ip = request.getLocalAddr();
		
		//ip del cliente
		String ipCliente = request.getRemoteAddr();
		
		int port = request.getLocalPort();
		
		//http
		String scheme = request.getScheme();
		
		//obtener host
		String host = request.getHeader("host");
		
		String url = scheme + "://" + host + "/" + contextPath + servletPath;
		
		String url2 = scheme + "://" + ip + "/" + contextPath + servletPath;
		
		
		try(PrintWriter out = response.getWriter()){
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("		<meta charset=\"UTF-8\">");
			out.println("		<title>Cabeceras HTTP Request</title>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<h1>Cabeceras HTTP Request!</h1>");
			out.println("		<ul>");
			out.println("			<li>Metodo Http: " + metodoHttp + "</li>");
			out.println("			<li>Request URI: " + requestUri+ "</li>");
			out.println("			<li>Request URL: " + requestUrl + "</li>");
			out.println("			<li>Context Path: " + contextPath + "</li>");
			out.println("			<li>Servlet Path: " + servletPath + "</li>");
			out.println("			<li>IP local: " + ip + "</li>");
			out.println("			<li>Puerto: " + port + "</li>");
			out.println("			<li>Scheme: " + scheme + "</li>");
			out.println("			<li>Host: " + host + "</li>");
			out.println("			<li>url: " + url + "</li>");
			out.println("			<li>url2t: " + url2 + "</li>");
			out.println("			<li>ip Cliente: " + ipCliente + "</li>");
			
			Enumeration<String> headerNames = request.getHeaderNames();
			
			while(headerNames.hasMoreElements()) {
				String cabecera = headerNames.nextElement();
				
				out.println("<li>" + cabecera + ": " + request.getHeader(cabecera) +"</li>");
				
			}
			
			out.println("		</ul>");
			out.println("	</body>");
			out.println("</html>");
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
