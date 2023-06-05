package com.burak.metro.service;

import com.burak.metro.model.BlueLine;
import com.burak.metro.model.GreenLine;
import com.burak.metro.model.RedLine;

public interface LineService {
    /**
     * <p>Search for the red metro line by the current time</p>
     * @return instance of RedLine class
     * @since 1.0
     */
    RedLine getRedLineByLocalTime();
    /**
     * <p>Search for the green metro line by the current time</p>
     * @return instance of GreenLine class
     * @since 1.0
     */
    GreenLine getGreenLineByLocalTime();
    /**
     * <p>Search for the blue metro line by the current time</p>
     * @return instance of BlueLine class
     * @since 1.0
     */
    BlueLine getBlueLineByLocalTime();
}
