package com.example.khaerulumam.submissionexpert4.nav;

import com.androidnetworking.error.ANError;

public interface FilmSQLiteNavigator {
    void handleError(Throwable throwable);
    void handleErrorNetwork(ANError error);
    void error(String eror);
}
