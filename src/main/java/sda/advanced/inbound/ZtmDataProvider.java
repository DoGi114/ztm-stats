package sda.advanced.inbound;

import sda.advanced.model.ZtmData;

import java.util.Optional;

public class ZtmDataProvider {
    private static final String url = "https://ckan2.multimediagdansk.pl/gpsPositions";

    public static Optional<ZtmData> getData() {
        return Optional.ofNullable(DataMapper.map((ZtmRawDataProvider.requestCurrentData(url))));
    }
}
