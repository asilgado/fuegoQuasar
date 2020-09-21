package com.desafio.fuegoQuasar;

import com.desafio.fuegoQuasar.model.Satellite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestObjectFactory {
    public static final String FINAL_MESSAGE = "este es un mensaje secreto";

    public static List<Satellite> buildSatelliteList() {
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(buildSatellite(485.7f, "kenobi", Arrays.asList("este", " ", " ", "mensaje", " ")));
        satellites.add(buildSatellite(266.1f, "skywalker", Arrays.asList(" ", "es", " ", " ", "secreto")));
        satellites.add(buildSatellite(600.5f, "sato", Arrays.asList("este", " ", "un", " ", " ")));
        return satellites;
    }

    public static List<Satellite> buildSatelliteListDistanceError() {
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(buildSatellite(100.0f, "kenobi", Arrays.asList("este", " ", " ", "mensaje", " ")));
        satellites.add(buildSatellite(115.5f, "skywalker", Arrays.asList(" ", "es", " ", " ", "secreto")));
        satellites.add(buildSatellite(142.7f, "sato", Arrays.asList("este", "", "un", " ", " ")));
        return satellites;
    }

    public static List<Satellite> buildSatelliteListMessageSizeError() {
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(buildSatellite(485.7f, "kenobi", Arrays.asList("este", " ", " ", "mensaje", " ")));
        satellites.add(buildSatellite(266.1f, "skywalker", Arrays.asList(" ", "es", " ", " ", "secreto")));
        satellites.add(buildSatellite(600.5f, "sato", Arrays.asList("este", " ", "un", " ")));
        return satellites;
    }

    public static List<Satellite> buildSatelliteListMessageEmpty() {
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(buildSatellite(485.7f, "kenobi", Collections.emptyList()));
        satellites.add(buildSatellite(266.1f, "skywalker", Arrays.asList(" ", "es", " ", " ", "secreto")));
        satellites.add(buildSatellite(600.5f, "sato", Arrays.asList("este", "", "un", "")));
        return satellites;
    }

    public static List<Satellite> buildSatelliteListQueueSuccess() {
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(buildSatellite(485.7f, "kenobi", Collections.emptyList()));
        satellites.add(buildSatellite(266.1f, "skywalker", Arrays.asList(" ", "es", " ", " ", "secreto")));
        return satellites;
    }

    public static Satellite buildSatellite(float distance, String name, List<String> message) {
        return Satellite.builder().distance(distance).name(name).message(message).build();
    }

}
