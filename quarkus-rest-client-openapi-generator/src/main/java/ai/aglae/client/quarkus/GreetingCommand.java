package ai.aglae.client.quarkus;

import org.openapi.quarkus.openapi_json.model.JobSeekerInputDto;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "greeting", mixinStandardHelpOptions = true)
public class GreetingCommand implements Runnable {

    @Parameters(paramLabel = "<name>", defaultValue = "picocli",
        description = "Your name.")
    String name;

    @Override
    public void run() {
        System.out.printf("Hello %s, go go commando!\n", name);
        JobSeekerInputDto jobSeekerInputDto = new JobSeekerInputDto();
    }

}
