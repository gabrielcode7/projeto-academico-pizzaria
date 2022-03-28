package action;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.produtoDao;
import dto.produtoDto;

/**
 * Servlet implementation class LogonServlet
 */
@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 5960707713814271218L;

	public ProdutoServlet() {
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
		String nome_do_produto = request.getParameter("nome_do_produto");
		String codigo_de_barras = request.getParameter("codigo_de_barras");
		String estoque_unitario = request.getParameter("estoque_unitario");
		String tamanho = request.getParameter("tamanho");
		String valor_de_venda = request.getParameter("valor_de_venda");
	    produtoDao produtoDao = new produtoDao();
		produtoDto produto = new produtoDto();
		produto.setNome_do_produto(nome_do_produto);
		produto.setCodigo_de_barras(codigo_de_barras);
		produto.setEstoque_unitario(estoque_unitario);
		produto.setTamanho(tamanho);
		produto.setValor_de_venda(valor_de_venda);
		try {
			produtoDao.save(produto);
		} catch (Exception e) {
			e.printStackTrace();
// TODO: handle exception
		}

		PrintWriter out = response.getWriter();
		out.println("<script>parent.location.href='" + request.getContextPath() + "/cadastroprodutos.jsp'</script>");
		out.flush();
		out.close();
	}
}
