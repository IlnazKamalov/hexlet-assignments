package exercise.controllers;

import exercise.domain.User;
import exercise.domain.query.QUser;
import io.ebean.DB;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

import java.util.List;

public class UserController implements CrudHandler {

    public void getAll(Context ctx) {
        List<User> users = new QUser()
                .orderBy()
                .id.asc()
                .findList();

        String json = DB.json().toJson(users);
        ctx.json(json);
    };

    public void getOne(Context ctx, String id) {

        User user = new QUser()
                .id.equalTo(Integer.parseInt(id))
                .findOne();

        String json = DB.json().toJson(user);
        ctx.json(json);
    };

    public void create(Context ctx) {
        String body = ctx.body();
        User user = DB.json().toBean(User.class, body);
        user.save();
    };

    public void update(Context ctx, String id) {
        String body = ctx.body();
        User user = DB.json().toBean(User.class, body);
        user.setId(id);
        user.update();
    };

    public void delete(Context ctx, String id) {
        new QUser()
                .id.equalTo(Integer.parseInt(id))
                .delete();
    };
}
