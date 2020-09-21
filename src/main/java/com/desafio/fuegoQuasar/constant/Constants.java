package com.desafio.fuegoQuasar.constant;

public final class Constants {
 //Services path
 public static final String PATH_ROOT="/api/v1/fuegoQuasar";
 public static final String PATH_TOP_SECRET = "/topsecret";
 public static final String PATH_TOP_SECRET_SPLIT = "/topsecret_split/{satellite_name}";
 public static final String PATH_TOP_SECRET_SPLIT_GET = "/topsecret_split";

 //Path variables
 public static final String SATELLITE_NAME = "satellite_name";

 //Error messages
 public static final String POSITION_ERROR="No se pueda determinar la posición";
 public static final String MESSAGE_ERROR="No se pueda determinar el mensaje";
 public static final String DECODE_MESSAGE_ERROR="No se puede determinar el mensaje";
 public static final int NUMBER_SATELLITES_IN_SERVICE = 3;

 public static final String NOT_ENOUGH_INFORMATION ="No hay suficiente información";

 //EPSILON
 public static final double EPSILON = 0.1;

}
