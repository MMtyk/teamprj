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
		
		if(choice.equals("next1"))
			next1(request,response);
		if(choice.equals("next2"))
			next2(request,response);
		if(choice.equals("next3"))
			next3(request,response);
		if(choice.equals("next4"))
			next4(request,response);
		if(choice.equals("back1"))
			back1(request,response);
		if(choice.equals("back2"))
			back2(request,response);
		if(choice.equals("back3"))
			back3(request,response);
		//if(choice.equals("back4"))
		//	back4(request,response);
	}
	
	protected void next1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNum = request.getParameter("idNum");
		String id = request.getParameter("id");
		AccountVO vo = new AccountVO();
		AccountCreateEntity ace = new AccountCreateEntity();
		vo.setId(id);
		vo.setIdNum(idNum);
		request.setAttribute("idNum", idNum);
		if(ace.next1(vo) == null) {
			vo.setIdChk("사용가능");
			request.setAttribute("idChk",vo.getIdChk());
			request.setAttribute("id", id);
			RequestDispatcher view = request.getRequestDispatcher("view/createaccount2.jsp");
			view.forward(request,  response);
		}
		else {
			vo.setIdChk("사용불가");
			request.setAttribute("idChk",vo.getIdChk());
			request.setAttribute("id", id);
			RequestDispatcher view = request.getRequestDispatcher("view/createaccount1.jsp");
			view.forward(request,  response);
		}
	}
	protected void next2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNum = request.getParameter("idNum");
		String nick = request.getParameter("nick");	
		AccountVO vo = new AccountVO();
		AccountCreateEntity ace = new AccountCreateEntity();
		vo.setNick(nick);
		vo.setIdNum(idNum);
		request.setAttribute("idNum", idNum);
		if(ace.next2(vo) == null) {
			vo.setNickChk("사용가능");
			request.setAttribute("nickChk",vo.getNickChk());
			request.setAttribute("nick", nick);
			RequestDispatcher view = request.getRequestDispatcher("view/createaccount3.jsp");
			view.forward(request,  response);
		}
		else {
			vo.setNickChk("사용불가");
			request.setAttribute("nickChk",vo.getNickChk());
			request.setAttribute("nick", nick);
			RequestDispatcher view = request.getRequestDispatcher("view/createaccount2.jsp");
			view.forward(request,  response);
		}
	}
	
	protected void next3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNum = request.getParameter("idNum");
		String passwd = request.getParameter("passwd");
		AccountVO vo = new AccountVO();
		AccountCreateEntity ace = new AccountCreateEntity();
		vo.setIdNum(idNum);
		vo.setPasswd(passwd);
		ace.next3(vo);
		request.setAttribute("idNum", idNum);
		

		RequestDispatcher view = request.getRequestDispatcher("view/createaccount4.jsp");
		view.forward(request,  response);
	}
	
	protected void next4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNum = request.getParameter("idNum");
		String passwd2 = request.getParameter("passwd2");
		AccountVO vo = new AccountVO();
		vo.setIdNum(idNum);
		AccountCreateEntity ace = new AccountCreateEntity();
		request.setAttribute("idNum", idNum);
		if(passwd2.equals(ace.next4(vo))){
			RequestDispatcher view = request.getRequestDispatcher("view/acsuccess.jsp");
			view.forward(request,  response);
		} else {
			request.setAttribute("passChk", "패스워드가 일치하지 않습니다.");
			RequestDispatcher view = request.getRequestDispatcher("view/createaccount4.jsp");
			view.forward(request,  response);
		}
	}

	protected void back1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNum = request.getParameter("idNum");
		AccountVO vo = new AccountVO();
		AccountCreateEntity ace = new AccountCreateEntity();
		vo.setIdNum(idNum);
		ace.Back1(vo);
		RequestDispatcher view = request.getRequestDispatcher("view/login.jsp");
		view.forward(request,  response);
	}
	protected void back2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNum = request.getParameter("idNum");
		String id = "";
		AccountVO vo = new AccountVO();
		AccountCreateEntity ace = new AccountCreateEntity();
		vo.setIdNum(idNum);
		id = ace.Back2(vo);
		request.setAttribute("id", id);
		request.setAttribute("idNum", idNum);
		RequestDispatcher view = request.getRequestDispatcher("view/createaccount1.jsp");
		view.forward(request,  response);
	}
	protected void back3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNum = request.getParameter("idNum");
		System.out.println(idNum);
		String nick = "";
		AccountVO vo = new AccountVO();
		AccountCreateEntity ace = new AccountCreateEntity();
		vo.setIdNum(idNum);
		nick = ace.Back3(vo);
		request.setAttribute("nick", nick);
		request.setAttribute("idNum", idNum);
		RequestDispatcher view = request.getRequestDispatcher("view/createaccount2.jsp");
		view.forward(request,  response);
	}
}
