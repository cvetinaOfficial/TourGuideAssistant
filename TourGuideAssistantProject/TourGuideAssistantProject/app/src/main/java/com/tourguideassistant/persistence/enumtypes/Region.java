package com.tourguideassistant.persistence.enumtypes;

public enum Region {
    Plovdiv(0),
    Sofia(1),
    Smolqn(2),
    Vidin(3),
    Montana(4),
    Vratsa(5),
    Pleven(6),
    Lovech(7),
    Gabrovo(8),
    VelikoTurnovo(9),
    Ruse(10),
    Razbgrad(11),
    Silistra(12),
    Shumen(13),
    Dobrich(14),
    Varna(15),
    Burgas(16),
    Qmbol(17),
    Haskovo(18),
    Sliven(19),
    StaraZagora(20),
    Turgovishte(21),
    Kurdjali(22),
    Blagoevgrad(23),
    Kustendil(24);

    public final int regionNumber;

    Region(int regionNumber) {
        this.regionNumber = regionNumber;
    }
}
