package com.ally.assignment.unicorn.controller;

import com.ally.assignment.unicorn.error.ResourceNotFoundException;
import com.ally.assignment.unicorn.model.Unicorn;
import com.ally.assignment.unicorn.responseVo.UnicornVo;
import com.ally.assignment.unicorn.service.UnicornService;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UnicornController {

    @Autowired
    UnicornService unicornService;

    @PostMapping(path = "/unicorns")
    public ResponseEntity<String> createUnicornResource(@RequestBody Unicorn unicorn) throws JSONException {
        JSONObject response = new JSONObject();
        response.put("unicornId",unicornService.createUnicornResource(unicorn));
        return new ResponseEntity<>(response.toString(), HttpStatus.CREATED);
    }

    @PutMapping(path = "/unicorns/{id}")
    public ResponseEntity<?> createUnicornResource(@PathVariable(value = "id") Long unicornId, @RequestBody Unicorn unicorn) {
        unicornService.updateUnicornResource(unicornId, unicorn);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/unicorns")
    public ResponseEntity<List<UnicornVo>> getAllUnicornResource() {
        return new ResponseEntity<List<UnicornVo>>(unicornService.getAllUnicornResource(), HttpStatus.OK);

    }

    @GetMapping(path = "/unicorns/{id}")
    public ResponseEntity<UnicornVo> getUnicornById(@PathVariable(value = "id") Long unicornId) {
        UnicornVo unicornVo = unicornService.getUnicornById(unicornId);
        if (unicornVo == null) {
            throw new ResourceNotFoundException(unicornId);
        } else {
            return new ResponseEntity<>(unicornVo, HttpStatus.OK);
        }
    }

}
