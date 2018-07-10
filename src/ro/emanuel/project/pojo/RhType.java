package ro.emanuel.project.pojo;

public enum RhType {

	POZITIV, NEGATIV;

	public static int getIntValue(RhType rht) {
		switch (rht) {
		case POZITIV:
			return 0;
		case NEGATIV:
			return 1;
		default:
			throw new IllegalArgumentException("Valoarea nu este valida");

		}
	}

	public static RhType getTypeByInt(int type) {
		switch (type) {
		case 0:
			return RhType.POZITIV;
		case 1:
			return RhType.NEGATIV;
		}
		return null;
	}

}
