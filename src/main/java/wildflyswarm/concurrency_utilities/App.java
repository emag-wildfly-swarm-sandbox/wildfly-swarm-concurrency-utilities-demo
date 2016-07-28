package wildflyswarm.concurrency_utilities;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class App {

  public static void main(String[] args) throws Exception {
    Container container = new Container();

    JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
    deployment.addPackage(App.class.getPackage());

    container.start().deploy(deployment);
  }

}
