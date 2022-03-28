package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.adminDao;
import dto.adminDto;

/**
 * Servlet implementation class AdmLogonServlet
 */
@WebServlet("/AdmLogonServlet")
public class AdmLogonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmLogonServlet() {
        super();
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
		String nome_func = request.getParameter("nome_func");
		String cpf = request.getParameter("cpf");
		adminDao adminDao = new adminDao();
		adminDto administrador = null;
		administrador = adminDao.getAdministrador(null, nome_func, cpf);
		HttpSession sessao = request.getSession();
		if (administrador != null) {
			request.getSession().setAttribute("usuario", administrador);
			PrintWriter out = response.getWriter();

			out.println("<script>parent.location.href='" + request.getContextPath() + "/admlogin.jsp'</script>");
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
