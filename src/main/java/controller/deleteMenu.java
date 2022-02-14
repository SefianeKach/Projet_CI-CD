package controller;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Command(name="deleteMenu")
public class deleteMenu implements Runnable{

    @Option(names = "--server-url", description = "Server called.")
    private String server = "https://menuserverclient.herokuapp.com/";

    @Parameters(description="menu to delete")
    private String idMenu;

    @Override
    public void run() {
        try {
                
            // génére le clien
            var client = HttpClient.newHttpClient();

            // envoie un request
            var request = HttpRequest.newBuilder(
                            URI.create(this.server + "/menus/" + this.idMenu))
                    .DELETE()
                    .build();

            //  utilise le client pour
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (IOException e) {
            }
            catch (InterruptedException e) {
            }

    }
}
