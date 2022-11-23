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
    /**
     * <p>Search for the red metro line by the current time</p>
     * @return instance of RedLine class
     * @since 1.0
     */
    RedLine getRedLineByCurrentTime();
    /**
     * <p>Search for the green metro line by the current time</p>
     * @return instance of GreenLine class
     * @since 1.0
     */
    GreenLine getGreenLineByCurrentTime();
    /**
     * <p>Search for the blue metro line by the current time</p>
     * @return instance of BlueLine class
     * @since 1.0
     */
    BlueLine getBlueLineByCurrentTime();
}
