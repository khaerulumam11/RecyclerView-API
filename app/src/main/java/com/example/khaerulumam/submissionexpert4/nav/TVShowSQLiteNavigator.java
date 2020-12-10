package com.example.khaerulumam.submissionexpert4.nav;

import com.androidnetworking.error.ANError;

public interface TVShowSQLiteNavigator {
    void handleError(Throwable throwable);
    void handleErrorNetwork(ANError error);
    void error(String eror);
}
