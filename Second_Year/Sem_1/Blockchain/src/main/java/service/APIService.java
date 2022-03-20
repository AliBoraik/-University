package service;

import Models.BlockModel;
import Models.NewBlockResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class APIService {

    public APIService() {
    }

    public void sendBlock(BlockModel blockModel) {
        try {
            URL url = new URL("http://188.93.211.195/dis/newblock?block=" +
                    URLEncoder.encode(blockModel.toString(), StandardCharsets.UTF_8));

            System.out.println(url);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            int rcode = con.getResponseCode();

            if (rcode == 200) {

                ObjectMapper mapper = new ObjectMapper();
                NewBlockResponse blockResponse =
                        mapper.readValue(con.getInputStream(), NewBlockResponse.class);

                System.out.println(blockResponse);
            } else {
                System.out.println("response code = " + rcode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Отправка блока
    public BlockModel[] getBlockChain() {
        try {
            URL url = new URL("http://188.93.211.195/dis/chain");

            System.out.println(url);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            int rcode = con.getResponseCode();

            if (rcode == 200) {

                ObjectMapper mapper = new ObjectMapper();
                BlockModel[] blocks =
                        mapper.readValue(con.getInputStream(), BlockModel[].class);
                System.out.println(blocks.length);
                return blocks;
            } else {
                System.out.println("response code = " + rcode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
