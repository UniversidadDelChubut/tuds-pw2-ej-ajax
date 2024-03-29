package app.util.helpers;

import java.util.Map;
import org.javalite.activeweb.AppContext;
import org.javalite.common.Convert;
import org.javalite.common.JsonHelper;
import org.javalite.common.Util;
import org.javalite.http.Http;
import org.javalite.http.Post;

// https://developers.google.com/recaptcha/docs/v3
public class RecaptchaV3Helper {
    private static String PRIVATE_KEY; 
    private static String URL;
    private static final Double DEFAULT_THRESHOLD = 0.5;

    public RecaptchaV3Helper(AppContext ac) {
        PRIVATE_KEY = (String)ac.get("recaptcha_private_key");
        URL = (String)ac.get("recaptcha_url");
    }
    
    public void verify(String gRecaptchaResponse) {
        verify(gRecaptchaResponse, DEFAULT_THRESHOLD);
    }

    public void verify(String gRecaptchaResponse, Double threshold) {
        if (Util.blank(gRecaptchaResponse)) {
            throw new IllegalArgumentException("Falta el token recaptcha a verificar");
        }

        Post post = Http.post(URL)
                .header("Content-type", "application/x-www-form-urlencoded")
                .param("secret", PRIVATE_KEY)
                .param("response", gRecaptchaResponse);

        String res = post.text();
        
        Map res_json = JsonHelper.toMap(res);

        boolean success = Convert.toBoolean(res_json.get("success"));
        Double score = Convert.toDouble(res_json.get("score"));

        if(!success || score == null || score < threshold) {
            throw new RuntimeException(res);
        }

    }
}
