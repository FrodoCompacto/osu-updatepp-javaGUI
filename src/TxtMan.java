import com.google.gson.Gson;

import java.io.*;

public class TxtMan {

    private String id = "0";
    private boolean isCountry = true;
    private int ms;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCountry() {
        return isCountry;
    }

    public void setCountry(boolean country) {
        isCountry = country;
    }

    public int getMs() {
        return ms;
    }

    public static Jsosu[] parseJson(String json) {
        Gson gson = new Gson();

        Jsosu[] jsosu = gson.fromJson(json, Jsosu[].class);

        return jsosu;

    }

    public static String getPosition(String json) throws FileNotFoundException {
        if (retrieveInfo().isCountry) {
            return parseJson(json)[0].getPpCountryRank();
        } else return parseJson(json)[0].getPpRank();
    }

    public static void writeOnTxt(String json) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter("pp.txt", "UTF-8");
        writer.println(getPosition(json));
        writer.close();

    }

    static void saveFile(String id, boolean flag, int delay){
        TxtMan user = new TxtMan();

        user.id = id;
        user.isCountry = flag;
        user.ms = delay;

        Gson gson = new Gson();

        try (FileWriter file = new FileWriter("login.peppy")) {
            gson.toJson(user, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TxtMan retrieveInfo() throws FileNotFoundException {
        BufferedReader leitor = new BufferedReader(new FileReader("login.peppy"));


        Gson gson = new Gson();

        return gson.fromJson(leitor, TxtMan.class);
    }

}
