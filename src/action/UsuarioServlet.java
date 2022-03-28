package action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.usuarioDao;
import dto.usuarioDto;

/**
 * Servlet implementation class LogonServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 5960707713814271218L;

	public UsuarioServlet() {
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
			cadastro(request, response);
		} catch (Exception e) {
// TODO: handle exception
		}
	}

	public void cadastro(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException, Exception {
		String login = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		Integer codigo = Integer.parseInt(request.getParameter("codigo"));
		usuarioDao usuarioDao = new usuarioDao();
		usuarioDto usuario = new usuarioDto();
		usuario.setLogin_usuario(login);
		usuario.setSenha_usuario(senha);
		usuario.setEmail_usuario(email);
		usuario.setTelefone_usuario(telefone);
		try {
			usuarioDao.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
// TODO: handle exception
		}

		PrintWriter out = response.getWriter();
		out.println("<script>parent.location.href='" + request.getContextPath() + "/login.jsp'</script>");
		out.flush();
		out.close();
	}
}
