package com.burak.metro.controller;

import com.burak.metro.dto.LineIntervalResponse;
import com.burak.metro.exception.ApiException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Lines")
@RequestMapping("/lines")
public interface LineController {

    @Operation(summary = "Get red line interval")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get interval",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = LineIntervalResponse.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ApiException.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Line is not found",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ApiException.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ApiException.class
                                            )
                                    )
                            }
                    )
            }
    )
    @GetMapping("/red")
    ResponseEntity<LineIntervalResponse> redLineInfo();

    @Operation(summary = "Get blue line interval")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get interval",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = LineIntervalResponse.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ApiException.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Line is not found",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ApiException.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ApiException.class
                                            )
                                    )
                            }
                    )
            }
    )
    @GetMapping("/blue")
    ResponseEntity<LineIntervalResponse> blueLineInfo();

    @Operation(summary = "Get green line interval")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get interval",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = LineIntervalResponse.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ApiException.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Line is not found",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ApiException.class
                                            )
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    implementation = ApiException.class
                                            )
                                    )
                            }
                    )
            }
    )
    @GetMapping("/green")
    ResponseEntity<LineIntervalResponse> greenLineInfo();

}
