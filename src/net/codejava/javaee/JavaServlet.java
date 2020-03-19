package net.codejava.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/result.html")
public class JavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		
		DataValidator validator = new DataValidator(request);
		
		PrintWriter out = response.getWriter(); //Создаем копию экземпляра класса для вывода текста

		PageRenderer renderer = new PageRenderer();
		
		String resultHtml = "";

		if ( validator.ValidateData() ) {

			PriceCalculator calculator = new PriceCalculator(request);
			PriceParams OsagoPrice = calculator.calculatePrice();
			
			renderer.setResultPrice(OsagoPrice);
			resultHtml = renderer.generateHTML(true);
			
			out.println(resultHtml);

		} else
			
			resultHtml = renderer.generateHTML(false);
			out.println(resultHtml); //эксепшн на ввод невалидных данных
			
		}

}

