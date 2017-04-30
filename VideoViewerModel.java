package gbuy.subtext.videoplayerjobinterview;

class VideoViewerModel {

    private int watchedVideos;
    private int currentVideoIndex;

    VideoViewerModel() {
        this.watchedVideos = 0;
        this.currentVideoIndex = 0;
    }

    public int getCurrentVideoIndex() {
        return currentVideoIndex;
    }

    int getWatchedVideos() {
        return watchedVideos;
    }

    public void setCurrentVideoIndex(int currentVideo) {
        this.currentVideoIndex = currentVideo;
    }

    public void setWatchedVideos(int watchedVideos) {
        this.watchedVideos = watchedVideos;
    }
}
