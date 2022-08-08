package com.example.demo.api;

import ru.redcom.lib.integration.api.client.dadata.DaDataClient;
import ru.redcom.lib.integration.api.client.dadata.DaDataClientFactory;
import ru.redcom.lib.integration.api.client.dadata.DaDataException;
import ru.redcom.lib.integration.api.client.dadata.dto.Address;

public class ApiDadata {

    private static final String API_KEY="5c35012ae18b15896ce86d33403bc537d502ce36";
    private static final String SECRET_KEY = "6f2d83c33f9e61a764dd1371b28c069813e6b13d";
    private final DaDataClient dadata= DaDataClientFactory.getInstance(API_KEY,SECRET_KEY);
    public Address cleanAddress(final String source) throws DaDataException {
        final Address a=dadata.cleanAddress(source);
        return a;
    }
}
