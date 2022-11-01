package exercise.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException {
        PrintWriter out = response.getWriter();
        List<String> companies = new ArrayList<>(getCompanies());
        String parameterSearch = request.getParameter("search");
        //String queryString = request.getQueryString();

        if (parameterSearch != null && !"".equals(parameterSearch)) {
            companies = companies.stream()
                    .filter(s -> s.contains(parameterSearch))
                    .collect(Collectors.toList());
        }

        if (companies.size() > 0) {
            companies.forEach(out::println);
        } else {
            out.println("Companies not found");
        }
    }
}
