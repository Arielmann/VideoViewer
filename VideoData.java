package gbuy.subtext.videoplayerjobinterview;

class VideoData {

    private String url;
    private int elapsedTime;

    VideoData(String url, int elapsedTime) {
        this.url = url;
        this.elapsedTime = elapsedTime;
    }

    public String getUrl() {
        return url;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }
}
