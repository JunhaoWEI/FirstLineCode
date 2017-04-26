package com.example.service;

/**
 * Created by weijunhao on 2017/4/26.
 */

public interface DownLoadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
