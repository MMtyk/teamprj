package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.AccountCreateEntity;
import service.LoginImpl;
import service.ILogin;
import vo.AccountVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String choice = request.getParameter("choice");
			AccountCreateEntity ace = new AccountCreateEntity();
			if(choice.equals("create")) {
				int idNum;
				idNum = ace.addAccount();
				request.setAttribute("idNum", String.valueOf(idNum));
				RequestDispatcher view = request.getRequestDispatcher("view/createaccount1.jsp");
				view.forward(request,  response);
			} else {
				String op1 = request.getParameter("op1");
				String op2 = request.getParameter("op2");
				ILogin cs = new LoginImpl();
				AccountVO vo = new AccountVO(op1, op2);
				request.setAttribute("op1", vo.getId());
				request.setAttribute("op2", vo.getPasswd());
	
				if(vo.getPasswd().equals(cs.checkPass(vo))) {
					RequestDispatcher view = request.getRequestDispatcher("view/main.jsp");
					view.forward(request,  response);
				}
				else {
					RequestDispatcher view = request.getRequestDispatcher("view/error.jsp");
					view.forward(request,  response);
				}
			}
		}catch(Exception e) {
			RequestDispatcher view = request.getRequestDispatcher("view/error.jsp");
			view.forward(request,  response);
		}
	}

}
