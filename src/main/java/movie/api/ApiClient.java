package movie.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import movie.api.vo.BoxOfficeResultVO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class ApiClient {

    @Value("${movie.api.key}")
    private String apiKey;

    public JSONObject callApi(String apiUrl) {
        StringBuilder result = new StringBuilder();
        JSONObject jsonObject = null;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
            String returnLine;

            JSONParser jsonParser = new JSONParser();
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);

                jsonObject = (JSONObject)jsonParser.parse(result.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public <T> T callApi(String apiUrl, Class<T> valueType) {
        JSONObject jsonObject = callApi(apiUrl);
        if (jsonObject != null) {
            ObjectMapper mapper = new ObjectMapper();

            if (valueType==BoxOfficeResultVO.class) {
                try {
                    JSONObject boxoffice = (JSONObject)jsonObject.get("boxOfficeResult");
                    return mapper.readValue(boxoffice.toString(), valueType);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            else {
                try {
                    JSONObject movieInfoResult = (JSONObject) jsonObject.get("movieInfoResult");
//                    System.out.println("movieInfoResult = " + movieInfoResult);
                    JSONObject movieInfo = (JSONObject) movieInfoResult.get("movieInfo");
                    return mapper.readValue(movieInfo.toString(), valueType);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
