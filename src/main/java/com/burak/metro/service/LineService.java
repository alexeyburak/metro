package com.burak.metro.service;

import com.burak.metro.model.BlueLine;
import com.burak.metro.model.GreenLine;
import com.burak.metro.model.RedLine;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public interface LineService {
    RedLine getRedLineByCurrentTime();
    GreenLine getGreenLineByCurrentTime();
    BlueLine getBlueLineByCurrentTime();
}
