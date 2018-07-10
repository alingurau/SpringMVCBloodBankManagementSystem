package ro.emanuel.project.pojo;

public enum SexType {

	FEMININ, MASCULIN;

	public static int getIntValue(SexType s) {
		switch (s) {
		case FEMININ:
			return 0;
		case MASCULIN:
			return 1;
		default:
			throw new IllegalArgumentException("Valoarea nu este valida");

		}
	}

	public static SexType getTypeByInt(int type) {
		switch (type) {
		case 0:
			return SexType.FEMININ;
		case 1:
			return SexType.MASCULIN;
		}
		return null;
	}
}
