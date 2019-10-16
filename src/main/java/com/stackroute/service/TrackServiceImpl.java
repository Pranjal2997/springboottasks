package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{
    private TrackRepository trackRepository;
    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track deleteTrackById(int trackId) throws TrackNotFoundException{
        Optional<Track > track = trackRepository.findById(trackId);
        if (track.isPresent()){
            trackRepository.deleteById(trackId);
            return track.get();
        }else{
            throw new TrackNotFoundException("Cannot find track");
        }
    }

    @Override
    public Track updateTrack(Track track) {
        Optional<Track> savedTrack = trackRepository.findById(track.getTrackId());
        if(savedTrack.isPresent()){
            Track updatedTrack = savedTrack.get();
            updatedTrack.setTrackComments(track.getTrackComments());
            trackRepository.save(updatedTrack);
            return updatedTrack;
        }else{
            return null;
        }
    }

    @Override
    public List<Track> findTrackByName(String trackName) throws TrackNotFoundException {
        return trackRepository.findAll();
    }
}
