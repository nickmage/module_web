package com.utils;

import com.figures.Figure;
import com.figures.FigureFactory;
import com.game_mech.GameService;
import com.game_mech.actions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceDispatch {

    private String action;
    private ResponseEntity responseEntity;
    private FigureFactory figureFactory;
    private GameService gameService;
    private Figure currentFigure;

    public ServiceDispatch(FigureFactory figureFactory, GameService gameService) {
        this.figureFactory = figureFactory;
        this.gameService = gameService;
    }

    public ResponseEntity getResponse(String action){
        if (action.equals("getFigure")) {
            try {
                currentFigure = new GetFigure().performAction();
            } catch (ActionException e) {
                return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
            }
            return ResponseEntity.ok(currentFigure);
        } else if (action.equals("moveLeft")){
            try {
                currentFigure = new MoveLeft(currentFigure).performAction();
            } catch (ActionException e) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(currentFigure);
        }else if (action.equals("moveRight")){
            try {
                currentFigure = new MoveRight(currentFigure).performAction();
            } catch (ActionException e) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(currentFigure);
        }else if (action.equals("down")){
            try {
                currentFigure = new Down(currentFigure).performAction();
            } catch (ActionException e) {
                return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
            }
            return ResponseEntity.ok(currentFigure);
        } else if (action.equals("fullDown")){
            try {
                currentFigure = new FullDown(currentFigure).performAction();
            } catch (ActionException e) {
                return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
            }
            return ResponseEntity.ok(currentFigure);
        } else




            return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

}
