package com.example.khaerulumam.submissionexpert4.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailFilmModel {

    @Expose
    @SerializedName("vote_count")
    private int voteCount;
    @Expose
    @SerializedName("vote_average")
    private double voteAverage;
    @Expose
    @SerializedName("video")
    private boolean video;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("tagline")
    private String tagline;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("spoken_languages")
    private List<SpokenLanguagesEntity> spokenLanguages;
    @Expose
    @SerializedName("runtime")
    private int runtime;
    @Expose
    @SerializedName("revenue")
    private int revenue;
    @Expose
    @SerializedName("release_date")
    private String releaseDate;
    @Expose
    @SerializedName("production_countries")
    private List<ProductionCountriesEntity> productionCountries;
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
    @SerializedName("original_title")
    private String originalTitle;
    @Expose
    @SerializedName("original_language")
    private String originalLanguage;
    @Expose
    @SerializedName("imdb_id")
    private String imdbId;
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
    @SerializedName("budget")
    private int budget;
    @Expose
    @SerializedName("belongs_to_collection")
    private BelongsToCollectionEntity belongsToCollection;
    @Expose
    @SerializedName("backdrop_path")
    private String backdropPath;
    @Expose
    @SerializedName("adult")
    private boolean adult;

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

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SpokenLanguagesEntity> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguagesEntity> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<ProductionCountriesEntity> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountriesEntity> productionCountries) {
        this.productionCountries = productionCountries;
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

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public BelongsToCollectionEntity getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(BelongsToCollectionEntity belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public static class SpokenLanguagesEntity {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("iso_639_1")
        private String iso6391;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }
    }

    public static class ProductionCountriesEntity {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("iso_3166_1")
        private String iso31661;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso31661() {
            return iso31661;
        }

        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
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

    public static class BelongsToCollectionEntity {
        @Expose
        @SerializedName("backdrop_path")
        private String backdropPath;
        @Expose
        @SerializedName("poster_path")
        private String posterPath;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
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
    }
}
