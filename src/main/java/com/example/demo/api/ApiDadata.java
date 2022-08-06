package com.example.demo.api;

import ru.redcom.lib.integration.api.client.dadata.DaDataClient;
import ru.redcom.lib.integration.api.client.dadata.DaDataClientFactory;
import ru.redcom.lib.integration.api.client.dadata.DaDataException;
import ru.redcom.lib.integration.api.client.dadata.dto.Address;

public class ApiDadata {

    private static final String API_KEY="e95ad9803e084e983fb35708f21612d3370af2f0";
    private static final String SECRET_KEY = "4d32436251fbd76728fa04e0b175a9f3aab2c0e3";
    private final DaDataClient dadata= DaDataClientFactory.getInstance(API_KEY,SECRET_KEY);
    public Address cleanAddress(final String source) throws DaDataException {
        final Address a=dadata.cleanAddress(source);
        return a;
    }
}
