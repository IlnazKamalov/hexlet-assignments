package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List getUsers() throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("src/main/resources/users.json").toAbsolutePath();
        return objectMapper.readValue(path.toFile(), List.class);
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {
        List users = getUsers();
        StringBuilder body = new StringBuilder();

        for (Object userValue: users) {
            Map user = (Map) userValue;
            String id = (String) user.get("id");
            String fullName = (user.get("firstName") + " " + user.get("lastName"));
            body.append("""
                    <table>
                    <tr>
                    """);
            body.append("<td>" + id + "</td>");
            body.append("<td>");
            body.append("<a href=\"/users/" + id + "\">" + fullName + "</a>");
            body.append("</td>");
            body.append("""
                    </tr>
                    </table>
                    """);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(body);
        }
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {
        List users = getUsers();
        StringBuilder body = new StringBuilder();

        for (Object userValue: users) {
            Map user = (Map) userValue;
            if (user.get("id").equals(id)) {
                String fullName = (user.get("firstName") + " " + user.get("lastName"));
                String email = (String) user.get("email");
                body.append("""
                        <table>
                        """);
                body.append("<tr><td><b> id: </b>" + id + "</td></tr>");
                body.append("<tr><td><b> FullName: </b>" + fullName + "</td></tr>");
                body.append("<tr><td><b> email: </b>" + email + "</td></tr>");
                body.append("""
                        </tr>
                        </table>
                        """);
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(body);
                return;
            }
        }

        if (body.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
