package com.stackroute.service;

import com.stackroute.domain.Track;

import java.io.IOException;
import java.util.List;

public interface TrackService {


    public List<Track> getAllTracks();

    public Track saveTrack(Track track);

    public Track deleteTrackById(int trackId);

    public Track updateTrack(Track track);
}
