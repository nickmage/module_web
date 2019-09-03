package com.game_mech.actions;

import com.figures.Figure;
import com.utils.ActionException;

public interface Actions {
    Figure performAction() throws ActionException;
}
