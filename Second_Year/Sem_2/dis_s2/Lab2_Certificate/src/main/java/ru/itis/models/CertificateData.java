package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CertificateData {

    private String country_Name;
    private String state;
    private String city;
    private String organization;
    private String Common;
    private String email_Address;
}
