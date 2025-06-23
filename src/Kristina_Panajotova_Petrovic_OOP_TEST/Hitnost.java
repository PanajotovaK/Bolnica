package Kristina_Panajotova_Petrovic_OOP_TEST;

public enum Hitnost {
    ZELENO,
    ZUTO,
    CRVENO;

    private Hitnost hitnost = this;

    public Hitnost povecajHitnost() {
        switch (this) {
            case ZELENO:
                return ZUTO;
            case ZUTO:
                return CRVENO;
            case CRVENO:
                return CRVENO;
        }
        return this;
    }


    public Hitnost smanjiHitnost() {
        switch (hitnost) {
            case CRVENO:
                return ZUTO;
            case ZUTO:
                return ZELENO;
            case ZELENO:
                return ZELENO;
        }
        return this;
    }

    public Hitnost getHitnost() {
        return hitnost;
    }

}
