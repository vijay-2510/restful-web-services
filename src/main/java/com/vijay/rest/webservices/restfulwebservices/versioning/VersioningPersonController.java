package com.vijay.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	// URI Versioning
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Vijay");
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Vijay", "Pandey"));
	}

	// Request Param Versioning
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Hello Vijay from Request Param V1");
	}

	@GetMapping(path = "person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParam() {
		return new PersonV2(new Name("Vijay", "Pandey"));
	}

	// Custom Header Versioning
	@GetMapping(path = "/person", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonUsingHeader() {
		return new PersonV1("Hello Vijay from Header V1");
	}

	@GetMapping(path = "/person", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonUsingHeader() {
		return new PersonV2(new Name("Vijay", "Pandey"));
	}

	// Media Type Versioning
	@GetMapping(path = "/person", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonUsingAcceptHeader() {
		return new PersonV1("Hello Vijay from Accept Header V1");
	}

	@GetMapping(path = "/person", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonUsingAcceptHeader() {
		return new PersonV2(new Name("Vijay", "Pandey"));
	}

}
