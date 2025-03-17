package com.parcial.parcial1.domain;

public enum OfficeType {
    DESKTOP, METING_OFFICE, PRIVATE_OFFICE;

    public String getTranslation() {
        return switch(this) {
            case DESKTOP -> "Escritorio";
            case METING_OFFICE -> "Oficina de Reuniones";
            case PRIVATE_OFFICE -> "Oficina Privada";
        };
    }
}
