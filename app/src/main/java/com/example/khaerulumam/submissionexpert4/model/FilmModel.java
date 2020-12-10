package com.example.khaerulumam.submissionexpert4.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmModel {

    @Expose
    @SerializedName("results")
    private List<ResultsEntity> results;
    @Expose
    @SerializedName("total_pages")
    private int totalPages;
    @Expose
    @SerializedName("total_results")
    private int totalResults;
    @Expose
    @SerializedName("page")
    private int page;

    public List<ResultsEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public static class ResultsEntity {
        @Expose
        @SerializedName("release_date")
        private String releaseDate;
        @Expose
        @SerializedName("overview")
        private String overview;
        @Expose
        @SerializedName("vote_average")
        private double voteAverage;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("genre_ids")
        private List<Integer> genreIds;
        @Expose
        @SerializedName("original_title")
        private String originalTitle;
        @Expose
        @SerializedName("original_language")
        private String originalLanguage;
        @Expose
        @SerializedName("backdrop_path")
        private String backdropPath;
        @Expose
        @SerializedName("adult")
        private boolean adult;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("poster_path")
        private String posterPath;
        @Expose
        @SerializedName("video")
        private boolean video;
        @Expose
        @SerializedName("vote_count")
        private int voteCount;
        @Expose
        @SerializedName("popularity")
        private double popularity;

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public boolean getVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }
    }
}
