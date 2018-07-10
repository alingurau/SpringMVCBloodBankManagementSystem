package ro.emanuel.project.pojo;

public enum BloodGroupType {

	A, B, AB, O;

	public static int getIntValue(BloodGroupType bgt) {
		switch (bgt) {
		case A:
			return 0;
		case B:
			return 1;
		case AB:
			return 2;
		case O:
			return 3;
		default:
			throw new IllegalArgumentException("Valoarea nu este valida");

		}
	}

	public static BloodGroupType getTypeByInt(int type) {
		switch (type) {
		case 0:
			return BloodGroupType.A;
		case 1:
			return BloodGroupType.B;
		case 2:
			return BloodGroupType.AB;
		case 3:
			return BloodGroupType.O;
		}
		return null;
	}

}