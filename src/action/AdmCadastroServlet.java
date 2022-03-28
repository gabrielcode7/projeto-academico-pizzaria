package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.adminDao;
import dto.adminDto;

/**
 * Servlet implementation class AdmCadastroServlet
 */
@WebServlet("/AdmCadastroServlet")
public class AdmCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmCadastroServlet() {
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
			cadastro(request, response);
		} catch (Exception e) {
// TODO: handle exception
		}
	}

		public void cadastro(HttpServletRequest request, HttpServletResponse response)

				throws ServletException, IOException, Exception {
			String nome_func = request.getParameter("nome_func");
			String cpf = request.getParameter("cpf");
			adminDao adminDao = new adminDao();
			adminDto administrador = new  adminDto();
			administrador.setNome_func(nome_func);
			administrador.setCpf(cpf);
			try {
				adminDao.save(administrador);
			} catch (Exception e) {
				e.printStackTrace();
	// TODO: handle exception
			}

			PrintWriter out = response.getWriter();
			out.println("<script>parent.location.href='" + request.getContextPath() + "/admlogin.jsp'</script>");
			out.flush();
			out.close();
		}
	}



