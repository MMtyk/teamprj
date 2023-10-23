package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.AccountCreateEntity;
import vo.AccountVO;

@WebServlet("/AccountCreateServlet")
public class AccountCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountCreateServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String choice = request.getParameter("choice");
		response.getWriter().append(choice);
		if(choice.equals("checkId"))
			checkId(request,response);
		if(choice.equals("checkNick"))
			checkNick(request,response);
		if(choice.equals("create"))
			create(request,response);

	}
	
	protected void checkId(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		AccountVO vo = new AccountVO();
		AccountCreateEntity ace = new AccountCreateEntity();
		vo.setId(id);
	}
	protected void checkNick(HttpServletRequest request, HttpServletResponse response) {
		String nick = request.getParameter("nick");	
		AccountVO vo = new AccountVO();
		vo.setNick(nick);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
