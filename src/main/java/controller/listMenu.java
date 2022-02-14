package controller;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Command(name="listMenu")
public class listMenu implements Runnable{

    @Option(names = "--server-url", description = "Server called.")
    private String server = "https://menuserverclient.herokuapp.com/";

    @Override
    public void run() {

        try {
                        // create a client
            var client = HttpClient.newHttpClient();

            // create a request
            var request = HttpRequest.newBuilder(
                            URI.create(this.server + "/menus"))
                    .GET()
                    .header("accept", "application/json")
                    .build();

            // use the client to send the request
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            }
        catch (IOException e) {
        }
        catch (InterruptedException e) {
        }

    }
    
}
