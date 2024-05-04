package tv.memoryleakdeath.magentabreeze.common;

import java.util.List;

public final class AlertTypeConstants extends BaseServiceSpecificValues {
    private static final List<AlertTypeConstants> alertTypes = List
            .of(new AlertTypeConstants(ServiceTypes.TWITCH, "FOLLOW"),
                    new AlertTypeConstants(List.of(ServiceTypes.TWITCH, ServiceTypes.YOUTUBE), "SUBSCRIBE"),
                    new AlertTypeConstants(ServiceTypes.TWITCH, "SUBSCRIBE_PRIME"),
                    new AlertTypeConstants(ServiceTypes.TWITCH, "SUBSCRIBE_TIER2"),
                    new AlertTypeConstants(ServiceTypes.TWITCH, "SUBSCRIBE_TIER3"),
                    new AlertTypeConstants(ServiceTypes.TWITCH, "BITS"),
                    new AlertTypeConstants(ServiceTypes.TWITCH, "SUBSCRIBE_STREAK"),
                    new AlertTypeConstants(ServiceTypes.TWITCH, "HYPE_TRAIN"),
                    new AlertTypeConstants(ServiceTypes.TWITCH, "RAIDS"),
                    new AlertTypeConstants(ServiceTypes.YOUTUBE, "MEMBERSHIP"),
                    new AlertTypeConstants(List.of(ServiceTypes.TWITCH, ServiceTypes.YOUTUBE), "HIGHLIGHTED_MESSAGE"));

    public AlertTypeConstants() {
    }

    private AlertTypeConstants(ServiceTypes type, String value) {
        super.setService(type);
        super.setValue(value);
    }

    private AlertTypeConstants(List<ServiceTypes> types, String value) {
        super.setService(types);
        super.setValue(value);
    }

    public static List<AlertTypeConstants> getValues(ServiceTypes serviceType) {
        return alertTypes.stream().filter(t -> t.getValue(serviceType) != null).toList();
    }

    public static List<AlertTypeConstants> getValues(String service) {
        ServiceTypes targetType = ServiceTypes.valueOf(service);
        return getValues(targetType);
    }

    public static List<AlertTypeConstants> getValues() {
        return alertTypes;
    }

    public static AlertTypeConstants getType(String type) {
        return alertTypes.stream().filter(t -> t.getValue().equals(type)).findFirst().orElse(null);
    }
}
