package com;

import com.utils.ServiceDispatch;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private ServiceDispatch dispatch;

    public MainController(ServiceDispatch dispatch) {
        this.dispatch = dispatch;
    }

    @GetMapping("/")
    public String indexGet() {
        //my html file
        return "index";
    }

    @GetMapping("/game")
    public String getGame() {
        return "game";
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity postGame(String action) {
        return dispatch.getResponse(action);
    }
}
