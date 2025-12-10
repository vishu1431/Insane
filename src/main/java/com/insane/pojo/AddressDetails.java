package com.insane.pojo;

import lombok.Data;

@Data
public class AddressDetails {
    private String tempAddress;
    private String permanentAddress;
    private String city;
    private String state;
    private String pincode;
  }
