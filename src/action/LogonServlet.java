package action;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.usuarioDao;
import dto.usuarioDto;

/**
 * Servlet implementation class LogonServlet
 */
@WebServlet("/LogonServlet")
public class LogonServlet extends HttpServlet {
	private static final long serialVersionUID = 5960709913814291218L;

	public LogonServlet() {
		super();
//contexto=getServletContext();
// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {
		try {
			executar(request, response);
		} catch (Exception e) {
// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {
		try {

			executar(request, response);
		} catch (Exception e) {
// TODO: handle exception
		}
	}

	protected void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {

		try {
			login(request, response);
		} catch (Exception e) {
// TODO: handle exception
		}
	}

	public void login(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException, Exception {
		String login = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		usuarioDao usuarioDao = new usuarioDao();
		usuarioDto usuario = null;
		usuario = usuarioDao.getUsuario(login, senha, email, telefone);
		HttpSession sessao = request.getSession();
		if (usuario != null) {
			request.getSession().setAttribute("usuario", usuario);
			PrintWriter out = response.getWriter();

			out.println("<script>parent.location.href='" + request.getContextPath() + "/index.jsp'</script>");
			out.flush();
			out.close();
		} else {
			PrintWriter out = response.getWriter();

			out.println("<script>parent.location.href='" + request.getContextPath() + "/login.jsp'</script>");
			out.flush();
			out.close();
		}
	}
}
