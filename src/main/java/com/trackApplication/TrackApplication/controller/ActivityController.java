package com.trackApplication.TrackApplication.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trackApplication.TrackApplication.model.ActivityModel;
import com.trackApplication.TrackApplication.services.ActivityServices;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityServices activityServices;
    
    @GetMapping("/all")
    public List<ActivityModel> getAllActivity() {
        return activityServices.getAllActivities();
    }

    @GetMapping("/pending")
    public List<ActivityModel> getPendingActivity() {
        return activityServices.getPendingActivities();
    }

    @PostMapping()
    public List<ActivityModel> postActivity(@RequestBody ActivityModel activityModel) {
        return Collections.singletonList(activityServices.addActivity(activityModel));
    }

    @PostMapping("/done/{id}")
    public List<Optional<ActivityModel>> markActivityDone(@PathVariable UUID id) {
        return Collections.singletonList(activityServices.markActivityDone(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String,UUID>> deleteActivity(@PathVariable UUID id) {
        activityServices.deleteActivity(id);
        return new ResponseEntity<>(new HashMap<String, UUID>() {{
            put("id", id);
        }}, HttpStatus.OK);
    }
}
