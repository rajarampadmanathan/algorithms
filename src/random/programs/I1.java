package random.programs;

@FunctionalInterface
interface I1 {

	int getValues();
	int hashCode();
	default int getValue() {
		return getValuehelper();
	}
	static int getValuehelper() {
		return 1;
	}
}

