package com.utils;

import com.figures.Figure;
import com.game_mech.actions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceDispatch {
    private Figure currentFigure;

    public ResponseEntity getResponse(String action) {
        switch (action) {
            case "getFigure":
                return execute(new GetFigure());
            case "moveLeft":
                return execute(new MoveLeft(currentFigure));
            case "moveRight":
                return execute(new MoveRight(currentFigure));
            case "down":
                return executeFall(new Down(currentFigure));
            case "fullDown":
                return executeFall(new FullDown(currentFigure));
            case "turnLeft":
                return execute(new TurnLeft(currentFigure));
            case "turnRight":
                return execute(new TurnRight(currentFigure));
            default:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    private ResponseEntity execute(Actions actions) {
        try {
            currentFigure = actions.performAction();
        } catch (ActionException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(currentFigure);
    }

    private ResponseEntity executeFall(Actions actions) {
        try {
            currentFigure = actions.performAction();
        } catch (ActionException e) {
            return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
        }
        return ResponseEntity.ok(currentFigure);
    }
}
