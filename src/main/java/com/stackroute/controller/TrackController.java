package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {

    @Autowired
    private TrackService trackService;

    private ResponseEntity responseEntity;
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }



    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        try{
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks(){
        try{
            responseEntity = new ResponseEntity(trackService.getAllTracks(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrackById(@RequestBody int trackId){
        try{
            responseEntity = new ResponseEntity(trackService.deleteTrackById(trackId), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){
        try{
            responseEntity = new ResponseEntity(trackService.updateTrack(track), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
