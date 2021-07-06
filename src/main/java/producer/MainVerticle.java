package producer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/html")
        .end("<h1>Olá Mozaiko!</h1>");
    }).listen(8080, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8080");
      } else {
        startPromise.fail(http.cause());
      }
    });

  }
}
