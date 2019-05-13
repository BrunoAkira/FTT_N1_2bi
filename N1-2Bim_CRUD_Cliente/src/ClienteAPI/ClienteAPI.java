package ClienteAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import Model.Cliente;

public class ClienteAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClienteDAO cd;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteAPI() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, 
                                                 IOException {
    	response.getWriter()
    	.append(request.getParameter("client-name")).append(";")
        .append(request.getParameter("client-email")).append(";");

	System.out.println(request);

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cliente c = new Cliente(
				request.getParameter("pid"), //ID sera gerado no BD pela sequence
				request.getParameter("client-name"),
				request.getParameter("client-email"));

		
		System.out.print(c);
		
		
		
		
		String status = "OK";
		String message = "Cliente salvo!";
		String now = String.valueOf(new Date());
		
		try {
		   
		   if (cd == null)
			   cd = new ClienteDAO();	
		   
		   cd.addCliente(c);
		
		} catch (Exception e) {
			status = "Error";
			message = e.getMessage();
			System.err.println(now +  " - Ops!! - " + message);
			System.err.println(now +  " - Ops!! - " + c);
			e.printStackTrace();
		}
		
		response.setContentType("application/json"); //MIME Type
		response.setCharacterEncoding("utf-8");
		
	    //create Json Object
		JsonObject json = new JsonObject();

		// put some value pairs into the JSON object .
		
		json.addProperty("Status", status);
		json.addProperty("Message", message);
		json.addProperty("Time", now);


		 response.getWriter().print(json.toString());
         response.flushBuffer();
	}

    /**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
    
}
