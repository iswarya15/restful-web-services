package com.in28minutes.rest.webservices.restful_web_services.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class VersioningPersonSbiController {

    @GetMapping(value = "/{version}/personsbi", version = "1.0.0")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Iswarya Chelliah");
    }

    @GetMapping(value="/{version}/personsbi", version = "2.0.0")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Iswarya", "Chelliah"));
    }

    @GetMapping(path = "/personsbi", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("Iswarya Chelliah");
    }

    @GetMapping(path = "/personsbi", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Name("Iswarya", "Chelliah"));
    }

    @GetMapping(path="/personsbi/headers", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        return new PersonV1("Iswarya Chelliah");
    }
}
