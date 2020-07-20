package com.salpe.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MyRestControler {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = MyDetails.class)) ),
            @ApiResponse(responseCode = "400", description = "Invalid name supplied"),
            @ApiResponse(responseCode = "404", description = "Object not found")})
    @Operation(summary = "summary an existing object", description = "description an existing object")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/hello" , produces = { "application/json" })
    public MyDetails sayHello(@Parameter(name = "name") String name){
        MyDetails myDetails = new MyDetails();
        myDetails.setName("Hello " + name);
        return myDetails;
    }
}

