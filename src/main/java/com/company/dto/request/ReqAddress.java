package com.company.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
@Data
@AllArgsConstructor
public class ReqAddress {
    private String country;
    private String city;
    private String street;
    private String postalCode;
}
