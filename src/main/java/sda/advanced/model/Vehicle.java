package sda.advanced.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    @JsonProperty("Line")
    private String line;
    @JsonProperty("Speed")
    private Integer speed;
    @JsonProperty("Delay")
    private Integer delay;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "line='" + line + '\'' +
                ", speed=" + speed +
                ", delay=" + delay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return line.equals(vehicle.line) &&
                speed.equals(vehicle.speed) &&
                delay.equals(vehicle.delay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, speed, delay);
    }
}
