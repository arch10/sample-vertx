package com.example.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class ExampleVerticle extends AbstractVerticle {
    public static void main(String args[]) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new ExampleVerticle());
    }

    @Override public void start() throws Exception {
        super.start();

        Router router = Router.router(vertx);

        HttpServer httpServer = vertx.createHttpServer();

        router.route().handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "text/plain");

            // Write to the response and end it
            response.end("Hello Falcon Team ! Welcome to Project Falcon!!");
        });

        httpServer.requestHandler(router).listen(8080);
    }
}
