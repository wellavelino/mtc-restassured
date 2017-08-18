package omdb.Helpers;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

/**
 * Created by wellingtonsantos on 8/18/17.
 */
public class JsonFactory {

    public static String convertStringToJson(String value) throws IOException {
        URL file = Resources.getResource("assets/" + value);
        return Resources.toString(file, Charsets.UTF_8);
    }

}

