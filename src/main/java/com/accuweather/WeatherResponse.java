package com.accuweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {

    @JsonProperty("WeatherText")
    private String weatherText;

    @JsonProperty("Temperature")
    private Temperature temperature;

    public String getWeatherText() {
        return weatherText;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public static class Temperature {
        @JsonProperty("Metric")
        private Metric metric;

        public Metric getMetric() {
            return metric;
        }
    }

    public static class Metric {
        @JsonProperty("Value")
        private double value;

        public double getValue() {
            return value;
        }
    }
}
