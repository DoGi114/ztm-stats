package sda.advanced.inbound;

import sda.advanced.model.ZtmData;

public class ZtmDataProvider {
    private static final String url = "https://ckan2.multimediagdansk.pl/gpsPositions";
    public static ZtmData getData(){
        return DataMapper.map((ZtmRawDataProvider.requestCurrentData(url)));
    }
}
