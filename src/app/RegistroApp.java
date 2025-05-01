package app;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RegistroServlet extends HttpServlet {
    private final ArrayList<Apartamento> lista = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int numero = Integer.parseInt(request.getParameter("numero"));
        String dueno = request.getParameter("dueno");
        String inquilino = request.getParameter("inquilino");
        int adultos = Integer.parseInt(request.getParameter("adultos"));
        int ninos = Integer.parseInt(request.getParameter("ninos"));
        double aseo = Double.parseDouble(request.getParameter("aseo"));
        double descuento = Double.parseDouble(request.getParameter("descuento"));

        int totalPersonas = adultos + ninos;
        double piscina = totalPersonas * 2000;
        double juegos = (ninos > 0) ? 5000 : 0;
        double zonas = (adultos > 0) ? 10000 : 0;
        double subtotal = piscina + juegos + zonas + aseo;
        double total = subtotal - descuento;

        Apartamento a = new Apartamento(numero, dueno, inquilino, adultos, ninos,
                piscina, juegos, zonas, aseo, subtotal, descuento, total);
        lista.add(a);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Registro exitoso</h1>");
        out.println("<p>Total a pagar: $" + total + "</p>");
        out.println("<a href='index.html'>Volver</a>");
        out.println("</body></html>");
    }
}