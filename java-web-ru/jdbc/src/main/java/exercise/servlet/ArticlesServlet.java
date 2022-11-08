package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import exercise.TemplateEngineUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class ArticlesServlet extends HttpServlet {

    private String getId(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return null;
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 1, null);
    }

    private String getAction(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return "list";
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 2, getId(request));
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String action = getAction(request);

        switch (action) {
            case "list":
                showArticles(request, response);
                break;
            default:
                showArticle(request, response);
                break;
        }
    }

    private void showArticles(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");
        List<Map<String, String>> articles = new ArrayList<>();

        String page = request.getParameter("page");
        int articlePage;

        if (page == null) {
            articlePage = 1;
        } else {
            articlePage = Integer.parseInt(page);
        }

        String query = "SELECT id, title, body FROM articles ORDER BY id LIMIT ? OFFSET ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 10);
            statement.setInt(2, (articlePage - 1) * 10);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                articles.add(Map.of(
                   "id", resultSet.getString("id"),
                        "title", resultSet.getString("title"),
                        "body", resultSet.getString("body")
                ));
            }
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        request.setAttribute("articles", articles);
        request.setAttribute("page", articlePage);
        TemplateEngineUtil.render("articles/index.html", request, response);
    }

    private void showArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");
        List<Map<String, String>> articles = new ArrayList<>();
        String query = "SELECT * FROM articles WHERE id = " + getId(request);

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                articles.add(Map.of(
                        "id", resultSet.getString("id"),
                        "title", resultSet.getString("title"),
                        "body", resultSet.getString("body")
                ));
            }
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        if (articles.isEmpty()) {
            response.setStatus(404);
            return;
        }
        request.setAttribute("articles", articles);
        TemplateEngineUtil.render("articles/show.html", request, response);
    }
}
