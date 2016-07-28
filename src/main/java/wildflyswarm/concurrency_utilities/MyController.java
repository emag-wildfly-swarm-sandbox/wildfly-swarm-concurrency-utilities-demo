package wildflyswarm.concurrency_utilities;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
@Path("/")
public class MyController {

  @Resource(lookup = "java:jboss/ee/concurrency/executor/default")
  private ManagedExecutorService executor;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String get() {
    System.out.println("Before execute");

    executor.execute(() -> {
      System.out.println("Async Task is start.");
      try {
        System.out.println("Async Task is waiting.");
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException ignore) {}
      System.out.println("Async Task is end.");
    });

    System.out.println("After execute");

    return "{\"value\":\"Async Hello\"}";
  }

}
