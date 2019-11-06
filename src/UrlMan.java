import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlMan {

    public static String readUrl(String stringUrl) throws Exception {
        BufferedReader leitor = null;
        try {
            URL url = new URL(stringUrl);
            leitor = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int ler;
            char[] chars = new char[1024];
            while ((ler = leitor.read(chars)) != -1)
                buffer.append(chars, 0, ler);

            return buffer.toString();
        } finally {
            if (leitor != null)
                leitor.close();
        }
    }
}
