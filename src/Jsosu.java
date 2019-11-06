import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Jsosu {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("join_date")
    @Expose
    private String joinDate;
    @SerializedName("count300")
    @Expose
    private String count300;
    @SerializedName("count100")
    @Expose
    private String count100;
    @SerializedName("count50")
    @Expose
    private String count50;
    @SerializedName("playcount")
    @Expose
    private String playcount;
    @SerializedName("ranked_score")
    @Expose
    private String rankedScore;
    @SerializedName("total_score")
    @Expose
    private String totalScore;
    @SerializedName("pp_rank")
    @Expose
    private String ppRank;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("pp_raw")
    @Expose
    private String ppRaw;
    @SerializedName("accuracy")
    @Expose
    private String accuracy;
    @SerializedName("count_rank_ss")
    @Expose
    private String countRankSs;
    @SerializedName("count_rank_ssh")
    @Expose
    private String countRankSsh;
    @SerializedName("count_rank_s")
    @Expose
    private String countRankS;
    @SerializedName("count_rank_sh")
    @Expose
    private String countRankSh;
    @SerializedName("count_rank_a")
    @Expose
    private String countRankA;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("total_seconds_played")
    @Expose
    private String totalSecondsPlayed;
    @SerializedName("pp_country_rank")
    @Expose
    private String ppCountryRank;
    @SerializedName("events")
    @Expose
    private List<Object> events = null;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPpRank() {
        return ppRank;
    }

    public String getCountry() {
        return country;
    }

    public String getPpCountryRank() {
        return ppCountryRank;
    }
}