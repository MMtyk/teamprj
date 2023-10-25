package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		//;/String id = request.getParameter("id");
		//response.getWriter().append(choice);
		//request.setAttribute("id", id);
		//RequestDispatcher view = request.getRequestDispatcher("createaccount.jsp");
		//view.forward(request,  response);
		
		
		if(choice.equals("checkId"))
			checkId(request,response);
		if(choice.equals("checkNick"))
			checkNick(request,response);
		if(choice.equals("create"))
			create(request,response);

	}
	
	protected void checkId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nick = request.getParameter("nick");
		AccountVO vo = new AccountVO();
		AccountCreateEntity ace = new AccountCreateEntity();
		vo.setId(id);
		if(ace.checkId(vo) == null)
			vo.setIdChk("사용가능");
		else
			vo.setIdChk("사용불가");
		request.setAttribute("idChk",vo.getIdChk());
		request.setAttribute("nickChk",vo.getNickChk());
		request.setAttribute("id", id);
		request.setAttribute("nick", nick);
		RequestDispatcher view = request.getRequestDispatcher("createaccount.jsp");
		view.forward(request,  response);
	}
	protected void checkNick(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nick = request.getParameter("nick");	
		AccountVO vo = new AccountVO();
		AccountCreateEntity ace = new AccountCreateEntity();
		vo.setNick(nick);
		if(ace.checkNick(vo) == null)
			vo.setNickChk("사용가능");
		else
			vo.setNickChk("사용불가");
		request.setAttribute("idChk",vo.getIdChk());
		request.setAttribute("nickChk",vo.getNickChk());
		request.setAttribute("id", id);
		request.setAttribute("nick", nick);
		RequestDispatcher view = request.getRequestDispatcher("createaccount.jsp");
		view.forward(request,  response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
