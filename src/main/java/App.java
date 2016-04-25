import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/total", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      double length = Double.parseDouble(request.queryParams("length"));
      double width = Double.parseDouble(request.queryParams("width"));
      double height = Double.parseDouble(request.queryParams("height"));
      double weight = Double.parseDouble(request.queryParams("weight"));
      double distance = Double.parseDouble(request.queryParams("distance"));

      Parcels myParcels = new Parcels(length, width, height, weight, distance);
      model.put("myParcels", myParcels);

      model.put("template", "templates/total.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
