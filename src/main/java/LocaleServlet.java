import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "LocaleServlet", value = "/LocaleServlet")
public class LocaleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute("locale");
        if (locale == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("locale")) {
                        locale = new Locale(cookie.getValue());
                        break;
                    }
                }
            }
        }

        // Встановлюємо поточну локалізацію
        if (locale != null) {
            Locale.setDefault(locale);
        }

        // Відображаємо сторінку з урахуванням поточної локалізації
        RequestDispatcher dispatcher = request.getRequestDispatcher("/book");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter("language");

        // Встановлюємо вибрану мову
        if (language.equals("en")) {
            setLocale(request, response, new Locale("en", "US"));
        } else if (language.equals("uk")) {
            setLocale(request, response, new Locale("uk", "UA"));
        }

        // Перенаправляємо користувача на ту ж сторінку, де він зробив вибір мови
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }

    protected void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // Зберігаємо вибрану мову в сесії
        HttpSession session = request.getSession();
        session.setAttribute("locale", locale);

        // Встановлюємо вибрану мову для поточного запиту
        Locale.setDefault(locale);

        // Оновлюємо кукі-файл для зберігання мови
        Cookie cookie = new Cookie("locale", locale.toString());
        cookie.setMaxAge(365 * 24 * 60 * 60); // кукі-файл діє протягом року
        response.addCookie(cookie);
    }
}
