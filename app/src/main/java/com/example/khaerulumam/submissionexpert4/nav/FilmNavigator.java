package com.example.khaerulumam.submissionexpert4.nav;

import com.androidnetworking.error.ANError;

public interface FilmNavigator {
    void handleError(Throwable throwable);
    void handleErrorNetwork(ANError error);
    void error(String eror);
}
