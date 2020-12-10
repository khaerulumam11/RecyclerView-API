package com.example.khaerulumam.submissionexpert4.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailTVShowModel {

    @Expose
    @SerializedName("vote_count")
    private int voteCount;
    @Expose
    @SerializedName("vote_average")
    private double voteAverage;
    @Expose
    @SerializedName("type")
    private String type;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("seasons")
    private List<SeasonsEntity> seasons;
    @Expose
    @SerializedName("production_companies")
    private List<ProductionCompaniesEntity> productionCompanies;
    @Expose
    @SerializedName("poster_path")
    private String posterPath;
    @Expose
    @SerializedName("popularity")
    private double popularity;
    @Expose
    @SerializedName("overview")
    private String overview;
    @Expose
    @SerializedName("original_name")
    private String originalName;
    @Expose
    @SerializedName("original_language")
    private String originalLanguage;
    @Expose
    @SerializedName("origin_country")
    private List<String> originCountry;
    @Expose
    @SerializedName("number_of_seasons")
    private int numberOfSeasons;
    @Expose
    @SerializedName("number_of_episodes")
    private int numberOfEpisodes;
    @Expose
    @SerializedName("networks")
    private List<NetworksEntity> networks;
    @Expose
    @SerializedName("next_episode_to_air")
    private NextEpisodeToAirEntity nextEpisodeToAir;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("last_episode_to_air")
    private LastEpisodeToAirEntity lastEpisodeToAir;
    @Expose
    @SerializedName("last_air_date")
    private String lastAirDate;
    @Expose
    @SerializedName("languages")
    private List<String> languages;
    @Expose
    @SerializedName("in_production")
    private boolean inProduction;
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("homepage")
    private String homepage;
    @Expose
    @SerializedName("genres")
    private List<GenresEntity> genres;
    @Expose
    @SerializedName("first_air_date")
    private String firstAirDate;
    @Expose
    @SerializedName("episode_run_time")
    private List<Integer> episodeRunTime;
    @Expose
    @SerializedName("created_by")
    private List<CreatedByEntity> createdBy;
    @Expose
    @SerializedName("backdrop_path")
    private String backdropPath;

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SeasonsEntity> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SeasonsEntity> seasons) {
        this.seasons = seasons;
    }

    public List<ProductionCompaniesEntity> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompaniesEntity> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public List<NetworksEntity> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworksEntity> networks) {
        this.networks = networks;
    }

    public NextEpisodeToAirEntity getNextEpisodeToAir() {
        return nextEpisodeToAir;
    }

    public void setNextEpisodeToAir(NextEpisodeToAirEntity nextEpisodeToAir) {
        this.nextEpisodeToAir = nextEpisodeToAir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LastEpisodeToAirEntity getLastEpisodeToAir() {
        return lastEpisodeToAir;
    }

    public void setLastEpisodeToAir(LastEpisodeToAirEntity lastEpisodeToAir) {
        this.lastEpisodeToAir = lastEpisodeToAir;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public boolean getInProduction() {
        return inProduction;
    }

    public void setInProduction(boolean inProduction) {
        this.inProduction = inProduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public List<GenresEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresEntity> genres) {
        this.genres = genres;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    public void setEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    public List<CreatedByEntity> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(List<CreatedByEntity> createdBy) {
        this.createdBy = createdBy;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public static class SeasonsEntity {
        @Expose
        @SerializedName("season_number")
        private int seasonNumber;
        @Expose
        @SerializedName("poster_path")
        private String posterPath;
        @Expose
        @SerializedName("overview")
        private String overview;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("episode_count")
        private int episodeCount;
        @Expose
        @SerializedName("air_date")
        private String airDate;

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(int seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEpisodeCount() {
            return episodeCount;
        }

        public void setEpisodeCount(int episodeCount) {
            this.episodeCount = episodeCount;
        }

        public String getAirDate() {
            return airDate;
        }

        public void setAirDate(String airDate) {
            this.airDate = airDate;
        }
    }

    public static class ProductionCompaniesEntity {
        @Expose
        @SerializedName("origin_country")
        private String originCountry;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("logo_path")
        private String logoPath;
        @Expose
        @SerializedName("id")
        private int id;

        public String getOriginCountry() {
            return originCountry;
        }

        public void setOriginCountry(String originCountry) {
            this.originCountry = originCountry;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(String logoPath) {
            this.logoPath = logoPath;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class NetworksEntity {
        @Expose
        @SerializedName("origin_country")
        private String originCountry;
        @Expose
        @SerializedName("logo_path")
        private String logoPath;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("name")
        private String name;

        public String getOriginCountry() {
            return originCountry;
        }

        public void setOriginCountry(String originCountry) {
            this.originCountry = originCountry;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(String logoPath) {
            this.logoPath = logoPath;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class NextEpisodeToAirEntity {
        @Expose
        @SerializedName("vote_count")
        private int voteCount;
        @Expose
        @SerializedName("vote_average")
        private int voteAverage;
        @Expose
        @SerializedName("show_id")
        private int showId;
        @Expose
        @SerializedName("season_number")
        private int seasonNumber;
        @Expose
        @SerializedName("production_code")
        private String productionCode;
        @Expose
        @SerializedName("overview")
        private String overview;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("episode_number")
        private int episodeNumber;
        @Expose
        @SerializedName("air_date")
        private String airDate;

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public int getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(int voteAverage) {
            this.voteAverage = voteAverage;
        }

        public int getShowId() {
            return showId;
        }

        public void setShowId(int showId) {
            this.showId = showId;
        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(int seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public String getProductionCode() {
            return productionCode;
        }

        public void setProductionCode(String productionCode) {
            this.productionCode = productionCode;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEpisodeNumber() {
            return episodeNumber;
        }

        public void setEpisodeNumber(int episodeNumber) {
            this.episodeNumber = episodeNumber;
        }

        public String getAirDate() {
            return airDate;
        }

        public void setAirDate(String airDate) {
            this.airDate = airDate;
        }
    }

    public static class LastEpisodeToAirEntity {
        @Expose
        @SerializedName("vote_count")
        private int voteCount;
        @Expose
        @SerializedName("vote_average")
        private int voteAverage;
        @Expose
        @SerializedName("still_path")
        private String stillPath;
        @Expose
        @SerializedName("show_id")
        private int showId;
        @Expose
        @SerializedName("season_number")
        private int seasonNumber;
        @Expose
        @SerializedName("production_code")
        private String productionCode;
        @Expose
        @SerializedName("overview")
        private String overview;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("episode_number")
        private int episodeNumber;
        @Expose
        @SerializedName("air_date")
        private String airDate;

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public int getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(int voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getStillPath() {
            return stillPath;
        }

        public void setStillPath(String stillPath) {
            this.stillPath = stillPath;
        }

        public int getShowId() {
            return showId;
        }

        public void setShowId(int showId) {
            this.showId = showId;
        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(int seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public String getProductionCode() {
            return productionCode;
        }

        public void setProductionCode(String productionCode) {
            this.productionCode = productionCode;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEpisodeNumber() {
            return episodeNumber;
        }

        public void setEpisodeNumber(int episodeNumber) {
            this.episodeNumber = episodeNumber;
        }

        public String getAirDate() {
            return airDate;
        }

        public void setAirDate(String airDate) {
            this.airDate = airDate;
        }
    }

    public static class GenresEntity {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class CreatedByEntity {
        @Expose
        @SerializedName("profile_path")
        private String profilePath;
        @Expose
        @SerializedName("gender")
        private int gender;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("credit_id")
        private String creditId;
        @Expose
        @SerializedName("id")
        private int id;

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
