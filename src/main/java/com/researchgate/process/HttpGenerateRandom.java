package com.researchgate.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hansmelo
 */
public class HttpGenerateRandom implements GenerateRandom {

    public static final int SIZE = 20;
    private static final String URL = "https://www.random.org/strings/?num=1&len=" + SIZE + "&upperalpha=on&unique=on&format=plain&rnd=new";
    private int sizeNewWord;

    public HttpGenerateRandom(int sizeNewWord) {
        this.sizeNewWord = sizeNewWord;
    }

    @Override
    public String execute() {
        String generateRandom = "";
        if (sizeNewWord > SIZE) {
            return generateRandom;
        }
        try {
            URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in
                        = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                generateRandom = response.toString();
            }
        } catch (IOException ex) {
            Logger.getLogger(HttpGenerateRandom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generateRandom;
    }
}
