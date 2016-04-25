import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }
  @ClassRule
 public static ServerRule server = new ServerRule();

 @Test
public void rootTest() {
  goTo("http://localhost:4567/");
  assertThat(pageSource()).contains("Shipping Calculator");
}

@Test
public void costToShip() {
  goTo("http://localhost:4567/");
  fill("#length").with("3");
  fill("#width").with("3");
  fill("#height").with("3");
  fill("#weight").with("6");
  fill("#distance").with("200");
  submit(".btn");
  assertThat(pageSource()).contains("Your total cost to ship is:");
}
}
