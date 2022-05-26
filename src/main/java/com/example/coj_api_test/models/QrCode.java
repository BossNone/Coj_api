package com.example.coj_api_test.models;

import java.util.List;

public class QrCode {
    private List<String> timestamp;
    private List<Long> count;

    public QrCode(List<String> timestamp, List<Long> count) {
        this.timestamp = timestamp;
        this.count = count;
    }

    public List<String> getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(List<String> timestamp) {
        this.timestamp = timestamp;
    }

    public List<Long> getCount() {
        return count;
    }

    public void setCount(List<Long> count) {
        this.count = count;
    }
}
