package sda.advanced.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZtmData {
    @JsonProperty("LastUpdateData")
    String lastUpdateDate;
    @JsonProperty("Vehicles")
    List<Vehicle> vehicleList;

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public String toString() {
        return "ZtmData{" +
                "lastUpdateDate='" + lastUpdateDate + '\'' +
                ", vehicleList=" + Arrays.toString(vehicleList.toArray()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZtmData ztmData = (ZtmData) o;
        return lastUpdateDate.equals(ztmData.lastUpdateDate) &&
                vehicleList.equals(ztmData.vehicleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastUpdateDate, vehicleList);
    }
}
