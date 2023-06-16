package com.ecomvn.common.entity;

public enum Location {
	HA_GIANG("Ha Giang"),
	CAO_BANG("Cao Bang"),
	BAC_KAN("Bac Kan"),
	TUYEN_QUANG("Tuyen Quang"),
	LAO_CAI("Lao Cai"),
	DIEN_BIEN("Dien Bien"),
	LAI_CHAU("Lai Chau"),
	SON_LA("Son La"),
	YEN_BAI("Yen Bai"),
	HOA_BINH("Hoa Binh"),
	THAI_NGUYEN("Thai Nguyen"),
	LANG_SON("Lang Son"),
	QUANG_NINH("Quang Ninh"),
	BAC_GIANG("Bac Giang"),
	PHU_THO("Phu Tho"),
	VINH_PHUC("Vinh Phuc"),
	BAC_NINH("Bac Ninh"),
	HAI_DUONG("Hai Duong"),
	HA_NOI("Ha Noi"),
	HAI_PHONG("Hai Phong"),
	HUNG_YEN("Hung Yen"),
	NAM_DINH("Nam Dinh"),
	THAI_BINH("Thai Binh"),
	NINH_BINH("Ninh Binh"),
	THANH_HOA("Thanh Hoa"),
	NGHE_AN("Nghe An"),
	HA_TINH("Ha Tinh"),
	QUANG_BINH("Quang Binh"),
	QUANG_TRI("Quang Tri"),
	THUA_THIEN_HUE("Thua Thien Hue"),
	DA_NANG("Da Nang"),
	QUANG_NAM("Quang Nam"),
	QUANG_NGAI("Quang Ngai"),
	BINH_DINH("Binh Dinh"),
	PHU_YEN("Phu Yen"),
	KHANH_HOA("Khanh Hoa"),
	NINH_THUAN("Ninh Thuan"),
	BINH_THUAN("Binh Thuan"),
	KON_TUM("Kon Tum"),
	GIA_LAI("Gia Lai"),
	DAK_LAK("Dak Lak"),
	DAK_NONG("Dak Nong"),
	LAM_DONG("Lam Dong"),
	BINH_PHUOC("Binh Phuoc"),
	TAY_NINH("Tay Ninh"),
	BINH_DUONG("Binh Duong"),
	DONG_NAI("Dong Nai"),
	BA_RIA_VUNG_TAU("Ba Ria - Vung Tau"),
	HO_CHI_MINH("Ho Chi Minh City"),
	LONG_AN("Long An"),
	TIEN_GIANG("Tien Giang"),
	BEN_TRE("Ben Tre"),
	TRA_VINH("Tra Vinh"),
	VINH_LONG("Vinh Long"),
	DONG_THAP("Dong Thap"),
	AN_GIANG("An Giang"),
	KIEN_GIANG("Kien Giang"),
	CAN_THO("Can Tho"),
	HAU_GIANG("Hau Giang"),
	SOC_TRANG("Soc Trang"),
	BAC_LIEU("Bac Lieu"),
	CA_MAU("Ca Mau"),
	HA_NAM("Ha Nam");


    private final String value;

    Location(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static Location setValue(String value) {
        for (Location location : Location.values()) {
            if (location.getValue().equalsIgnoreCase(value)) {
                return location;
            }
        }
        throw new IllegalArgumentException("Invalid location value: " + value);
    }
}
