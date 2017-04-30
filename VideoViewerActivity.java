package gbuy.subtext.videoplayerjobinterview;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.LinkedList;
import java.util.List;

public class VideoViewerActivity extends AppCompatActivity {

    private VideoView videoView;
    private List<VideoData> videoDataList;
    private VideoViewerModel model;
    private String videoAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setOnCompletionListener(onVideoCompletionListener);
        videoDataList = new LinkedList<>();
        model = new VideoViewerModel();
        Button feedSessionButton = (Button) findViewById(R.id.feedButton);
        feedSessionButton.setOnClickListener(onFeedRequestSent);
        Button closeSessionButton = (Button) findViewById(R.id.closeSessionButton);
        closeSessionButton.setOnClickListener(onClosedSessionButtonClicked);
    }

    private void playVideo(String videoUrl) {
        Uri vidUri = Uri.parse(videoUrl);
        videoView.setVideoURI(vidUri);
        videoView.start();
    }

    private View.OnClickListener onFeedRequestSent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (int i = 0; i <= 200; i++) {
                VideoData videoData = new VideoData(videoAddress, 0);
                videoDataList.add(videoData);
            }
            playVideo(videoDataList.get(0).getUrl());
        }
    };

    View.OnClickListener onClosedSessionButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (model.getWatchedVideos() >= 20) {
                Toast.makeText(v.getContext(), "Session ended", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(v.getContext(), "Current session is not yet finished",
                        Toast.LENGTH_LONG).show();
            }
        }
    };

    MediaPlayer.OnCompletionListener onVideoCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            model.setWatchedVideos(model.getWatchedVideos() + 1);

            if (videoDataList.get(model.getCurrentVideoIndex() + 1) != null) {
                model.setCurrentVideoIndex(model.getCurrentVideoIndex() + 1);
            }

            playVideo(videoDataList.get(model.getCurrentVideoIndex()).getUrl());
        }
    };
}
